package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ProductCoupleskudetailData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class product_coupleskudetail_test extends HsqInterfaceTest {

    private ProductCoupleskudetailData model;

    private void interfaces() {
        setUrl("product.coupleskudetail.uri");
        process(true,false);
        model = sparseJson(ProductCoupleskudetailData.class);
    }

    @Test(dependsOnGroups = "loginTrue", description = "二人购商品详情")
    public void product_coupleskudetail_true() throws IOException {
        param = "pinActivitiesId=" + SqlDetail.getInstance().getParamValue("pinActivitiesId");
        interfaces();
        generalDetailAssert();
    }

    @Test(dependsOnGroups = "loginTrue", description = "二人购商品详情（参加活动报名）")
    public void product_coupleskudetail_activitieTrue() throws IOException {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            param = "pinActivitiesId=" + SqlDetail.getInstance().getParamValue(2, "activitiePinActivitiesId");
            interfaces();
            activitieDetailAssert();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue", description = "二人购商品详情(多件优惠第二件减钱)")
    public void product_coupleskudetail_lose2() throws IOException {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            param = "pinActivitiesId=" + SqlDetail.getInstance().getParamValue("losePinActivitiesId2");
            interfaces();
            loseDetailAssert2();
        }else {
            System.out.println("此环境无此cases");
        }
    }

    @Test(dependsOnGroups = "loginTrue", description = "二人购商品详情(多件优惠二三四五付钱)")
    public void product_coupleskudetail_pay2345() throws IOException {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            param = "pinActivitiesId=" + SqlDetail.getInstance().getParamValue("payPinActivitiesId2345");
            interfaces();
            payDetailAssert2345();
        }else {
            System.out.println("此环境无此cases");
        }
    }


    private void generalDetailAssert() throws IOException {
        detailAssertTest(1, "source_type", model.source_type);
        detailAssertTest(1, "enabled", model.enabled);
        detailAssertTest(1, "actived", model.actived);
        detailAssertTest(0, "delete_flag", model.delete_flag);
        detailAssertTest(2, "audit_status", model.audit_status);
        detailAssertTest(0, "restriction_amount", model.restriction_amount);
        detailAssertTest(0, "only_new_user", model.only_new_user);
        detailAssertTest(2, "countLimit", model.countLimit);
        detailAssertTest(2592000,"offline_before_expired", model.offline_before_expired);
        detailAssertTest("", "description", model.description);
        detailAssertTest(true, "coupleIsOnline", model.coupleIsOnline);
        detailAssertTest(true, "canDelivery", model.canDelivery);
        detailAssertTest(4, "labels.size()", model.labels.size());
        detailAssertTest(1, "merchantInfo.enabled", model.merchantInfo.enabled);
        detailAssertTest(true,"singeCanBought", model.singeCanBought);
        detailAssertTest(true,"coupleCanBought", model.coupleCanBought);
        detailAssertTest(1, "merchant_type", model.merchant_type);


        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest("pin", "feature", model.feature);
            detailAssertTest(616, "merchant_id", model.merchant_id);
            detailAssertTest(25302, "product_id", model.product_id);
            detailAssertTest("接口测试专用商品，勿动动", "name", model.name);
            detailAssertTest(100,"weight", model.weight);
            detailAssertTest(1900,"price", model.price);
            detailAssertTest("thumbnail", model.thumbnail);
            detailAssertTest(5000,"market_price", model.market_price);
//            detailAssertTest(1900,"lowest_price", model.lowest_price);
            detailAssertTest(1523873005,"seller_time", model.seller_time);
            detailAssertTest("1833552000","expired_date", model.expired_date);
            detailAssertTest(1522512000,"manufactured_date", model.manufactured_date);
            detailAssertTest("","merchant_item_code", model.merchant_item_code);
            detailAssertTest(1523872988,"created_at", model.created_at);
            detailAssertTest(1550815808,"updated_at", model.updated_at);
            detailAssertTest(1523873005,"audit_time", model.audit_time);
            detailAssertTest(1523873005,"online_time", model.online_time);
//            detailAssertTest(1000,"lowest_web_price", model.lowest_web_price);

            for (int i = 0; i < model.attrs.size(); i++) {
                if (model.attrs.get(i).name.equals("保质期")) {
                    detailAssertTest("2018/04/01生产-2028/02/08到期" , "attrs.value", model.attrs.get(i).value);
                }else if (model.attrs.get(i).name.equals("规格")) {
                    detailAssertTest("200g", "attrs.value", model.attrs.get(i).value);
                }else {
                    detailAssertTest("保质期和规格验证失败", "attrs.value",  model.attrs.get(i).value);
                }
            }
            detailAssertTest(100,"couplePrice", model.couplePrice);
            detailAssertTest(1099,"singlePrice", model.singlePrice);
            detailAssertTest(1830960000,"coupleEndTime", model.coupleEndTime);
            detailAssertTest(1523873252,"startTime", model.startTime);
            for (int i = 0; i < model.attrKeys.size(); i++) {
                if (model.attrKeys.get(i).name.equals("保质期")) {
                    detailAssertTest("2018/04/01-2028/02/08" , "attrKeys.defaultAttr", model.attrKeys.get(i).defaultAttr);
                }else if (model.attrKeys.get(i).name.equals("规格")) {
                    detailAssertTest("200g", "attrKeys.defaultAttr", model.attrKeys.get(i).defaultAttr);
                }else {
                    detailAssertTest("保质期和规格验证失败", "attrKeys.defaultAttr",  model.attrKeys.get(i).defaultAttr);
                }
            }
            for (HashMap.Entry<String, ProductCoupleskudetailData.AttrDatasModel> entry : model.attrDatas.entrySet()) {
                detailAssertTest(28659, "attrDatas.id",  entry.getValue().id);
                detailAssertTest(1, "attrDatas.source_type", entry.getValue().source_type);
                detailAssertTest(616, "attrDatas.merchant_id", entry.getValue().merchant_id);
                detailAssertTest(25302, "attrDatas.product_id", entry.getValue().product_id);
                detailAssertTest("接口测试专用商品，勿动动", "attrDatas.name", entry.getValue().name);
                detailAssertTest(100, "attrDatas.weight", entry.getValue().weight);
                detailAssertTest(1900, "attrDatas.price", entry.getValue().price);
                detailAssertTest("attrDatas.thumbnail", entry.getValue().thumbnail);
                detailAssertTest(5000, "attrDatas.market_price", entry.getValue().market_price);
//                detailAssertTest(1900, "attrDatas.lowest_price", entry.getValue().lowest_price);
                detailAssertTest(1523873005, "attrDatas.seller_time", entry.getValue().seller_time);
                detailAssertTest("2028-02-08", "attrDatas.expired_date", entry.getValue().expired_date);
                detailAssertTest("2018-04-01", "attrDatas.manufactured_date", entry.getValue().manufactured_date);
                detailAssertTest(1, "attrDatas.enabled", entry.getValue().enabled);
                detailAssertTest("", "attrDatas.merchant_item_code", entry.getValue().merchant_item_code);
                detailAssertTest(1, "attrDatas.actived", entry.getValue().actived);
                detailAssertTest(0, "attrDatas.delete_flag", entry.getValue().delete_flag);
                detailAssertTest(1523872988, "attrDatas.created_at", entry.getValue().created_at);
                detailAssertTest(1550815808, "attrDatas.updated_at", entry.getValue().updated_at);
                detailAssertTest(2, "attrDatas.audit_status", entry.getValue().audit_status);
                detailAssertTest(1523873005, "attrDatas.audit_time", entry.getValue().audit_time);
                detailAssertTest(0, "attrDatas.restriction_amount", entry.getValue().restriction_amount);
                detailAssertTest(1, "attrDatas.fpostage_amount", entry.getValue().fpostage_amount);
                detailAssertTest(1523873005, "attrDatas.online_time", entry.getValue().online_time);
                detailAssertTest(0, "attrDatas.only_new_user", entry.getValue().only_new_user);
                detailAssertTest("pin", "attrDatas.feature", entry.getValue().feature);
//                detailAssertTest(1000, "attrDatas.lowest_web_price", entry.getValue().lowest_web_price);
                detailAssertTest(12122, "attrDatas.pinactivitiesid", entry.getValue().pinactivitiesid);

            }

            for (int i = 0; i < model.attrOptions.size(); i++) {
                if (model.attrOptions.get(i).name.equals("保质期")) {
                    for (int j = 0; j < model.attrOptions.get(i).list.size(); j++) {
                        detailAssertTest("2018/04/01-2028/02/08", "attrOptions.list.value", model.attrOptions.get(i).list.get(j).value);
                        detailAssertTest(28659, "attrOptions.list.skuId", model.attrOptions.get(i).list.get(j).skuId);
                    }
                }else if (model.attrOptions.get(i).name.equals("规格")) {
                    for (int j = 0; j < model.attrOptions.get(i).list.size(); j++) {
                        detailAssertTest("200g", "attrOptions.list.value", model.attrOptions.get(i).list.get(j).value);
                        detailAssertTest(28659, "attrOptions.list.skuId", model.attrOptions.get(i).list.get(j).skuId);
                    }
                }else {
                    detailAssertTest("保质期和规格验证失败", "attrOptions.name",  model.attrOptions.get(i).name);
                }
            }
            detailAssertTest("1833552000", "batch", model.batch);

            for (int i = 0; i < model.pics.size(); i++) {
                detailAssertTest("batch", model.pics.get(0));
                detailAssertTest("batch", model.pics.get(1));
            }

            detailAssertTest(28659, "skuId", model.skuId);
            detailAssertTest(25302, "productId", model.productId);
            detailAssertTest(616, "merchantId", model.merchantId);
            detailAssertTest(616, "merchantInfo.id", model.merchantInfo.id);
            detailAssertTest("蜜我食铺", "merchantInfo.name", model.merchantInfo.name);
            detailAssertTest("merchantInfo.logo", model.merchantInfo.logo);
            detailAssertTest("haoshiqi://hybrid?compid=haoshiqi&comppage=merchant&merchantid=616", "merchantInfo.schema", model.merchantInfo.schema);
            detailAssertTest("http://m.beta.haoshiqi.net/#couple_rules", "coupleRuleUrl", model.coupleRuleUrl);
            detailAssertTest("价格", "pricePrefix", model.pricePrefix);
            detailAssertTest("haoshiqi://com.doweidu/couplesbuydetail?pinActivityId=11836", "schema", model.schema);
            detailAssertTest("http://m.beta.haoshiqi.net//#couple_detail?pinactivitiesid=11836&sid=28659", "h5Link", model.h5Link);

            detailAssertTest("model.shareInfo.firendsZone.thumbnail", model.shareInfo.firendsZone.thumbnail);
            detailAssertTest("pages/index/index?jumplink=detail%3Fid%3D11836&minishare=1", "model.shareInfo.firendsZone.link", model.shareInfo.firendsZone.link);
            detailAssertTest("1.00元接口测试专用商品，勿动动", "model.shareInfo.firendsZone.content", model.shareInfo.firendsZone.content);
            detailAssertTest(true, "shareInfo.wechat.isMini", model.shareInfo.wechat.isMini);
            detailAssertTest("pages/index/index?jumplink=detail%3Fid%3D11836&minishare=1", "shareInfo.wechat.pagePath", model.shareInfo.wechat.pagePath);
            detailAssertTest("gh_9b3866e4e1ae", "shareInfo.wechat.userName", model.shareInfo.wechat.userName);
            detailAssertTest("我买了1.00元接口测试专用商品，勿动动", "shareInfo.wechat.title", model.shareInfo.wechat.title);
            detailAssertTest("model.shareInfo.wechat.thumbnail", model.shareInfo.wechat.thumbnail);
            detailAssertTest("pages/index/index?jumplink=detail%3Fid%3D11836&minishare=1", "model.shareInfo.wechat.link", model.shareInfo.wechat.link);
            detailAssertTest("2人团，成团必发货，好食期优选，正品保证", "model.shareInfo.wechat.content", model.shareInfo.wechat.content);
            detailAssertTest("我买了1.00元接口测试专用商品，勿动动", "shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
            detailAssertTest("model.shareInfo.mobileQQ.thumbnail", model.shareInfo.mobileQQ.thumbnail);
            detailAssertTest("pages/index/index?jumplink=detail%3Fid%3D11836&minishare=1", "model.shareInfo.mobileQQ.link", model.shareInfo.mobileQQ.link);
            detailAssertTest("2人团，成团必发货，好食期优选，正品保证", "model.shareInfo.mobileQQ.content", model.shareInfo.mobileQQ.content);
            detailAssertTest("我买了1.00元接口测试专用商品，勿动动", "shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
            detailAssertTest("model.shareInfo.alipay.thumbnail", model.shareInfo.alipay.thumbnail);
            detailAssertTest("pages/index/index?jumplink=detail%3Fid%3D11836&minishare=1", "model.shareInfo.alipay.link", model.shareInfo.alipay.link);
            detailAssertTest("2人团，成团必发货，好食期优选，正品保证", "model.shareInfo.alipay.content", model.shareInfo.alipay.content);

        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest("pin,gift", "feature", model.feature);
            detailAssertTest(1786, "merchant_id", model.merchant_id);
            detailAssertTest(70743, "product_id", model.product_id);
            detailAssertTest("压测专用（勿动） 200g", "name", model.name);
            detailAssertTest(0,"weight", model.weight);
            detailAssertTest(3,"price", model.price);
            detailAssertTest("thumbnail", model.thumbnail);
            detailAssertTest(3,"market_price", model.market_price);
//            detailAssertTest(3,"lowest_price", model.lowest_price);
            detailAssertTest(1557365804,"seller_time", model.seller_time);
            detailAssertTest("2127312000","expired_date", model.expired_date);
            detailAssertTest(778348800,"manufactured_date", model.manufactured_date);            detailAssertTest("","merchant_item_code", model.merchant_item_code);
            detailAssertTest("","merchant_item_code", model.merchant_item_code);
            detailAssertTest(1557365778,"created_at", model.created_at);
            detailAssertTest(1558086188,"updated_at", model.updated_at);
            detailAssertTest(1557365804,"audit_time", model.audit_time);
            detailAssertTest(1557365804,"online_time", model.online_time);
//            detailAssertTest(3,"lowest_web_price", model.lowest_web_price);
            for (int i = 0; i < model.attrs.size(); i++) {
                if (model.attrs.get(i).name.equals("保质期")) {
                    detailAssertTest("1994/09/01生产-2037/05/31到期" , "attrs.value", model.attrs.get(i).value);
                }else if (model.attrs.get(i).name.equals("规格")) {
                    detailAssertTest("200g", "attrs.value", model.attrs.get(i).value);
                }else {
                    detailAssertTest("保质期和规格验证失败", "attrs.value",  model.attrs.get(i).value);
                }
            }
            detailAssertTest(2,"couplePrice", model.couplePrice);
            detailAssertTest(3,"singlePrice", model.singlePrice);
            detailAssertTest(2127312000,"coupleEndTime", model.coupleEndTime);
            detailAssertTest(1557365804,"startTime", model.startTime);
            for (int i = 0; i < model.attrKeys.size(); i++) {
                if (model.attrKeys.get(i).name.equals("保质期")) {
                    detailAssertTest("1994/09/01-2037/05/31" , "attrKeys.defaultAttr", model.attrKeys.get(i).defaultAttr);
                }else if (model.attrKeys.get(i).name.equals("规格")) {
                    detailAssertTest("200g", "attrKeys.defaultAttr", model.attrKeys.get(i).defaultAttr);
                }else {
                    detailAssertTest("保质期和规格验证失败", "attrKeys.defaultAttr",  model.attrKeys.get(i).defaultAttr);
                }
            }
            for (HashMap.Entry<String, ProductCoupleskudetailData.AttrDatasModel> entry : model.attrDatas.entrySet()) {
                detailAssertTest(85486, "attrDatas.id",  entry.getValue().id);
                detailAssertTest(1, "attrDatas.source_type", entry.getValue().source_type);
                detailAssertTest(1786, "attrDatas.merchant_id", entry.getValue().merchant_id);
                detailAssertTest(70743, "attrDatas.product_id", entry.getValue().product_id);
                detailAssertTest("压测专用（勿动） 200g", "attrDatas.name", entry.getValue().name);
                detailAssertTest(0, "attrDatas.weight", entry.getValue().weight);
                detailAssertTest(3, "attrDatas.price", entry.getValue().price);
                detailAssertTest("attrDatas.thumbnail", entry.getValue().thumbnail);
                detailAssertTest(3, "attrDatas.market_price", entry.getValue().market_price);
//                detailAssertTest(3, "attrDatas.lowest_price", entry.getValue().lowest_price);
                detailAssertTest(1557365804, "attrDatas.seller_time", entry.getValue().seller_time);
                detailAssertTest("2037-05-31", "attrDatas.expired_date", entry.getValue().expired_date);
                detailAssertTest("1994-09-01", "attrDatas.manufactured_date", entry.getValue().manufactured_date);
                detailAssertTest(1, "attrDatas.enabled", entry.getValue().enabled);
                detailAssertTest("", "attrDatas.merchant_item_code", entry.getValue().merchant_item_code);
                detailAssertTest(1, "attrDatas.actived", entry.getValue().actived);
                detailAssertTest(0, "attrDatas.delete_flag", entry.getValue().delete_flag);
                detailAssertTest(1557365778, "attrDatas.created_at", entry.getValue().created_at);
                detailAssertTest(1558086188, "attrDatas.updated_at", entry.getValue().updated_at);
                detailAssertTest(2, "attrDatas.audit_status", entry.getValue().audit_status);
                detailAssertTest(1557365804, "attrDatas.audit_time", entry.getValue().audit_time);
                detailAssertTest(0, "attrDatas.restriction_amount", entry.getValue().restriction_amount);
                detailAssertTest(0, "attrDatas.fpostage_amount", entry.getValue().fpostage_amount);
                detailAssertTest(1557365804, "attrDatas.online_time", entry.getValue().online_time);
                detailAssertTest(0, "attrDatas.only_new_user", entry.getValue().only_new_user);
                detailAssertTest("pin,gift", "attrDatas.feature", entry.getValue().feature);
//                detailAssertTest(3, "attrDatas.lowest_web_price", entry.getValue().lowest_web_price);
                detailAssertTest(60658, "attrDatas.pinactivitiesid", entry.getValue().pinactivitiesid);

            }

            for (int i = 0; i < model.attrOptions.size(); i++) {
                if (model.attrOptions.get(i).name.equals("保质期")) {
                    for (int j = 0; j < model.attrOptions.get(i).list.size(); j++) {
                        detailAssertTest("1994/09/01-2037/05/31", "attrOptions.list.value", model.attrOptions.get(i).list.get(j).value);
                        detailAssertTest(85486, "attrOptions.list.skuId", model.attrOptions.get(i).list.get(j).skuId);
                    }
                }else if (model.attrOptions.get(i).name.equals("规格")) {
                    for (int j = 0; j < model.attrOptions.get(i).list.size(); j++) {
                        detailAssertTest("200g", "attrOptions.list.value", model.attrOptions.get(i).list.get(j).value);
                        detailAssertTest(85486, "attrOptions.list.skuId", model.attrOptions.get(i).list.get(j).skuId);
                    }
                }else {
                    detailAssertTest("保质期和规格验证失败", "attrOptions.name",  model.attrOptions.get(i).name);
                }
            }
            detailAssertTest("2127312000", "batch", model.batch);
            for (int i = 0; i < model.pics.size(); i++) {
                detailAssertTest("batch", model.pics.get(0));
                detailAssertTest("batch", model.pics.get(1));
            }

            detailAssertTest(85486, "skuId", model.skuId);
            detailAssertTest(70743, "productId", model.productId);
            detailAssertTest(1786, "merchantId", model.merchantId);
            detailAssertTest(1786, "merchantInfo.id", model.merchantInfo.id);
            detailAssertTest("淘食铺", "merchantInfo.name", model.merchantInfo.name);
            detailAssertTest("merchantInfo.logo", model.merchantInfo.logo);
            detailAssertTest("haoshiqi://hybrid?compid=haoshiqi&comppage=merchant&merchantid=1786", "merchantInfo.schema", model.merchantInfo.schema);

            detailAssertTest("model.shareInfo.firendsZone.thumbnail", model.shareInfo.firendsZone.thumbnail);
            detailAssertTest("pages/index/index?jumplink=detail%3Fid%3D60627&minishare=1", "model.shareInfo.firendsZone.link", model.shareInfo.firendsZone.link);
            detailAssertTest("0.02元压测专用（勿动） 200g", "model.shareInfo.firendsZone.content", model.shareInfo.firendsZone.content);
            detailAssertTest(true, "shareInfo.wechat.isMini", model.shareInfo.wechat.isMini);
            detailAssertTest("pages/index/index?jumplink=detail%3Fid%3D60627&minishare=1", "shareInfo.wechat.pagePath", model.shareInfo.wechat.pagePath);
            detailAssertTest("gh_9b3866e4e1ae", "shareInfo.wechat.userName", model.shareInfo.wechat.userName);
            detailAssertTest("我买了0.02元压测专用（勿动） 200g", "shareInfo.wechat.title", model.shareInfo.wechat.title);
            detailAssertTest("model.shareInfo.wechat.thumbnail", model.shareInfo.wechat.thumbnail);
            detailAssertTest("pages/index/index?jumplink=detail%3Fid%3D60627&minishare=1", "model.shareInfo.wechat.link", model.shareInfo.wechat.link);
            detailAssertTest("2人团，成团必发货，好食期优选，正品保证", "model.shareInfo.wechat.content", model.shareInfo.wechat.content);
            detailAssertTest("我买了0.02元压测专用（勿动） 200g", "shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
            detailAssertTest("model.shareInfo.mobileQQ.thumbnail", model.shareInfo.mobileQQ.thumbnail);
            detailAssertTest("pages/index/index?jumplink=detail%3Fid%3D60627&minishare=1", "model.shareInfo.mobileQQ.link", model.shareInfo.mobileQQ.link);
            detailAssertTest("2人团，成团必发货，好食期优选，正品保证", "model.shareInfo.mobileQQ.content", model.shareInfo.mobileQQ.content);
            detailAssertTest("我买了0.02元压测专用（勿动） 200g", "shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
            detailAssertTest("model.shareInfo.alipay.thumbnail", model.shareInfo.alipay.thumbnail);
            detailAssertTest("pages/index/index?jumplink=detail%3Fid%3D60627&minishare=1", "model.shareInfo.alipay.link", model.shareInfo.alipay.link);
            detailAssertTest("2人团，成团必发货，好食期优选，正品保证", "model.shareInfo.alipay.content", model.shareInfo.alipay.content);


        }
    }

    //营销活动
    private void activitieDetailAssert() throws IOException {
        detailAssertTest(8888, "price", model.price);
        detailAssertTest(9999, "market_price", model.market_price);
//        detailAssertTest(8888, "lowest_price", model.lowest_price);
//        detailAssertTest(9999, "lowest_web_price", model.lowest_web_price);
        detailAssertTest(1, "couplePrice", model.couplePrice);
        detailAssertTest(8888, "singlePrice", model.singlePrice);
        detailAssertTest(296, "activityPreheat.activityId", model.activityPreheat.activityId);
        detailAssertTest(219, "activityPreheat.activityTopicId", model.activityPreheat.activityTopicId);
        detailAssertTest(1, "activityPreheat.activityPrice", model.activityPreheat.activityPrice);
        detailAssertTest(9999, "activityPreheat.marketPrice", model.activityPreheat.marketPrice);
        if (model.activityPreheat.activityStock <= 0) {
            GeneralAssert.detailedAssert("返回的活动库存不正确", url, pathId, param, result);
        }
        detailAssertTest(1556680053, "activityPreheat.startTime", model.activityPreheat.startTime);
        detailAssertTest(2147483647, "activityPreheat.endTime", model.activityPreheat.endTime);
        detailAssertTest("【活动报名的前缀】接口自动化测试专用营销活动（勿动） 100g", "name", model.name);

        for (HashMap.Entry<String, ProductCoupleskudetailData.AttrDatasModel> entry : model.attrDatas.entrySet()) {
            detailAssertTest(8888, "attrDatas.price", entry.getValue().price);
            detailAssertTest(9999, "attrDatas.market_price", entry.getValue().market_price);
//            detailAssertTest(8888, "attrDatas.lowest_price", entry.getValue().lowest_price);
//            detailAssertTest(9999, "attrDatas.lowest_web_price", entry.getValue().lowest_web_price);
            detailAssertTest("接口自动化测试专用营销活动（勿动） 100g", "attrDatas.name", entry.getValue().name);

        }
    }

    //多件优惠第二件减钱
    private void loseDetailAssert2() throws IOException {
        detailAssertTest("第2件减11.1元", "model.shopDiscount.get(0)", model.shopDiscount.get(0));
        //判断多规格
        detailAssertTest(15, "attrKeys.get(1).list.size()", model.attrKeys.get(1).list.size());
    }

    //多件优惠二三四五付钱
    private void payDetailAssert2345() throws IOException {
        detailAssertTest("第2件11.54元", "model.shopDiscount.get(0)", model.shopDiscount.get(0));
        detailAssertTest("第3件8元", "model.shopDiscount.get(1)", model.shopDiscount.get(1));
        detailAssertTest("第4件0.01元", "model.shopDiscount.get(2)", model.shopDiscount.get(2));
        detailAssertTest("第5件5元", "model.shopDiscount.get(3)", model.shopDiscount.get(3));
    }


}
