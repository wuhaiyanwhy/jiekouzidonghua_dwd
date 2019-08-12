package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class UserLikeproductlistData {

    public ArrayList<ListModel> list;
    public int totalPage;
    public int totalCnt;

    public static class ListModel {
        //店铺
        public int user_id;
        public int id;
        public int sourceType;
        public String logo;
        public String name;
        public String created_at;
        public int merchant_id;
        public String schema;
        public String city;
        public String province;

        //商品
        public int source_type;
        public int product_id;
        public int sku_id;
        public String product_name;
        public String thumbnail;
        public String delete_flag;
        public int activity_id;
        public int product_status;
        public int terminal;
        public int skuId;
        public ArrayList<String> tags;
        public int offline_before_expired;
        public int left_stock;
        public int produce_price;
        public int price;
        public int lowest_price;
        public String seller_time;
        public String expired_date;
        public int market_price;
        public String end_time;
        public String count_limit;

    }
}
