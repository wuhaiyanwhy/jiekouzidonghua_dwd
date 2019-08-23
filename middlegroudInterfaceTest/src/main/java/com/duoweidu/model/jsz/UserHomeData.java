package com.duoweidu.model.jsz;

import java.util.ArrayList;

public class UserHomeData {
    public int commission_accum_amount;
    public int coming_soon_amount;
    public ArrayList<OrdercntModel>order_cnt;
    public static class OrdercntModel {
        public int unpaid;
        public int unused;
    }
    public ArrayList<UserinfoModel>user_info;
    public static class UserinfoModel {
        public int id;
        public String dwd_uid;
        public String dwd_oauth_id;
        public String nickname;
        public String mobile;
        public String avatar;
        public String salt;
        public String share_code;
        public int member_level;
        public String created_at;
        public String updated_at;
        public int step;
        public String openid;
        public String oauth_appid;
    }
}
