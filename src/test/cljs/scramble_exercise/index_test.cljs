(ns scramble-exercise.index_test
  (:require [scramble-exercise.index :refer [api-call api-scramble-call-message]]
            [cljs.test :refer-macros [deftest is testing]]))

(deftest api-scrable-url-path-test
  (testing "if the api path is consistent"
    (is (= "api/scramble" (#'scramble-exercise.index/api-scrable-url-path)))))
