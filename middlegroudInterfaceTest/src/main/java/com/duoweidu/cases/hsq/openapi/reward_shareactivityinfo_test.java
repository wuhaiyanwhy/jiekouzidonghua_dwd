package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.RewardShareactivityinfoData;
import org.testng.annotations.Test;

public class reward_shareactivityinfo_test extends HsqInterfaceTest {

    private RewardShareactivityinfoData model;

    @Test(dependsOnGroups = "loginTrue",description = "获取分享活动信息")
    public void reward_shareactivityinfo_true() {
        setUrl("reward.shareactivityinfo.uri");
        param = "activityId=1";
        process(true,false);
        model = sparseJson(RewardShareactivityinfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("id", model.id);
        detailAssertTest("title", model.title);
        detailAssertTest("subTitle", model.subTitle);
        detailAssertTest("pageLocation", model.pageLocation);
        detailAssertTest("buttonText", model.buttonText);
        detailAssertTest("model.shareInfo.firendsZone.thumbnail", model.shareZones.firendsZone.thumbnail);
        detailAssertTest("model.shareInfo.firendsZone.link", model.shareZones.firendsZone.link);
        detailAssertTest("model.shareInfo.firendsZone.content", model.shareZones.firendsZone.content);
        detailAssertTest("shareInfo.wechat.title", model.shareZones.wechat.title);
        detailAssertTest("model.shareInfo.wechat.thumbnail", model.shareZones.wechat.thumbnail);
        detailAssertTest("model.shareInfo.wechat.link", model.shareZones.wechat.link);
        detailAssertTest("model.shareInfo.wechat.content", model.shareZones.wechat.content);
        detailAssertTest("shareInfo.mobileQQ.title", model.shareZones.mobileQQ.title);
        detailAssertTest("model.shareInfo.mobileQQ.thumbnail", model.shareZones.mobileQQ.thumbnail);
        detailAssertTest("model.shareInfo.mobileQQ.link", model.shareZones.mobileQQ.link);
        detailAssertTest("model.shareInfo.mobileQQ.content", model.shareZones.mobileQQ.content);
        detailAssertTest("shareInfo.mobileQQ.title", model.shareZones.mobileQQ.title);

    }

}
