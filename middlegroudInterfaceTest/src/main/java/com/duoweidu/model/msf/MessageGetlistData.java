package com.duoweidu.model.msf;

import java.util.ArrayList;

public class MessageGetlistData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int id;
        public int sender_id;
        public int receiver_id;
        public int sys_message_id;
        public String title;
        public String content;
        public int type;
        public int related_id;
        public int status;
        public String publish_at;
        public String created_at;
        public String updated_at;
        public int article_id;
        public String article_title;
        public String article_pic;
        public int article_pic_width;
        public int article_pic_height;
        public int article_status;
        public int media_type;
        public String sender_nickname;
        public String sender_avatar;
        public String sender_introduction;
        public int sender_quality_user;

    }
}
