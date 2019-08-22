package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class PointTopicbuskulistData {

    public ArrayList<ListMOdel> list;

    public static class ListMOdel {
        public int id;
        public int bu_sku_id;
        public int skuId;
        public int productId;
        public int merchantId;
        public int price;
        public int marketPrice;
        public int point;
        public int pointMetaId;
        public int channelId;
        public int startTime;
        public int endTime;
        public int auditStatus;
        public int auditTime;
        public int enabled;
        public int isDelete;
        public int createdAt;
        public int updatedAt;
        public int type;
        public String pointRules;
        public int listDisplay;
        public String subchannel;
        public String name;
        public String thumbnail;
        public int topic_id;
        public int priority;
        public String label;
        public ArrayList<TagsModel> tags;

        public static class TagsModel {
            public String text;
            public String background;
        }

        public int pSkuId;
        public String requestId;
        public int merchant_type;
    }
}
