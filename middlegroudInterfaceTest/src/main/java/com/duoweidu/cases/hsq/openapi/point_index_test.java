package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.PointIndexData;
import org.testng.annotations.Test;

public class point_index_test extends HsqInterfaceTest {

    private PointIndexData model;

    @Test(description = "积分首页")
    public void point_index_true() {
        setUrl("point.index.uri");
        param = "channel=h5&pointChannelId=1";
        process(true, false);
        model = sparseJson(PointIndexData.class);
        detailAssert();
    }

    private void detailAssert() {

        detailAssertTest("bannerList", model.bannerList);
        if (model.bannerList.size() > 0) {
            for (int i = 0; i < model.bannerList.size(); i++) {
                detailAssertTest("bannerList.get(i).id", model.bannerList.get(i).id);
                detailAssertTest("bannerList.get(i).image", model.bannerList.get(i).image);
                detailAssertTest("bannerList.get(i).type", model.bannerList.get(i).type);
                detailAssertTest("bannerList.get(i).url", model.bannerList.get(i).url);
                detailAssertTest("bannerList.get(i).location", model.bannerList.get(i).location);
                detailAssertTest("bannerList.get(i).starttime", model.bannerList.get(i).starttime);
                detailAssertTest("bannerList.get(i).endtime", model.bannerList.get(i).endtime);
                detailAssertTest("bannerList.get(i).enabled", model.bannerList.get(i).enabled);
                detailAssertTest("bannerList.get(i).priority", model.bannerList.get(i).priority);
                detailAssertTest("bannerList.get(i).source_type", model.bannerList.get(i).source_type);
                detailAssertTest("bannerList.get(i).sub_data", model.bannerList.get(i).sub_data);
            }
        }
        detailAssertTest("skuList.list", model.skuList.list);
        if (model.skuList.list.size() > 0) {
            for (int i = 0; i < model.skuList.list.size(); i++) {
                detailAssertTest("skuList.list.get(i).id", model.skuList.list.get(i).id);
                detailAssertTest("skuList.list.get(i).skuId", model.skuList.list.get(i).skuId);
                detailAssertTest("skuList.list.get(i).productId", model.skuList.list.get(i).productId);
                detailAssertTest("skuList.list.get(i).merchantId", model.skuList.list.get(i).merchantId);
                detailAssertTest("skuList.list.get(i).name", model.skuList.list.get(i).name);
                detailAssertTest("skuList.list.get(i).price", model.skuList.list.get(i).price);
                detailAssertTest("skuList.list.get(i).marketPrice", model.skuList.list.get(i).marketPrice);
                detailAssertTest("skuList.list.get(i).thumbnail", model.skuList.list.get(i).thumbnail);
                detailAssertTest("skuList.list.get(i).point", model.skuList.list.get(i).point);
                detailAssertTest("skuList.list.get(i).pointMetaId", model.skuList.list.get(i).pointMetaId);
                detailAssertTest("skuList.list.get(i).channelId", model.skuList.list.get(i).channelId);
                detailAssertTest("skuList.list.get(i).startTime", model.skuList.list.get(i).startTime);
                detailAssertTest("skuList.list.get(i).endTime", model.skuList.list.get(i).endTime);
                detailAssertTest("skuList.list.get(i).auditStatus", model.skuList.list.get(i).auditStatus);
                detailAssertTest("skuList.list.get(i).auditTime", model.skuList.list.get(i).auditTime);
                detailAssertTest("skuList.list.get(i).enabled", model.skuList.list.get(i).enabled);
                detailAssertTest("skuList.list.get(i).createdAt", model.skuList.list.get(i).createdAt);
                detailAssertTest("skuList.list.get(i).updatedAt", model.skuList.list.get(i).updatedAt);
                detailAssertTest("skuList.list.get(i).type", model.skuList.list.get(i).type);
                detailAssertTest("skuList.list.get(i).pointRules", model.skuList.list.get(i).pointRules);
                detailAssertTest("skuList.list.get(i).listDisplay", model.skuList.list.get(i).listDisplay);
                detailAssertTest("skuList.list.get(i).subchannel", model.skuList.list.get(i).subchannel);
//                detailAssertTest("skuList.list.get(i).feature", model.skuList.list.get(i).feature);
                detailAssertTest("skuList.list.get(i).pSkuId", model.skuList.list.get(i).pSkuId);
            }
        }
        detailAssertTest("skuList.totalCnt", model.skuList.totalCnt);
        detailAssertTest("skuList.totalPage", model.skuList.totalPage);
        detailAssertTest("subButtonList", model.subButtonList);
        if (model.subButtonList.size() > 0) {
            for (int i = 0; i < model.subButtonList.size(); i++) {
                detailAssertTest("subButtonList.get(i).id", model.subButtonList.get(i).id);
                detailAssertTest("subButtonList.get(i).type", model.subButtonList.get(i).type);
                detailAssertTest("subButtonList.get(i).icon", model.subButtonList.get(i).icon);
                detailAssertTest("subButtonList.get(i).label", model.subButtonList.get(i).label);
                detailAssertTest("subButtonList.get(i).jump_type", model.subButtonList.get(i).jump_type);
                detailAssertTest("subButtonList.get(i).jump_url", model.subButtonList.get(i).jump_url);
                detailAssertTest("subButtonList.get(i).client_type", model.subButtonList.get(i).client_type);
//                detailAssertTest("subButtonList.get(i).priority", model.subButtonList.get(i).priority);
                detailAssertTest("subButtonList.get(i).enabled", model.subButtonList.get(i).enabled);
                detailAssertTest("subButtonList.get(i).expired_time", model.subButtonList.get(i).expired_time);
                detailAssertTest("subButtonList.get(i).version", model.subButtonList.get(i).version);
                detailAssertTest("subButtonList.get(i).sub_data", model.subButtonList.get(i).sub_data.w);
                detailAssertTest("subButtonList.get(i).id", model.subButtonList.get(i).sub_data.h);
            }
        }
        detailAssertTest("labels", model.labels);
        for (int i = 0; i < model.labels.size(); i++) {
            detailAssertTest("labels.get(i).icon", model.labels.get(i).icon);
            detailAssertTest("labels.get(i).text", model.labels.get(i).text);
        }
    }

}
