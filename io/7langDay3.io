Builder := Object clone
Builder depth := 0
Builder tab := method(
    t := ""
    depth repeat(t = t .. "  ")
    return t
)

Builder forward := method(
  writeln(self tab, "<", call message name, ">")
	depth = depth + 1
    call message arguments foreach(
	  arg, 
	  content := self doMessage(arg); 
	  if(content type == "Sequence", writeln(self tab, content)))
  	depth = depth - 1  
  writeln(self tab, "</", call message name, ">"))

Builder  ul(
	li("Io"), 
	li("Lua"), 
	li("JavaScript"))
		

squareBrackets := method(call message arguments)
	
[1,2,3,4,5] println
["Right","Said","Fred"] println