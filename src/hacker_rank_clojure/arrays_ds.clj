(ns hacker_rank_clojure.arrays-ds)

(use '[clojure.string :only (split triml)])

(
  let [
       n_t (read-line)
       n (Integer/parseInt n_t)
       ]

  (
    let [
         arr_temp (read-line)
         arr_t (split arr_temp #"\s+")
         arr (map #(Integer/parseInt %) arr_t)
         ]
    (println (clojure.string/join " " (reverse arr)))
    )
  )
