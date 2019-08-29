package com.duoweidu.model.hsq;

public class UserRiskpreventcheatData {

    public String pid;
    public String app_id;
    public BizContextModel biz_context;

    public static class BizContextModel {
        public String service;
        public String risk_type;
        public String pid;
    }

    public int riskgo_switch;
}
