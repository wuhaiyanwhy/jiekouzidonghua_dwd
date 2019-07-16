package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ActivityAssistanceshareinfoData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class ActivityAssistanceshareinfo extends HsqInterfaceTest {

    private ActivityAssistanceshareinfoData model;

    @Test(description = "获取分享图片信息")
    public void activityAssistanceshareinfo() {
        setUrl("activity.assistanceshareinfo.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("token", SqlDetail.getInstance().getParamValue("token")));
        list.add(new BasicNameValuePair("activityId", SqlDetail.getInstance().getParamValue(2, "noPayActivityId")));
        list.add(new BasicNameValuePair("eventId", SqlDetail.getInstance().getParamValue(2, "noPayActivityEventId")));
        process(list, false, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(ActivityAssistanceshareinfoData.class);
            detailAssert();
        }

    }

    private void detailAssert() {
        detailAssertTest("share_image_url", model.share_image_url);
        detailAssertTest("qrcode_url", model.qrcode_url);

    }
}
