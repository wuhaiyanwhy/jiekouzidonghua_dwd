package com.duoweidu.cases.interfaces;

import com.duoweidu.utils.ConfigFileUrl;

public class HsqMerchantInterfaceTest extends InterfaceTest {

    @Override
    public int channel_id() {
        return ConfigFileUrl.getChannel2();
    }

}
