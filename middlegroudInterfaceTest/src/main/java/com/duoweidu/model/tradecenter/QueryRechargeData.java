package com.duoweidu.model.tradecenter;

public class QueryRechargeData {

    public String trade_no;
    public int recharge_amount;
    public String currency;
    public int recharge_status;
    public String account_number;
    public String recharge_type_code;
    public String recharge_desc;
    public OriginDataModel origin_data;
    public String reverse;

    public static class OriginDataModel {

        public String trade_no;
        public int recharge_amount;
        public String currency;
        public String channel_name;
        public String channel_code;
        public String account_number;
        public int recharge_status;
        public int created_at;
        public int updated_at;
    }

}
