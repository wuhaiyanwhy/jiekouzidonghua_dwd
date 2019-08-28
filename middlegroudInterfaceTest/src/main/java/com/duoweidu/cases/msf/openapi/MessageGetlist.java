package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.MessageGetlistData;
import org.testng.annotations.Test;

public class MessageGetlist extends MsfInterfaceTest {

    private MessageGetlistData model;

    @Test(dependsOnGroups = "loginTrue",description = "消息列表")
    public void messageGetlist() {
        setUrl("message.getlist.uri");
        process(true,false);
        model = sparseJson(MessageGetlistData.class);
        detailAssert();
    }

    private void detailAssert() {
        if (model.list.size() > 0) {
            for (int i = 0; i < model.list.size(); i++) {
                assertNotEmpty("list.get(i).id", model.list.get(i).id);
                assertNotEmpty("list.get(i).sender_id", model.list.get(i).sender_id);
                assertNotEmpty("list.get(i).receiver_id", model.list.get(i).receiver_id);
                assertNotNull("list.get(i).sys_message_id", model.list.get(i).sys_message_id);
                assertNotEmpty("list.get(i).title", model.list.get(i).title);
                assertNotNull("list.get(i).content", model.list.get(i).content);
                assertNotEmpty("list.get(i).type", model.list.get(i).type);
                assertNotEmpty("list.get(i).related_id", model.list.get(i).related_id);
                assertNotEmpty("list.get(i).status", model.list.get(i).status);
                assertNotEmpty("list.get(i).publish_at", model.list.get(i).publish_at);
                assertNotEmpty("list.get(i).created_at", model.list.get(i).created_at);
                assertNotEmpty("list.get(i).updated_at", model.list.get(i).updated_at);
                assertNotEmpty("list.get(i).article_id", model.list.get(i).article_id);
                assertNotEmpty("list.get(i).article_title", model.list.get(i).article_title);
                assertNotEmpty("list.get(i).article_pic", model.list.get(i).article_pic);
                assertNotNull("list.get(i).article_pic_width", model.list.get(i).article_pic_width);
                assertNotNull("list.get(i).article_pic_height", model.list.get(i).article_pic_height);
                assertNotEmpty("list.get(i).article_status", model.list.get(i).article_status);
                assertNotEmpty("list.get(i).media_type", model.list.get(i).media_type);
                assertNotEmpty("list.get(i).sender_nickname", model.list.get(i).sender_nickname);
                assertNotEmpty("list.get(i).sender_avatar", model.list.get(i).sender_avatar);
                assertNotNull("list.get(i).sender_introduction", model.list.get(i).sender_introduction);
                assertNotNull("list.get(i).sender_quality_user", model.list.get(i).sender_quality_user);
            }
        }
    }
}
