(ns scramble-exercise.scramble-test
  (:require [clojure.test :refer :all]
            [scramble-exercise.scramble :refer :all]))

(defn- api-call
  "Makes the API call returning the body of response"
  [str1 str2]
  {:a ""})

(defn- api-scramble-call-message
  "Connects to API scramble to get the result of scrambling and displaying it in message element of the page"
  [str1 str2]
  (let [body (api-call str1 str2)
        result (:result body)]
    (str "Scrambling result for [" str1 "] and [" str2 "] is: " result
         (if (not result) (str "<br/>" (:message body))))))


(deftest scramble?-test
  (testing "negative"
    (is (false? (scramble? "katas" "steak")))
    (is (false? (scramble? "" "")))
    (is (false? (scramble? "1" "q")))
    (is (false? (scramble? "a" "_")))
    (is (false? (scramble? "\\/" "vv")))
    (is (false? (scramble? "w" "V")))
    (is (false? (scramble? "" "aaaaaaaaa")))
    (is (false? (scramble? "sfavdava" "")))
    (is (false? (scramble? "123123123" "2351523")))
    (is (false? (scramble? "ASDWCAsdasd" "PVLXV")))
    (is (false? (scramble? "aaaaa" "aaaaaaaaa")))
    (is (false? (scramble? " -213sda0/.A" "28s 0)3^=s;OKS"))))
  (testing "positive"
    (is (true? (scramble? "rekqodlw" "world")))
    (is (true? (scramble? "abcdefghijklmnopqrstwxyz" "zyxwtsrqponmlkjihgfedcba")))
    (is (true? (scramble? "cedewaraaossoqqyt" "codewars")))
    (is (true? (scramble? "helloworld" "world")))
    (is (true? (scramble? "listen" "silent")))
    (is (true? (scramble? "ccccccccccfffffffffkkkkkkkklllllll" "cffkkkllll")))
    (is (true? (scramble? "cfccccfccffffffllkkkkffkkfkklllcccll" "cffkkkllll")))
    (is (true? (scramble? "cfcckkccfccffcffffllkkffkkfkklllccll" "cfkllllkkf")))
    (is (true? (scramble? "todayisthebestdayofmylife" "fomo")))
    (is (true? (scramble? "qwertyuiopasdfghjklzxcvbnm" "qwertyuiopasdfghjklzxcvbnm")))))

(deftest can-be-scrambled?-regex-test
  (testing "timing regex function"
    (time (#'scramble-exercise.scramble/can-be-scrambled?-regex "a" "a"))
    (time (#'scramble-exercise.scramble/can-be-scrambled?-regex "xx" "xx"))
    (time (#'scramble-exercise.scramble/can-be-scrambled?-regex "zzz" "zzz"))
    (time (#'scramble-exercise.scramble/can-be-scrambled?-regex
            "qwerqwrtwetyerwytruyertuytuiyuoupyoiasdfadfgdsgdfhfhjghlgjhkhmnbcmbnvxvbnxzcvzbxcbxzcvzxcvzxcvzxcbxzczfdwra"
            "poiuytrewqlkjhgfdsamnbvcxzqazwsxedcrfvtgbyhnujmikolpmlpnkonjibhuvgycftxdrzseawqlikjihogiofgnghnmcbnvhdhsaef"))
    (time (#'scramble-exercise.scramble/can-be-scrambled?-regex
            (str "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                 "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                 "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm")
            (str "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
                 "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
                 "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww")))
    (time (#'scramble-exercise.scramble/can-be-scrambled?-regex
            (str "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            (str "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")))))

(deftest can-be-scrambled?-count-map-test
  (testing "timing count map function"
    (time (#'scramble-exercise.scramble/can-be-scrambled?-count-map "a" "a"))
    (time (#'scramble-exercise.scramble/can-be-scrambled?-count-map "xx" "xx"))
    (time (#'scramble-exercise.scramble/can-be-scrambled?-count-map "zzz" "zzz"))
    (time (#'scramble-exercise.scramble/can-be-scrambled?-count-map
            "qwerqwrtwetyerwytruyertuytuiyuoupyoiasdfadfgdsgdfhfhjghlgjhkhmnbcmbnvxvbnxzcvzbxcbxzcvzxcvzxcvzxcbxzczfdwra"
            "poiuytrewqlkjhgfdsamnbvcxzqazwsxedcrfvtgbyhnujmikolpmlpnkonjibhuvgycftxdrzseawqlikjihogiofgnghnmcbnvhdhsaef"))
    (time (#'scramble-exercise.scramble/can-be-scrambled?-count-map
            (str "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                 "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                 "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm")
            (str "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
                 "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
                 "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww")))
    (time (#'scramble-exercise.scramble/can-be-scrambled?-count-map
            (str "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            (str "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")))))
