package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.InviteInitdataData;
import org.testng.annotations.Test;

public class InviteInitdata extends MsfInterfaceTest {

    private InviteInitdataData model;

    @Test(dependsOnGroups = "loginTrue",description = "邀请页面初始化数据")
    public void inviteInitdata() {
        setUrl("invite.initdata.uri");
        process(true,false);
        model = sparseJson(InviteInitdataData.class);
        detailassert();
    }

    private void detailassert() {
        assertNotEmpty("pg_head", model.pg_head);
        assertNotEmpty("gift", model.gift);
        assertNotEmpty("rectangle", model.rectangle);
        assertNotEmpty("share", model.share);
        assertNotEmpty("share_wx", model.share_wx);
        assertNotEmpty("share_wb", model.share_wb);
        assertNotEmpty("bg_color", model.bg_color);
        assertNotNull("max_inv_count", model.max_inv_count);
        assertNotNull("invited_count", model.invited_count);
        assertNotEmpty("rules", model.rules);
    }
}
