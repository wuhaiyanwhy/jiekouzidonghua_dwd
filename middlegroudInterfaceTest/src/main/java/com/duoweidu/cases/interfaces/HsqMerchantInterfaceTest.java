package com.duoweidu.cases.interfaces;

import com.duoweidu.utils.ConfigFileUrl;

public class
HsqMerchantInterfaceTest extends InterfaceTest {

    @Override
    protected long limitTime() {
        return ConfigFileUrl.getLimitTime1();
    }

    @Override
    public int channel_id() {
        return ConfigFileUrl.getChannel2();
    }

}
