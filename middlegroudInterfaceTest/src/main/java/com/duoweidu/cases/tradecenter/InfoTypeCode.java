package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.model.tradecenter.InfoTypeCodeData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class InfoTypeCode extends TradeCenterInterfaceTest {

    private InfoTypeCodeData model;

    @Test(dependsOnGroups = "msfCreate", description = "查询订单附加信息类别代码")
    public void msfInfoTypeCode() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "order.info_type_code"));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(InfoTypeCodeData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest("fees", model.fees.toString());
        detailAssertTest("运费", "fees.FREIGHT", model.fees.FREIGHT);
        detailAssertTest("promotion", model.promotion.toString());
        detailAssertTest("平台优惠", "promotion.PLATFORM", model.promotion.PLATFORM);
        detailAssertTest("商家优惠", "promotion.SELLER", model.promotion.SELLER);
        detailAssertTest("活动优惠", "promotion.ACTIVITY", model.promotion.ACTIVITY);
        detailAssertTest("settle_type", model.settle_type.toString());
        detailAssertTest("用户返佣", "settle.ONLINE_COMMISSION", model.settle_type.USER_COMMISSION);
        detailAssertTest("商家结算", "settle.ONLINE_SETTLE_PRICE", model.settle_type.SELLER_SETTLEMENT);
        detailAssertTest("settle_method", model.settle_method.toString());
        detailAssertTest("线上结算-佣金", "settle.ONLINE_COMMISSION", model.settle_method.ONLINE_COMMISSION);
        detailAssertTest("线上结算-结算价", "settle.ONLINE_SETTLE_PRICE", model.settle_method.ONLINE_SETTLE_PRICE);
        detailAssertTest("线下结算", "settle.OFFLINE", model.settle_method.OFFLINE);
        detailAssertTest("不结算", "settle.NO_SETTLE", model.settle_method.NO_SETTLE);
        detailAssertTest("", "reverse", model.reverse);

    }
}
