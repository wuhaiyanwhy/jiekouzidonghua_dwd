package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserFavoritelist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "用户收藏列表")
    public void userFavoritelist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_FAVORITELIST);
        param = "page_num=1&page_limit=20&need_pagination=1";
        process(true,true);
    }
}
