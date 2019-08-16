package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class UserGetgetusercartv1Data {

    public ArrayList<ListModel> list;
    public ArrayList<ListModel> invalid_sku_list;
    public String cart_jump_url;
    public int single_sku_cnt;
    public int total_sku_cnt;

    public static class ListModel {
        public int merchant_id;
        public String merchant_name;
        public String merchant_url;
        public String icon;
        public ArrayList<SkuListModel> sku_list;

        public static class SkuListModel {
            public int id;
            public int sku_id;
            public String name;
            public int merchant_type;
            public String pic;
            public ArrayList<String> attrs;
            public int price;
            public int amount;
            public int is_like;
            public int max_cart_nums;
            public String max_cart_desc;
            public String left_stock;
            public boolean active;
        }
    }
}
