package com.duoweidu.config.sql;

import com.duoweidu.utils.ConfigFileUrl;

public class SqlDetailMultiChannel1 extends SqlDetail {

    public int channel_id() {
        int channelId = super.channel_id();
        if (ConfigFileUrl.getChannel1() != 0) {
            channelId = ConfigFileUrl.getChannel1();
        }
        return channelId;
    }
}
