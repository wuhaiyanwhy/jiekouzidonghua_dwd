package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderCoupleeventjoinModel;
import org.testng.annotations.Test;

public class order_coupleeventjoin_test extends HsqInterfaceTest {

    private OrderCoupleeventjoinModel model;

    @Test(dependsOnGroups = "loginTrue",description = "邀请好友参团")
    public void order_coupleeventjoin_true() {
        setUrl("order.coupleeventjoin.uri");
        param = "orderId="+ SqlDetail.getInstance().getParamValue("orderId");
        process(true,false);
        model = sparseJson(OrderCoupleeventjoinModel.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("pinEventId", model.pinEventId);
        detailAssertTest("pinEventStatus", model.pinEventStatus);
        detailAssertTest("owner", model.owner);
        detailAssertTest("pinActivitiesId", model.pinActivitiesId);
        detailAssertTest("restCount", String.valueOf(model.restCount));
        detailAssertTest("countLimit", model.countLimit);
        detailAssertTest("title", model.title);
        detailAssertTest("groupPrice", model.groupPrice);
        detailAssertTest("isOwner", model.isOwner);
        detailAssertTest("shareUrl", model.shareUrl);
        detailAssertTest("isJoin", model.isJoin);
        detailAssertTest("actionType", model.actionType);
        detailAssertTest("orderType", model.orderType);
        detailAssertTest("model.shareInfo.firendsZone.thumbnail", model.shareInfo.firendsZone.thumbnail);
        detailAssertTest("model.shareInfo.firendsZone.link", model.shareInfo.firendsZone.link);
        detailAssertTest("model.shareInfo.firendsZone.content", model.shareInfo.firendsZone.content);
        detailAssertTest("shareInfo.wechat.isMini", model.shareInfo.wechat.isMini);
        detailAssertTest("shareInfo.wechat.pagePath", model.shareInfo.wechat.pagePath);
        detailAssertTest("shareInfo.wechat.userName", model.shareInfo.wechat.userName);
        detailAssertTest("shareInfo.wechat.title", model.shareInfo.wechat.title);
        detailAssertTest("model.shareInfo.wechat.thumbnail", model.shareInfo.wechat.thumbnail);
        detailAssertTest("model.shareInfo.wechat.link", model.shareInfo.wechat.link);
        detailAssertTest("model.shareInfo.wechat.content", model.shareInfo.wechat.content);
        detailAssertTest("shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
        detailAssertTest("model.shareInfo.mobileQQ.thumbnail", model.shareInfo.mobileQQ.thumbnail);
        detailAssertTest("model.shareInfo.mobileQQ.link", model.shareInfo.mobileQQ.link);
        detailAssertTest("model.shareInfo.mobileQQ.content", model.shareInfo.mobileQQ.content);
        detailAssertTest("shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
        detailAssertTest("model.shareInfo.alipay.thumbnail", model.shareInfo.alipay.thumbnail);
        detailAssertTest("model.shareInfo.alipay.link", model.shareInfo.alipay.link);
        detailAssertTest("model.shareInfo.alipay.content", model.shareInfo.alipay.content);


    }
}
