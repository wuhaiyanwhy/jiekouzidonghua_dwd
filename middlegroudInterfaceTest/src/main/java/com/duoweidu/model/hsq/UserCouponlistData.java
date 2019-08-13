package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class UserCouponlistData {

    public ArrayList<ListModel> list;
    public int totalPage;
    public int totalCnt;
    public String usageUrl;
    public CouponCntModel couponCnt;

    public static class ListModel {
        public int id;
        public int user_id;
        public int coupon_id;
        public String coupon_code;
        public String range_type;
        public int type;
        public String merchant_id;
        public String title;
        public String sub_title;
        public String usage_title;
        public int value;
        public int is_at_least;
        public int at_least;
        public String start_at;
        public String end_at;
        public String usage_desc;
        public int status;
        public int is_expired;
        public int is_used;
        public String used_at;
        public String created_at;
        public ArrayList<String> limit_ids;
        public ArrayList<String> limit_ids_status;
        public String schema;

    }

    public static class CouponCntModel {
        public int avaliableCnt;
        public int expiredCnt;
        public int usedCnt;

    }
}
