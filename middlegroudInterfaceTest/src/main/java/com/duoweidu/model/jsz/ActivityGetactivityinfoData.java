package com.duoweidu.model.jsz;


import java.util.ArrayList;

public class ActivityGetactivityinfoData {

    public int id;
    public int market_price;
    public int sale_price;
    public int commission_price;
    public String start_time;
    public String end_time;
    public int left_stock;
    public int need_book;
    public int allow_take_out;
    public int refund_type;
    public int redeem_period;
    public String redeem_time;
    public int refund_expired;
    public String poster;
    public int sales_volume;

    public ItemModel item;
    public static class ItemModel {
        public String images;
        public String name;
        public String description;
        public int enabled;
    }

    public String tips;
    public String description;

    public BranchModel branch;
    public static class BranchModel {
        public int id;
        public String lat;
        public String lng;
        public String name;
        public String address;
        public String logo;
        public String tel;
        public int enabled;
        public int distance;
    }

    public int end_timestamp;
    public boolean enabled;

    public ArrayList<SpecialTipsModel> special_tips;
    public static class SpecialTipsModel {
        public String icon;
        public String key;
        public String text;
    }

    public ArrayList<TipsArrayModel> tips_array;
    public static class TipsArrayModel {
        public String title;
        public String text;
    }
}
