(def barber (agent 0))

(def waiting-room (atom 3))

(defn get-haircut [count]
  (swap! waiting-room inc)
  (println "Start haircut")
  (Thread/sleep 20)
  (inc count))

(defn try-to-sit [count]
  (if (== count 0)
      (do
          ;;(println "No free chairs. The customer leaves")
          count)
      (do
          (println "Sit in waiting room")
          (send barber get-haircut)
          (dec count))))
		  (defn new-customer []
  (swap! waiting-room try-to-sit))

(defn shop-loop [max]
  (let [orig (System/currentTimeMillis)]
      (loop []
          (if (< (- (System/currentTimeMillis) orig) max)
              (let [next (+ 10 (rand 20))]
                  (Thread/sleep next)
                  (new-customer)
                  (recur))
              max))))
			  (defn init [_ v] v)

(defn start [max]
  (println "starting")
  (send barber init 0)
  (swap! waiting-room init 3)
  (future (shop-loop max))
  (Thread/sleep max)
  @barber)
  