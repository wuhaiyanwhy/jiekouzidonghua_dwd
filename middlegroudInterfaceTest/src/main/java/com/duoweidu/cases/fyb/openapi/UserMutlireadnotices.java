package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.hsq.ResData;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserMutlireadnotices extends FybInterfaceTest {

    private ResData model;

    @Test(description = "系统通知消息已读")
    public void userMutlireadnotices() {
        setUrl("user.mutlireadnotices.uri");
        process(true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertTrue("res", model.res);
    }

}
