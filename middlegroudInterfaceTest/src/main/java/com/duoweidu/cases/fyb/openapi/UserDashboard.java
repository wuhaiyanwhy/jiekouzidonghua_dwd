package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.UserDashboardData;
import org.testng.annotations.Test;

public class UserDashboard extends FybInterfaceTest {

    private UserDashboardData model;

    @Test(description = "用户中心")
    public void userDashboard() {
        setUrl("user.dashboard.uri");
        process(true,false);
        model = sparseJson(UserDashboardData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("userInfo.id", model.userInfo.id);
        assertNotEmpty("userInfo.username", model.userInfo.username);
        assertNotEmpty("userInfo.avatar", model.userInfo.avatar);
        assertNotNull("userInfo.mobile", model.userInfo.mobile);
        assertNotNull("userInfo.email", model.userInfo.email);
        assertNotEmpty("userInfo.birthday", model.userInfo.birthday);
        assertEquals("userInfo.sex", model.userInfo.sex, 1);
        assertEquals("userInfo.enabled", model.userInfo.enabled, 1);
        assertNotEmpty("userInfo.created_at", model.userInfo.created_at);
        assertNotEmpty("userInfo.updated_at", model.userInfo.updated_at);
        assertNotNull("userInfo.is_new_user", model.userInfo.is_new_user);
        assertNotEmpty("userInfo.total_voucher_money", model.userInfo.total_voucher_money);
        assertNotNull("userInfo.total_redpacket_money", model.userInfo.total_redpacket_money);
        assertNotNull("totalAmount", model.totalAmount);
        assertNotNull("inActiveAmount", model.inActiveAmount);
        assertNotNull("activeAmount", model.activeAmount);
        assertNotNull("isShowInvitedUserList", model.isShowInvitedUserList);
        assertNotNull("toPayNum", model.toPayNum);
        assertNotNull("toReceiptNum", model.toReceiptNum);
        assertNotNull("toCommentNum", model.toCommentNum);
        assertNotEmpty("recommend.list", model.recommend.list);
        assertNotEmpty("recommend.totalCnt", model.recommend.totalCnt);
        assertNotEmpty("recommend.totalPage", model.recommend.totalPage);

        for (int i = 0; i < model.recommend.list.size(); i++) {
            assertNotEmpty("recommend.list.get(i).id", model.recommend.list.get(i).id);
            assertNotEmpty("recommend.list.get(i).name", model.recommend.list.get(i).name);
            assertNotEmpty("recommend.list.get(i).main_sku", model.recommend.list.get(i).main_sku);
            assertNotEmpty("recommend.list.get(i).main_sku_pic", model.recommend.list.get(i).main_sku_pic);
            assertNotNull("recommend.list.get(i).left_stock", model.recommend.list.get(i).left_stock);
            assertNotNull("recommend.list.get(i).locked_stock", model.recommend.list.get(i).locked_stock);
            assertNotEmpty("recommend.list.get(i).thumbnail", model.recommend.list.get(i).thumbnail);
            assertNotEmpty("recommend.list.get(i).market_price", model.recommend.list.get(i).market_price);
            assertNotEmpty("recommend.list.get(i).price", model.recommend.list.get(i).price);
            assertNotEmpty("recommend.list.get(i).reversion", model.recommend.list.get(i).reversion);
            assertNotEmpty("recommend.list.get(i).deduction", model.recommend.list.get(i).deduction);
            assertNotEmpty("recommend.list.get(i).selled_cnt", model.recommend.list.get(i).selled_cnt);
        }


    }
}
