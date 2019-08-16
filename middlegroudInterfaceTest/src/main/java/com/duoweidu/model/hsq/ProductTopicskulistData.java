package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class ProductTopicskulistData {

    public ArrayList<ListModel> list;
    public int totalCnt;
    public int totalPage;

    public static class ListModel {
        public int id;
        public int topic_id;
        public int sku_id;
        public String sku_name;
        public String sku_pic;
        public String sku_desc;
        public int type;
        public int priority;
        public int pinActivityId;
        public String title;
        public int single_price;
        public int group_price;
        public int count_limit;
        public int merchant_id;
        public int merchant_type;
        public int market_price;
    }
}
