package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class ActivityAssistanceeventdetailData {

    public int activity_id;
    public int sku_id;
    public String main_pic;
    public String name;
    public String activity_title;
    public String activity_rule;
    public String title;
    public String sub_title;
    public UgcBriefModel ugc_brief;
    public int status;
    public int activity_status;
    public int activity_price;
    public int single_price;
    public int start_time;
    public int end_time;
    public int booster_num;
    public int join_times_limit;
    public AssistanceEventModel assistance_event;
    public int product_id;
    public int left_stock;
    public boolean can_share;
    public ArrayList<SuccessEventModel> success_event;


    public static class UgcBriefModel {
        public ArrayList list;
        public int count;
    }

    public static class AssistanceEventModel {
        public ArrayList<EventUserMpdel> eventUser;
        public boolean is_join;
        public int event_id;
        public int status;
        public int booster_num;
        public String join_count;
        public int left_time;
        public int join_times;
        public int end_time;
        public int order_id;
        public boolean is_new;

        public static class EventUserMpdel {
            public int user_id;
            public String username;
            public String avatar;
            public boolean owner;
        }

    }

    public static class SuccessEventModel {
            public UserInfoModel userInfo;
            public int created_at;
            public String success_time;

        public static class UserInfoModel{
            public int user_id;
            public String username;
            public String avatar;
        }
    }

}
