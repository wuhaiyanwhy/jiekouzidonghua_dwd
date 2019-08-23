package com.duoweidu.model.jsz;

import java.util.ArrayList;

public class FeedbackFeedbackitemlistData {

    public ArrayList<ListModel>list;
    public static class ListModel {
        public int id;
        public int type;
        public int order_type;
        public String content;
        public int weight;
        public int required;
        public int count_refund_rate;
        public int enable;
        public String created_at;
        public String updated_at;
        public int need_review;
        public int need_compenstion;
        public int need_invalid_coupon;

    }
}
