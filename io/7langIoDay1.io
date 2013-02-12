ANSWER

1/ 

vagrant@precise32:/vagrant_data/io$ io
Io 20110905
Io> 1 + 1
==> 2
Io> 1 + "one"

  Exception: argument 0 to method '+' must be a Number, not a 'Sequence'
  ---------
  message '+' in 'Command Line' on line 1

  A: Depends a lot on your definition of strong and weak.  To me it's a strong dynamically typed language.
  
 2/
 
 Io 20110905
 Io> 0 and true
 ==> true
 Io> 0 and false
 ==> false
 Io> "" and true
 ==> true
 Io> "" and false
 ==> false
 Io> '' and true
 Io> (nil and false) true
 ==> true

   Exception: Object does not respond to ''''
   ---------
   Object ''                            Command Line 1
   
   3/
   
   o> Vehicle := Object clone
   ==>  Vehicle_0x95a5378:
     type             = "Vehicle"

   Io> Car := Vehicle clone
   ==>  Car_0x9647a80:
     type             = "Car"

   Io> Car proto
   ==>  Vehicle_0x95a5378:
     type             = "Vehicle"

   Io> Car proto slotNames
   ==> list(type)
   
   4/
   =   Assign to an existing slot
   :=  Create and assign to a slot
   ::= + add setter
   
   DO
   
   1/ 


#from the Io beginners programming guide
greet := method(
    writeln ("What is your name?"); 
     you := File standardInput readLine ("> ");
    writeln ("Hello ", you)
)
greet
$ ./greet.io
What is your name?
> richard
Hello richard


