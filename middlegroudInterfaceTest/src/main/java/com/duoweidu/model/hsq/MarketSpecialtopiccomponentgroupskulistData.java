package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class MarketSpecialtopiccomponentgroupskulistData {

    public ArrayList<ListModel> list;
    public int totalCnt;
    public int totalPage;

    public static class ListModel {
        public int priority;
        public int sku_id;
        public String sku_pic;
        public int pin_activities_id;
        public String couple_title;
        public int couple_price;
        public int market_price;
        public String sub_title;
        public boolean can_bought;
        public int left_stock;
        public int selled_stock;
        public int count_limit;
        public String corner_mark_image;
        public String master_label;
        public String slave_label;
        public int updated_at;
        public int group_price_activity;


    }
}
