package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.ArticleDetailData;
import org.testng.annotations.Test;

public class ArticleDetail extends MsfInterfaceTest {

    private ArticleDetailData model;

    @Test(description = "文章详情")
    public void articleDetail() {
        setUrl("article.detail.uri");
        param = "id=" + SqlDetail.getInstance().getParamValue("article_id");
        process(true,false);
        model = sparseJson(ArticleDetailData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("id", model.id);
        assertNotEmpty("user_id", model.user_id);
        assertNotEmpty("title", model.title);
        assertNotNull("weight", model.weight);
        assertNotNull("nature_weight", model.nature_weight);
        assertNotNull("human_weight", model.human_weight);
        assertNotNull("reject_reason", model.reject_reason);
        assertNotNull("high_quality", model.high_quality);
        assertNotNull("recommend", model.recommend);
        assertNotNull("recommend_reason", model.recommend_reason);
        assertNotNull("lng", model.lng);
        assertNotNull("lat", model.lat);
        assertNotNull("address", model.address);
        assertNotEmpty("zone_id", model.zone_id);
        assertNotNull("branch_id", model.branch_id);
        assertNotNull("branch_tmp_id", model.branch_tmp_id);
        assertNotNull("star", model.star);
        assertNotEmpty("content", model.content);
        assertNotNull("video_id", model.video_id);
        assertNotEmpty("pic", model.pic);
        assertNotNull("gif", model.gif);
        assertNotNull("order_id", model.order_id);
        assertNotNull("activity_id", model.activity_id);
        assertNotEmpty("user_first", model.user_first);
        assertNotEmpty("first_audit_time", model.first_audit_time);
        assertNotEmpty("act_status", model.act_status);
        assertNotEmpty("status", model.status);
        assertNotEmpty("created_at", model.created_at);
        assertNotEmpty("updated_at", model.updated_at);
        assertNotEmpty("avatar", model.avatar);
        assertNotEmpty("nickname", model.nickname);
        assertNotEmpty("followed", model.followed);
        assertNotEmpty("likes_status", model.likes_status);
        assertNotEmpty("favorite_status", model.favorite_status);
        assertNotNull("favorite_num", model.favorite_num);
        assertNotNull("likes_num", model.likes_num);
        assertNotNull("comment_num", model.comment_num);
        assertNotNull("article_num", model.article_num);
        assertNotNull("fans_num", model.fans_num);
        assertNotNull("follow_num", model.follow_num);
        assertNotEmpty("pics", model.pics);
        assertNotEmpty("pic_list", model.pic_list);
        for (int i = 0; i < model.pic_list.size(); i++) {
            assertNotEmpty("pic_list.get(i).pic", model.pic_list.get(i).pic);
            assertNotNull("pic_list.get(i).width", model.pic_list.get(i).width);
            assertNotNull("pic_list.get(i).height", model.pic_list.get(i).height);

        }
        assertNotNull("comments", model.comments);
        assertNotNull("branch_name", model.branch_name);
        assertNotNull("branch_head_pic", model.branch_head_pic);
        assertNotNull("branch_lng", model.branch_lng);
        assertNotNull("branch_lat", model.branch_lat);
        assertNotNull("branch_address", model.branch_address);
        assertNotNull("branch_desc", model.branch_desc);
        assertNotNull("branch_phone", model.branch_phone);
        assertNotNull("branch_star", model.branch_star);
        assertNotNull("branch_article_count", model.branch_article_count);
        assertNotNull("activity", model.activity);
        assertNotNull("quality_user", model.quality_user);
        assertNotNull("branch_distance", model.branch_distance);
        assertNotNull("width", model.width);
        assertNotNull("height", model.height);
        assertNotNull("is_self", model.is_self);
        assertNotEmpty("share.title", model.share.title);
        assertNotEmpty("share.desc_wechat", model.share.desc_wechat);
        assertNotEmpty("share.desc_weibo", model.share.desc_weibo);
        assertNotEmpty("share.pic", model.share.pic);
        assertNotEmpty("share.link", model.share.link);
        assertNotNull("media_type", model.media_type);

    }
}
