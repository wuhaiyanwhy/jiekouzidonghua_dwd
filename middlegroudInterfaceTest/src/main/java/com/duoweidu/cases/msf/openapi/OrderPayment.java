package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.OrderPaymentData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class OrderPayment extends MsfInterfaceTest {

    private OrderPaymentData model;

    @Test(dependsOnGroups = "loginTrue",description = "支付页面接口")
    public void orderPayment() {
        setUrl("order.payment.uri");
        param = "activity_id=" + SqlDetail.getInstance().getParamValue(2, "pay_activity_id");
        process(false, false);
        //线上无法下单
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(OrderPaymentData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        assertNotNull("order_id", model.order_id);
        assertNotNull("order_tips", model.order_tips);
        assertNotNull("order_left_time", model.order_left_time);
        assertNotEmpty("activity_id", model.activity_id);
        assertNotEmpty("amount", model.amount);
        assertNotEmpty("item_id", model.item_id);
        assertNotEmpty("item_name", model.item_name);
        assertNotEmpty("branch_id", model.branch_id);
        assertNotEmpty("branch_name", model.branch_name);
        assertNotEmpty("pay_channels", model.pay_channels);
        for (int i = 0; i < model.pay_channels.size(); i++) {
            assertNotEmpty("pay_channels.get(i).id", model.pay_channels.get(i).id);
            assertNotEmpty("pay_channels.get(i).name", model.pay_channels.get(i).name);
            assertNotEmpty("pay_channels.get(i).icon", model.pay_channels.get(i).icon);
        }
        assertNotEmpty("tips", model.tips);
        assertNotEmpty("special_tips", model.special_tips);
        for (int i = 0; i < model.special_tips.size(); i++) {
            assertNotEmpty("special_tips.get(i).text", model.special_tips.get(i).text);
            assertNotEmpty("special_tips.get(i).icon", model.special_tips.get(i).icon);

        }
        assertNotNull("tips_array", model.tips_array);
        assertNotNull("warning_text", model.warning_text);
        assertNotNull("honey_deduction.usable_honey", model.honey_deduction.usable_honey);
        assertNotNull("honey_deduction.dec_amount", model.honey_deduction.dec_amount);
        assertNotNull("honey_deduction.honey_spend", model.honey_deduction.honey_spend);
        assertNotNull("honey_deduction.selected", model.honey_deduction.selected);
        assertNotNull("honey_deduction.deducted", model.honey_deduction.deducted);
        assertNotNull("honey_deduction.optional", model.honey_deduction.optional);
        assertNotNull("honey_deduction.honey_limit", model.honey_deduction.honey_limit);
        assertNotNull("honey_deduction.message", model.honey_deduction.message);
        assertNotEmpty("final_amount", model.final_amount);
    }
}
