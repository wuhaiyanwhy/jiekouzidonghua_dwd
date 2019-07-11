package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.model.hsq.PointSkulistData;
import org.testng.annotations.Test;


public class point_skulist_test extends HsqInterfaceTest {

    private PointSkulistData model;

    @Test(description = "积分商品列表")
    public void point_skulist_true() {
        setUrl("point.skulist.uri");
        param = "terminal=aliapp&pageNum=1&pageLimit=10&needPagination=1&pointChannelId=1&noHideLoading=true&appId=" +
                SqlDetail.getParamValue(0, "pointAppId");
        process(true,true);
        model = sparseJson(PointSkulistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).skuId", model.list.get(i).skuId);
            detailAssertTest("list.get(i).productId", model.list.get(i).productId);
            detailAssertTest("list.get(i).merchantId", model.list.get(i).merchantId);
            detailAssertTest("list.get(i).name", model.list.get(i).name);
            detailAssertTest("list.get(i).price", model.list.get(i).price);
            detailAssertTest("list.get(i).marketPrice", model.list.get(i).marketPrice);
            detailAssertTest("list.get(i).thumbnail", model.list.get(i).thumbnail);
            detailAssertTest("list.get(i).point", model.list.get(i).point);
            detailAssertTest("list.get(i).pointMetaId", model.list.get(i).pointMetaId);
            detailAssertTest("list.get(i).channelId", model.list.get(i).channelId);
            detailAssertTest("list.get(i).startTime", model.list.get(i).startTime);
            detailAssertTest("list.get(i).endTime", model.list.get(i).endTime);
            detailAssertTest("list.get(i).auditStatus", model.list.get(i).auditStatus);
            detailAssertTest("list.get(i).auditTime", model.list.get(i).auditTime);
            detailAssertTest("list.get(i).enabled", model.list.get(i).enabled);
            detailAssertTest("list.get(i).isDelete", String.valueOf(model.list.get(i).isDelete));
            detailAssertTest("list.get(i).priority",String.valueOf(model.list.get(i).priority));
            detailAssertTest("list.get(i).createdAt", model.list.get(i).createdAt);
            detailAssertTest("list.get(i).updatedAt", model.list.get(i).updatedAt);
            detailAssertTest("list.get(i).type", model.list.get(i).type);
            detailAssertTest("list.get(i).pointRules", model.list.get(i).pointRules);
            detailAssertTest("list.get(i).listDisplay", model.list.get(i).listDisplay);
            detailAssertTest("list.get(i).subchannel", model.list.get(i).subchannel);
//            detailAssertTest("list.get(i).feature", model.list.get(i).feature);
            detailAssertTest("list.get(i).pSkuId", model.list.get(i).pSkuId);
            detailAssertTest("list.get(i).merchant_type", model.list.get(i).merchant_type);
        }
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("totalPage", model.totalPage);

    }


}
