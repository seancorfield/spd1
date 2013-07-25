(ns spd1.expectations.bag
  (:require [spd1.bag :refer :all]
            [expectations :refer [expect]]
            :reload-all))

(expect (list (+ (:l B1) (:w B1) (:h B1))
              (+ (:l B2) (:w B2) (:h B2))
              (+ (:l B3) (:w B3) (:h B3)))
        (linear-length-lob (list B1 B2 B3)))

(expectations/run-all-tests)