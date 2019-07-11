package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class CommonIndexZhimaData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int margin_top;
        public int margin_bottom;
        public int width;
        public int height;
        public String type;
        public ArrayList<ListListModel> list;
        public String comment;

        public static class ListListModel {
            //banner
            public ImageModel image;
            public String link;
            public int id;

            public static class ImageModel {
                public String url;
                public int w;
                public int h;
            }

            //未签约卡片
            public String act_name;
            public String consumed_rules;
            public int discount;
            public String activity_no;

            //标题栏广告
            public TestModel text;

            public static class TestModel {
                public String title;
                public String describe;
            }

            //大牌超值购
//            public int id;
            public String sku_pic;
            public String sub_image;
            public String sub_title;
            public int sort;
            public String couple_title;
            public int zhima_id;
            public int sku_id;
            public int price;
            public int show_price;
            public int end_time;
            public int start_time;
            public boolean can_bought;
            public String expired_date;


        }

    }

}


