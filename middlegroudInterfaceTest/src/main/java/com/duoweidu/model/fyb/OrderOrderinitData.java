package com.duoweidu.model.fyb;

import java.util.ArrayList;

public class OrderOrderinitData {

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
        public int platformDiscount;
        public int voucherDiscount;
        public int fastBuy;
        public int activeVoucherMoney;
        public int notActiveVoucherMoney;
        public int activeRedpacketMoney;
        public int hasInvited;
        public int hasNewUserBenefit;


        public static class ItemListModel {
            public int merchantId;
            public String merchantName;
            public int freeDeliveryPrice;
            public int isFreeDelivery;
            public int isFreeBaseWeight;
            public int totalPrice;
            public int totalAmount;
            public int marketPrice;
            public int needPayPrice;
            public int totalWeight;
            public int totalWeightSum;
            public ArrayList<OrderOrderdetailData.SkuListModel> skuList;
            public int deliveryPrice;
            public int delivery_fee_way;
            public boolean isDeliveryFree;

        }
    }

    public static class PaymentwayModel {
        public int id;
        public String name;
        public String icon;
    }

    public static class AddressModel {
        public int id;
        public String province;
        public String city;
        public String district;
        public String contacter;
        public String detail_address;
        public String mobile;

    }


}
