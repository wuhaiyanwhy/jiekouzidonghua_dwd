package com.duoweidu.config;

import com.duoweidu.utils.ConfigFileUrl;

public class SqlDetailMultiChannel1 extends SqlDetail {

    @Override
    public int channel_id() {
        int channelId = ConfigFileUrl.getChannel();
        if (ConfigFileUrl.getChannel1() != 0) {
            channelId = ConfigFileUrl.getChannel1();
        }
        return channelId;
    }
}
