module alleven where
-- basic version
    allEven :: [Integer] -> [Integer]
    allEven [] = []
    allEven (h:t) = if even h then h:allEven t else allEven t
	
-- using filter	
	allEven2 :: [Integer] -> [Integer]
	allEven2 = filter (even) 