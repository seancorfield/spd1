(ns spd1.sum-n)

#_(defn sum-n-odds
  "Natural -> Natural
   Produce the sum of the first n odd numbers."
  [n] 0) ; stub

(defn sum-n-odds
  "Natural -> Natural
   Produce the sum of the first n odd numbers."
  [n]
  (reduce + 0 (filter odd? (range (* 2 n)))))