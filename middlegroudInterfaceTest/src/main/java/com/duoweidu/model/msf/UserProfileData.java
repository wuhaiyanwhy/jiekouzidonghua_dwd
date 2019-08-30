package com.duoweidu.model.msf;

import java.util.ArrayList;

public class UserProfileData {

    public String user_id;
    public String nickname;
    public String avatar;
    public int quality_user;
    public String introduction;
    public int keep_sign_days;
    public int fans_num;
    public int follow_num;
    public int likes_num;
    public int favorite_num;
    public int total_honey;
    public boolean has_daily_bonus;
    public boolean is_followed;
    public String about_daily_bonus;
    public ArticleModel article;
    public ArticleTabNumModel article_tab_num;

    public static class ArticleModel {
        public ArrayList<ListModel> list;
        public int total_page;
        public int total_cnt;
        public int page_limit;

        public static class ListModel {
            public int id;
            public String title;
            public String pic;
            public int width;
            public int height;
            public int media_type;
            public String user_id;
            public String user_nickname;
            public String user_avatar;
            public int quality_user;
            public int likes_num;
            public boolean likes_status;

        }
    }

    public static class ArticleTabNumModel {
        public int favorite_num;
        public int article_num;
    }

}
