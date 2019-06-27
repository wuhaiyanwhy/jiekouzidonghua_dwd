package com.duoweidu.model.table;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 构建表model
 */
@Data
public class Build {

    private int id;
    private int channel_id;
    private int env;
    private int enabled;
    private int message_status;
    private Timestamp created_at;
    private String note;

    public Build() {

    }

    public Build(int channel_id) {

        this.channel_id = channel_id;
    }

    public Build(int channel_id, int env) {

        this.channel_id = channel_id;
        this.env = env;
    }

    public Build(int channel_id, int env, int enabled, int message_status) {

        this.channel_id = channel_id;
        this.env = env;
        this.enabled = enabled;
        this.message_status = message_status;
    }
}
