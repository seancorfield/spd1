(ns spd1.trip
  (:require [expectations :refer [expect run-tests]]))


;; trip-solution.rkt

;; =================
;; Data definitions:

;; in this example, we use a record and protocols for the associated functions

;
; PROBLEM A:
;
; Design a data definition to help travellers plan their next trip.
; A trip should specify an origin, destination, mode of transport and
; duration (in days).
;

(defrecord Trip [origin destination mot duration])
;; Trip is (->Trip String String String Natural)
;; interp. a trip with origin, destination, mode of transport, and duration in days

(def T1 (->Trip "Vancouver" "Cancun" "Flight" 10))
(def T2 (->Trip "Calgary" "Ottawa" "Car" 14))
(def T3 (->Trip "Montreal" "New York" "Flight" 5))

#_
(def (fn-for-trip t)
  (... (:origin t)       ;String
       (:destination t)  ;String
       (:mot t)          ;String
       (:duration t)))   ;Natural


;; Template rules used:
;; - compound: 4 fields

;; =================
;; Functions:

;
; PROBLEM B:
;
; You have just found out that you have to use all your days off work
; on your next vacation before they expire at the end of the year.
; Comparing two options for a trip, you want to take the one that
; lasts the longest. Design a function that compares two trips and
; returns the trip with the longest duration.
;
; Note that the rule for templating a function that consumes two
; compound data parameters is for the template to include all
; the selectors for both parameters.
;

;; Note that with protocols, this acts as the "forward declaration" and could
;; have any number of functions declared that operate on Trip data so I've defined
;; one that makes a printable version of a Trip, as an example

(defprotocol TripRelated
  (longer-trip? [this trip]
                "Trip Trip -> Trip
                produce the trip with the longer duration")
  (printable [this]
             "Trip -> String
             produce a printable, human readable string describing a trip"))

(expect T2 (longer-trip? T2 T3))
(expect T1 (longer-trip? T3 T1))
(expect (->Trip "Houston" "Dallas" "Car" 5)
        (longer-trip? T3 (->Trip "Houston" "Dallas" "Car" 5)))

;(define (longer-trip? t1 t2) T1)  ; stub

#_
(define (fn-for-trip t1 t2)
  (... (:origin t1)
       (:destination t1)
       (:mot t1)
       (:duration t1)
       (:origin t2)
       (:destination t2)
       (:mot t2)
       (:duration t2)))



(extend-protocol TripRelated
  Trip
  (longer-trip? [this trip]
                (if (> (:duration this) (:duration trip))
                  this
                  trip))
  (printable [this] (str "Travelling from " (:origin this) " to " (:destination this) " by " (:mot this) " takes " (:duration this) " hours.")))

(printable T1)
(printable T2)
(printable T3)

;; run the tests
(run-tests [*ns*])
