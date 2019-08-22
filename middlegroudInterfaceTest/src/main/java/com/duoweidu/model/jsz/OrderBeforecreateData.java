package com.duoweidu.model.jsz;

import java.util.ArrayList;

public class OrderBeforecreateData {

    public int activity_id;
    public int left_stock;
    public int commission_price;
    public String item_name;
    public int market_price;
    public int sale_price;
    public String item_image;

    public ArrayList<SpecialtipsModel>special_tips;
    public static class SpecialtipsModel {
        public String icon;
        public String key;
        public String text;
    }

    public String tips;
    public String redeem_time;

    public ArrayList<TipsarrayModel>tips_array;
    public static class TipsarrayModel {
        public String title;
        public String text;
    }

    public int pay_amount;
}
