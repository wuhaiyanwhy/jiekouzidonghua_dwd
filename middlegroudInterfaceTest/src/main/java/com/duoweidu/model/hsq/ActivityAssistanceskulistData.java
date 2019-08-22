package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class ActivityAssistanceskulistData {

    public ArrayList<ListModel> list;
    public int totalCnt;
    public int totalPage;

    public static class ListModel {
        public int activity_id;
        public String title;
        public int start_time;
        public int end_time;
        public int status;
        public int activity_status;
        public int merchant_id;
        public int booster_num;
        public int join_times_limit;
        public String activity_rule;
        public String priority;
        public int increase_stock;
        public int left_stock;
        public int locked_stock;
        public int activity_stock;
        public int sku_id;
        public int product_id;
        public int activity_type;
        public int activity_price;
        public int single_price;
        public String name;
        public String thunbnail;
        public int created_at;
        public String app_id;
        public int assistance_channel;
        public int is_noticed;
    }
}
