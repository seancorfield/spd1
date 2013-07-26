(ns spd1.abstract-sum
  (:require [expectations :refer [expect run-tests]]
            [expectations.workaround :refer [clear-tests]]))

(clear-tests [*ns*])

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

;; define those primitives
(defn- string-length [s] (.length s))
(defn- sqr [n] (* n n))

;; automcatically run tests
(run-tests [*ns*])