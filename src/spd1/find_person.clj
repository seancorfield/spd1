(ns spd1.find-person
  (:require [expectations :refer [expect run-tests]]))

(comment
  "The following program implements an arbitrary-arity descendant family
  tree in which each person can have any number of children.

  PROBLEM A:

  Decorate the type comments with reference arrows and establish a clear
  correspondence between template function calls in the templates and
  arrows in the type comments.")

;; Data Definitions

;; unlike bag.clj, we'll use a plain ol' map for person here

;; Person is {:name String :age Natural :kids ListOfPerson}
;; interp. A person, with first name, age and their children
(def P1 {:name "N1" :age 5 :kids []})
(def P2 {:name "N2" :age 25 :kids (list P1)})
(def P3 {:name "N3" :age 15 :kids []})
(def P4 {:name "N4" :age 45 :kids (list P3 P2)})

#_(define (fn-for-person p)
  (... (person-name p)			;String
       (person-age p)			  ;Natural
       (fn-for-lop (person-kids p))))

#_(define (fn-for-person p)
  (... (person-name p)			;String
       (person-age p)	  		;Natural
       (fn-for-lop (person-kids p))))

;; Functions

(comment
  "PROBLEM B:

  Design a function that consumes a Person and a String. The function
  should search the entire tree looking for a person with the given
  name. If found the function should produce the person's age. If not
  found the function should produce false.")

;; String Person -> Natural or false
;; String ListOfPerson -> Natural or false
;; search the given tree for a person with the given name, produce age if found; false otherwise

;; declare function ahead of examples
(declare find--lop)
(declare find--person)

(expect false (find--lop "N1" []))
(expect false (find--person "N2" P1))
(expect 5 (find--person "N1" P1))
(expect 15 (find--lop "N3" (cons P1 (cons P2 (cons P3 [])))))
(expect false (find--lop "N4" (cons P1 (cons P2 (cons P3 [])))))
(expect 5 (find--person "N1" P2))
(expect false (find--person "N3" P2))
(expect 25 (find--person "N2" P4))
(expect 5 (find--person "N1" P4))

;; declare missing primitives
(declare string=?)

(defn find--person
  "String Person -> Natural or false
  search the given tree for a person with the given name, produce age if found; false otherwise"
  [n p]
  (if (string=? (:name p) n)
      (:age p)
      (find--lop n (:kids p))))

(defn find--lop
  "String ListOfPerson -> Natural or false
  search the given tree for a person with the given name, produce age if found; false otherwise"
  [n lop]
  (cond (empty? lop) false
        :else
        (if (not (false? (find--person n (first lop))))
          (find--person n (first lop))
          (find--lop n (rest lop)))))

;; define primitives
(defn string=? [a b] (= a b))

;; automcatically run tests
(run-tests [*ns*])
