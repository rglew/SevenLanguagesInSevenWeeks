module String2Num where

import Data.Char
import Data.List

parse str =
    let (integer_bit, dec_points) = break (== '.') str
    in foldl' pInt_bit 0 (clean integer_bit) + foldr pDec_pts 0 (clean dec_points) / 10 -- make it so!

clean s   = filter isDigit s -- gets rid of any crap like $ signs
pInt_bit  a b = 10*a + toNum b --covert to number
pDec_pts a b = toNum a + b/10 --convert to number
toNum c   = fromIntegral $ ord c - ord '0' -- converts the type