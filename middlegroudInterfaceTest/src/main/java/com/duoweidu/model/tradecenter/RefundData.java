package com.duoweidu.model.tradecenter;

public class RefundData {

    public String trade_no;
    public String pay_trade_no;
    public int refund_amount;
    public OriginDataModel origin_data;
    public String reverse;

    public static class OriginDataModel {
        public String account_number;
        public int refund_amount;
    }
}
