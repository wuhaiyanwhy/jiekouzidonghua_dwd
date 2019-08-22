package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.UserMyincomeData;
import org.testng.annotations.Test;

public class UserMyincome extends JszInterfaceTest {

    private UserMyincomeData model;

    public void userMyincome(String commissionstatus) {
        setUrl("user.myincome.uri");
        param = "commission_status=" + commissionstatus +
        "&needPagination=0" ;
        process(true, false);
        model = sparseJson(UserMyincomeData.class);
        detailAssert();
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

    private void detailAssert(){
        detailAssertTest("commission_accum_amount",model.commission_accum_amount);
        for ( int i = 0; i<model.list.size(); i++){
            detailAssertTest("id",model.list.get(i).id);
            detailAssertTest("user_id",model.list.get(i).user_id);
            detailAssertTest("order_id",model.list.get(i).order_id);
            detailAssertTest("item_name",model.list.get(i).item_name);
            detailAssertTest("pay_amount",model.list.get(i).pay_amount);
            detailAssertTest("commission_amount",model.list.get(i).commission_amount);
            detailAssertTest("nickname",model.list.get(i).nickname);
            detailAssertTest("commission_type",model.list.get(i).commission_type);
            detailAssertTest("row_status",model.list.get(i).row_status);
            detailAssertTest("created_at",model.list.get(i).created_at);
//            detailAssertTest("order_created_at",model.list.get(i).order_created_at);
//            detailAssertTest("item_id",model.list.get(i).item_id);
//            detailAssertTest("activity_id",model.list.get(i).activity_id);
//            detailAssertTest("item_image",model.list.get(i).item_image);
        }
//        detailAssertTest("total_cnt",model.total_cnt);
//        detailAssertTest("total_page",model.total_page);
    }
}
