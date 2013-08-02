(ns spd1.area-starter
  (:require [expectations :refer [expect run-tests]]))

(comment
  "PROBLEM:

   DESIGN a function called area that consumes the length of one side 
   of a square and produces the area of the square.

   Remember, when we say DESIGN, we mean follow the recipe.

   Leave behind commented out versions of the stub and template.")


;; Number -> Number
;; produces the area of a square given the length of the side
(declare area)
(expect (* 3 3)     (area 3))
(expect (* 3.2 3.2) (area 3.2))

;(defn area [len] 0) ; stub

;;(defn area [len]  ; template
;;  (... len))

(defn area [len]   ; actual function
  (* len len))



;; automcatically run tests
(run-tests [*ns*])
(remove-ns (symbol (str *ns*)))