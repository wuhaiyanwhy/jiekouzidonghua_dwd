package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class NationCitylistModel {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int id;
        public String city;
        public int province_id;
        public int amap_id;
        public int is_hot;
        public String pin_yin;
    }
}
