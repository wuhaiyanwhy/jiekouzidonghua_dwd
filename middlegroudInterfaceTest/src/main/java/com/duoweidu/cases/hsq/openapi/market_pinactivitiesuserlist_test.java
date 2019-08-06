package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.MarketPinactivitiesuserlistData;
import org.testng.annotations.Test;

public class market_pinactivitiesuserlist_test extends HsqInterfaceTest {

    private MarketPinactivitiesuserlistData model;

    @Test(dependsOnGroups = "loginTrue",description = "分享页拼团头像列表")
    public void market_pinactivitiesuserlist_true() {
        setUrl("market.pinactivitiesuserlist.uri");
        param = "pinEventId="+ SqlDetail.getInstance().getParamValue("pinEventId");
        process(true,true);
        model = sparseJson(MarketPinactivitiesuserlistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).userAvatar", model.list.get(i).userAvatar);
            detailAssertTest("list.get(i).userId", model.list.get(i).userId);
            detailAssertTest("list.get(i).isOwner", model.list.get(i).isOwner);
        }
        detailAssertTest("type", model.type);
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("totalPage", model.totalPage);
        detailAssertTest("countLimit", model.countLimit);
        detailAssertTest("joinCount", model.joinCount);
        detailAssertTest("restCount", String.valueOf(model.restCount));

    }
}
