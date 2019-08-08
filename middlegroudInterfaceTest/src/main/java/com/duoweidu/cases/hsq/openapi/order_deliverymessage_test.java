package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderDeliverymessageData;
import org.testng.annotations.Test;

public class order_deliverymessage_test extends HsqInterfaceTest {

    private OrderDeliverymessageData model;

    @Test(dependsOnGroups = "loginTrue",description = "查看物流")
    public void order_deliverymessage_true() {
        setUrl("order.deliverymessage.uri");
        param = "orderId=" + SqlDetail.getInstance().getParamValue("orderId");
        process(true, false);
        model = sparseJson(OrderDeliverymessageData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("order_id", model.order_id);
        detailAssertTest("user_id", model.user_id);
        detailAssertTest("type", model.type);
        detailAssertTest("delivery_no", model.delivery_no);
        detailAssertTest("delivery_com_code", model.delivery_com_code);
        detailAssertTest("delivery_com_name", model.delivery_com_name);
        detailAssertTest("status", model.status);
        detailAssertTest("updated_at", model.updated_at);
        detailAssertTest("msg", model.msg);
        for (int i = 0; i < model.msg.size(); i++) {
            detailAssertTest("msg.get(i).time", model.msg.get(i).time);
            detailAssertTest("msg.get(i).context", model.msg.get(i).context);
            detailAssertTest("msg.get(i).ftime", model.msg.get(i).ftime);
            detailAssertTest("msg.get(i).areaName", model.msg.get(i).areaName);
            detailAssertTest("msg.get(i).status", model.msg.get(i).status);
        }
        detailAssertTest("platform", model.platform);
        detailAssertTest("userId", model.userId);
        detailAssertTest("orderId", model.orderId);


    }

}
