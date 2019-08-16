package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class stock_jointaobaolist_test extends HsqOpadminInterfaceTest {

    @Override
    protected long limitTime() {
        return 10000;
    }

    @Test(dependsOnGroups = "loginTrue",description = "淘宝商品绑定管理列表")
    public void stock_jointaobaolist_true() {
        setUrl("stock.jointaobaolist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);

    }
}
