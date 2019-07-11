package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

import java.io.IOException;

public class user_usercouplelist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="二人购用户订单列表(拼团中)")
    public void user_usercouplelist_pintuanzhongTrue() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_USERCOUPLELIST);
        param = "type=1";
        process(true,false);
    }

    @Test(dependsOnGroups = "loginTrue",description ="二人购用户订单列表(拼团成功)")
    public void user_usercouplelist_pintuanchenggongTrue() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_USERCOUPLELIST);
        param = "type=2";
        process(true,true);
    }

    @Test(dependsOnGroups = "loginTrue",description ="二人购用户订单列表(拼团失败)")
    public void user_usercouplelist_pintuanshibaiTrue() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_USERCOUPLELIST);
        param = "type=3";
        process(true,true);
    }

}
