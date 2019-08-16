package com.duoweidu.model.tradecenter;

public class QueryWithdrawData {

    public String trade_no;
    public String gateway_trade_no;
    public int platform_id;
    public int platform_user_id;
    public int global_user_id;
    public int withdraw_status;
    public int withdraw_amount;
    public int service_charge;
    public int real_service_charge;
    public String currency;
    public String target_account;
    public String remark;
    public String fail_reason;
    public int process_at;
    public originModel origin;
    public String reverse;

    public static class originModel {
        public String return_code;
        public String return_msg;
        public String result_code;
        public String err_code;
        public String err_code_des;
        public String partner_trade_no;
        public String mch_id;
        public String appid;

    }
}
