package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class UserUsercenterData {

    public int favoritesProductCnt;
    public int favoritesMerchantCnt;
    public int toPayNum;
    public int toReceiptNum;
    public int toCommentNum;
    public int totalSavedMoney;
    public int toRefundNum;
    public UserInfoModel userInfo;
    public UserInfoModel userinfo;
    public ArrayList<ActivitiesModel> activities;
    public int couponCnt;
    public int pinOrderCnt;
    public int lotteryOrderCnt;
    public String talentLink;
    public LightMemberExposeInfoModel light_member_expose_info;
    public int recommend_source_id;
    public int transactionOrderCnt;

    public static class UserInfoModel {
        public String username;
        public String avatar;
        public String mobile;
        public String email;
        public String birthday;
        public int sex;
        public int enabled;
        public String created_at;
        public int is_talent;
        public int is_dealer;
        public int is_talent_blocked;
        public int balance;
        public int locked_balance;
        public int withdraw_total;
        public int transfer_amount;
        public int saved_money_total;
        public String wechat_mp_open_id;
        public String wechat_jx_open_id;
        public String wechat_open_id;
        public int user_id;
        public String inviteCode;
        public String wechat_union_id;
        public int register_type;
        public String alipay_user_id;
        public String token;
        public boolean is_test_user;
        public ArrayList<String> uc_phone;
        public boolean authPhone;
        public int userId;
        public ArrayList<String> userMedals;
        public int agreementStatus;

    }

    public static class ActivitiesModel {
        public String text;
        public String loc;
    }

    public static class LightMemberExposeInfoModel {
        public int agreement_status;
        public String desc;
        public String image_url;
    }
}
