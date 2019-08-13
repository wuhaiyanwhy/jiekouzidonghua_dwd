package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class marketSpecialtopicTopicinfoData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public boolean enable;
        public String flow;
        public int margin_top;
        public String margin_bottom;
        public int margin_lr;
        public int width;
        public int height;
        public String start_time;
        public String end_time;
        public String comment;
        public ArrayList<ListModel1> list;
        public String type;
        public String id;
        public boolean active;

        public static class ListModel1 {
            public ImageModel image;
            public String link;

            public static class ImageModel {
                public String url;
                public int w;
                public int h;
            }
        }


    }
}
