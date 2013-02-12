fib := method ( n,
        if(n<2,
          return n
			)
	    return fib(n-1) + fib(n-2)
	)
			
	// seems pretty obvious - but is horribly inefficient - not sure why it's SO bad though.
	
for (i,1,10,fib(i) println)	//don't put a big number in here
	
	
