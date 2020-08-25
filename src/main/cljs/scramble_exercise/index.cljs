(ns scramble-exercise.index
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [clojure.browser.dom :as dom])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn- update-message
  "Updates the message element in page with the given text"
  [message]
  (set! (.-innerHTML (dom/get-element "message")) message))

(update-message "")

(defn- api-scrable-url-path
  "Computes the API path"
  []
  "api/scramble")

(defn- api-call
  "Makes the API call returning the body of response"
  [str1 str2]
  (go (let [response (<! (http/post (api-scrable-url-path) {:form-params {:str1 str1 :str2 str2}}))]
        (:body response))))

(defn- api-scramble-call-message
  "Connects to API scramble to get the result of scrambling and displaying it in message element of the page"
  [str1 str2]
  (let [body (api-call str1 str2)
        result (:result body)]
    (str "Scrambling result for [" str1 "] and [" str2 "] is: " result
         (if (not result) (str "<br/>" (:message body))))))

(defn- form-on-submit-override
  "Changes the page form on submit behaviour to call API scramble and to show the result in the same page"
  []
  (set! (.-form js/document)
        -onsubmit
        (fn [e]
          (do (.preventDefault e)
              (update-message
                (api-scramble-call-message (dom/get-value (dom/get-element "str1"))
                                           (dom/get-value (dom/get-element "str2"))))))))

(form-on-submit-override)
