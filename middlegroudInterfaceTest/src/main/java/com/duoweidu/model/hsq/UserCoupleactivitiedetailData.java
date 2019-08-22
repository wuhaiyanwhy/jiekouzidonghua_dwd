package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class UserCoupleactivitiedetailData {

    public ArrayList<FriendsInfoModel> friendsInfo;
    public int activity_type;
    public FastJoinListModel fastJoinList;
    public int status;
    public String endTime;
    public int countLimit;
    public int joinCount;
    public String title;
    public int restCount;
    public ArrayList<String> recommendPinEventList;
    public SkuInfoModel skuInfo;
    public int isJoin;
    public int isOwner;
    public String shareUrl;
    public int pinActivitiesId;
    public int skuId;
    public String price_info;
    public ProductCoupleskudetailData.ShareInfoModel shareInfo;

    public static class FriendsInfoModel {
        public int userId;
        public String userAvatar;
    }

    public static class FastJoinListModel {
        public ArrayList<String> list;
        public int totalCnt;
    }

    public static class SkuInfoModel {
        public String thumbnail;
        public int skuId;
        public String manufactured_date;
        public String expired_date;
        public int marketPrice;
        public String description;
        public int deliveryTimeAfterBuy;
        public int restrictionAmount;
        public ArrayList<String> attrs;
        public String batch;
        public String pinActivitiesTitle;
        public int groupPrice;
        public int single_price;
        public boolean enabled;
        public int left_stock;
        public ArrayList<String> skuPics;
        public ArrayList<AttrKeysModel> attrKeys;
        public ArrayList<ProductCoupleskudetailData.LabelsModel> labels;
        public String pricePrefix;

        public static class AttrKeysModel {
            public String name;
            public String defaultAttr;
        }

    }
}
