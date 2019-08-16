package com.duoweidu.model.hsq;

import com.alibaba.fastjson.annotation.JSONField;

public class OrderOrderpayData {

    //普通的
    public String partner;
    public String seller;
    public String paymentStr;
    public int mergeType;
    public int paymentId;

    //拼团的
    public String appid;
    public String noncestr;
    @JSONField(name = "package")
    public String page;
    public String partnerid;
    public String prepayid;
    public String timestamp;
    public String paysign;
}
