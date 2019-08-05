package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class UserGetcanchoosesku extends HsqInterfaceTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取可选规格",priority = 1)
    public void userGetcanchoosesku(){
        setUrl("user.getcanchoosesku.uri");
        param = "skuId=" + SqlDetail.getInstance().getParamValue("goskuId");
        process(true,false);


    }
}
