package com.duoweidu.model.fyb;

import java.util.ArrayList;

public class CategorySearchData {

    public ArrayList<ListModel> list;
    public int totalPage;
    public int totalCnt;

    public static class ListModel {
        public int id;
        public String name;
        public int main_sku;
        public String main_sku_pic;
        public int left_stock;
        public int locked_stock;
        public String thumbnail;
        public int market_price;
        public int reversion;
        public int deduction;
        public int selled_cnt;
        public int price;

    }
}
