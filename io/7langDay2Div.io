realDivision := Number getSlot("/")

Number / := method (i, 
    if (i != 0, self realDivision(i), 0)
)

4/0 println
4/2 println
