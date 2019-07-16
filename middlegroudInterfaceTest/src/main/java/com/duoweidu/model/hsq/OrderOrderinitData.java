package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class OrderOrderinitData {

    public String confirmSid;
    public boolean orderAvailable;
    public ArrayList<OrderCoupleorderinitData.PaymentwayModel> paymentway;
    public PackageInfoModel packageInfo;
    public AvaliableCouponsModel avaliableCoupons;
    public OrderCoupleorderinitData.AddressModel address;

    public static class PackageInfoModel {
        public int platformDiscount;
        public int orderType;
        public int needPayPrice;
        public int pinActivitiesId;
        public ArrayList<ItemListModel> itemList;
        public int totalAmount;
        public ArrayList<String> newUserBenefit;
        public int zhimaId;

        public static class ItemListModel {

            public String merchantName;
            public int merchantId;
            public int orderType;
            public String schema;
            public int needPayPrice;
            public int totalAmount;
            public ArrayList<SkuListModel>  skuList;
            public int discountPrice;
            public int platformDiscount;
            public int freeDeliveryPrice;
            public int isFreeDelivery;
            public int needPayWithoutPlatformDiscount;

            public static class SkuListModel {
                public int id;
                public String name;
                public String thumbnail;
                public int market_price;
                public int left_stock;
                public int orderAmount;
                public int dealAmount;
                public ArrayList<AttributeTagsModel> attribute_tags;
                public boolean canDelivery;
                public boolean outOfStock;
                public String skuThumbnail;
                public int product_id;
                public int price;
                public int orderPrice;
                public int totalPrice;


                public static class AttributeTagsModel {
                    public String name;
                    public String value;
                }


        }


    }
    }

    public static class AvaliableCouponsModel {
        public ArrayList<String> list;
        public int totalCnt;
    }
}
