package com.duoweidu.model.tradecenter;

public class QueryRefundData {

    public String trade_no;
    public String pay_trade_no;
    public int refund_amount;
    public String currency;
    public String refund_type_code;
    public String refund_desc;
    public OriginDataModel origin_data;
    public int refund_status;
    public String reverse;

    public static class OriginDataModel {
        public String account_number;
        public int refund_amount;
        public String currency;
        public String pay_trade_no;
    }

}
