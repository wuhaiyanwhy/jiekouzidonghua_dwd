package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class user_usercouplelist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="二人购用户订单列表(拼团中)")
    public void user_usercouplelist_pintuanzhongTrue() {
        setUrl("user.usercouplelist.uri");
        param = "type=1";
        process(true,false);
    }

    @Test(dependsOnGroups = "loginTrue",description ="二人购用户订单列表(拼团成功)")
    public void user_usercouplelist_pintuanchenggongTrue() {
        setUrl("user.usercouplelist.uri");
        param = "type=2";
        process(true,true);
    }

    @Test(dependsOnGroups = "loginTrue",description ="二人购用户订单列表(拼团失败)")
    public void user_usercouplelist_pintuanshibaiTrue() {
        setUrl("user.usercouplelist.uri");
        param = "type=3";
        process(true,true);
    }

}
