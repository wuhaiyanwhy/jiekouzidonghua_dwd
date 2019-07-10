package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class UserFavoritelist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "用户收藏列表")
    public void userFavoritelist() {
        setUrl("user.favoritelist.uri");
        param = "page_num=1&page_limit=20&need_pagination=1";
        process(true,true);
    }
}
