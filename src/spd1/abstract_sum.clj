(ns spd1.abstract-sum
  (:require [expectations :refer [expect run-tests]]))

(comment
  "PROBLEM A:

  Design an abstract function (including signature, purpose, and tests) to
  simplify the two sum-of functions.")

;; caution: fn is special in Clojure so we use f for the function argument

;; declare function ahead of examples
(declare abstract-sum)

;; Clojure doesn't have these primitives so we'll declare them - and define them later
(declare string-length)
(declare sqr)

;; examples
(expect 0 (abstract-sum string-length []))
(expect 6 (abstract-sum string-length (list "a" "bc" "def")))
(expect (+ 4 16) (abstract-sum sqr (list 2 4)))

#_(defn abstract-sum
  "(X -> Number) (listof X) -> Number
  Produce sum of calling f on every element of lox"
  [f lox]
  0) ; stub

#_(defn abstract-sum
  "(X -> Number) (listof X) -> Number
  Produce sum of calling f on every element of lox"
  [f lox]
  (cond (empty? lox) 0
        :else (+ (f (first lox))
                 (abstract-sum f (rest lox))))) ; stub

;; of course the idiomatic solution here would be reduce/map
(defn abstract-sum [f lox] (reduce + (map f lox)))

(comment
  "PROBLEM B:

  Now re-define the original functions to use the new abstract function.

  Remember, the signature and tests should not change from the original
  functions.")

;; declare function ahead of examples
(declare sum-of-squares)

;; examples
(expect 0 (sum-of-squares []))
(expect (+ 4 16) (sum-of-squares (list 2 4)))

(defn sum-of-squares
  "(listof Number) -> Number
  produce the sum of the squares of the numbers in lon"
  [lon]
  (abstract-sum sqr lon))

;; declare function ahead of examples
(declare sum-of-lengths)

;; examples
(expect 0 (sum-of-lengths []))
(expect 3 (sum-of-lengths (list "a" "bc")))

(defn sum-of-lengths
  "(listof String) -> Number
  produce the sum of the lengths of the strings in los"
  [los]
  (abstract-sum string-length los))

;; define those primitives
(defn- string-length [s] (.length s))
(defn- sqr [n] (* n n))

;; automcatically run tests
(run-tests [*ns*])
(remove-ns (symbol (str *ns*)))
