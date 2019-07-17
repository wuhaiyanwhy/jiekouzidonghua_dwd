package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ActivityGetactivitylist extends JszInterfaceTest {

    @Test(description = "活动列表")
    public void activityGetactivitylist() {
        setUrl("activityGetactivitylist.uri");
        param = "zoneId=" + SqlDetail.getInstance().getParamValue("zoneId");
        param = "lng=" + SqlDetail.getInstance().getParamValue("lng");
        param = "lat=" + SqlDetail.getInstance().getParamValue("lat");
        param = "pageLimit=" + SqlDetail.getInstance().getParamValue("pageLimit");
        param = "pageNum=" + SqlDetail.getInstance().getParamValue("pageNum");
        process(true,false);

    }
}
