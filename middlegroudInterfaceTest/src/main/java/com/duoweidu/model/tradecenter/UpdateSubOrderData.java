package com.duoweidu.model.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;

public class UpdateSubOrderData extends TradeCenterInterfaceTest {

    public String order_no;
    public String sub_order_no;
    public ChangesModel changes;
    public String reverse;

    public static class ChangesModel {
        public String order_status;
        public int refund_status;
        public int refund_amount;
        public int settle_amount;
        public int commission_amount;
    }
}
