package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.PointRecommenditemsData;
import com.duoweidu.utils.ConfigFileUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class point_recommenditems_test extends HsqInterfaceTest {

    private PointRecommenditemsData model;

    @Test(description = "积分商品推荐列表")
    public void point_recommenditems_true() {
        setUrl("point.recommenditems.uri");
        param = "item_selected_cnt=3&data_rule=1&point_sku_id=" + SqlDetail.getInstance().getParamValue("pSkuId");


        process(false, false);
        statusAssertTest();

        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray dataList = jsonObject.getJSONArray("data");
            if (dataList.length() > 0) {
                generalAssertTest(false, true);
                model = sparseJsonResult(PointRecommenditemsData.class);
                detailAssert();
            }
        } catch (JSONException e) {
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    private void detailAssert() {

        detailAssertTest("data", model.data);
        for (int i = 0; i < model.data.size(); i++) {
            detailAssertTest("data.get(i).id", model.data.get(i).id);
            detailAssertTest("data.get(i).thumbnail", model.data.get(i).thumbnail);
            detailAssertTest("data.get(i).point", model.data.get(i).point);
            detailAssertTest("data.get(i).price", model.data.get(i).price);
            detailAssertTest("data.get(i).name", model.data.get(i).name);
            detailAssertTest("data.get(i).merchant_type", model.data.get(i).merchant_type);
            detailAssertTest("data.get(i).enabled", String.valueOf(model.data.get(i).enabled));
        }
    }
}
