package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.MarketLotteryactivitylistData;
import org.testng.annotations.Test;

public class market_lotteryactivitylist_test extends HsqInterfaceTest {

    private MarketLotteryactivitylistData model;

    @Test(dependsOnGroups = "loginTrue",description = "抽奖团列表")
    public void market_lotteryactivitylist_true() {
        setUrl("market.lotteryactivitylist.uri");
        process(true,true);
        model = sparseJson(MarketLotteryactivitylistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("status", model.list.get(i).status);
            detailAssertTest("canBuy", String.valueOf(model.list.get(i).canBuy));
            detailAssertTest("canSub", String.valueOf(model.list.get(i).canSub));
            detailAssertTest("canUnSub", String.valueOf(model.list.get(i).canUnSub));
            detailAssertTest("pinActivitiesId", model.list.get(i).pinActivitiesId);
            detailAssertTest("type", model.list.get(i).type);
            detailAssertTest("title", model.list.get(i).title);
            detailAssertTest("startTime", model.list.get(i).status);
            detailAssertTest("endTime", model.list.get(i).status);
            detailAssertTest("groupPrice", String.valueOf(model.list.get(i).groupPrice));
            detailAssertTest("marketPrice", String.valueOf(model.list.get(i).marketPrice));
            detailAssertTest("remindStatus", String.valueOf(model.list.get(i).remindStatus));
            detailAssertTest("lotteryTime", String.valueOf(model.list.get(i).lotteryTime));
            detailAssertTest("hasBeenLottery", String.valueOf(model.list.get(i).hasBeenLottery));
            detailAssertTest("lotteryPics", model.list.get(i).lotteryPics);
        }
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("totalPage", model.totalPage);
    }
}
