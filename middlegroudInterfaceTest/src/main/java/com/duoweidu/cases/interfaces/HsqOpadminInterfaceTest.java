package com.duoweidu.cases.interfaces;

import com.duoweidu.config.SqlGeneral;
import com.duoweidu.utils.ConfigFileUrl;

public class HsqOpadminInterfaceTest extends InterfaceTest {

    @Override
    //获取url和pathId
    protected void setUrl(String key) {
        url = ConfigFileUrl.getUrlByKey(key, ConfigFileUrl.getChannel1());
        pathId = SqlGeneral.getInterfacePathValue(ConfigFileUrl.getChannel1(), key).getId();
    }
}
