package com.duoweidu.model.msf;

import java.util.ArrayList;

public class ActivityDetailData {

    public int activity_id;
    public int source_type;
    public int online_status;
    public int start_price;
    public int floor_price;
    public int current_price;
    public int market_price;
    public String tips;
    public int item_id;
    public int branch_id;
    public int left_stock;
    public String item_pic;
    public String item_name;
    public String description;
    public ArrayList<MenusModel> menus;
    public ArrayList<String> pic_list;
    public BranchModel branch;
    public int bargain_count;
    public ArrayList<SpecialTipsModel> special_tips;
    public ArrayList<String> tips_array;
    public String activity_sale_status;

    public static class MenusModel {
        public String name;
        public ArrayList<ItemsModel> items;
        public static class ItemsModel {
            public String name;
            public String price;
        }
    }

    public static class BranchModel {
        public int id;
        public String branch_name;
        public String branch_head_pic;
        public String description;
        public String address;
        public String address_short;
        public String phone;
        public String lat;
        public String lng;
        public int zone_id;
        public int article_count;
        public int star;

    }

    public static class SpecialTipsModel {
        public String text;
        public String icon;
    }

}
