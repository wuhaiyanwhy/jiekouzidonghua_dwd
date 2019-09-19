package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.CommonNoticestatusData;
import org.testng.annotations.Test;

public class CommonNoticestatus extends FybInterfaceTest {

    private CommonNoticestatusData model;

    @Test(description = "消息状态查询")
    public void commonNoticestatus() {
        setUrl("common.noticestatus.uri");
        param = "cityId=2";
        process(true,false);
        model = sparseJson(CommonNoticestatusData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("id", model.id);
        assertNotEmpty("user_id", model.user_id);
        assertNotEmpty("title", model.title);
        assertNotEmpty("content", model.content);
        assertNotEmpty("send_time", model.send_time);
        assertNotEmpty("action", model.action);

    }
}
