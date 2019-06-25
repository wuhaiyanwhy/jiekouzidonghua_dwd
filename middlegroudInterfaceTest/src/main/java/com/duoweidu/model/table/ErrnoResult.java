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

}
