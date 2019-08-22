package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.CommonCbdlistData;
import org.testng.annotations.Test;

public class CommonCbdlist extends JszInterfaceTest {

    private CommonCbdlistData model;

    @Test(description = "热门商业圈")
    public void commonCbdlist() {
        setUrl("common.cbdlist.uri");
        param = "zoneId=" + SqlDetail.getInstance().getParamValue(0,"zoneId");
        process(true, false);
        model = sparseJson(CommonCbdlistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for(int i = 0; i < model.all.size(); i++) {
            detailAssertTest("id",model.all.get(i).id);
            detailAssertTest("name",model.all.get(i).name);
            detailAssertTest("lat",model.all.get(i).lat);
            detailAssertTest("lng",model.all.get(i).lng);
        }
    }
}
