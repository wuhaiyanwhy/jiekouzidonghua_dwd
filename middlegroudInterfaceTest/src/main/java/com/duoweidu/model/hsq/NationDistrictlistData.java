package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class NationDistrictlistData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int id;
        public String district;
        public int city_id;
    }
}
