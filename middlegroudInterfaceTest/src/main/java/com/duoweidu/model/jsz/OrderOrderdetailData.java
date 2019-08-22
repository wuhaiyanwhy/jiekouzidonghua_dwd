package com.duoweidu.model.jsz;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.ArrayList;

public class OrderOrderdetailData {
    public ArrayList<Listmodel>list;
    public static class Listmodel {
        public int id;
        public int user_id;
        public int commission_user_id;
        public int activity_id;
        public int branch_id;
        public int item_id;
        public int amount;
        public int pay_amount;
        public int commission_amount;
        public String redeem_time;
        public String start_time;
        public String expire_time;
        public String pay_at;
        public String refunded_at;
        public int refund_status;
        public int row_status;
        public String created_at;
        public String branch_name;
        public int status;
        public String status_text;
        public String item_name;
        public String item_image;
        public int sale_price;
        public int market_price;
        public int expire_timestamp;
    }
}
