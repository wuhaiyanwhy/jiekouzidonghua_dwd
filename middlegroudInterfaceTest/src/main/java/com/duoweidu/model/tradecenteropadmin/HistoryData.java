package com.duoweidu.model.tradecenteropadmin;

import java.util.ArrayList;

public class HistoryData {

    public ArrayList<ListModel> list;
    public int total_cnt;
    public int total_page;

    public static class ListModel {
        public int id;
        public int before_available_amount;
        public int before_frozen_amount;
        public int change_amount;
        public String change_code;
        public int after_available_amount;
        public int after_frozen_amount;
        public int created_at;
    }
}
