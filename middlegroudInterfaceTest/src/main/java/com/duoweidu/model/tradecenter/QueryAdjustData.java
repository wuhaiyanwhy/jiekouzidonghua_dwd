package com.duoweidu.model.tradecenter;

public class QueryAdjustData {

    public int status;
    public int adjust_amount;
    public String currency;
    public String account_number;
    public int created_at;
    public String trade_no;
    public String adjust_type_code;
    public String adjust_desc;
    public OriginDataModel origin_data;
    public String reverse;

    public static class OriginDataModel {

        public String trade_no;
        public String account_number;
        public int adjust_amount;
        public int adjust_status;
        public String currency;
        public int created_at;
        public int updated_at;
    }

}
