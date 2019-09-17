package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.CommonVerifyupgradeData;
import org.testng.annotations.Test;

public class common_verifyupgrade_test extends HsqInterfaceTest {

    private CommonVerifyupgradeData model;

    @Test(description = "app检查更新")
    public void common_verifyupgrade_true() {
        setUrl("common.verifyupgrade.uri");
        param  = "terminal=android";
        process(true,false);
        model = sparseJson(CommonVerifyupgradeData.class);
        detailAssert();
    }

    private void detailAssert() {
        if (!model.needUpgrade) {
            assertFalse("forcedUpgrade", model.forcedUpgrade);
        }else {
            assertNotEmpty("needUpgrade", model.needUpgrade);
            assertNotEmpty("forcedUpgrade", model.forcedUpgrade);
            assertNotEmpty("android_latest_release", model.android_latest_release);
            assertNotEmpty("android_download_url", model.android_download_url);
            assertNotEmpty("android_release_note", model.android_release_note);
            assertNotEmpty("android_package_size", model.android_package_size);
        }
    }
}
