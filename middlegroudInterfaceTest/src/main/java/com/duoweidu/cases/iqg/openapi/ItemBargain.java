package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class ItemBargain extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "砍价",groups = "itemBargain")
    public void item_bargain_true() {
        url = ConfigFileUrl.getUrlByKey("item.bargain.uri") + "/" + SqlDetail.getInstance().getParamValue(2, "activityId") + "/bargain";
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("black_box", SqlDetail.getInstance().getParamValue(2,"black_box")));
        process(list, false, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
        }
    }
}

