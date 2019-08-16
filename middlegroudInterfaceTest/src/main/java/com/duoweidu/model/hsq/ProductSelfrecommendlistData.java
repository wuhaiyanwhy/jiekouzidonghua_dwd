package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class ProductSelfrecommendlistData {

    public ArrayList<ListModel> list;

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
        public int all_stock;
        public ArrayList<String> tags;
        public boolean canBought;
        public boolean onLine;
        public boolean inStock;

    }
}
