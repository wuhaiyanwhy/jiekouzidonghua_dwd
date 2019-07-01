package com.duoweidu.model.tradecenter;

public class UpdateOrderData {

    public String order_no;
    public ChangesModel changes;
    public String reverse;

    public static class ChangesModel {
        public String order_status;
        public int commission_amount;
    }
}
