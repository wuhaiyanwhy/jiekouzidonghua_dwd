package com.duoweidu.model.msf;

import java.util.ArrayList;

public class ArticleFavoritelistData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int id;
        public int article_id;
        public int user_id;
        public int status;
        public String created_at;
        public String updated_at;
        public String nickname;
        public String avatar;
        public int quality_user;

    }
}
