package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.AddressSearchData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class AddressSearch extends JszInterfaceTest {

    private AddressSearchData model;

    @Test(description = "地址搜索")
    public void addressSearch() {
        setUrl("address.search.uri");
        param = "keyword=" + SqlDetail.getInstance().getParamValue(0, "keyword") +
                "&city=" + SqlDetail.getInstance().getParamValue(0, "city");
        process(true, false);
        model = sparseJson(AddressSearchData.class);
//        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssert();
        }
//    }

    private void detailAssert() {
        detailAssertTest("status", model.status);
        detailAssertTest("count", model.count);
        detailAssertTest("info", model.info);
        detailAssertTest("infocode", model.infocode);

        for (int i = 0; i < model.pois.size(); i++) {
            detailAssertTest("id", model.pois.get(i).id);
            detailAssertTest("name", model.pois.get(i).name);
            detailAssertTest("type", model.pois.get(i).type);
            detailAssertTest("typecode", model.pois.get(i).typecode);
            detailAssertTest("address", model.pois.get(i).address);
            detailAssertTest("location", model.pois.get(i).location);
            detailAssertTest("cityname", model.pois.get(i).cityname);
            detailAssertTest("adname", model.pois.get(i).adname);
            detailAssertTest("shopinfo", model.pois.get(i).shopinfo);
            detailAssertTest("pname", model.pois.get(i).pname);
//            detailAssertTest("photos",model.pois.get(i).photos);

            if (model.pois.get(i).photos.size() > 0) {
                for (int j = 0; j < model.pois.get(i).photos.size(); j++) {
                    detailAssertTest("url", model.pois.get(i).photos.get(j).url);
                }
            }
        }
    }
}



