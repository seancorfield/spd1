;; double-starter.clj
;; Week3 - Lecture 2a, 2b

(ns spd1.double-starter
  (:require [expectations :refer [expect run-tests]]))


(comment
  "PROBLEM:

  Design a function that consumes a number and produces twice that number. 
  Call your function double. Follow the HtDF recipe and show the stub and 
  template." )


;; Number -> Number
;; produce 2 times the given number
(declare double-fn)
(expect 6 (double-fn 3))
(expect 8.4 (double-fn 4.2))

;(defn double-fn [n] 0)  ; Stub

;(defn double [n]  ; Template
;  (... n))

(defn double-fn [n]  ; Function
  "Number -> Number
   produce 2 times the given number"
  (* n 2))


;; automcatically run tests
(run-tests [*ns*])
(remove-ns (symbol (str *ns*)))