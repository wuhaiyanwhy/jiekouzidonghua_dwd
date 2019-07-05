package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class ItemBargain extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "砍价",groups = "itemBargain")
    public void item_bargain_true()  {
        url = ConfigFileUrl.getUrlByKey("item.bargain.uri") + "/" + SqlDetail.getParamValue(2, "activityId") + "/bargain";
        pathId = SqlDetail.getPathId("item.bargain.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
        }
    }

}
