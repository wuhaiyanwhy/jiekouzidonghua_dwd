package com.duoweidu.model.iqgTable;

/**
 * iqg一元券订单表
 */
public class TrdCouponOrder {

    public String created_at;
    public String user_id;
    public String coup_activity_id;

    public TrdCouponOrder() {

    }

    public TrdCouponOrder(String created_at, String user_id, String coup_activity_id) {
        this.created_at = created_at;
        this.user_id = user_id;
        this.coup_activity_id = coup_activity_id;
    }
}
