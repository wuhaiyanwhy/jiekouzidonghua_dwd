package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class MarketSpecialtopiccomponentinfoModel {

    public InfoModel info;
    public ArrayList<ListModel> list;

    public static class InfoModel {
        public String bg_color;
        public String foot_text;
        public String share_desc;
        public String share_img;
        public String share_title;
        public String title;
        public String left_text;
        public RuleButtonModel rule_button;
        public ApiParams api_params;

        public static class RuleButtonModel {
            public String url;
            public String text;
        }

        public static class ApiParams {
            public String componentGroupId;
        }

    }

    public static class ListModel {
        public int id;
        public String type;
        public String comment;
        public int margin_bottom;
        public int margin_lr;
        public int margin_top;
        public String bg_color;
        public int width;
        public int height;
        public ArrayList<ListModel1> list;

        public static class ListModel1 {
            public ImageModel image;
            public String link;

            public static class ImageModel {
                public int w;
                public int h;
                public String url;
            }
        }

    }
}
