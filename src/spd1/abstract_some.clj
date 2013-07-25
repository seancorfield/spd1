(ns spd1.abstract-some)

(comment
  "PROBLEM:

  Design an abstract function called some? (including signature, purpose,
  and tests) to simplify the following two functions. When you are done
  rewrite the original functions to use your new some? function.")

(comment
  "PART A: Design an abstract function")

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

;; Clojure doesn't have postive? / negative? primitives so let's define those:
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
