package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.PointTopicbuskulistData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class point_topicbuskulist_test extends HsqInterfaceTest {

    private PointTopicbuskulistData model;

    @Test(description = "获取积分专题sku信息列表(老专题)")
    public void point_topicbuskulist_true() {
        setUrl("point.topicbuskulist.uri");

        param = "pointChannelId=1&topicCode=" + SqlDetail.getInstance().getParamValue("point_topicCode");
        process(true, true);
        model = sparseJson(PointTopicbuskulistData.class);
        detailAssert();
    }

    private void detailAssert() {

        if (model.list.size() > 0) {

            detailAssertTest("list", model.list);
            for (int i = 0; i < model.list.size(); i++) {
                detailAssertTest("list.get(i).id", model.list.get(i).id);
                detailAssertTest("list.get(i).bu_sku_id", model.list.get(i).bu_sku_id);
                detailAssertTest("list.get(i).skuId", model.list.get(i).skuId);
                detailAssertTest("list.get(i).productId", model.list.get(i).productId);
                detailAssertTest("list.get(i).merchantId", model.list.get(i).merchantId);
                detailAssertTest("list.get(i).price", String.valueOf(model.list.get(i).price));
                detailAssertTest("list.get(i).marketPrice", model.list.get(i).marketPrice);
                detailAssertTest("list.get(i).point", model.list.get(i).point);
                detailAssertTest("list.get(i).pointMetaId", model.list.get(i).pointMetaId);
                detailAssertTest("list.get(i).channelId", model.list.get(i).channelId);
                detailAssertTest("list.get(i).startTime", model.list.get(i).startTime);
                detailAssertTest("list.get(i).endTime", model.list.get(i).endTime);
                detailAssertTest("list.get(i).auditStatus", model.list.get(i).auditStatus);
                detailAssertTest("list.get(i).auditTime", model.list.get(i).auditTime);
                detailAssertTest("list.get(i).enabled", model.list.get(i).enabled);
                detailAssertTest("list.get(i).isDelete", String.valueOf(model.list.get(i).isDelete));
                detailAssertTest("list.get(i).createdAt", model.list.get(i).createdAt);
                detailAssertTest("list.get(i).updatedAt", model.list.get(i).updatedAt);
                detailAssertTest("list.get(i).type", model.list.get(i).type);
                detailAssertTest("list.get(i).pointRules", model.list.get(i).pointRules);
                detailAssertTest("list.get(i).listDisplay", String.valueOf(model.list.get(i).listDisplay));
                detailAssertTest("list.get(i).subchannel", model.list.get(i).subchannel);
                detailAssertTest("list.get(i).name", model.list.get(i).name);
                detailAssertTest("list.get(i).thumbnail", model.list.get(i).thumbnail);
                detailAssertTest("list.get(i).topic_id", model.list.get(i).topic_id);
//                detailAssertTest("list.get(i).priority", model.list.get(i).priority);
//                detailAssertTest("list.get(i).label", model.list.get(i).label);
//                detailAssertTest("list.get(i).tags", model.list.get(i).tags);
//                detailAssertTest("list.get(i).tags.get(0).text", model.list.get(i).tags.get(0).text);
//                detailAssertTest("list.get(i).tags.get(0).background", model.list.get(i).tags.get(0).background);
                detailAssertTest("list.get(i).pSkuId", model.list.get(i).pSkuId);
//                detailAssertTest("list.get(i).requestId", model.list.get(i).requestId);
                detailAssertTest("list.get(i).merchant_type", model.list.get(i).merchant_type);
            }
        }
    }
}
