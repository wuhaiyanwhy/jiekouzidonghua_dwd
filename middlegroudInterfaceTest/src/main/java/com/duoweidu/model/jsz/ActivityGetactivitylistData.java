package com.duoweidu.model.jsz;

import java.util.ArrayList;

public class ActivityGetactivitylistData {

    public int total_cnt;
    public int total_page;

    public ArrayList<ListModel> list;
    public static class ListModel {
        public int id;
        public int sale_price;
        public int market_price;
        public int commission_price;
        public String start_time;
        public String end_time;
        public int left_stock;
        public int stock;
        public int redeem_period;
        public int need_book;
        public int allow_take_out;
        public int refund_type;
        public int refund_expired;
        public int settle_price;
        public int day_buy_limit;
        public int sales_volume;
        public String poster;
        public String redeem_time;
        public int row_status;
        public String created_at;
        public String branch_name;
        public String lng;
        public String lat;
        public String item_name;
        public String item_image;
        public int distance;
        public int end_timestamp;
    }

    public ArrayList<BannerModel> banner;
    public static class BannerModel {
        public int id;
        public String title;
        public String url;
        public String event_id;//空值
        public String need_login;
        public String size;
        public String image_url;
        public String width;
        public String height;
    }
}




