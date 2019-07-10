package com.duoweidu.model.msfTable;

import lombok.Data;

/**
 * 订单相关表映射
 */
@Data
public class Order {

    private String created_at;
    private String user_id;
    private int status;

    public Order() {

    }

    public Order(String created_at, String user_id, int status) {
        this.created_at = created_at;
        this.user_id = user_id;
        this.status = status;
    }
}
