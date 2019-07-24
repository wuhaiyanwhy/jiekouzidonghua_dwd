package com.duoweidu.config.sql;

import com.duoweidu.utils.ConfigFileUrl;

public class SqlDetailMultiChannel2 extends SqlDetail {

    private static SqlDetail instance;

    @Override
    public int channel_id() {
        int channelId = super.channel_id();
        if (ConfigFileUrl.getChannel1() != 0) {
            channelId = ConfigFileUrl.getChannel2();
        }
        return channelId;
    }

    public static SqlDetail getInstance() {
        if (instance == null) {
            instance = new SqlDetailMultiChannel1();
        }
        return instance;
    }



}
