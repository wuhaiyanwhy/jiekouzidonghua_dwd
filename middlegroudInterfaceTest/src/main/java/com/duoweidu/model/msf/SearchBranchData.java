package com.duoweidu.model.msf;

import java.util.ArrayList;

public class SearchBranchData {

    public int totalCnt;
    public int totalPage;
    public ArrayList<ListModel> list;
    public int total_cnt;
    public int total_page;
    public ArrayList<BranchNearcbdData.NearModel> near;


    public static class ListModel {
        public int id;
        public String branch_name;
        public String branch_head_pic;
        public String contactor;
        public String phone;
        public String lng;
        public String lat;
        public String address;
        public int cbd_id;
        public int zone_id;
        public int cat_id;
        public String description;
        public int status;
        public String created_at;
        public String updated_at;
        public LocationModel location;
        public int star;
        public int article_count;
        public CatInfoModel cat_info;
        public int distance;

        public static class LocationModel {
            public String lat;
            public String lon;
        }

        public static class CatInfoModel {
            public int id;
            public String name;
            public int weight;
            public int type;
            public int zone_id;
            public int status;
            public String created_at;
            public String updated_at;
        }

    }
}
