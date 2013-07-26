(ns expectations.workaround
  (:require [expectations :refer [->expectation]]))

(defn clear-tests
  "Temporary workaround to clear out all expectations in a list of namespaces.
   Hopefully Jay Fields will add a similar function soon..."
  [ns-list]
  (doseq [ns ns-list]
    (doseq [e-var (->expectation ns)]
      (ns-unmap ns (.sym e-var)))))