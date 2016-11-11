package com.angcyo.eventbus30demo;

/**
 * Created by angcyo on 2016-08-15.
 */
public class MsgEvent {


    public static class MyMsg {
        public String jsonData;

        public MyMsg(String jsonData) {
            this.jsonData = jsonData;
        }
    }

    public static class MessageInts {
        public int num;

        public MessageInts(int num) {
            this.num = num;
        }
    }
}
