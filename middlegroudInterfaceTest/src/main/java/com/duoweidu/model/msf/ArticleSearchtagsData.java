package com.duoweidu.model.msf;

import java.util.ArrayList;

public class ArticleSearchtagsData {

    public ArrayList<ListModel> list;
    public boolean has_next;

    public static class ListModel {
        public int id;
        public String name;
        public int weight;
        public int is_hot;
        public int zone_id;

    }
}
