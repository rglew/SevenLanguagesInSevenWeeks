// recursive version
fib := method ( n,
        if(n<2,
          return n
			)
	    return fib(n-1) + fib(n-2)
	)
			
	// seems pretty obvious - but is horribly inefficient - not sure why it's SO bad though.
	
for (i,1,10,fib(i) println)	//don't put a big number in here
	
	
// iterator version

Fib := Object clone
Fib fiblist ::= list()
Fib	fib2 := method ( n,
		if (n < 2, return n)
		fiblist = list(1, 1)
		a := 0
		b := 0	
	while (n > 2, a = fiblist at (fiblist size - 1 ); b = fiblist at (fiblist size - 2 ); fiblist append (a + b); n = n - 1)
	return fiblist at (fiblist size - 1)
	)

for (i,1,10,Fib fib2(i) println)	//this is much faster