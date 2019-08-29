package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.MessageTypeData;
import org.testng.annotations.Test;

public class MessageType extends MsfInterfaceTest {

    private MessageTypeData model;

    @Test(dependsOnGroups = "loginTrue",description = "消息首页")
    public void messageType() {
        setUrl("message.type.uri");
        process(true,false);
        model = sparseJson(MessageTypeData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotNull("like_favorite.count", model.like_favorite.count);
        assertNotNull("comment.count", model.comment.count);
        assertNotNull("fans.count", model.fans.count);
        assertNotNull("notice.count", model.notice.count);
        assertNotNull("follow.count", model.follow.count);
        if (model.notice.list.size() > 0) {
            for (int i = 0; i < model.notice.list.size(); i++) {
                assertNotEmpty("notice.list.get(i).id", model.notice.list.get(i).id);
                assertNotNull("notice.list.get(i).sender_id", model.notice.list.get(i).sender_id);
                assertNotEmpty("notice.list.get(i).receiver_id", model.notice.list.get(i).receiver_id);
                assertNotNull("notice.list.get(i).sys_message_id", model.notice.list.get(i).sys_message_id);
                assertNotEmpty("notice.list.get(i).title", model.notice.list.get(i).title);
                assertNotEmpty("notice.list.get(i).content", model.notice.list.get(i).content);
                assertNotEmpty("notice.list.get(i).type", model.notice.list.get(i).type);
                assertNotEmpty("notice.list.get(i).related_id", model.notice.list.get(i).related_id);
                assertNotNull("notice.list.get(i).status", model.notice.list.get(i).status);
                assertNotEmpty("notice.list.get(i).publish_at", model.notice.list.get(i).publish_at);
                assertNotEmpty("notice.list.get(i).created_at", model.notice.list.get(i).created_at);
                assertNotEmpty("notice.list.get(i).updated_at", model.notice.list.get(i).updated_at);
                assertNotEmpty("notice.list.get(i).article_id", model.notice.list.get(i).article_id);
                assertNotEmpty("notice.list.get(i).article_title", model.notice.list.get(i).article_title);
                assertNotEmpty("notice.list.get(i).article_pic", model.notice.list.get(i).article_pic);
                assertNotNull("notice.list.get(i).article_pic_width", model.notice.list.get(i).article_pic_width);
                assertNotNull("notice.list.get(i).article_pic_height", model.notice.list.get(i).article_pic_height);
                assertNotEmpty("notice.list.get(i).article_status", model.notice.list.get(i).article_status);
                assertNotEmpty("notice.list.get(i).media_type", model.notice.list.get(i).media_type);
                assertNotEmpty("notice.list.get(i).sender_nickname", model.notice.list.get(i).sender_nickname);
                assertNotEmpty("notice.list.get(i).sender_avatar", model.notice.list.get(i).sender_avatar);
                assertNotNull("notice.list.get(i).sender_quality_user", model.notice.list.get(i).sender_quality_user);
            }
        }
        if (model.follow.list.size() > 0) {
            for (int i = 0; i < model.follow.list.size(); i++) {
                assertNotEmpty("notice.follow.get(i).id", model.follow.list.get(i).id);
                assertNotEmpty("notice.follow.get(i).sender_id", model.follow.list.get(i).sender_id);
                assertNotEmpty("notice.follow.get(i).receiver_id", model.follow.list.get(i).receiver_id);
                assertNotNull("notice.follow.get(i).sys_message_id", model.follow.list.get(i).sys_message_id);
                assertNotEmpty("notice.follow.get(i).title", model.follow.list.get(i).title);
                assertNotEmpty("notice.follow.get(i).content", model.follow.list.get(i).content);
                assertNotEmpty("notice.follow.get(i).type", model.follow.list.get(i).type);
                assertNotEmpty("notice.follow.get(i).related_id", model.follow.list.get(i).related_id);
                assertNotNull("notice.follow.get(i).status", model.follow.list.get(i).status);
                assertNotEmpty("notice.follow.get(i).publish_at", model.follow.list.get(i).publish_at);
                assertNotEmpty("notice.follow.get(i).created_at", model.follow.list.get(i).created_at);
                assertNotEmpty("notice.follow.get(i).updated_at", model.follow.list.get(i).updated_at);
                assertNotEmpty("notice.follow.get(i).article_id", model.follow.list.get(i).article_id);
                assertNotEmpty("notice.follow.get(i).article_title", model.follow.list.get(i).article_title);
                assertNotEmpty("notice.follow.get(i).article_pic", model.follow.list.get(i).article_pic);
                assertNotNull("notice.follow.get(i).article_pic_width", model.follow.list.get(i).article_pic_width);
                assertNotNull("notice.follow.get(i).article_pic_height", model.follow.list.get(i).article_pic_height);
                assertNotEmpty("notice.follow.get(i).article_status", model.follow.list.get(i).article_status);
                assertNotEmpty("notice.follow.get(i).media_type", model.follow.list.get(i).media_type);
                assertNotEmpty("notice.follow.get(i).sender_nickname", model.follow.list.get(i).sender_nickname);
                assertNotEmpty("notice.follow.get(i).sender_avatar", model.follow.list.get(i).sender_avatar);
                assertNotNull("notice.follow.get(i).sender_quality_user", model.follow.list.get(i).sender_quality_user);
            }
        }
    }
}
