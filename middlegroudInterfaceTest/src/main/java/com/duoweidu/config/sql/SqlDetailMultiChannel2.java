package com.duoweidu.config.sql;

import com.duoweidu.utils.ConfigFileUrl;

public class SqlDetailMultiChannel2 extends SqlDetail {

    @Override
    public int channel_id() {
        int channelId = ConfigFileUrl.getChannel();
        if (ConfigFileUrl.getChannel1() != 0) {
            channelId = ConfigFileUrl.getChannel2();
        }
        return channelId;
    }

}
