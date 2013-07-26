(ns spd1.abstract-some
  (:require [expectations :refer [expect run-tests]]))

(comment
  "PROBLEM:

  Design an abstract function called some? (including signature, purpose,
  and tests) to simplify the following two functions. When you are done
  rewrite the original functions to use your new some? function.")

(comment
  "PART A: Design an abstract function")

;; declare function ahead of examples
(declare some-pred?)

;; declare positive? and negative? so we can define them later (Clojure doesn't have these primitives)
(declare positive?)
(declare negative?)

;; examples
(expect false (some-pred? positive? []))
(expect true (some-pred? positive? (list 1 4 -1 3)))
(expect false (some-pred? positive? (list -1 -5)))
(expect true (some-pred? negative? (list 2 -1)))
(expect true (some-pred? even? (list 1 5 2 7)))
(expect true (some-pred? odd? (list 1 5 2 7)))
(expect false (some-pred? odd? (list 2 4 6)))

#_(defn some-pred?
  "(X -> Boolean) (listof X) -> Boolean
   produces true if some number in the lists fits the predicate"
  [pred lon]
  false) ; stub

(defn some-pred?
  "(X -> Boolean) (listof X) -> Boolean
   produces true if some number in the lists fits the predicate"
  [pred lon]
  (if (empty? lon)
    false
    (or (pred (first lon))
        (some-pred? pred (rest lon)))))

(comment
  "PART B: Rewrite the original functions")

;; declare function ahead of examples
(declare some-positive?)

;; examples
(expect false (some-positive? []))
(expect true (some-positive? (list 2 -3 -4)))
(expect false (some-positive? (list -2 -3 -4)))

(defn some-positive?
  "ListOfNumber -> Boolean
   produce true if some number in lon is positive"
  [lon]
  (some-pred? positive? lon))

;; declare function ahead of examples
(declare some-negative?)

;; examples
(expect false (some-negative? []))
(expect true (some-negative? (list 2 3 -4)))
(expect false (some-negative? (list 2 3 4)))

(defn some-negative?
  "ListOfNumber -> Boolean
   produce true if some numner in lon is negative"
  [lon]
  (some-pred? negative? lon))

;; missing "primitives"
(defn positive?
  "Number -> Boolean
   produce true if the given number is positive (greater than zero)."
  [n]
  (< 0 n))

(defn negative?
  "Number -> Boolean
   produce true if the given number is negative (less than zero)."
  [n]
  (> 0 n))

;; automatically run the tests
(run-tests [*ns*])
(remove-ns (symbol (str *ns*)))
