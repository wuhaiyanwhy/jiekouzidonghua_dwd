package com.duoweidu.model.msf;

public class ArticleInitdataData {

    public BranchModel branch;
    public int order_id;
    public WordsModel words;
    public ArticleModel article;

    public static class BranchModel {
        public int id;
        public String branch_name;
        public String lng;
        public String lat;
        public String address;
        public int zone_id;
        public int status;
        public String created_at;
    }

    public static class WordsModel {
        public int min;
        public int middle;
        public int max;
        public int publish_honey;
        public int recommend_honey;

    }

    public static class ArticleModel {
        public int order_id;
        public int activity_id;

    }
}
