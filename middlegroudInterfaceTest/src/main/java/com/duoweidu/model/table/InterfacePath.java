package com.duoweidu.model.table;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 接口路径表model
 */
@Data
public class InterfacePath {

    private int id;
    private int channel_id;
    private String name;
    private String path;
    private int errno_count;
    private Timestamp created_at;
    private String note;

    public InterfacePath() {

    }

    public InterfacePath(int channel_id, String name) {
        this.channel_id = channel_id;
        this.name = name;
    }

    public InterfacePath(int id, int channel_id) {
        this.id = id;
        this.channel_id = channel_id;
    }

    public InterfacePath(int id, int channel_id, int errno_count) {
        this.id = id;
        this.channel_id = channel_id;
        this.errno_count = errno_count;
    }

}
