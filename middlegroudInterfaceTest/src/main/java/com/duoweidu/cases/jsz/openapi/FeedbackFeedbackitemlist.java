package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.FeedbackFeedbackitemlistData;
import org.testng.annotations.Test;


public class FeedbackFeedbackitemlist extends JszInterfaceTest {

    private FeedbackFeedbackitemlistData model;

    public void feedbackitemlist(String type) {
        setUrl("feedback.feedbackitemlist.uri");
        param = "type=" + type;
        process(true, false);
        model = sparseJson(FeedbackFeedbackitemlistData.class);
        detailAssert();

    }

    @Test(description = "1纠错")
    public void feedbackFeedbackitemlist1() {
        feedbackitemlist(SqlDetail.getInstance().getParamValue(0,"type1"));
    }

    @Test(description = "2退款")
    public void feedbackFeedbackitemlist2() {
        feedbackitemlist(SqlDetail.getInstance().getParamValue(0,"type2"));

    }

    private void detailAssert(){
        for( int i = 0 ; i<model.list.size(); i++) {
            detailAssertTest("list.id", model.list.get(i).id);
            detailAssertTest("type",model.list.get(i).type);
            detailAssertTest("order_type",model.list.get(i).content);
            detailAssertTest("weight",model.list.get(i).weight);
//            detailAssertTest("required",model.list.get(i).required);
//            detailAssertTest("count_refund_rate",model.list.get(i).count_refund_rate);
//            detailAssertTest("enable",model.list.get(i).enable);
            detailAssertTest("created_at",model.list.get(i).created_at);


//            detailAssertTest("updated_at",model.list.get(i).updated_at);
//            detailAssertTest("need_review",model.list.get(i).need_review);
//            detailAssertTest("need_compenstion",model.list.get(i).need_compenstion);
//            detailAssertTest("need_invalid_coupon",model.list.get(i).need_invalid_coupon);
        }
    }
}

