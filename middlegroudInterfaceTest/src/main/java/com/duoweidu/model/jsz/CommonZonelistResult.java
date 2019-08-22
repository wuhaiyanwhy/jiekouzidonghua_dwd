package com.duoweidu.model.jsz;

import java.util.ArrayList;

public class CommonZonelistResult {

    public ArrayList<DataModel> data;
    public static class DataModel {
        public int id;
        public String name;
        public String address;
        public String lng;
        public String lat;
        public int baidu_city_id;
        public String province_name;
        public int amap_city_id;
    }
}
