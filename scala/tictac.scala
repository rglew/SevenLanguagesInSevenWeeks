// Chapter 5 Day 1 Problems

// Write a game that will take a tic-tac-toe board with X, O, and blank
// characters and detect the winner or whether there is a tie or no 
// winner yet.  Use classes where appropriate.

// Bonus problem: Let two players play tic-tac-toe.


class TicTac {

var board = List()

def status(board:List()):String = {

val winningCombos = ((1,2,3),(4,5,6),(7,8,9),(1,4,7),(2,5,8),(3,6,9),(1,5,9),(3,5,7))

forEach combo in winningCombos{
if board(combo(1)) == board(combo(2) == board(combo(3)) then return("winner = " && combo(1))
}

// no winners

foreach position in board{
if position == "_" then return("not finished")
}
//game is finished - draw

return("draw")


}


}

val game = new TicTac

var status = game.status(("X","O","X","X","X","X","O","O","X"))
println(status)


















import scala.collection.mutable.Map

class SymbolPrinter(s:Symbol) {
	def print():String = {
		if (s == 'Blank') { return " " }
		return s.toString drop 1
	}
}
implicit def symbolExtension(s:Symbol) = new SymbolPrinter(s)

class Board {
	val board = Map('TopLeft -> 'Blank,
					'MidLeft -> 'Blank,
					'BottomLeft -> 'Blank,
					'TopCenter -> 'Blank,
					'MidCenter -> 'Blank,
					'BottomCenter -> 'Blank,
					'TopRight -> 'Blank,
					'MidRight -> 'Blank,
					'BottomRight -> 'Blank)
					
