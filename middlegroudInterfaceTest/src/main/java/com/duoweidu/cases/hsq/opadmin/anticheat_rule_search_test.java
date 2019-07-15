package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class anticheat_rule_search_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "反作弊管理搜索")
    public void anticheat_rule_search_true() {
        setUrl("anticheat.rule.search.uri");
        process(false,false);

    }
}
