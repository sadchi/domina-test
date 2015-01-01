(ns domina-test.core
  (:require [reagent.core :as r]
            [cljs.core.async :refer [chan close!]]
            [domina :as d :refer [add-class! toggle-class! remove-class!]]
            [domina.css :as d-css :refer [sel]])


  (:require-macros
   [cljs.core.async.macros :as m :refer [go]]))

(def state (r/atom true))

(defn load-state []
  (if @state
    (-> (sel ".loader")
        (remove-class! "loaded")
        (add-class! "loading"))
    (-> (sel ".loader")
        (remove-class! "loading")
        (add-class! "loaded"))))

(defn timeout [ms]
  (let [c (chan)]
    (js/setTimeout (fn [] (close! c)) ms)
    c))
  
(defn timeout2 [f ms]
  (js/setTimeout f ms))

(defn btn1 []
  [:div.box {:on-click #(swap! state not)} (str "BTN1 state:" @state )])


(defn btn2 []
  (load-state)
  [:div.box.blue {:on-click #(swap! state not)}])


(defn ^:export start []
  (.log js/console "Started!")
  (r/render-component [btn1] (.getElementById js/document "btn1"))
  (r/render-component [btn2] (.getElementById js/document "btn2")))
