package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class PointIndexData {
    public ArrayList<BannerListModel> bannerList;
    public SkuListModel skuList;
    public ArrayList<SubButtonListMOdel> subButtonList;
    public ArrayList<LabelsModel> labels;

    public static class BannerListModel {
        public int id;
        public String image;
        public int type;
        public String url;
        public String location;
        public String version;
        public int starttime;
        public int endtime;
        public int enabled;
        public int priority;
        public int source_type;
        public String sub_data;
        public ArrayList<UserFlowModel> userFlow;

        public static class UserFlowModel {
        }
    }

    public static class SkuListModel {
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
            public int priotrity;
            public int createdAt;
            public int updatedAt;
            public int type;
            public String pointRules;
            public int listDisplay;
            public String subchannel;
            public String feature;
            public String label;
            public int pSkuId;

        }
    }

    public static class SubButtonListMOdel {

        public int id;
        public int type;
        public int loc;
        public String icon;
        public String label;
        public int jump_type;
        public String jump_url;
        public int client_type;
        public int has_tag;
        public String tag_icon;
        public int priority;
        public int enabled;
        public int expired_time;
        public String version;
        public SubDataModel sub_data;

        public static class SubDataModel {
            public int w;
            public int h;
        }
    }

    public static class LabelsModel {
        public String icon;
        public String text;
    }
}
