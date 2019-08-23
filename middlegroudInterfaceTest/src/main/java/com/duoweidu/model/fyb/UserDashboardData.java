package com.duoweidu.model.fyb;

import java.util.ArrayList;

public class UserDashboardData {

    public UserInfoModel userInfo;
    public int totalAmount;
    public int inActiveAmount;
    public int activeAmount;
    public ArrayList<String> invitedUserList;
    public int isShowInvitedUserList;
    public int toPayNum;
    public int toReceiptNum;
    public int toCommentNum;
    public RecommendModel recommend;

    public static class UserInfoModel {
        public int id;
        public String username;
        public String avatar;
        public String mobile;
        public String email;
        public String birthday;
        public int sex;
        public int enabled;
        public String created_at;
        public String updated_at;
        public int is_new_user;
        public int total_voucher_money;
        public int total_redpacket_money;
    }

    public static class RecommendModel {
        public ArrayList<ListModel> list;
        public int totalPage;
        public int totalCnt;

        public static class ListModel {
            public int id;
            public String name;
            public int main_sku;
            public String main_sku_pic;
            public int left_stock;
            public int locked_stock;
            public String thumbnail;
            public int market_price;
            public int price;
            public String reversion;
            public String deduction;
            public int selled_cnt;
        }
    }
}
