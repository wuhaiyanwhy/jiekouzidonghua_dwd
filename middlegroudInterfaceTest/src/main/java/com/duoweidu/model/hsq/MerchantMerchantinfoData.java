package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class MerchantMerchantinfoData {

    public int id;
    public int roles;
    public String name;
    public String tinyurl;
    public String logo;
    public String description;
    public int online_sku_cnt;
    public int enabled;
    public int is_free_base_weight;
    public String notice;
    public String udesk_merchant_id;
    public ArrayList<BrandListModel> brandList;
    public String province;
    public String city;
    public boolean is_like;
    public ArrayList<String> coupons;
    public ArrayList<String> activityList;
    public int sourceType;

    public static class BrandListModel {
        public String id;
        public String name;
        public String logo;
    }

}
