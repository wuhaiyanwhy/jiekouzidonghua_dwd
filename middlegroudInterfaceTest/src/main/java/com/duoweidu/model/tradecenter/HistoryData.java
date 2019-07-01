package com.duoweidu.model.tradecenter;

import java.util.ArrayList;

public class HistoryData {

    public ArrayList<ListModel> list;
    public int total_cnt;
    public int total_page;
    public String reverse;

    public static class ListModel {
        public int record_id;
        public int before_available_amount;
        public int before_frozen_amount;
        public int change_amount;
        public int change_type;
        public String change_code;
        public String change_type_code;
        public String change_desc;
        public int after_available_amount;
        public int after_frozen_amount;
        public String related_trade_no;
        public int created_at;
        public String account_type_code;
        public String account_type_desc;
        public String currency;

    }
}
