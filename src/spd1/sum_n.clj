(ns spd1.sum-n
  (:require [expectations :refer [expect run-tests]]))

(comment
  "PROBLEM:

  Complete the design of the following function, by writing out
  the final function definition. Use at least one built in abstract
  function.")

;; declare function ahead of examples
(declare sum-n-odds)

;; examples
(expect 0 (sum-n-odds 0))
(expect (+ 0 1) (sum-n-odds 1))
(expect (+ 0 1 3 5) (sum-n-odds 3))

(comment
  "HINT: The first n odd numbers are contained in the first 2*n naturals.
  For example (list 0 1 2 3) contains the first 4 naturals and the first
  2 odd numbers. Also remember that DrRacket has a build in predicate
  function called odd?")

#_(defn sum-n-odds
  "Natural -> Natural
   Produce the sum of the first n odd numbers."
  [n] 0) ; stub

;; SOLUTION CHOICE ONE

;; reduce is Clojure's folder; (range n) is Clojure's (build-list n identity)
(defn sum-n-odds
  "Natural -> Natural
   Produce the sum of the first n odd numbers."
  [n]
  (reduce + 0 (filter odd? (range (* 2 n)))))

;; build-list if you wanted it
(defn build-list [n f] (map f (range n)))

;; SOLUTION CHOICE TWO

;; letfn is how Clojure declares local functions
(defn sum-n-odds
  "Natural -> Natural
   Produce the sum of the first n odd numbers."
  [n]
  (letfn [(multiply [i] (+ (* 2 i) 1))]
    (reduce + 0 (build-list n multiply))))

;; automatically run tests
(run-tests [*ns*])
