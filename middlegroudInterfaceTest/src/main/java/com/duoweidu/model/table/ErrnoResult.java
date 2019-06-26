package com.duoweidu.model.table;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 报错信息表model
 */
@Data
public class ErrnoResult {

    private int id;
    private int channel_id;
    private int env_id;
    private int path_id;
    private int build_id;
    private String params;
    private int status;
    private String result;
    private Timestamp created_at;
    private String note;

    public ErrnoResult() {

    }

    public ErrnoResult(int channel_id, int env_id, int path_id, int build_id, String params, int status, String result) {
        this.channel_id = channel_id;
        this.env_id = env_id;
        this.path_id = path_id;
        this.build_id = build_id;
        this.params = params;
        this.status = status;
        this.result = result;
    }

}
