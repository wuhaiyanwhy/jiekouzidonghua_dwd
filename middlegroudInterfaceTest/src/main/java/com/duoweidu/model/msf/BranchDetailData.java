package com.duoweidu.model.msf;

import java.util.ArrayList;

public class BranchDetailData {

    public int id;
    public int merchant_id;
    public int seller_id;
    public String branch_name;
    public String branch_head_pic;
    public String contactor;
    public String phone;
    public String mobile;
    public String contract_no;
    public String hygienic_license;
    public String lng;
    public String lat;
    public String address;
    public String address_short;
    public int cbd_id;
    public int zone_id;
    public int cat_id;
    public String description;
    public int source_type;
    public String redeem_time;
    public int freeze_period;
    public int is_recommend;
    public String out_link;
    public String branch_code;
    public String qr_code;
    public int status;
    public String created_at;
    public String updated_at;
    public CatInfoModel cat_info;
    public ArrayList<ActivityListModel> activity_list;
    public ArrayList<PicListModel> pic_list;
    public int distance;

    public static class CatInfoModel {
        public int id;
        public String name;
        public int weight;
        public int type;
        public int zone_id;
        public int status;
        public String created_at;
        public String updated_at;

    }

    public static class ActivityListModel {
        public int activity_id;
        public String item_name;
        public String item_pic;
        public int market_price;
        public int start_price;
        public int floor_price;
        public int current_price;
        public int bargain_range;
        public int left_stock;
        public String branch_name;
        public int bargain_count;
        public boolean is_bargained;
        public boolean is_sold;
        public int distance;
    }

    public static class PicListModel {
        public int id;
        public int article_id;
        public String pic;
        public int width;
        public int height;
        public int status;
        public String created_at;
        public String updated_at;
    }

}
