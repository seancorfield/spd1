(ns spd1.expectations.sum-n-solution
  (require [spd1.sum-n-solution :refer :all]
           [expectations :refer [expect]]))

(expect 0 (sum-n-odds 0))
(expect (+ 0 1) (sum-n-odds 1))
(expect (+ 0 1 3 5) (sum-n-odds 3))