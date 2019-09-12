package com.duoweidu.model.msf;

import java.util.ArrayList;

public class ActivityListData {

    public int total_page;
    public int total_cnt;
    public ArrayList<CategoryModel> category;
    public ArrayList<ListModel> list;

    public static class CategoryModel {
        public int id;
        public String name;
    }

    public static class ListModel {
        public int activity_id;
        public String item_name;
        public String item_pic;
        public int market_price;
        public int start_price;
        public int floor_price;
        public int current_price;
        public int bargain_range;
        public int bargain_count;
        public String branch_name;
        public int distance;
        public boolean is_bargained;
        public boolean is_sold;
        public boolean is_new;
    }
}
