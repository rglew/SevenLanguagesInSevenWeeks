//dim (3,4) gives list(list(,0,0,0)list(0,0,0)list(0,0,0)list(0,0,0))
	
2dlist := List clone
2dlist dim := method(x ,y ,
	y repeat (
	nest := list()	
	x repeat (nest append(0))
	self append(nest)
	)
)

2dlist set := method(x,y,val,
self at (y) atPut(x,val)
)

2dlist get := method(x,y,
self at (y) at (x)
)

2dlist writeToFile := method(fileName,
	f := File with(fileName)
	f remove
	f openForUpdating
	f write(self asJson)
	f close
)

2dlist buildFromFile := method(fileName,
	
f := File with(fileName)
	if(f exists(fileName),
		f openForReading
		contents := f readLines
		contents println)
		self := contents
	
	)

2dlist dim(10,20) println
"Setting" println
2dlist set(3,4,"stuff") println
"Getting" println
2dlist get(3,4) println
	
	
"Writing to File" println
2dlist writeToFile("/vagrant_data/io/matrix.txt")

"Reading from File" println
2dlist buildFromFile("matrix.txt") println
2dlist println
2dlist get(3,4) println
	
	