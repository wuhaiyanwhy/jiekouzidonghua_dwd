package com.duoweidu.model.msf;

import java.util.ArrayList;

public class OrderPaymentData {

    public int order_id;
    public String order_tips;
    public String order_left_time;
    public int activity_id;
    public int amount;
    public int item_id;
    public String item_name;
    public int branch_id;
    public String branch_name;
    public ArrayList<PayChannelsModel> pay_channels;
    public String tips;
    public ArrayList<SpecialTipsModel> special_tips;
    public ArrayList<String> tips_array;
    public String warning_text;
    public HoneyDeductionModel honey_deduction;
    public int final_amount;

    public static class PayChannelsModel {
        public int id;
        public String name;
        public String icon;
    }

    public static class SpecialTipsModel {
        public String text;
        public String icon;
    }

    public static class HoneyDeductionModel {
        public int usable_honey;
        public int dec_amount;
        public int honey_spend;
        public boolean selected;
        public boolean deducted;
        public boolean optional;
        public boolean honey_limit;
        public String message;

    }



}
