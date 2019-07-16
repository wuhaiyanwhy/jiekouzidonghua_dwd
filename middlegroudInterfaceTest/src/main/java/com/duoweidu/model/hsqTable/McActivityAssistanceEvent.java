package com.duoweidu.model.hsqTable;

/**
 * 助力免单表
 */
public class McActivityAssistanceEvent {
    public int join_count;
    public int event_status;
    public String owner_id;
    public String assistance_id;

    public McActivityAssistanceEvent() {

    }

    public McActivityAssistanceEvent(int join_count, int event_status, String owner_id, String assistance_id) {
        this.join_count = join_count;
        this.event_status = event_status;
        this.owner_id = owner_id;
        this.assistance_id = assistance_id;
    }
}
