package com.duoweidu.model.iqgTable;

import lombok.Data;

/**
 * iqg订单表
 */
@Data
public class ProductOrder {

    public String created_at;
    public String user_id;
    public String status1;
    public String status2;

    public ProductOrder() {

    }

    public ProductOrder(String created_at, String user_id, String status1, String status2) {
        this.created_at = created_at;
        this.user_id = user_id;
        this.status1 = status1;
        this.status2 = status2;
    }
}
