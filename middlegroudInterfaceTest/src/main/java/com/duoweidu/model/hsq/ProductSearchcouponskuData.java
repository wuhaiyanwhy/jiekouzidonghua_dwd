package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class ProductSearchcouponskuData {

    public int totalCnt;
    public int totalPage;
    public ArrayList<ListModel> list;

    public static class ListModel {
        public SkuInfoModel skuInfo;
        public String name;
        public int id;
        public ArrayList<String> tags;

        public static class SkuInfoModel {
            public int manufactured_date;
            public int lowest_price;
            public String created_at;
            public int merchant_id;
            public int enabled;
            public int price;
            public int product_id;
            public int offline_before_expired;
            public int skuId;
            public String thumbnail;
            public int ugc_cnt;
            public int only_new_user;
            public int weight;
            public int liked_cnt;
            public int version_id;
            public String product_name;
            public int expired_date;
            public int seller_time;
            public ArrayList<ProductCoupleskudetailData.AttrsModel> attrs;
            public int left_stock;
            public String name;
            public int market_price;
            public int lowest_web_price;
            public int selled_cnt;
            public String skuPic;
            public int today_discount;
            public int productId;
            public String productName;
            public int merchant_type;


        }
    }
}
