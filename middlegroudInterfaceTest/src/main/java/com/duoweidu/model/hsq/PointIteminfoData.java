package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class PointIteminfoData {

    public int skuId;
    public int productId;
    public int merchantId;
    public String name;
    public int price;
    public int marketPrice;
    public String thumbnail;
    public int point;
    public int pointMetaId;
    public int channelId;
    public int startTime;
    public int endTime;
    public int auditStatus;
    public int auditTime;
    public int enabled;
    public int isDelete;
    public int priority;
    public int createdAt;
    public int updatedAt;
    public int type;
    public String pointRules;
    public int listDisplay;
    public String subchannel;
    public int mappingId;
    public int countLimit;
    public ArrayList<AttrsModel> attrs;
    public ArrayList<PointRulesDescModel> pointRulesDesc;
    public String description;
    public String deliveryRangeTip;
    public ActivityModel activity;
    public int leftStock;
    public MerchantInfoModel merchantInfo;
    public ArrayList<BatchOptionsModel> batchOptions;
    public ArrayList<AttrOptionsModel> attrOptions;
    public UgcBriefModel ugcBrief;
    public ArrayList<String> pics;
    public ArrayList<LabelsModel> labels;
    public int pSkuId;
    public int manufactured_date;
    public int expired_date;
    public int offline_before_expired;
    public String batch;
    public String skuType;
    public int merchant_type;
    public int custom_service_id;

    public static class AttrsModel {
        public String name;
        public String value;
    }
    public static class PointRulesDescModel{
        public String name;
        public int point;
        public int grade;
    }



    public static class ActivityModel{
    }
    public static class MerchantInfoModel {
        public ArrayList<LabelsModel> labels;
        public String name;
        public String udesk_merchant_id;
        public String udesk_merchant_name;

        public static class LabelsModel {
            public String icon;
            public String text;
        }
    }
    public static class BatchOptionsModel {
        public String batch;
        public int pSkuId;
        public int price;
        public String expired_date;
        public String manufactured_date;
        public String seller_time;
        public int lowest_price;
        public int offline_before_expired;
    }
    public static class AttrOptionsModel{
        public String name;
        public ArrayList<ListModel> list;

        public static class ListModel{
            public String value;
            public int pSkuId;
        }
    }
    public static class UgcBriefModel {
        public ArrayList<ListModel> list;
        public int totalCnt;

        public static class ListModel {

        }
    }
    public static class LabelsModel {
        public String icon;
        public String text;
        public String link;
    }
}
