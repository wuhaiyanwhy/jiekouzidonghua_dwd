package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class ProductCoupleskulistData {

    public ArrayList<ListModel> list;
    public int totalPage;
    public int totalCnt;
    public ProductCoupleskudetailData.ShareInfoModel shareInfo;

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
        public String endTime;
        public int showCountDownLimit;
        public boolean canDelivery;
        public int merchant_id;
        public int merchant_type;
        public int left_stock;
        public String all_stock;
        public ArrayList<TagsModel> tags;
        public boolean canBought;
        public boolean onLine;
        public boolean inStock;
        public String request_id;

        public static class TagsModel {
            public String text;
            public String background;
        }


    }
}
