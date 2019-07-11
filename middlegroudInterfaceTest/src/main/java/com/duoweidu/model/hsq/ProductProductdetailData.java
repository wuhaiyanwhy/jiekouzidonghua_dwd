package com.duoweidu.model.hsq;

import com.alibaba.fastjson.annotation.JSONField;

public class ProductProductdetailData {
    public String id;
    public int source_type;
    public String name;
    public String cate_ids;
    public String main_sku;
    public String main_sku_pic;
    public int lowest_price;
    public int highest_price;
    public int market_price;
    public int merchant_id;
    public int selled_cnt;
    public int ugc_cnt;
    public int liked_cnt;
    public int enabled;
    public String attr_ids;
    public String thumbnail;
    public int package_type;
    public int brand_id;
    public String producing_area;
    public int offline_before_expired;
    public int priority;
    public int today_discount;
    public int delivery_time_after_buy;
    public String description;
    public int restriction_amount;
    public int seller_time;
    public int weight;
    public int merchant_type;
    //取的key和定义的值不同用注解：@JSONField（name = "x"）
    @JSONField(name = "udesk_merchant_id")
    private String udesk_merchant_id;
    @JSONField(name = "graphicDetail")
    public String graphicDetail;

    //data下层有jsonObject/jsonArray的写法
//    @JSONField(name = "sub_model")
//    public SubModel subModel;
//    @JSONField(name = "sub_model_array")
//    public ArrayList<SubModel2> subModelList;
//
//    public static class SubModel {
//        private String text;
//    }
//
//    public static class SubModel2 {
//        private String text;
//    }

}
