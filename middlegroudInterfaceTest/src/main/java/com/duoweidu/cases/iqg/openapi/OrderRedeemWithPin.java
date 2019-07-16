package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderRedeemWithPin extends IqgInterfaceTest {

    @Test(dependsOnGroups = "orderTrue",description = "兑换")
    public void order_redeem_with_pin_true() {
        url = ConfigFileUrl.getUrlByKey("order.redeem_with_pin.uri") + "/" + SqlDetail.getInstance().getParamValue("orderId");
        pathId = SqlDetail.getInstance().getPathId("order.redeem_with_pin.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("pin", SqlDetail.getInstance().getParamValue(2, "pin")));
        process(list,false,false);
    }

}
