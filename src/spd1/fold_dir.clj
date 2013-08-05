(ns spd1.fold-dir
  (:require [expectations :refer [expect run-tests]]))

;; fold-dir-solution without the image stuff (which isn't needed anyway)

;
; In this exercise you will be need to remember the following DDs
; for an image organizer.
;


;; =================
;; Data definitions:

;; using a plain map for the Dir struct in this example
;; since we don't have a record constructore, we'll define a utility fn for the map:
(defn make-dir [name sub-dirs images] {:name name :sub-dirs sub-dirs :images images})
;; Dir is {:name String :sub-dirs ListOfDir :images ListOfImage}
;; interp. An directory in the organizer, with a name, a list
;;         of sub-dirs and a list of images.

;; ListOfDir is one of:
;;  - []
;;  - (cons Dir ListOfDir)
;; interp. A list of directories, this represents the sub-directories of
;;         a directory.

;; ListOfImage is one of:
;;  - []
;;  - (cons Image ListOfImage)
;; interp. a list of images, this represents the sub-images of a directory.
;; NOTE: Image is a primitive type, but ListOfImage is not.
;; (there is no Image type in Clojure so we'll just use arrays of the attributes)

(def I1 [:square 10 "solid" "red"])
(def I2 [:square 12 "solid" "green"])
(def I3 [:rectangle 13 14 "solid" "blue"])
(def D4 (make-dir "D4" [] (list I1 I2)))
(def D5 (make-dir "D5" [] (list I3)))
(def D6 (make-dir "D6" (list D4 D5) []))


;; =================
;; Functions:

;
; PROBLEM A:
;
; Design an abstract fold function for Dir called fold-dir.
;

(declare fold-dir)

;; (foldr cons empty (list 1 2 3)) becomes (reduce conj [] (list 1 2 3))
;; althought that produces [1 2 3], a vector, but in the fold-dir function
;; the combiner functions are used in a manner than cons is suitable
(expect (list 1 2 3) (reduce conj [] (list 1 2 3)))

;; we could define our own foldr that matched Racket's however:
;; (X Y -> Y) Y (listof X) -> Y
(declare foldr)
(expect (list 1 2 3) (foldr cons () (list 1 2 3)))
;(defn foldr [f y l] ()) ; stub
(defn foldr [f y l]
  (cond (empty? l) y
        :else (f (first l)
                 (foldr f y (rest l)))))

;; (String Y Z -> X) (X Y -> Y) (Image Z -> Z) Y Z Dir -> X
;; the abstract fold function for Dir
(expect D6 (fold-dir make-dir cons cons () () D6))

(defn fold-dir [c1 c2 c3 b1 b2 d]
  (letfn [(fn-for-dir [d]         ; Dir -> X
            (c1 (:name d)
                (fn-for-lod (:sub-dirs d))
                (fn-for-loi (:images d))))

          (fn-for-lod [lod]       ; (listof Dir) -> Y
            (cond (empty? lod) b1
                  :else
                   (c2 (fn-for-dir (first lod))
                       (fn-for-lod (rest lod)))))

          (fn-for-loi [loi]       ; (listof Image) -> Z
            (cond (empty? loi) b2
                  :else
                   (c3 (first loi)
                       (fn-for-loi (rest loi)))))]
    (fn-for-dir d)))

;
; PROBLEM B:
;
; Design a function that consumes a Dir and produces the number of
; images in the directory and its sub-directories.
; Use the fold-dir abstract function.
;

(declare count-images)
;; Dir -> Natural
;; count total number of Images in dir and all its subdirs
(expect 2 (count-images D4))
(expect 3 (count-images D6))

(defn count-images [d]
  (letfn [(c1 [n rlod rloi] (+ rlod rloi))
          (c2 [rdir rlod]   (+ rdir rlod))
          (c3 [img rloi]    (+ 1 rloi))]
    (fold-dir c1 c2 c3 0 0 d)))

;
; PROBLEM C:
;
; Design a function that consumes a Dir and a String. The function looks in
; dir and all its sub-directories for a directory with the given name. If it
; finds such a directory it should produce true, if not it should produce false.
; Use the fold-dir abstract function.
;

(declare find)

;; String Dir -> Boolean
;; look for a dir named name, if found produce true, otherwise produce false
(expect true (find "D4" D6))
(expect false (find "D8" D4))

(defn find [name dir]
  (letfn [(c1 [n rdirs rimgs]
            (or (= name n)
                rdirs
                rimgs))
          (c2 [rdir rdirs]
            (or rdir rdirs))
          (c3 [img rimgs]
            false)]
    (fold-dir c1 c2 c3 false false dir)))

;
; PROBLEM D:
;
; Is fold-dir really the best way to code the function from part C? Why or
; why not?
;
; No. Consider the case where the directory we are looking for is at the very
; root of the tree. As we have written the function in part C with fold-dir,
; even though find will produce true for the root node it will search the whole
; tree anyways.
;
; When we use fold-dir it isn't possible to implement find so that it stops
; searching as soon as it finds a directory with the right name. Instead it
; will always search the whole tree.
;



;; automcatically run tests
(run-tests [*ns*])
