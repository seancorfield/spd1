(ns spd1.area-starter
  (:require [expectations :refer [expect run-tests]]))

;; area-starter.clj
;; week2 - lecture 2d

(comment
  "PROBLEM:

   DESIGN a function called area that consumes the length of one side 
   of a square and produces the area of the square.

   Remember, when we say DESIGN, we mean follow the recipe.

   Leave behind commented out versions of the stub and template."

   "Clojure: no built in square function(?)")


(declare area) ;

(expect (* 3 3)     (area 3))
(expect (* 3.2 3.2) (area 3.2))

;(defn area [len] 0) ;stub

;(defn area [len]    ;template
;  (... len))

(defn area [len]     ;function
  (* len len))



;; automcatically run tests
(run-tests [*ns*])
(remove-ns (symbol (str *ns*)))