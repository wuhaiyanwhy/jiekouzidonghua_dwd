package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.UserCoupleactivitiedetailData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;


public class user_coupleactivitiedetail_test extends HsqInterfaceTest {

    public UserCoupleactivitiedetailData model;

    @Test(dependsOnGroups = "loginTrue",description = "分享详情")
    public void user_coupleactivitiedetail_true() {
        setUrl("user.coupleactivitiedetail.uri");
        param = "pinEventId=" + SqlDetail.getInstance().getParamValue("pinEventId");
        process(true,false);
        model = sparseJson(UserCoupleactivitiedetailData.class);
        detailAssert();
    }

    private void detailAssert() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest("friendsInfo", model.friendsInfo);
            for (int i = 0; i < model.friendsInfo.size(); i++) {
                detailAssertTest("userId", model.friendsInfo.get(i).userId);
                detailAssertTest("userAvatar", model.friendsInfo.get(i).userAvatar);
            }
        }
        detailAssertTest("status", model.status);
        detailAssertTest("endTime", model.endTime);
        detailAssertTest("countLimit", model.countLimit);
        detailAssertTest("joinCount", model.joinCount);
        detailAssertTest("title", model.title);
        detailAssertTest("skuInfo.thumbnail", model.skuInfo.thumbnail);
        detailAssertTest("skuInfo.skuId", model.skuInfo.skuId);
        detailAssertTest("skuInfo.manufactured_date", model.skuInfo.manufactured_date);
        detailAssertTest("skuInfo.expired_date", model.skuInfo.expired_date);
        detailAssertTest("skuInfo.marketPrice", model.skuInfo.marketPrice);
        detailAssertTest("skuInfo.deliveryTimeAfterBuy", model.skuInfo.deliveryTimeAfterBuy);
        detailAssertTest("skuInfo.attrs", model.skuInfo.attrs);
        detailAssertTest("skuInfo.batch", model.skuInfo.batch);
        detailAssertTest("skuInfo.pinActivitiesTitle", model.skuInfo.pinActivitiesTitle);
        detailAssertTest("skuInfo.groupPrice", model.skuInfo.groupPrice);
        detailAssertTest("skuInfo.single_price", model.skuInfo.single_price);
        detailAssertTest("skuInfo.enabled", model.skuInfo.enabled);
        detailAssertTest("skuInfo.left_stock", String.valueOf(model.skuInfo.left_stock));
        detailAssertTest("skuInfo.skuPics", model.skuInfo.skuPics);
        detailAssertTest("skuInfo.attrKeys", model.skuInfo.attrKeys);
        for (int i = 0; i < model.skuInfo.attrKeys.size(); i++) {
            detailAssertTest("skuInfo.attrKeys.get(i).name", model.skuInfo.attrKeys.get(i).name);
            detailAssertTest("skuInfo.attrKeys.get(i).defaultAttr", model.skuInfo.attrKeys.get(i).defaultAttr);

        }
//        detailAssertTest("skuInfo.labels", model.skuInfo.labels);
//        for (int i = 0; i < model.skuInfo.labels.size(); i++) {
//            detailAssertTest("skuInfo.labels.get(i).icon", model.skuInfo.labels.get(i).icon);
//            detailAssertTest("skuInfo.labels.get(i).text", model.skuInfo.labels.get(i).text);
//            detailAssertTest("skuInfo.labels.get(i).link", model.skuInfo.labels.get(i).link);
//
//        }
//        detailAssertTest("pricePrefix", model.skuInfo.pricePrefix);
        detailAssertTest("pinActivitiesId", model.pinActivitiesId);
        detailAssertTest("skuId", model.skuId);

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

