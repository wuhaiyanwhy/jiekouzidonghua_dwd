package com.duoweidu.model.msf;

import java.util.ArrayList;

public class ArticleCommentuserlistData {

    public ArrayList<ListModel> list;
    public int last_id;
    public boolean has_next;

    public static class ListModel {
        public int id;
        public String avatar;
        public String nickname;
    }
}
