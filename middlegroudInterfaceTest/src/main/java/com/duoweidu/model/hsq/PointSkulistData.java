package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class PointSkulistData {
    public ArrayList<ListModel> list;
    public int totalCnt;
    public int totalPage;

    public static class ListModel {
        public int id;
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
        public String feature;
        public String label;
        public int pSkuId;
        public int merchant_type;
    }
}
