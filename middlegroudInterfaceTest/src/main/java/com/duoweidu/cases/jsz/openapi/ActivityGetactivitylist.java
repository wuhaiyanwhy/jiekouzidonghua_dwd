package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ActivityGetactivitylist extends JszInterfaceTest {

    @Test(description = "活动列表")
    public void activityGetactivitylist() {
        setUrl("activityGetactivitylist.uri");
        param = "zoneId=" + SqlDetail.getInstance().getParamValue(0, "zoneId") +
                "&lng=" + SqlDetail.getInstance().getParamValue(0,"lng") +
                "&lat=" + SqlDetail.getInstance().getParamValue(0,"lat") +
                "&pageLimit=" + SqlDetail.getInstance().getParamValue(0,"pageLimit") +
                "&pageNum=" + SqlDetail.getInstance().getParamValue(0,"pageNum") ;
        process(true,false);

    }
}
