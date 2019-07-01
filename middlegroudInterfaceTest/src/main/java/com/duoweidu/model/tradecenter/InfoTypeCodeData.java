package com.duoweidu.model.tradecenter;

public class InfoTypeCodeData {

    public FeesModel fees;
    public PromotionModel promotion;
    public SettleModel settle;
    public String reverse;

    public static class FeesModel {
        public String FREIGHT;
    }

    public static class PromotionModel {
        public String PLATFORM;
        public String SELLER;
        public String ACTIVITY;
    }

    public static class SettleModel {
        public String ONLINE_COMMISSION;
        public String ONLINE_SETTLE_PRICE;
        public String OFFLINE;
        public String NO_SETTLE;

    }
}
