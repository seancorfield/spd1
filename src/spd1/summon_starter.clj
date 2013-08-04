(ns spd1.summon-starter
  (:require [expectations :refer [expect run-tests]]))

;; summon-starter.clj
;; Week 2 -  practice problem -  W2P1

(comment
  "PROBLEM:

  You might want to use a spell to summon items like a magician.
  DESIGN a function that generates summoning charms with a magician's
  enthusiasm. For example:

     (summon 'Firebolt') should produce 'summon Firebolt!'
     (summon 'portkey') should produce 'summon portkey!'
     (summon 'broom') should produce 'summon broom!'

  Remember, when we say DESIGN, we mean follow the recipe.

  Your complete design should include signature, purpose,
  commented out stub, examples/tests, commented out template,
  and the completed function definition."

  "BSL's 'string-apend' => Clojere's 'str'")



(declare summon)

;; tests
(expect "summon Firebolt!"          (summon "Firebolt"))
(expect (str "summon " "portkey!")  (summon "portkey"))
(expect (str "summon " "broom" "!") (summon "broom"))

;(defn summon [s]  ;stub
;  "a")

;(defn summon [s]  ;template
;  (... s))

(defn summon [s]
  " String -> String
    add 'summon' to the start of s and '!' to the end"
  (str "summon " s "!"))

;; automcatically run tests
(run-tests [*ns*])
