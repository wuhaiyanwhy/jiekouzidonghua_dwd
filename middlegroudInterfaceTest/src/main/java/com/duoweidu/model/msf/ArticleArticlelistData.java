package com.duoweidu.model.msf;

import java.util.ArrayList;

public class ArticleArticlelistData {

    public int total_cnt;
    public int total_page;
    public ArrayList<ListModel> list;
    public String page_serial;

    public static class ListModel {
        public int id;
        public String title;
        public String gif;
        public String pic;
        public int width;
        public int height;
        public int media_type;
        public int user_id;
        public String user_nickname;
        public String user_avatar;
        public int quality_user;
        public int likes_num;
        public boolean likes_status;
    }
}
