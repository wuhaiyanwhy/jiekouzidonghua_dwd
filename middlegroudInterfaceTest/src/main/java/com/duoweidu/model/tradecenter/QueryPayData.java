package com.duoweidu.model.tradecenter;

public class QueryPayData {

    public boolean has_refund;
    public int status;
    public int total_amount;
    public String pay_type_code;
    public String pay_desc;
    public OriginDataModel origin_data;
    public String reverse;

    public static class OriginDataModel {
        public String trade_no;
        public String order_no;
        public int pay_amount;
        public String currency;
        public String channel_name;
        public String channel_code;
        public String account_number;
        public int pay_status;
        public int pay_finished;
        public int created_at;
        public int updated_at;
    }
}
