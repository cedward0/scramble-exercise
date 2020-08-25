(ns scramble-exercise.view_test
  (:require [clojure.test :refer :all]
            [scramble-exercise.view :refer :all]))

(deftest content-page-test
  (testing "negative"
    (is (= [:body {:class "body"}
            [:h1 "Scramble exercise"] [:br]
            [:section
             [:form {:action "/api/scramble" :id "form" :method "POST" :name "form"}
              [:label {:for "str1"} "First string: "] [:input {:id "str1" :name "str1" :type "text"}] [:br]
              [:label {:for "str2"} "Second string: "] [:input {:id "str2" :name "str2" :type "text"}] [:br] [:br]
              [:button {:type "submit"} "Scramble"]] [:br]
             [:div [:p {:id "message" :name "message"} [:strong ""]]]]]
           (content-page "")))))

(deftest not-found-page-test
  (testing "negative"
    (is (= [:body {:class "body"} [:h1 "Page NOT found"]]
           (not-found-page)))))
