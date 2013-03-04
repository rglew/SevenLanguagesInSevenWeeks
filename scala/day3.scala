import io.Source
import scala.actors.Actor._
 
// Regex to pick up external links; very simplified, so it'll miss some
val linkRegex = "(?i)<a.+?href=\"(http.+?)\".*?>(.+?)</a>".r
 
object PageLoader {
  def load(url: String) = {
    try {
      Source.fromURL(url).mkString
    } catch {
      case e: Exception => System.err.println(e)
      ""
    }
  }
 
  def getPageSize(url: String) = load(url).length
 
  def getPageSizeAndLinks(url: String) = {
    val content = load(url)
    val links = linkRegex.findAllIn(content).matchData.toList.map(_.group(1))
    (content.length, links)
  }
}
 
val urls = List("http://duckduckgo.com/",
                "http://www.bing.com",
                "http://www.google.com",
                "http://www.wolframalpha.com/")
 
 
def timeMethod(method: () => Unit) {
  val start = System.nanoTime
  method()
  val end = System.nanoTime
  println("Method took " + (end - start)/1000000000.0 + " seconds.")
}
 
def sequential() {
  for (url <- urls) {
    val (size, links) = PageLoader.getPageSizeAndLinks(url)
    val totalSize = crawlLinks(size, links)
    printOutput(url, size, links, totalSize)
  }
}
 
def crawlLinks(size: Int, links: List[String]): Int = links match {
  case Nil => size
  case head :: tail => crawlLinks(size + PageLoader.getPageSize(head), tail)  
} 
 
def printOutput(url: String, size: Int, links: List[String], totalSize: Int) {
  println(url + ": size = " + size + ", links = " + links.length + ", total size = " + totalSize)
}
 
def concurrent() {
  val caller = self
 
  urls.foreach { url =>
    actor {
      val (size, links) = PageLoader.getPageSizeAndLinks(url)
      val linkCollectorActor = self
 
      links.foreach(link => actor { linkCollectorActor ! PageLoader.getPageSize(link) })
 
      var totalSize = size
      for (i <- 1 to links.length) {
        receive { case linkSize: Int => totalSize += linkSize }
      }
      
      caller ! (url,  size, links, totalSize)
    }
  }  
  
  for (i <- 1 to urls.length) {    
    receive {
      case (url: String, size: Int, links: List[String], totalSize: Int) => printOutput(url, size, links, totalSize)
    }
  }
}
 
println("Sequential run:")
timeMethod(sequential)
 
println("Concurrent run:")
timeMethod(concurrent)