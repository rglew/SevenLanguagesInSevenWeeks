module Main where
	my_reverse :: [a] -> [a]
	my_reverse =  foldl (flip (:)) []