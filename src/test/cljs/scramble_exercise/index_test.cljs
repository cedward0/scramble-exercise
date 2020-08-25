(ns scramble-exercise.index_test
  (:require [scramble-exercise.index :refer [api-call api-scramble-call-message]]
            [cljs.test :refer-macros [deftest is testing]]))

(deftest api-scrable-url-path-test
  (testing "if the api path is consistent"
    (is (= "api/scramble" (#'scramble-exercise.index/api-scrable-url-path)))))

(deftest api-scramble-call-message-test
  (testing "scrambling true"
    (is (= "Scrambling result for [a] and [a] is: true"
           (with-redefs [api-call (fn [_ _] {:result true})]
                        (api-scramble-call-message "a" "a")))))
  (testing "scrambling false"
    (is (= "Scrambling result for [1] and [2] is: false<br/>Because"
           (with-redefs [api-call (fn [_ _] {:result false :message "Because"})]
                        (api-scramble-call-message "1" "2"))))))
