(ns spd1.bag)

(defrecord Bag [l w h])
;; Bag is (->Bag Number Number Number)
;; interp. a bag with a length, width, and height in centimeters
(def B1 (->Bag 19.5 10.0 6.5))
(def B2 (->Bag 23.0 11.5 7.0))
(def B3 (->Bag 18.0 9.5 5.5))

;; ListOfBag is one of:
;; - empty []
;; - (cons Bag ListOfBag)
(def LOB1 [])
(def LOB2 (list B1 B2 B3))

#_(defn linear-length-lob
  "(listof Bag) -> (listof Number)
   produce a list of the linear length of all the bags in the given list"
  [lob]
  []) ; stub

(defn linear-length-lob
  "(listof Bag) -> (listof Number)
   produce a list of the linear length of all the bags in the given list"
  [lob]
  (letfn [(linear-length [b]
                         (+ (:l b) (:w b) (:h b)))]
    (map linear-length lob)))
