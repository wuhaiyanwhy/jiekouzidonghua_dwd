package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.UserUsercouplelistData;
import org.testng.annotations.Test;

public class user_usercouplelist_test extends HsqInterfaceTest {

    private UserUsercouplelistData model;

    public void genUsercouplelist(int type, boolean isList) {
        setUrl("user.usercouplelist.uri");
        param = "type=" + type;
        process(true, isList);
        model = sparseJson(UserUsercouplelistData.class);

    }

    @Test(dependsOnGroups = "loginTrue",description ="二人购用户订单列表(拼团中)")
    public void user_usercouplelist_pintuanzhongTrue() {
        genUsercouplelist(1, false);
    }

    @Test(dependsOnGroups = "loginTrue",description ="二人购用户订单列表(拼团成功)")
    public void user_usercouplelist_pintuanchenggongTrue() {
        genUsercouplelist(2, true);
        detailAssert();
    }

    @Test(dependsOnGroups = "loginTrue",description ="二人购用户订单列表(拼团失败)")
    public void user_usercouplelist_pintuanshibaiTrue() {
        genUsercouplelist(3, true);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).order_id", model.list.get(i).order_id);
//            detailAssertTest("list.get(i).pin_activities_id", model.list.get(i).pin_activities_id);
            detailAssertTest("list.get(i).pin_event_id", model.list.get(i).pin_event_id);
            detailAssertTest("list.get(i).user_id", model.list.get(i).user_id);
            detailAssertTest("list.get(i).pin_event_status", model.list.get(i).pin_event_status);
            detailAssertTest("list.get(i).type", model.list.get(i).type);
            detailAssertTest("list.get(i).last_update", model.list.get(i).last_update);
            detailAssertTest("list.get(i).couplePrice", model.list.get(i).couplePrice);
            detailAssertTest("list.get(i).marketPrice", model.list.get(i).marketPrice);
            detailAssertTest("list.get(i).pinActivitiesId", model.list.get(i).pinActivitiesId);
            detailAssertTest("list.get(i).url", model.list.get(i).url);
            detailAssertTest("list.get(i).skuId", model.list.get(i).skuId);
            detailAssertTest("list.get(i).coupleTitle", model.list.get(i).coupleTitle);
            detailAssertTest("list.get(i).skuPic", model.list.get(i).skuPic);
        }
        detailAssertTest("totalPage", model.totalPage);
        detailAssertTest("totalCnt", model.totalCnt);

    }

}
