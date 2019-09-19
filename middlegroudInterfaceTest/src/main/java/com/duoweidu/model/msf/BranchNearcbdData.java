package com.duoweidu.model.msf;

import java.util.ArrayList;

public class BranchNearcbdData {

    public ArrayList<NearModel> near;
    public ArrayList<HotModel> hot;

    public static class NearModel {
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

    public static class HotModel {
        public int id;
        public int zone_id;
        public String name;
        public String address;
        public String lat;
        public String lng;
        public int weight;
        public int status;
        public int is_hot;
        public String created_at;
        public String updated_at;

    }
}
