package com.duoweidu.model.table;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 接口参数表model
 */
@Data
public class Param {

    private int id;
    private int channel_id;
    private int path_id;
    private int env;
    private String name;
    private String value;
    private Timestamp created_at;
    private String note;
    private String token;

    public  Param() {

    }

    public Param(int channel_id, int env, String name) {
        this.channel_id = channel_id;
        this.env = env;
        this.name = name;
    }
}
