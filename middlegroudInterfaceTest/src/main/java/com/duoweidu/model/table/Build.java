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
    private int enabled;
    private int message_status;
    private Timestamp created_at;
    private String note;
}
