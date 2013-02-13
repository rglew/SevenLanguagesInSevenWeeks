avglist := List clone
avglist average := method(
					self selectInPlace(v,v isKindOf(Number))
					if(self size > 0, self reduce(+) / self size, nil))
				
emptylist := avglist clone
emptylist average println
avglist append(1,2,3,4,5,6,7,8,9,10,"a","b","c")
avglist average println
