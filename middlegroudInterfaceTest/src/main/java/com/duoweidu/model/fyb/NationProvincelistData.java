package com.duoweidu.model.fyb;

import java.util.ArrayList;

public class NationProvincelistData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int id;
        public String province;
        public int enabled;
    }
}
