(ns spd1.expectations.demolish
  (:require [spd1.demolish :refer :all]
            [expectations :refer [expect]]))

(expect false (demolish? :new))
(expect true  (demolish? :old))
(expect false (demolish? :heritage))
