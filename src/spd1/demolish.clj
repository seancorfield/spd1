(ns spd1.demolish
  (:require [expectations :refer [expect given]]
            [expectations.workaround :refer [clear-tests]]))

(clear-tests [*ns*])

;; Data Definitions

;; BuildingStatus is one of:
;; :new
;; :old
;; :heritage
;; interp. classification of building based on age

#_(defn fn-for-building-status [bs]
  (cond (= :new bs) (...)
        (= :old bs) (...)
        (= :heritage) (...)))

;; Template Rules Used:
;; - one of: 3 cases
;; - atomic distinct: :new
;; - atomic distinct: :old
;; - atomic distinct: :heritage

;; Functions

(comment
  "PROBLEM B:

  The city wants to demolish all buildings classified as "old". You are hired to design a function called
  demolish? that determines whether a building should be torn down or not.")

;; note we must declare the function being tested ahead of the examples
(declare demolish?)

;; basic examples / tests
(expect false (demolish? :new))
(expect true  (demolish? :old))
(expect false (demolish? :heritage))

;; an alternative form of the above tests
(given [result age] (expect result (demolish? age))
       false :new
       true  :old
       false :heritage)

#_(defn demolish?
  "BuildingStatus -> Boolean
   produce true if the building is 'old' and should be demolished."
  [bs]
  false) ; stub

#_(defn demolish?
  "BuildingStatus -> Boolean
   produce true if the building is 'old' and should be demolished."
  [bs]
  (cond (= :new bs) false
        (= :old bs) true
        (= :heritage) false))

(defn demolish?
  "BuildingStatus -> Boolean
   produce true if the building is 'old' and should be demolished."
  [bs]
  (= :old bs))

;; make the tests run automatically
(expectations/run-tests [*ns*])