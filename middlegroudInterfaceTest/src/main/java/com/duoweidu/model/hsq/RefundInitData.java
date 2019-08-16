package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class RefundInitData {

    public ArrayList<ReasonListModel> reasonList;
    public ArrayList<RefundMethodListModel> refundMethodList;
    public String salesRefundType;

    public static class ReasonListModel {
        public int id;
        public int type;
        public String name;
        public int priority;
        public int enabled;
    }

    public static class RefundMethodListModel {
        public int id;
        public String name;
    }
}
