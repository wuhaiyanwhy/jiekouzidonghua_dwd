package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.model.tradecenter.BillData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Bill extends TradeCenterInterfaceTest {

    private BillData model;

    @Test(dependsOnGroups = "msfCreate", description = "获取对账单信息")
    public void msf() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.bill"));
        list.add(new BasicNameValuePair("billdate", "20190529"));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(BillData.class);
            detailAssert();
        }
    }

    private void detailAssert() {

        detailAssertTest("filelink", model.filelink);
        detailAssertTest("accesskey", model.accesskey);
        detailAssertTest(1696, "filesize", model.filesize);
        detailAssertTest("b84b766278078bc085748c5a6ae76427f0d52ba6", "filesum", model.filesum);
        detailAssertTest("20190529", "billdate", model.billdate);
        detailAssertTest("", "reverse", model.reverse);
    }
}
