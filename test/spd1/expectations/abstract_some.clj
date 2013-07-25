(ns spd1.expectations.abstract-some
  (:require [spd1.abstract-some :refer :all]
            [expectations :refer [expect]]))

(expect false (some-pred? positive? []))
(expect true (some-pred? positive? (list 1 4 -1 3)))
(expect false (some-pred? positive? (list -1 -5)))
(expect true (some-pred? negative? (list 2 -1)))
(expect true (some-pred? even? (list 1 5 2 7)))
(expect true (some-pred? odd? (list 1 5 2 7)))
(expect false (some-pred? odd? (list 2 4 6)))

(expect false (some-positive? []))
(expect true (some-positive? (list 2 -3 -4)))
(expect false (some-positive? (list -2 -3 -4)))

(expect false (some-negative? []))
(expect true (some-negative? (list 2 3 -4)))
(expect false (some-negative? (list 2 3 4)))
