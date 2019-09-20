package com.duoweidu.model.msf;

import java.util.ArrayList;

public class BranchCatlistData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int id;
        public String name;
        public int weight;
        public int zone_id;
        public int created_at;

    }
}
