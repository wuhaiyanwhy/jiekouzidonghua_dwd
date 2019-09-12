package com.duoweidu.model.msf;

import java.util.ArrayList;

public class ActivitySharedetailData {

    public int activity_id;
    public int source_type;
    public int online_status;
    public String item_name;
    public String item_pic;
    public int market_price;
    public int left_stock;
    public int branch_id;
    public int start_price;
    public int floor_price;
    public int current_price;
    public int bargain_range;
    public int bargain_count;
    public boolean is_bargained;
    public int reduce;
    public boolean is_sold;
    public ActivityDetailData.BranchModel branch;
    public ArrayList<BargainUsersModel> bargain_users;

    public static class BargainUsersModel {
        public int id;
        public String nickname;
        public String avatar;
        public int quality_user;
    }

}
