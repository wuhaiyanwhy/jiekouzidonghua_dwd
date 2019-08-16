package com.duoweidu.model.tradecenter;

import java.util.ArrayList;

public class WithdrawListData {
    public ArrayList<ListModel>list;

    public static  class ListModel{
        public String trade_no;
        public String gateway_trade_no;
        public int channel_id;
        public String channel_code;
        public String channel_name;
        public int withdraw_status;
        public int withdraw_amount;
        public int service_charge;
        public int real_service_charge;
        public String currency;
        public String target_account;
        public String remark;
        public String fail_reason;
        public int process_at;
    }
}
