package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.CommonIndexZhimaData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class CommonIndexZhima extends HsqInterfaceTest {

    //此接口响应时间过长不受我们控制
    @Override
    protected long limitTime() {
        return 3000;
    }

    private CommonIndexZhimaData model;

    @Test(description = "芝麻信用购首页")
    public void commonIndexZhima() {
        setUrl("common.index_zhima.uri");
        process(true,true);
        model = sparseJson(CommonIndexZhimaData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("margin_top", String.valueOf(model.list.get(i).margin_top));
            detailAssertTest("margin_bottom", String.valueOf(model.list.get(i).margin_bottom));
            detailAssertTest("width", String.valueOf(model.list.get(i).width));
            detailAssertTest("height", String.valueOf(model.list.get(i).height));
            detailAssertTest("type", model.list.get(i).type);
            detailAssertTest("comment", model.list.get(i).comment);

            if (model.list.get(i).type.equals("banner") && model.list.get(i).comment.equals("顶部导航")) {
                detailAssertTest("list.get(i).list.get(0).image.url", model.list.get(i).list.get(0).image.url);
                detailAssertTest("list.get(i).list.get(0).image.w", model.list.get(i).list.get(0).image.w);
                detailAssertTest("list.get(i).list.get(0).image.h", model.list.get(i).list.get(0).image.h);
                detailAssertTest("list.get(i).list.get(0).link", model.list.get(i).list.get(0).link);
                detailAssertTest("list.get(i).list.get(0).id", model.list.get(i).list.get(0).id);
            }

            if (model.list.get(i).type.equals("zhima_not_start") && model.list.get(i).comment.equals("芝麻信用未签约卡片")) {
                for (int j = 0; j < model.list.get(i).list.size(); j++) {
                    detailAssertTest("list.get(i).list.get(j).act_name", model.list.get(i).list.get(j).act_name);
                    detailAssertTest("list.get(i).list.get(j).consumed_rules", model.list.get(i).list.get(j).consumed_rules);
                    detailAssertTest("list.get(i).list.get(j).discount", model.list.get(i).list.get(j).discount);
                    detailAssertTest("list.get(i).list.get(j).activity_no", model.list.get(i).list.get(j).activity_no);
                }
            }

            if (model.list.get(i).type.equals("title_bar") && model.list.get(i).comment.equals("标题栏广告")) {
                detailAssertTest("list.get(i).list.get(0).text", model.list.get(i).list.get(0).text.toString());
                detailAssertTest("list.get(i).list.get(0).text.title", model.list.get(i).list.get(0).text.title);
                detailAssertTest("list.get(i).list.get(0).text.describe", model.list.get(i).list.get(0).text.describe);

            }

            if (model.list.get(i).type.equals("rec_sku_activites") && model.list.get(i).comment.equals("大牌超值购")) {
                for (int j = 0; j < model.list.get(i).list.size() - 1; j++) {
                    detailAssertTest("list.get(i).list.get(j).id", model.list.get(i).list.get(0).id);
                    detailAssertTest("list.get(i).list.get(j).sku_pic", model.list.get(i).list.get(0).sku_pic);
                    detailAssertTest("list.get(i).list.get(j).sort", String.valueOf(model.list.get(i).list.get(0).sort));
                    detailAssertTest("list.get(i).list.get(j).couple_title", model.list.get(i).list.get(0).couple_title);
                    detailAssertTest("list.get(i).list.get(j).zhima_id", model.list.get(i).list.get(j+1).zhima_id);
                    detailAssertTest("list.get(i).list.get(j).sku_id", model.list.get(i).list.get(j+1).sku_id);
                    detailAssertTest("list.get(i).list.get(j).price", model.list.get(i).list.get(j+1).price);
                    detailAssertTest("list.get(i).list.get(j).show_price", model.list.get(i).list.get(j+1).show_price);
                    detailAssertTest("list.get(i).list.get(j).discount", String.valueOf(model.list.get(i).list.get(j+1).discount));
                    detailAssertTest("list.get(i).list.get(j).end_time", model.list.get(i).list.get(j+1).end_time);
                    detailAssertTest("list.get(i).list.get(j).start_time", model.list.get(i).list.get(j+1).start_time);
                    detailAssertTest("list.get(i).list.get(j).can_bought", model.list.get(i).list.get(j+1).can_bought);
                    detailAssertTest("list.get(i).list.get(j).expired_date", model.list.get(i).list.get(j+1).expired_date);

                }

            }

        }

    }
}
