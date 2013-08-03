(ns spd1.less-than-five
  (:require [expectations :refer [expect run-tests]]))

;; less-than-five.clj
;; week 3 - practice- W2P2

(comment
  "PROBLEM:

   DESIGN function that consumes a string 
   and determines whether its length is less than 5.

   Remember, when we say DESIGN, we mean follow the recipe.

   Your complete design should include signature, purpose, 
   commented out stub, examples/tests, commented out template,
   and the completed function definition."

  " BSL: (string-length str) -> Clojure: (count str)")


(declare less-than-5?)

;; tests
(expect true  (less-than-5? ""))
(expect true  (less-than-5? "five"))
(expect false (less-than-5? "12345"))
(expect false (less-than-5? "eighty"))

;(defn less-than-5? [s]  ;stub
;  true)

;(defn (ess-than-5? [s]  ;template
;  (... s))

(defn less-than-5? [s]   ;function
  "String -> Boolean
   produce true if length of string is less than 5"
  (< (count s) 5))



;; Automcatically run tests
(run-tests [*ns*])
(remove-ns (symbol (str *ns*)))