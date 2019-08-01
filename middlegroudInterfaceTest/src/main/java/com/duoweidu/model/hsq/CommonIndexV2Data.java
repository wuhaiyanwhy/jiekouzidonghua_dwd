package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class CommonIndexV2Data {

    public int id;
    public int channel;
    public String title;
    public int status;
    public int start_time;
    public int end_time;
    public int delete_flag;
    public int type;
    public int sub_type;
    public String code;
    public ArrayList<ListModel> list;
    public InfoModel info;

    public static class ListModel {
        public boolean enable;
        public String flow;
        public int margin_top;
        public int margin_bottom;
        public int margin_lr;
        public String layout;
        public boolean auto;
        public int interval;
        public boolean dots;
        public int width;
        public int height;
        public String comment;
        public ArrayList<ListModel1> list;
        public String type;
        public String id;
        public boolean active;
        public ArrayList<String> flow_code;

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

    public static class InfoModel {
        public String title;
        public String bg_color;
        public String foot_text;
        public String share_title;
        public String share_desc;
        public String share_link;
        public boolean is_mini;
        public String share_img;
        public String share_induce;
        public ArrayList<FloatsModel> floats;

        public static class FloatsModel {
            public boolean enable;
            public String flow;
            public int width;
            public int height;
            public int bottom;
            public int right;
            public String comment;
            public IconModel icon;
            public String type;
            public String id;
            public boolean active;
            public int margin_top;
            public int margin_bottom;
            public int margin_lr;


            public static class IconModel {
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

}
