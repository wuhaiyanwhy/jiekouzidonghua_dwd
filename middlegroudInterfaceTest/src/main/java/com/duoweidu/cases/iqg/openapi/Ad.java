package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.iqg.AdData;
import org.testng.annotations.Test;

public class Ad extends IqgInterfaceTest {

    private AdData model;

    @Test(dependsOnGroups = "loginTrue",description = "广告")
    public void ad_true() {
        setUrl("ad.uri");
        param = "position_id=1&zone_id=" + SqlDetail.getInstance().getParamValue(0, "zone_id");
        process(true,true);
        model = sparseJson(AdData.class);
        detailAssert();
    }

    public void detailAssert(){
        for ( int i = 0; i<model.list.size(); i++){
            detailAssertTest("id",model.list.get(i).id);
            detailAssertTest("title",model.list.get(i).title);
            detailAssertTest("url",model.list.get(i).url);
            detailAssertTest("size",model.list.get(i).size);
//            detailAssertTest("width",model.list.get(i).width);
//            detailAssertTest("height",model.list.get(i).height);
        }
    }
}
