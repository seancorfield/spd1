(ns spd1.sum-n
  (:require [expectations :refer [expect]]
            [expectations.workaround :refer [clear-tests]]))

(clear-tests [*ns*])

;; declare function ahead of examples
(declare sum-n-odds)

;; examples
(expect 0 (sum-n-odds 0))
(expect (+ 0 1) (sum-n-odds 1))
(expect (+ 0 1 3 5) (sum-n-odds 3))

#_(defn sum-n-odds
  "Natural -> Natural
   Produce the sum of the first n odd numbers."
  [n] 0) ; stub

(defn sum-n-odds
  "Natural -> Natural
   Produce the sum of the first n odd numbers."
  [n]
  (reduce + 0 (filter odd? (range (* 2 n)))))

;; automatically run tests
(expectations/run-tests [*ns*])