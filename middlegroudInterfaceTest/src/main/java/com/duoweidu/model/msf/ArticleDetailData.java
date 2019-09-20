package com.duoweidu.model.msf;

import java.util.ArrayList;

public class ArticleDetailData {

    public int id;
    public int user_id;
    public String title;
    public int weight;
    public int nature_weight;
    public int human_weight;
    public String reject_reason;
    public int high_quality;
    public int recommend;
    public String recommend_reason;
    public int lng;
    public int lat;
    public String address;
    public int zone_id;
    public int branch_id;
    public int branch_tmp_id;
    public int star;
    public String content;
    public String video_id;
    public String pic;
    public String gif;
    public int order_id;
    public int activity_id;
    public int user_first;
    public String first_audit_time;
    public int act_status;
    public int status;
    public String created_at;
    public String updated_at;
    public String avatar;
    public String nickname;
    public boolean followed;
    public boolean likes_status;
    public boolean favorite_status;
    public int favorite_num;
    public int likes_num;
    public int comment_num;
    public int article_num;
    public int fans_num;
    public int follow_num;
    public ArrayList<String> pics;
    public ArrayList<PicListModel> pic_list;
    public ArrayList<String> comments;
    public String branch_name;
    public String branch_head_pic;
    public int branch_lng;
    public int branch_lat;
    public String branch_address;
    public String branch_desc;
    public String branch_phone;
    public int branch_star;
    public int branch_article_count;
    public String activity;
    public int quality_user;
    public int branch_distance;
    public int width;
    public int height;
    public boolean is_self;
    public ShareModel share;
    public int media_type;


    public static class PicListModel {
        public String pic;
        public int width;
        public int height;
    }

    public static class ShareModel {
        public String title;
        public String desc_wechat;
        public String desc_weibo;
        public String pic;
        public String link;

    }

}
