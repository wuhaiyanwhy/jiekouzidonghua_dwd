package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class ActivityAssistanceitemdetailData {
    public int activity_id;
    public int sku_id;
    public ArrayList<String> pics;
    public String name;
    public String activity_title;
    public String activity_rule;
    public ArrayList<LabelsModel> labels;
    public UgcBriefModel ugc_brief;
    public int status;
    public int activity_status;
    public int activity_price;
    public int single_price;
    public int start_time;
    public int end_time;
    public int booster_num;
    public int join_times_limit;
    public AssistanceventModel assistance_event;
    public boolean can_delivery;
    public String udesk_merchant_id;
    public ArrayList<PromotionsModel> promotions;
    public int product_id;
    public int is_noticed;
    public int left_stock;
    public int can_buy;
    public boolean can_share;
    public ArrayList<AttrsModel> attrs;
    public String graphicDetail;
    public String batch;

    public static class LabelsModel {
        public String icon;
        public String text;
        public String link;
    }

    public static class UgcBriefModel {
        public ArrayList list;
        public int count;
    }

    public static class AssistanceventModel {

    }

    public static class PromotionsModel {
        public String icon;
        public String text;
    }

    public static class AttrsModel {
        public String name;
        public String value;
    }
}