package com.duoweidu.model.fyb;

import java.util.ArrayList;

public class UserNoticelistData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int id;
        public int user_id;
        public String title;
        public String link;
        public String content;
        public String send_time;
        public int is_read;
        public String read_time;
        public int delete_flag;
        public int types;
        public String pic;
        public String action;
    }
}
