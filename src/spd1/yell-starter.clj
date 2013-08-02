(ns spd1.yell-starter
 (:require [expectations :refer [expect run-tests]]))

;; yell-starter.clj
;; Week 2 - Lecture 2c

(comment
  "PROBLEM:

   DESIGN a function called yell that consumes strings like 'hello' 
   and adds '!' to produce strings like 'hello!'.

   Remember, when we say DESIGN, we mean follow the recipe.

   Leave behind commented out versions of the stub and template.")

(ns spd1.find-person
  (:require [expectations :refer [expect run-tests]]))



;; String -> String
;; Produces a String appended with ! given a String
(declare yell)
(expect "dog!" (yell "dog"))
(expect "cat!!" (yell "cat!")) ; I'm really afraid of cats

;(defn yell [st] "") ;; Stub

;;(defn yell [st]     ;; Template
;;  (... st ... "!"))

(defn yell [st]   ;; Function
  "String -> String
   Produces a String appended with ! given a String"
  (str st "!"))



;; automcatically run tests
(run-tests [*ns*])
(remove-ns (symbol (str *ns*)))