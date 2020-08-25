(ns scramble-exercise.view)

(defn content-page [message]
  [:body {:class "body"}
   [:h1 "Scramble exercise"] [:br]
   [:section
    [:form {:id "form" :name "form" :action "/api/scramble" :method "POST"}
     [:label {:for "str1"} "First string: "]
     [:input {:type "text" :name "str1" :id "str1"}] [:br]
     [:label {:for "str2"} "Second string: "]
     [:input {:type "text" :name "str2" :id "str2"}] [:br] [:br]
     [:button {:type "submit"} "Scramble"]] [:br]
    [:div
     [:p {:id "message" :name "message"} [:strong message]]]]])

(defn not-found-page []
  [:body {:class "body"}
   [:h1 "Page NOT found"]])
