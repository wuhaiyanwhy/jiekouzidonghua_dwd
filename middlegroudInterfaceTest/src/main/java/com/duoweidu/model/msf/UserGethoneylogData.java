package com.duoweidu.model.msf;

import java.util.ArrayList;

public class UserGethoneylogData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int id;
        public int type;
        public int honey;
        public String remark;
        public String created_at;
        public String title;

    }
}
