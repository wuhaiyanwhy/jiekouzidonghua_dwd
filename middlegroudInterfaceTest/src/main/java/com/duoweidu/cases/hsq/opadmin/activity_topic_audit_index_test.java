package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class activity_topic_audit_index_test extends HsqOpadminInterfaceTest {

        @Test(dependsOnGroups = "loginTrue",description = "审核SABC活动")
        public void activity_topic_audit_index_true() {

            setUrl("activity.topic.audit.index.uri");
            process(false,false);

        }
}
