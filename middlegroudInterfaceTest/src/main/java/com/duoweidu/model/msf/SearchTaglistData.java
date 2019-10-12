package com.duoweidu.model.msf;

import java.util.ArrayList;

public class SearchTaglistData {

    public int totalCnt;
    public int totalPage;
    public ArrayList<ListModel> list;
    public int total_cnt;
    public int total_page;

    public static class ListModel {
        public int id;
        public String name;
        public String remark;
        public int status;
        public int weight;
        public String created_at;
        public String updated_at;

    }
}
