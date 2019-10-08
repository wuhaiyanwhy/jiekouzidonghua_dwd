package com.duoweidu.model.hsqTable;

import lombok.Data;

/**
 * 子订单表
 */
@Data
public class TraSubOrder {

    private int id;
    private String order_id;
    private int user_id;
    private int product_id;
    private int sku_id;
    private int bu_sku_id;
    private int point;
    private String sku_name;
    private String sku_thumbnail;
    private int unit_price;
    private int market_price;
    private int amount;
    private int total_price;
    private int discount_price;
    private int pay_price;
    private String attribute_tags;
    private int status;
    private int comment_status;
    private int is_free;
    private int created_at;
    private int updated_at;
    private int platform_discount;
    private int merchant_discount;
    private int settlement_price;
    private int settlement_way;
    private int source_type;
    private int confirm_time;
    private int pin_activities_id;
    private int pin_event_id;
    private String last_update;
    private String attrs_snapshot;
    private int saved_money;



}
