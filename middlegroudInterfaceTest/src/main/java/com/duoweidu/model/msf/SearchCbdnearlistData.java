package com.duoweidu.model.msf;

import java.util.ArrayList;

public class SearchCbdnearlistData {

    public int total_cnt;
    public int total_page;
    public ArrayList<ListModel> list;

    public static class ListModel {
        public int zone_id;
        public String address;
        public String lng;
        public String updated_at;
        public int is_hot;
        public String name;
        public int weight;
        public String created_at;
        public LocationModel location;
        public int id;
        public String lat;
        public int status;

        public static class LocationModel {
            public String lon;
            public String lat;
        }

    }
}
