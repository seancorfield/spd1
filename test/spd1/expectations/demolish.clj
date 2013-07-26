(ns spd1.expectations.demolish
  (:require [spd1.demolish :refer :all]
            [expectations :refer [expect given]]))

;; basic examples / tests
(expect false (demolish? :new))
(expect true  (demolish? :old))
(expect false (demolish? :heritage))

;; an alternative form of the above tests
(given [result age] (expect result (demolish? age))
       false :new
       true  :old
       false :heritage)
