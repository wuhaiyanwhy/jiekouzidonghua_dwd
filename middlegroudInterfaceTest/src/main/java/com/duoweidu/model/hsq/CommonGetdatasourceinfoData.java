package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class CommonGetdatasourceinfoData {

    public ArrayList<String> tabs;
    public ArrayList<ListModel> list;
    public int totalNum;
    public int totalPage;
    public int currentPage;
    public boolean channelError;


    public static class ListModel {

        public int id;
        public int category_id;
        public int biz_id;
        public String feature;
        public int topping;
        public String name;
        public int merchant_id;
        public int sku_price;
        public String thumbnail;
        public int market_price;
        public int enabled;
        public String expired_date;
        public int left_stock;
        public int product_id;
        public int all_stock;
        public String title;
        public int price;
        public String sub_title;
        public int merchant_type;
        public String type;
        public int pin_id;
        public boolean can_bought;
        public ArrayList<String> tags;
        public int sku_id;
        public String merchant_name;
        public String link;
        public boolean subscribed;

    }
}
