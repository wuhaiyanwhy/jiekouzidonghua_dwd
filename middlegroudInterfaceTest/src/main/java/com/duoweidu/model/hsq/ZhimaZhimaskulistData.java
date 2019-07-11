package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class ZhimaZhimaskulistData {

    public String type;
    public String titleText;
    public String titleImg;
    public ArrayList<ListModel> list;
    public int totalCnt;
    public int totalPage;
    public String currentPage;

    public static class ListModel {
        public int id;
        public int sku_id;
        public String zm_sku_name;
        public int price;
        public int show_price;
        public int discount;
        public String thumbnail;
        public int left_stock;

    }

}
