; Code is not mine - shamelessly stolen from here - only included for completeness for Clojure Day 3
; http://blog.wakatta.jp/blog/2011/11/13/seven-languages-in-seven-weeks-clojure-day-3/

(defn check-balance [b]
  "Check that the balance of account is not negative"
  (<= 0 b))

(defn make-account []
  "Create a new account"
  (let [r (ref 0)]
      (set-validator! r check-balance)
      r))  

(defn credit [account, amount]
  "Add amount to account's balance"
  (alter account + amount))

(defn debit [account, amount]
  "Debit amount from account's balance"
  (alter account - amount))
  
(defn balance [account]
  "Return balance of account"
  @account)

(defn make-bank [n]
  "Create a bank of n accounts"
  (vec (repeatedly n make-account)))
  
(defn bank-credit [bank, acc_num, amount]
  "Add amount to acc_num's balance"
  (credit (nth bank acc_num) amount))

(defn bank-debit [bank, acc_num, amount]
  "Debit amount from acc_num's balance"
  (debit (nth bank acc_num) amount))

(defn bank-balance [bank, acc_num]
  "Return the balance of acc_num"
  (balance (nth bank acc_num)))

(defn bank-transfer [bank, acc_num1, acc_num2, amount]
  "Transfer amount from acc_num1 to acc_num2 in bank"
  (dosync 
      (bank-credit bank acc_num2 amount)
      (bank-debit bank acc_num1 amount)))

(defn bank-balances [bank]
  "Show the balance of all accounts"
  (dotimes [i (count bank)]
      (println (str "Account " i ": " (bank-balance bank i)))))
	  
	 
; USAGE

;; create the bank
(def bank (make-bank 3))

;; put some money in
(dosync (bank-credit bank 0 100))

;; show the balances
(bank-balances bank)

;; a first transfer
(dosync (bank-transfer bank 0 1 75))

;; show the balances
(bank-balances bank)

;; not enough fund, so it will fail
(dosync (bank-transfer bank 0 2 75))

;; and indeed, the balances have not changed
(bank-balances bank)