	def print(): String = {
		board('TopLeft).print + "|" + board('TopCenter).print + "|" + board('TopRight).print + "\n" + 
		"------\n" + 
		board('MidLeft).print + "|" + board('MidCenter).print + "|" + board('MidRight).print + "\n" + 
		"------\n" +
		board('BottomLeft).print + "|" + board('BottomCenter).print + "|" + board('BottomRight).print + "\n"
	}
	
	def canMove(position:Symbol) = { board(position) == 'Blank }
	
	def move(position:Symbol, player:Symbol) = {
		if (board(position) == 'Blank) { board(position) = player }
	}
	
	def winner():Symbol = {
		if (isWinner('X)) { return 'X }
		if (isWinner('Y)) { return 'Y }
		if (allPositionsFilled) { return 'Tie }
		return 'NoneYet
	}
	
	private def isWinner(player:Symbol):Boolean = {
		isRowWinner(player) || isColumnWinner(player) || isDiagonalWinner(player)
	}
	
	private def isRowWinner(player:Symbol):Boolean = {
		(board('TopLeft) == player && board('TopCenter) == player && board('TopRight) == player) ||
		(board('MidLeft) == player && board('MidCenter) == player && board('MidRight) == player) ||
		(board('BottomLeft) == player && board('BottomCenter) == player && board('BottomRight) == player)
	}
	
	private def isColumnWinner(player:Symbol):Boolean = {
		(board('TopLeft) == player && board('MidLeft) == player && board('BottomLeft) == player) ||
		(board('TopCenter) == player && board('MidCenter) == player && board('BottomCenter) == player) ||
		(board('TopRight) == player && board('MidRight) == player && board('BottomRight) == player)
	}
	
	private def isDiagonalWinner(player:Symbol):Boolean = {
		(board('TopLeft) == player && board('MidCenter) == player && board('BottomRight) == player) ||
		(board('TopRight) == player && board('MidCenter) == player && board('BottomLeft) == player)
	}
	
	private def allPositionsFilled():Boolean = {
		board foreach ((spot) => 
			if (spot._2 == 'Blank) { return false }
		)
		return true
	}
}

class Game {
	def newGame() = {
		val board = new Board
		var player = 'X
		while (board.winner == 'NoneYet) {
			printMoveOptions
			turn(player, board)
			if (player == 'X) { player = 'Y } else { player = 'X }
		}
		printWinner(board)
	}
	
	private def printMoveOptions() = {
		print("Move options: TopLeft, TopCenter, TopRight, MidLeft, MidCenter, MidRight, ")
		println("BottomLeft, BottomCenter, BottomRight\n")
	}
	
	private def turn(player:Symbol, board:Board) = {
		val position = getMove(player, board)
		board.move(position, player)
		println("\n" + board.print)
	}
	
	private def getMove(player:Symbol, board:Board):Symbol = {
		while (true) {
			print("Player " + player.print + " enter a move: ")
			val position = Symbol(readLine)
			if (board.canMove(position)) {
				return position
			} else {
				println("Position already taken.  Try agin.\n")
			}
		}
		return 'Blank
	}
	
	private def printWinner(board:Board) = {
		if (board.winner == 'X || board.winner == 'Y) {
			println("Player " + board.winner + " won")
		} else {
			println("Tie game")
		}
	}
}

val game = new Game
game.newGame


// Chapter 5 Day 2 Problems

// Use foldLeft to compute the total size of a list of strings
val list = List("one", "two", "three", "four")
val size = (0 /: list) {(size, i) => size + i.size}
println(size)
println("")

// Write a Censor trait with a method that will replace the curse words
// Shoot and Darn with Pucky and Beans alternatives.  Use a map to 
// store the curse words and their alternatives.
trait Censor {
	def censor(text:String):String = {
		var censoredText = text
		val replacements = Map("Shoot" -> "Pucky", "Darn" -> "Beans")
		for ((curseWord, cleanWord) <- replacements) 
			censoredText = censoredText.replace(curseWord, cleanWord)
		return censoredText
	}
}

class Reviewer extends Censor

println(new Reviewer().censor("one Shoot three   four    Darn Darn"))
println("")

// Load the curse words and alternatives from a file.
import scala.collection.mutable.HashMap
import scala.io.Source

trait Censor2 {
	def censor(text:String):String = {
		var censoredText = text
		val replacements = getReplacements
		for ((curseWord, cleanWord) <- replacements) 
			censoredText = censoredText.replace(curseWord, cleanWord)
		return censoredText
	}
	
	def getReplacements():HashMap[String, String] = {
		val replacements = new HashMap[String, String]
		Source.fromFile("replacements.txt").getLines().foreach { line => 
			val pair = line.split(":")
			replacements += pair(0) -> pair(1)
		}
		return replacements
	}
}

class Reviewer2 extends Censor2
println(new Reviewer2().censor("one Shoot three   four    Darn Darn"))
println("")


// Chapter 5 Day 3 Problems

// Take the sizer application and add a message to count the number of 
// links on the page.
import scala.io._
import scala.actors._
import Actor._

object PageLoader {
	def getPage(url: String) = Source.fromURL(url).mkString
	def getPageSize(url: String) = getPage(url).length
	def getLinkCount(url: String) = {
		val regex = "<a ".r
		regex.findAllIn(getPage(url)).size
	}
} 

val urls = List("http://www.amazon.com",
				"http://www.twitter.com",
				"http://www.google.com",
				"http://www.cnn.com")
				
def timeMethod(method: () => Unit) = {
	val start = System.nanoTime
	method()
	val end = System.nanoTime
	println("Method took " + (end - start) / 1000000000.0 + " seconds.")
}

def getPageInfoSequentially() = {
	for (url <- urls) {
		println("Size for " + url + ": " + PageLoader.getPageSize(url))
		println("Link count for " + url + ": " + PageLoader.getLinkCount(url))
	}
}

def getPageInfoConcurrently() = {
	var caller = self
	
	for (url <- urls) {
		actor { caller ! ("Size", url, PageLoader.getPageSize(url)) }
		actor { caller ! ("Count", url, PageLoader.getLinkCount(url)) }
	}
		
	for (i <- 1 to urls.size * 2) {
		receive {
			case ("Size", url, size) =>
				println("Size for " + url + ": " + size)
			case ("Count", url, count) =>
				println("Link count for " + url + ": " + count)
		}
	}
}

println("Sequential run: ")
timeMethod { getPageInfoSequentially }
println("")
println("Concurrent run: ")
timeMethod { getPageInfoConcurrently }
println("")

// Bonus problem: Make the sizer follow the links on a given page,
// and load them as well.  For example, a sizer for "google.com"
// would compute the size for Google and all of the pages it links to.
import scala.io._
import scala.actors._
import Actor._
import scala.collection.mutable._

object PageLoader2 {
	def getPage(url: String) = Source.fromURL(url).mkString
	def getPageSize(url: String) = getPage(url).length
	def getLinks(page: String) : ArrayBuffer[String] = {
		val links = new ArrayBuffer[String]()
		val regex = "<a href=\"(.*?)\".*?>.*?</a>".r
		regex.findAllIn(page).matchData.foreach(m =>
			links += m.group(1)
		)
		return links
	}
	def getLinkCount(url: String) = {
		getLinks(getPage(url)).size
	}
	def getChildPageInfo(url: String) : HashMap[String, Int] = {
		val linkSizes = new HashMap[String, Int]
		getLinks(getPage(url)).foreach(link =>
			try {
				linkSizes += link -> getPageSize(link)
			} catch {
				case e => e
			}
		)
		return linkSizes
	}
} 

val urls2 = List("http://www.amazon.com",
				"http://www.twitter.com",
				"http://www.google.com",
				"http://www.cnn.com")

def timeMethod2(method: () => Unit) = {
	val start = System.nanoTime
	method()
	val end = System.nanoTime
	println("Method took " + (end - start) / 1000000000.0 + " seconds.")
}

def getPageInfoSequentially2() = {
	for (url <- urls) {
		val childPageInfo = PageLoader2.getChildPageInfo(url)
		for (key <- childPageInfo.keys) {
			println("Size for " + key + ": " + childPageInfo(key))
		}
	}
}

def getPageInfoConcurrently2() = {
	var caller = self

	for (url <- urls) {
		actor { caller ! (url, PageLoader2.getChildPageInfo(url)) }
	}

	for (i <- 1 to urls.size) {
		receive {
			case (url, sizes:HashMap[String, Int]) =>
				for (key <- sizes.keys) {
					println("Size for " + key + ": " + sizes(key))
				}
		}
	}
}

println("Sequential run: ")
timeMethod2 { getPageInfoSequentially2 }
println("")
println("Concurrent run: ")
timeMethod2 { getPageInfoConcurrently2 }