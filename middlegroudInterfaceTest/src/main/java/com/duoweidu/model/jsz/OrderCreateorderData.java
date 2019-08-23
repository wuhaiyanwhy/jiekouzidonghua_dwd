package com.duoweidu.model.jsz;

import java.util.ArrayList;

public class OrderCreateorderData {

    public int order_id;
    public int payment_id;

    public ArrayList<SigndataModel>sign_data;
    public static class SigndataModel{
        public String appId;
        public String timeStamp;
        public String nonceStr;
//        public String package;
        public String signType;
        public String paySign;
    }
}
