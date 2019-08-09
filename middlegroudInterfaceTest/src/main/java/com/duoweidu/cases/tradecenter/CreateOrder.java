package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.CreateOrderData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CreateOrder extends TradeCenterInterfaceTest {


    public void commonParameters(List<NameValuePair> list, String orderType) {
        list.add(new BasicNameValuePair("method", "trade.create_order"));
        list.add(new BasicNameValuePair("totalAmount", SqlDetail.getInstance().getParamValue(0, "createOrderTotalAmount")));
        list.add(new BasicNameValuePair("payAmount", SqlDetail.getInstance().getParamValue(0, "createOrderPayAmount")));
        if (orderType.equals("subOrder")) {
            list.add(new BasicNameValuePair("orderData", "[{\"sign\":1001,\"goodsId\":1000000123,\"skuId\":\"EF123458\",\"goodsName\":\"多维度蜜糖(1L)\",\"goodsPrice\":12,\"goodsNumber\":2,\"totalAmount\":24,\"payAmount\":10,\"refundAmount\":2,\"orderStatus\":\"RE4\",\"refundStatus\":2,\"extraDeduct\":[{\"amount\":100,\"currency\":\"DWD_IQG_COIN\",\"equalPayAmount\":1},{\"amount\":100,\"currency\":\"DWD_IQG_COIN2\",\"equalPayAmount\":2}],\"extraFees\":[{\"feesTypeCode\":\"FREIGHT\",\"amount\":10},{\"feesTypeCode\":\"FREIGHT\",\"amount\":20}],\"orderPromotion\":[{\"promotionTypeCode\":\"PLATFORM\",\"promotionName\":\"6周年庆\",\"equalPayAmount\":5,\"activityId\":\"DQ1001\"},{\"promotionTypeCode\":\"SELLER\",\"promotionName\":\"满10减2\",\"equalPayAmount\":2,\"couponId\":\"CK10009\"}]},{\"sign\":1002,\"goodsId\":1000000123,\"skuId\":\"EF123459\",\"goodsName\":\"多维度蜜糖(500ML)\",\"goodsPrice\":12,\"goodsNumber\":2,\"totalAmount\":24,\"payAmount\":10,\"refundAmount\":2,\"orderStatus\":\"RE4\",\"refundStatus\":2,\"extraDeduct\":[{\"amount\":100,\"currency\":\"DWD_IQG_COIN\",\"equalPayAmount\":1},{\"amount\":100,\"currency\":\"DWD_IQG_COIN2\",\"equalPayAmount\":2}],\"extraFees\":[{\"feesTypeCode\":\"FREIGHT\",\"amount\":10},{\"feesTypeCode\":\"FREIGHT\",\"amount\":20}],\"orderPromotion\":[{\"promotionTypeCode\":\"PLATFORM\",\"promotionName\":\"6周年庆\",\"equalPayAmount\":5,\"activityId\":\"DQ1001\"},{\"promotionTypeCode\":\"SELLER\",\"promotionName\":\"满10减2\",\"equalPayAmount\":2,\"couponId\":\"CK10009\"}]}]"));
        } else if (orderType.equals("settleOrder")) {
            list.add(new BasicNameValuePair("orderData", "[{\"goodsId\":1000000123,\"skuId\":\"EF123458\",\"goodsName\":\"多维度蜜糖(1L)\",\"goodsPrice\":12,\"goodsNumber\":2,\"totalAmount\":24,\"payAmount\":10,\"refundAmount\":2,\"orderStatus\":\"RE4\",\"refundStatus\":2,\"extraDeduct\":[{\"amount\":100,\"currency\":\"DWD_IQG_COIN\",\"equalPayAmount\":1},{\"amount\":100,\"currency\":\"DWD_IQG_COIN2\",\"equalPayAmount\":2}],\"extraFees\":[{\"feesTypeCode\":\"FREIGHT\",\"amount\":10},{\"feesTypeCode\":\"FREIGHT\",\"amount\":20}],\"orderPromotion\":[{\"promotionTypeCode\":\"PLATFORM\",\"promotionName\":\"6周年庆\",\"equalPayAmount\":5,\"activityId\":\"DQ1001\"},{\"promotionTypeCode\":\"SELLER\",\"promotionName\":\"满10减2\",\"equalPayAmount\":2,\"couponId\":\"CK10009\"}],\"orderSettle\":[{\"settleTypeCode\":\"USER_COMMISSION\",\"settleMethodCode\":\"ONLINE_COMMISSION\",\"settleAmount\":12,\"settleAccount\":\"844d284e6940a4ed2f7a3f962aae4f2ea04f8e50b09cff06\",\"commissionRate\":0.03,\"commissionAmount\":12}]}]"));
            list.add(new BasicNameValuePair("currency","CNY"));
        } else {
            list.add(new BasicNameValuePair("orderData", "[{\"goodsId\":1000000123,\"skuId\":\"EF123458\",\"goodsName\":\"多维度蜜糖(1L)\",\"goodsPrice\":12,\"goodsNumber\":2,\"totalAmount\":24,\"payAmount\":10,\"refundAmount\":2,\"orderStatus\":\"RE4\",\"refundStatus\":2,\"extraDeduct\":[{\"amount\":100,\"currency\":\"DWD_IQG_COIN\",\"equalPayAmount\":1},{\"amount\":100,\"currency\":\"DWD_IQG_COIN2\",\"equalPayAmount\":2}],\"extraFees\":[{\"feesTypeCode\":\"FREIGHT\",\"amount\":10},{\"feesTypeCode\":\"FREIGHT\",\"amount\":20}],\"orderPromotion\":[{\"promotionTypeCode\":\"PLATFORM\",\"promotionName\":\"6周年庆\",\"equalPayAmount\":5,\"activityId\":\"DQ1001\"},{\"promotionTypeCode\":\"SELLER\",\"promotionName\":\"满10减2\",\"equalPayAmount\":2,\"couponId\":\"CK10009\"}]}]"));
        }
    }

    private CreateOrderData model;

    @Test(dependsOnGroups = "msfCreate", description = "创建订单", groups = "msfCreateOrder")
    public void msfCreateOrder() {
        List<NameValuePair> list = new LinkedList<>();
        commonParameters(list, "order");
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
        commonParameters(list, "subOrder");
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateOrderData.class);
            detailAssert();
        }
    }

    @Test(dependsOnGroups = "iqgCreate", description = "创建订单", groups = "iqgCreateOrder")
    public void iqgCreateOrder() {
        List<NameValuePair> list = new LinkedList<>();
        commonParameters(list, "order");

        TradecenterConfig.accountType = "DWD_IQG_COIN";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateOrderData.class);
            TradecenterConfig.iqgCreateOrderOrderNo = model.order_no;
            TradecenterConfig.iqgCreateOrderSubOrderNo = model.sub_order_no;

            detailAssert();
        }
    }

    @Test(dependsOnGroups = "iqgCreate", description = "创建子订单")
    public void iqgCreateSubOrder() {
        List<NameValuePair> list = new LinkedList<>();
        commonParameters(list, "subOrder");

        TradecenterConfig.accountType = "DWD_IQG_COIN";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateOrderData.class);
            detailAssert();
        }
    }

    @Test(dependsOnGroups = "jszCreate", description = "创建订单", groups = "jszCreateOrder")
    public void jszCreateOrder() {
        List<NameValuePair> list = new LinkedList<>();
        commonParameters(list, "order");

        TradecenterConfig.accountType = "DWD_JSZ_COMMISSION";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateOrderData.class);
            TradecenterConfig.jszCreateOrderOrderNo = model.order_no;
            TradecenterConfig.jszCreateOrderSubOrderNo = model.sub_order_no;

            detailAssert();
        }
    }

    @Test(dependsOnGroups = "jszCreate", description = "创建结算订单")
    public void jszCreateSettleOrder() {
        List<NameValuePair> list = new LinkedList<>();
        commonParameters(list, "settleOrder");

        TradecenterConfig.accountType = "DWD_JSZ_COMMISSION";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateOrderData.class);
            TradecenterConfig.jszCreateSettleOrderOrderNo = model.order_no;
            TradecenterConfig.jszCreateSettleOrderSubOrderNo = model.sub_order_no;
            detailAssert();
        }
    }


    private void detailAssert() {
        detailAssertTest("order_no", model.order_no);
        detailAssertTest("sub_order_no", model.sub_order_no);
        detailAssertTest("", "reverse", model.reverse);

    }
}
