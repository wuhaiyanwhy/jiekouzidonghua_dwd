package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class OrderOderinitv1Data {

    public PackageInfoModel packageInfo;
    public ArrayList<PaymentwayModel> paymentway;
    public boolean orderAvailable;
    public AddressModel address;
    public String confirmSid;

    public static class PackageInfoModel {

        public int totalPrice;
        public int totalAmount;
        public int needPayPrice;
        public ArrayList<ItemListModel> itemList;
        public ArrayList<String> platformCouponList;
        public int platformDiscount;
        public int discountTotal;
        public int savePrice;

        public static class ItemListModel {
            public int merchant_id;
            public String merchant_name;
            public String icon;
            public int freeDeliveryPrice;
            public int isFreeDelivery;
            public int isFreeBaseWeight;
            public int totalPrice;
            public int totalAmount;
            public int marketPrice;
            public int needPayPrice;
            public int totalWeight;
            public int totalWeightSum;
            public ArrayList<SkuListModel> skuList;
            public int total_double_discount_price;
            public String lately_double_tips;
            public int deliveryPrice;
            public int delivery_fee_way;
            public boolean isDeliveryFree;
            public int merchantDiscount;
            public ArrayList<String> merchantCouponList;
            public int needPayWithoutPlatformDiscount;
            public String merchant_url;



        }
    }

}
