package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.model.iqg.AddressInfoData;
import org.testng.annotations.Test;

public class AddressInfo extends IqgInterfaceTest {

    private AddressInfoData model;

    @Test(dependsOnGroups = "loginTrue",description = "今日砍价用户头像")
    public void addressInfoTrue() {
        setUrl("address.info.uri");
        param = "zone_id=21";
        process(true,false);
        model = sparseJson(AddressInfoData.class);
        detailAssert();
    }

    private void detailAssert(){
        for ( int i = 0; i<model.cbd.size(); i++){
            detailAssertTest("name",model.cbd.get(i).name);
            detailAssertTest("lat",model.cbd.get(i).lat);
            detailAssertTest("lng",model.cbd.get(i).lng);
        }
    }

}
