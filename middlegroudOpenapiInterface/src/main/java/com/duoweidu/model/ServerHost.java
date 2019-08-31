package com.duoweidu.model.table;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 环境表model
 */
@Data
public class ServerHost {

    private int id;
    private int channel_id;
    private int env;
    private String protocol;
    private String server_name;
    private Timestamp created_at;
    private String name;

    public ServerHost() {

    }

    public ServerHost(int channel_id, int env) {
        this.channel_id = channel_id;
        this.env = env;
    }
}
