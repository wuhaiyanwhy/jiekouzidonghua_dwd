package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class BranchComments extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取某个门店的评论列表")
    public void branchCommentsTrue() {
        setUrl("today_bargin.use_avatar.uri");
        process(false,false);
    }
}
