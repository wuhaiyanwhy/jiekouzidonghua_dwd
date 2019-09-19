package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.InviteGetcodeData;
import org.testng.annotations.Test;

public class InviteGetcode extends MsfInterfaceTest {

    private InviteGetcodeData model;

    @Test(dependsOnGroups = "loginTrue",description = "获取邀请码")
    public void inviteGetcode() {
        setUrl("invite.getcode.uri");
        process(true,false);
        model = sparseJson(InviteGetcodeData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("invite_code", model.invite_code);
    }
}
