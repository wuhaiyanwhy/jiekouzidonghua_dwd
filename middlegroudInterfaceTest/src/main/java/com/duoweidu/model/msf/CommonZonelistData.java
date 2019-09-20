package com.duoweidu.model.msf;

import java.util.ArrayList;

public class CommonZonelistData {

    public ArrayList<ZonelistModel> zonelist;
    public ArrayList<HotlistModel> hotlist;

    public static class ZonelistModel {
        public int id;
        public int baidu_city_id;
        public int amap_city_id;
        public String name;
        public String address;
        public String lng;
        public String lat;
        public int weight;
        public int launched_at;
        public String first_pin_yin;
        public int is_hot;
        public int status;
        public String cover;
        public String province_name;

    }

    public static class HotlistModel {
        public int id;
        public int baidu_city_id;
        public int amap_city_id;
        public String name;
        public String address;
        public String lng;
        public String lat;
        public int weight;
        public int launched_at;
        public String first_pin_yin;
        public int is_hot;
        public int status;
        public String cover;
        public String province_name;

    }
}
