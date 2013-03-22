module ReSort where
import Data.Ord

reSort [] = []
reSort (x:xs) = my_insert x $ reSort xs
  where my_insert x [] = [x]
        my_insert x (y:ys) | x > y        = y:my_insert x ys
                           | otherwise    = x:y:ys
