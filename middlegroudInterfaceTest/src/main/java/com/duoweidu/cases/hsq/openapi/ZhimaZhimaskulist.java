package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ZhimaZhimaskulistData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class ZhimaZhimaskulist extends HsqInterfaceTest {

    private ZhimaZhimaskulistData model;

    @Test(description = "芝麻首页商品列表")
    public void zhimaZhimaskulist() {
        setUrl("zhima.zhimaskulist.uri");
        param = "pageNum=1&pageSize=20&appId=" + SqlDetail.getParamValue(0, "zhimaAppId");
        process(true, true);
        model = sparseJson(ZhimaZhimaskulistData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("type", model.type);
        detailAssertTest("titleText", model.titleText);
//        detailAssertTest("titleImg", model.titleImg);
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("totalPage", model.totalPage);
        detailAssertTest("currentPage", model.currentPage);
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).sku_id", model.list.get(i).sku_id);
            detailAssertTest("list.get(i).zm_sku_name", model.list.get(i).zm_sku_name);
            detailAssertTest("list.get(i).price", model.list.get(i).price);
            detailAssertTest("list.get(i).show_price", model.list.get(i).show_price);
            detailAssertTest("list.get(i).discount", model.list.get(i).discount);
            //beta品的数据有问题，暂时禁用
            if ("prod".equals(ConfigFileUrl.getEnv())) {
                detailAssertTest("list.get(i).thumbnail", model.list.get(i).thumbnail);
            }
            detailAssertTest("list.get(i).left_stock", String.valueOf(model.list.get(i).left_stock));
        }

    }


}
