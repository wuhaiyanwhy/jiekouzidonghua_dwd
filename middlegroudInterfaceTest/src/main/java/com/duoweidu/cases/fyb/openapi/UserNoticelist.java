package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.UserNoticelistData;
import org.testng.annotations.Test;

public class UserNoticelist extends FybInterfaceTest {

    private UserNoticelistData model;

    @Test(description = "系统消息列表")
    public void userNoticelist() {
        setUrl("user.noticelist.uri");
        param = "pageNum=1&pageLimit=10";
        process(true,true);
        model = sparseJson(UserNoticelistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).user_id", model.list.get(i).user_id);
            assertNotEmpty("list.get(i).title", model.list.get(i).title);
            assertNotEmpty("list.get(i).content", model.list.get(i).content);
            assertNotEmpty("list.get(i).send_time", model.list.get(i).send_time);
            assertNotNull("list.get(i).is_read", model.list.get(i).is_read);
            assertNotNull("list.get(i).delete_flag", model.list.get(i).delete_flag);
            assertNotNull("list.get(i).types", model.list.get(i).types);
            assertNotEmpty("list.get(i).action", model.list.get(i).action);
        }
    }
}
