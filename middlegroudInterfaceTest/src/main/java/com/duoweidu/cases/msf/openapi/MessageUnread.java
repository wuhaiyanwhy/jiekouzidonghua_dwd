package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.MsfConfig;
import com.duoweidu.model.msf.MessageUnreadData;
import org.testng.annotations.Test;

public class MessageUnread extends MsfInterfaceTest {

    private MessageUnreadData model;

    @Test(dependsOnGroups = "loginTrue",description = "未读消息数")
    public void messageUnread() {
        setUrl("message.unread.uri");
        param = "user_id="  + MsfConfig.userId;
        process(true,false);
        model = sparseJson(MessageUnreadData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotNull("count", model.count);
    }
}
