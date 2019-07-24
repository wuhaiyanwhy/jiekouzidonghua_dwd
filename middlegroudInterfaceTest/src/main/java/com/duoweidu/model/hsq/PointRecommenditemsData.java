package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class PointRecommenditemsData {

    public int errno;
    public String errmsg;
    public ArrayList<DataModel> data;

    public static class DataModel {
        public int id;
        public String thumbnail;
        public int point;
        public int price;
        public String name;
        public int merchant_type;
        public int enabled;
    }

    public int timestamp;
    public String serverlogid;
}
