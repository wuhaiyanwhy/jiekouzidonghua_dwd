package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class OrderDeliverymessageData {

    public int order_id;
    public int user_id;
    public int type;
    public String delivery_no;
    public String delivery_com_code;
    public String delivery_com_name;
    public String status;
    public int updated_at;
    public ArrayList<MsgModel> msg;
    public int platform;
    public int userId;
    public int orderId;

    public static class MsgModel {
        public String time;
        public String context;
        public String ftime;
        public String areaName;
        public String status;

    }


}
