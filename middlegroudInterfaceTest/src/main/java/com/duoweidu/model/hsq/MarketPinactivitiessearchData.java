package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class MarketPinactivitiessearchData {

    public ArrayList<ListModel> list;
    public ArrayList<String> category;
    public String searchHasExpiryDate;
    public int totalCnt;
    public int totalPage;
    public ShareInfoModel shareInfo;


    public static class ListModel {
        public int pinActivitiesId;
        public int skuId;
        public String coupleTitle;
        public int couplePrice;
        public int productId;
        public int marketPrice;
        public String expiredDate;
        public String skuPic;
        public int countLimit;
        public int endTime;
        public int showCountDownLimit;
        public boolean canDelivery;
        public int merchant_id;
        public int merchant_type;
        public int left_stock;
        public int all_stock;
        public ArrayList<TagsModel> tags;
        public int canBought;
        public int onLine;
        public int inStock;

        public static class TagsModel {
            public String text;
            public String background;
        }

    }

    public static class ShareInfoModel {
        public FirendsZoneModel firendsZone;
        public WechatModel wechat;
        public MobileQQModel mobileQQ;

        public static class FirendsZoneModel {
            public String content;
            public String thumbnail;
            public String link;
        }

        public static class WechatModel {
            public String title;
            public String content;
            public String thumbnail;
            public String link;
        }

        public static class MobileQQModel {
            public String title;
            public String content;
            public String thumbnail;
            public String link;
        }


    }


}
