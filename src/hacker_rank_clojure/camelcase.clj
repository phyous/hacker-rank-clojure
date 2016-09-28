(ns hacker-rank-clojure.camelcase)
(use '[clojure.string :only (split triml)])

(defn count-words
  "counts the number of words in a camel case string"
  [s]
  (+ 1 (count (re-seq #"[A-Z]" s)) )
  )

(let 
  [s (read-line)]
  (println (count-words s))
  )
