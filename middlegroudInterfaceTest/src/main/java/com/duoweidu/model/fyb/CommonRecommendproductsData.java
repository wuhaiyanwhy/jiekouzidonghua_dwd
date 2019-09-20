package com.duoweidu.model.fyb;

import java.util.ArrayList;

public class CommonRecommendproductsData {

    public ArrayList<ListModel> list;
    public ArrayList<HasReturnListModel> hasReturnList;
    public ArrayList<BannerListModel> bannerList;
    public ArrayList<TopNavigateListModel> topNavigateList;
    public int isPopNew;
    public int isShowRedBag;
    public int redBagMoney;
    public int totalPage;
    public int totalCnt;
    public ArrayList<String> template;
    public ArrayList<IconModel> icon;
    public ArrayList<TodayHotModel> todayHot;
    public ArrayList<AdvertisementModel> advertisement;

    public static class ListModel {
        public int id;
        public String name;
        public int main_sku;
        public String main_sku_pic;
        public int left_stock;
        public int locked_stock;
        public String thumbnail;
        public int market_price;
        public int price;
        public int reversion;
        public int deduction;
        public int selled_cnt;

    }

    public static class HasReturnListModel {
        public int id;
        public int user_id;
        public String user_name;
        public String avatar;
        public int amount;
        public String achieve_time;
    }

    public static class BannerListModel {
        public int id;
        public String link;
        public ImageModel image;
        public String description;

        public static class ImageModel {
            public String url;
            public SubDataModel sub_data;
            public String description;

            public static class SubDataModel {
                public int w;
                public int h;
            }
        }
    }

    public static class TopNavigateListModel {
        public int id;
        public int source_type;
        public int type;
        public String icon;
        public String label;
        public int jump_type;
        public String jump_url;
        public int client_type;
        public String priority;
        public int enabled;
        public String version;
    }

    public static class IconModel {
        public int id;
        public ImageModel image;
        public String link;
        public String label;

        public static class ImageModel {
            public String url;
            public int w;
            public int h;
        }
    }

    public static class TodayHotModel {
        public int id;
        public String name;
        public int main_sku;
        public String main_sku_pic;
        public int left_stock;
        public int locked_stock;
        public String thumbnail;
        public int market_price;
        public int price;
        public int reversion;
        public int deduction;
        public int selled_cnt;

    }

    public static class AdvertisementModel {
        public int id;
        public String link;
        public ImageModel image;

        public static class ImageModel {
            public String url;
            public SubDataModel sub_data;
            public String description;

            public static class SubDataModel {
                public int w;
                public int h;
            }
        }
    }

}
