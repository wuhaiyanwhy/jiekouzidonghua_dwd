package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

/**
 * 暂无公告，无需通用断言
 */
public class msgboard_getlistmsgboard_test extends HsqInterfaceTest {

    private void genMsgboard(String channelId) {
        setUrl("msgboard.getlistmsgboard.uri");
        param = "channelId=" + channelId;
        process(true,false);
    }

    @Test(dependsOnGroups = "loginTrue",description = "获取公告列表(主站)")
    public void msgboard_getlistmsgboard_zhuzhanTrue() {
        genMsgboard("1");
    }

    @Test(dependsOnGroups = "loginTrue",description = "获取公告列表(支付宝)")
    public void msgboard_getlistmsgboard_zhifubaoTrue() {
        genMsgboard("2");
    }

}
