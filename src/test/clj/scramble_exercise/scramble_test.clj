(ns scramble-exercise.scramble-test
  (:require [clojure.test :refer :all]
            [scramble-exercise.scramble :refer :all]))

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

(deftest scramble?-with-message-test
  (testing "negative"
    (is (= {:message "The second string cannot be scrambled from the first string" :result false}
           (scramble?-with-message "katas" "steak")))
    (is (= {:message "Both strings are empty" :result false}
           (scramble?-with-message "" "")))
    (is (= {:message "[1] does not have only lower case letters" :result false}
           (scramble?-with-message "1" "q")))
    (is (= {:message "[_] does not have only lower case letters" :result false}
           (scramble?-with-message "a" "_")))
    (is (= {:message "[\\/] does not have only lower case letters" :result false}
           (scramble?-with-message "\\/" "vv")))
    (is (= {:message "[V] does not have only lower case letters" :result false}
           (scramble?-with-message "w" "V")))
    (is (= {:message "First string is empty" :result false}
           (scramble?-with-message "" "aaaaaaaaa")))
    (is (= {:message "Second string is empty" :result false}
           (scramble?-with-message "sfavdava" "")))
    (is (= {:message "[123123123] does not have only lower case letters and [2351523] does not have only lower case letters" :result false}
           (scramble?-with-message "123123123" "2351523")))
    (is (= {:message "[ASDWCAsdasd] does not have only lower case letters and [PVLXV] does not have only lower case letters" :result false}
           (scramble?-with-message "ASDWCAsdasd" "PVLXV")))
    (is (= {:message "The second string cannot be scrambled from the first string" :result false}
           (scramble?-with-message "aaaaa" "aaaaaaaaa")))
    (is (= {:message "[ -213sda0/.A] does not have only lower case letters and [28s 0)3^=s;OKS] does not have only lower case letters" :result false}
           (scramble?-with-message " -213sda0/.A" "28s 0)3^=s;OKS"))))
  (testing "positive"
    (is (= {:result true} (scramble?-with-message "rekqodlw" "world")))
    (is (= {:result true} (scramble?-with-message "abcdefghijklmnopqrstwxyz" "zyxwtsrqponmlkjihgfedcba")))
    (is (= {:result true} (scramble?-with-message "cedewaraaossoqqyt" "codewars")))
    (is (= {:result true} (scramble?-with-message "helloworld" "world")))
    (is (= {:result true} (scramble?-with-message "listen" "silent")))
    (is (= {:result true} (scramble?-with-message "ccccccccccfffffffffkkkkkkkklllllll" "cffkkkllll")))
    (is (= {:result true} (scramble?-with-message "cfccccfccffffffllkkkkffkkfkklllcccll" "cffkkkllll")))
    (is (= {:result true} (scramble?-with-message "cfcckkccfccffcffffllkkffkkfkklllccll" "cfkllllkkf")))
    (is (= {:result true} (scramble?-with-message "todayisthebestdayofmylife" "fomo")))
    (is (= {:result true} (scramble?-with-message "qwertyuiopasdfghjklzxcvbnm" "qwertyuiopasdfghjklzxcvbnm")))))
