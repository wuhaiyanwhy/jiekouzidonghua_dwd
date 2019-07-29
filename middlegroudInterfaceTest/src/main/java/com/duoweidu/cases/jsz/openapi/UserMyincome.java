package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class UserMyincome extends JszInterfaceTest {

    public void userMyincome(String commissionstatus) {
        setUrl("user.myincome.uri");
        param = "commission_status=" + commissionstatus +
        "&needPagination=0" ;
        process(true, false);
    }

    @Test(description = "0:全部收益")
    public void UserMyincome0() {
        userMyincome(SqlDetail.getInstance().getParamValue(0,"commissionstatus0"));
    }

    @Test(description = "1:已到账")
    public void UserMyincome1() {
        userMyincome(SqlDetail.getInstance().getParamValue(0, "commissionstatus1"));
    }

    @Test(description = "2:即将到账")
    public void UserMyincome2() {
        userMyincome(SqlDetail.getInstance().getParamValue(0,"commissionstatus2"));

    }
}
