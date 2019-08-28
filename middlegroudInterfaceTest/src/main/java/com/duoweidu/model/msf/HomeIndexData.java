package com.duoweidu.model.msf;

import java.util.ArrayList;

public class HomeIndexData {

    public AdsModel ads;
    public ArrayList<TagsModel> tags;
    public ArrayList<CategoriesModel> categories;
    public ArticleModel article;

    public static class AdsModel {
        public int width;
        public int height;
        public ArrayList<ListModel> list;

        public static class ListModel {
            public int id;
            public String pic;
            public int width;
            public int height;
            public String link;
        }
    }

    public static class TagsModel {
        public int id;
        public String name;
    }

    public static class CategoriesModel {
        public int id;
        public String name;
    }

    public static class ArticleModel {
        public int total_cnt;
        public int total_page;
        public ArrayList<ListModel> list;
        public String page_serial;

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
}
