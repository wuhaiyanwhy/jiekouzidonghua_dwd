package com.duoweidu.model.msf;

import java.util.ArrayList;

public class UserFollowlistData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public String user_id;
        public int user_type;
        public String nickname;
        public String avatar;
        public String introduction;
        public int article_num;
        public int fans_num;
        public boolean followed;
        public int quality_user;

    }
}
