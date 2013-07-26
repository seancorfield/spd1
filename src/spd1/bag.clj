(ns spd1.bag
  (:require [expectations :refer [expect]]
            [expectations.workaround :refer [clear-tests]]))

(clear-tests [*ns*])

(defrecord Bag [l w h])
;; Bag is (->Bag Number Number Number)
;; interp. a bag with a length, width, and height in centimeters
(def B1 (->Bag 19.5 10.0 6.5))
(def B2 (->Bag 23.0 11.5 7.0))
(def B3 (->Bag 18.0 9.5 5.5))

;; ListOfBag is one of:
;; - empty []
;; - (cons Bag ListOfBag)
(def LOB1 [])
(def LOB2 (list B1 B2 B3))

(comment
  "PROBLEM:

  The linear length of a bag is defined to be it length plus
  width plus height. Design the function linear-length-lob that consumes
  a list of bags and produces a list of the linear lengths of each of
  the bags in the list.

  Use at least one built-in abstract function and encapsulate any helper
  functions in a local expression.")

;; declare function ahead of examples
(declare linear-length-lob)

;; examples
(expect (list (+ (:l B1) (:w B1) (:h B1))
              (+ (:l B2) (:w B2) (:h B2))
              (+ (:l B3) (:w B3) (:h B3)))
        (linear-length-lob (list B1 B2 B3)))

#_(defn linear-length-lob
  "(listof Bag) -> (listof Number)
   produce a list of the linear length of all the bags in the given list"
  [lob]
  []) ; stub

(defn linear-length-lob
  "(listof Bag) -> (listof Number)
   produce a list of the linear length of all the bags in the given list"
  [lob]
  (letfn [(linear-length [b]
                         (+ (:l b) (:w b) (:h b)))]
    (map linear-length lob)))

(expectations/run-tests [*ns*])

