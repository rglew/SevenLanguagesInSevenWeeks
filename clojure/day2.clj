(defmacro unless
  ([test body] `(if (not ~test) ~body))
  ([test body alt] `(if (not ~test) ~body ~alt)))
  
  (defprotocol Printer
  (print [job device])
  (cancel_job [job device]))
  
  (defrecord HP_Laserjet_1320n []
  Printer
  (print [job device]
    (println (str "Printing " job " on device " device)))
  (cancel_job [job device]
    (println (str "Cancelling job " job " on device " device))))
	
  (defrecord Canon_Inkjet_600C []
  Printer
  (print [job device]
    (println (str "Printing " job " on device " device)))
  (cancel_job [job device]
    (println (str "Cancelling job " job " on device " device))))
	
