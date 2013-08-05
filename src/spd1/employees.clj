(ns spd1.employees
  (:require [expectations :refer [expect run-tests]]))


;; employees-solution.rkt

;; =================
;; Data definitions:

;
; PROBLEM A:
;
; You work in the Human Resources department at a ski lodge. Because the lodge is busier at certain times
; of year, the number of employees fluctuates. There are always more than 10, but the maximum is 50.
;
; Design a data definition to represent the number of ski lodge employees. Call it Employees.
;


;; Employees is Natural(10, 50]
;; Interp. range of employees working at a ski lodge at one time

(def E1 11)
(def E2 40)
(def E3 50)

#_
(define (fn-for-employees e)
  (... e))

;; Template rules used:
;;  - atomic non-distinct: Natural(10, 50]

;; =================
;; Functions:

;
; PROBLEM B:
;
; Now design a function that will calculate the total payroll for the quarter. Each employee is paid
; $1,500 per quarter. Call it calculate-payroll.
;

(declare calculate-payroll)

(expect 16500 (calculate-payroll E1))
(expect 60000 (calculate-payroll E2))
(expect 75000 (calculate-payroll E3))

#_(defn calculate-payroll
  "Employees -> Natural
  calculates the ski lodge's payroll based on $1,500/employee"
  [e]
  0) ; stub

;<use template from Employees>

(defn calculate-payroll
  "Employees -> Natural
  calculates the ski lodge's payroll based on $1,500/employee"
  [e]
  (* e 1500))

;; run all tests
(run-tests [*ns*])
