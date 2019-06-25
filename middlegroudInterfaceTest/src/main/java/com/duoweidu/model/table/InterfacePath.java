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
    private String path;
    private int errno_count;
    private Timestamp created_at;
    private String note;

    public InterfacePath() {

    }

    public InterfacePath(int channel_id, String note) {
        this.channel_id = channel_id;
        this.note = note;
    }

}
