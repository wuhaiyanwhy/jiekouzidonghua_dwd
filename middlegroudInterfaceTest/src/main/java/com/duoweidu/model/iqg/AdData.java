package com.duoweidu.model.iqg;

import java.util.ArrayList;

public class AdData {
    public ArrayList<ListModel>list;
    public static class ListModel {
        public int id;
        public String title;
        public String url;
        public String size;
        public String image_url;
        public String width;
        public String height;
    }
}
