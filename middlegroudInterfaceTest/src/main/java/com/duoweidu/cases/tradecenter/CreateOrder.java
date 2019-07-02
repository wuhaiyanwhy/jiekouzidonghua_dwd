package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.SqlTradecenter;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.CreateOrderData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CreateOrder extends TradeCenterInterfaceTest {

    private CreateOrderData model;

    @Test(dependsOnGroups = "msfCreate", description = "创建订单", groups = "msfCreateOrder")
    public void msfCreateOrder() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method","trade.create_order"));
        list.add(new BasicNameValuePair("totalAmount", SqlTradecenter.getParamValue(0, "createOrderTotalAmount")));
        list.add(new BasicNameValuePair("orderData","[{\"goodsId\":1000000123,\"skuId\":\"EF123458\",\"goodsName\":\"多维度蜜糖(1L)\",\"goodsPrice\":12,\"goodsNumber\":2,\"totalAmount\":24,\"payAmount\":10,\"refundAmount\":2,\"orderStatus\":\"RE4\",\"refundStatus\":2,\"extraDeduct\":[{\"amount\":100,\"currency\":\"DWD_IQG_COIN\",\"equalPayAmount\":1},{\"amount\":100,\"currency\":\"DWD_IQG_COIN2\",\"equalPayAmount\":2}],\"extraFees\":[{\"feesTypeCode\":\"FREIGHT\",\"amount\":10},{\"feesTypeCode\":\"FREIGHT\",\"amount\":20}],\"orderPromotion\":[{\"promotionTypeCode\":\"PLATFORM\",\"promotionName\":\"6周年庆\",\"equalPayAmount\":5,\"activityId\":\"DQ1001\"},{\"promotionTypeCode\":\"SELLER\",\"promotionName\":\"满10减2\",\"equalPayAmount\":2,\"couponId\":\"CK10009\"}],\"orderSettle\":[{\"settleTypeCode\":\"ONLINE_COMMISSION\",\"settleAmount\":12,\"commissionRate\":0.03,\"commissionAmount\":12}]}]"));
        list.add(new BasicNameValuePair("orderSettle","[{\"settleTypeCode\":\"ONLINE_COMMISSION\",\"settleAmount\":12,\"commissionRate\":0.03,\"commissionAmount\":12}]"));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateOrderData.class);
            TradecenterConfig.msfCreateOrderOrderNo = model.order_no;
            TradecenterConfig.msfCreateOrderSubOrderNo = model.sub_order_no;

            detailAssert();
        }
    }

    @Test(dependsOnGroups = "msfCreate", description = "创建子订单")
    public void msfCreateSubOrder() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method","trade.create_order"));
        list.add(new BasicNameValuePair("totalAmount","99"));
        list.add(new BasicNameValuePair("orderData","[{\"sign\":1001,\"goodsId\":1000000123,\"skuId\":\"EF123458\",\"goodsName\":\"多维度蜜糖(1L)\",\"goodsPrice\":12,\"goodsNumber\":2,\"totalAmount\":24,\"payAmount\":10,\"refundAmount\":2,\"orderStatus\":\"RE4\",\"refundStatus\":2,\"extraDeduct\":[{\"amount\":100,\"currency\":\"DWD_IQG_COIN\",\"equalPayAmount\":1},{\"amount\":100,\"currency\":\"DWD_IQG_COIN2\",\"equalPayAmount\":2}],\"extraFees\":[{\"feesTypeCode\":\"FREIGHT\",\"amount\":10},{\"feesTypeCode\":\"FREIGHT\",\"amount\":20}],\"orderPromotion\":[{\"promotionTypeCode\":\"PLATFORM\",\"promotionName\":\"6周年庆\",\"equalPayAmount\":5,\"activityId\":\"DQ1001\"},{\"promotionTypeCode\":\"SELLER\",\"promotionName\":\"满10减2\",\"equalPayAmount\":2,\"couponId\":\"CK10009\"}],\"orderSettle\":[{\"settleTypeCode\":\"ONLINE_COMMISSION\",\"settleAmount\":12,\"commissionRate\":0.03,\"commissionAmount\":12}]},{\"sign\":1002,\"goodsId\":1000000123,\"skuId\":\"EF123459\",\"goodsName\":\"多维度蜜糖(500ML)\",\"goodsPrice\":12,\"goodsNumber\":2,\"totalAmount\":24,\"payAmount\":10,\"refundAmount\":2,\"orderStatus\":\"RE4\",\"refundStatus\":2,\"extraDeduct\":[{\"amount\":100,\"currency\":\"DWD_IQG_COIN\",\"equalPayAmount\":1},{\"amount\":100,\"currency\":\"DWD_IQG_COIN2\",\"equalPayAmount\":2}],\"extraFees\":[{\"feesTypeCode\":\"FREIGHT\",\"amount\":10},{\"feesTypeCode\":\"FREIGHT\",\"amount\":20}],\"orderPromotion\":[{\"promotionTypeCode\":\"PLATFORM\",\"promotionName\":\"6周年庆\",\"equalPayAmount\":5,\"activityId\":\"DQ1001\"},{\"promotionTypeCode\":\"SELLER\",\"promotionName\":\"满10减2\",\"equalPayAmount\":2,\"couponId\":\"CK10009\"}],\"orderSettle\":[{\"settleTypeCode\":\"ONLINE_COMMISSION\",\"settleAmount\":12,\"commissionRate\":0.03,\"commissionAmount\":12}]}]"));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateOrderData.class);
            detailAssert();
        }
    }


    private void detailAssert() {
        detailAssertTest("order_no", model.order_no);
        detailAssertTest("sub_order_no", model.sub_order_no);
        detailAssertTest("", "reverse", model.reverse);

    }
}
