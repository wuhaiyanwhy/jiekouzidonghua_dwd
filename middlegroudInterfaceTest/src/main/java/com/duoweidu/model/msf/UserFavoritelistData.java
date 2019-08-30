package com.duoweidu.model.msf;

import java.util.ArrayList;

public class UserFavoritelistData {

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
