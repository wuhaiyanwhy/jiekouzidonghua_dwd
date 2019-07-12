package com.duoweidu.config.sql;

import com.duoweidu.config.SqlGeneral;
import com.duoweidu.model.hsqTable.McActivityAssistanceEvent;
import com.duoweidu.model.iqgTable.ProductOrder;
import com.duoweidu.model.iqgTable.TrdCouponOrder;
import com.duoweidu.model.msfTable.Order;
import com.duoweidu.utils.ConfigFileUrl;
import com.duoweidu.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

/**
 * 根据渠道判断详细sql
 */
public class SqlDetail {

    private static SqlSession iqgBetaSession;
    private static SqlSession msfBetaSession;
    private static SqlSession hsqBetaSession;

    static {
        iqgBetaSession = DatabaseUtil.getIqgBetaSqlSession();
        msfBetaSession = DatabaseUtil.getMsfBetaSqlSession();
        hsqBetaSession = DatabaseUtil.getHsqBetaSqlSession();
    }


    /**
     * 交易中心渠道号默认为6
     * 1.好食期 2.爱抢购 3.觅食蜂 4.返一半 5.巨食阵 6.交易中心
     */
    public int channel_id() {
        return ConfigFileUrl.getChannel();
    }

    /**
     * 获取服务主机表的协议
     *
     * @return
     */
    public static String getProtocol() {
        SqlDetail sqlDetail = new SqlDetail();
        return SqlGeneral.getServerHostValue(sqlDetail.channel_id()).getProtocol();
    }

    /**
     * 获取服务主机表的服务器名称
     *
     * @return
     */
    public static String getServerName() {
        SqlDetail sqlDetail = new SqlDetail();
        return SqlGeneral.getServerHostValue(sqlDetail.channel_id()).getServer_name();
    }

    /**
     * 获取接口路径表的路径
     * @param name
     * @return
     */
    public static String getPath(String name) {
        SqlDetail sqlDetail = new SqlDetail();
        return SqlGeneral.getInterfacePathValue(sqlDetail.channel_id(), name).getPath();
    }

    /**
     * 获取接口路径表的id
     * @param name
     * @return
     */
    public static int getPathId(String name) {
        SqlDetail sqlDetail = new SqlDetail();
        return SqlGeneral.getInterfacePathValue(sqlDetail.channel_id(), name).getId();
    }

    /**
     * 获取接口表的报错次数
     * @param id
     * @return
     */
    public static int getPathErrnoCount(int id) {
        SqlDetail sqlDetail = new SqlDetail();
        return SqlGeneral.getInterfacePathValue(id, sqlDetail.channel_id()).getErrno_count();
    }

    /**
     * 更新报错次数，根据path_id 自增1
     * @param id
     */
    public static void updatePathErrnoCount(int id) {
        SqlDetail sqlDetail = new SqlDetail();
        SqlGeneral.updateInterfacePathErrnoCount(id, sqlDetail.channel_id(), getPathErrnoCount(id) + 1);
    }

    /**
     * 获取参数表的参数值
     * @param name
     * @return
     */
    public static String getParamValue(String name) {
        SqlDetail sqlDetail = new SqlDetail();
        return SqlGeneral.getParamValue(sqlDetail.channel_id(), name).getValue();
    }

    /**
     * 获取参数表的参数值
     *
     * @param env
     * @param name
     * @return
     */
    public static String getParamValue(int env, String name) {
        SqlDetail sqlDetail = new SqlDetail();
        return SqlGeneral.getParamValue(sqlDetail.channel_id(), env, name).getValue();
    }

    /**
     * 插入构建状态
     * @param enabled
     * @param message_status
     */
    public static void insertBuild(int enabled, int message_status) {
        SqlDetail sqlDetail = new SqlDetail();
        SqlGeneral.insertBuildValue(sqlDetail.channel_id(), enabled, message_status);
    }

    /**
     * 获取构建状态
     * @return
     */
    public static ArrayList<Integer> getBuildEnabled() {
        SqlDetail sqlDetail = new SqlDetail();
        return SqlGeneral.getBuildEnabled(sqlDetail.channel_id());
    }

    /**
     * 获取发送短信状态
     * @return
     */
    public static ArrayList<Integer> getBuildMessageStatus() {
        SqlDetail sqlDetail = new SqlDetail();
        return SqlGeneral.getBuildMessageStatus(sqlDetail.channel_id());
    }

    /**
     * 获取最新的构建id
     * @return
     */
    public static int getBuildId() {
        return SqlGeneral.getBuildId().getId();
    }

    /**
     * 插入报错相关信息
     * @param path_id
     * @param params
     * @param status
     * @param result
     */
    public static void insertErrnoResult(int path_id, String params, int status, String result) {
        SqlDetail sqlDetail = new SqlDetail();
        SqlGeneral.insertErrnoResult(sqlDetail.channel_id(), path_id, getBuildId() + 1, params, status, result);
    }

    /**
     * 更新product_order用户订单数据成功(iqg)
     */
    public static void iqgUptadeOrder() {
        ProductOrder productOrder = new ProductOrder(getParamValue(0, "created_at"),
                getParamValue(0, "user_id"),
                "1", "5");
        int res = iqgBetaSession.update("updateProductOrder", productOrder);
        iqgBetaSession.commit();
        if (res >0) {
            System.out.println("更新product_order用户订单数据成功");
        }

    }

    /**
     * 更新trd_coupon_order用户订单数据成功（iqg）
     */
    public static void iqgUptadeOneCouponOrder() {
        TrdCouponOrder trdCouponOrder = new TrdCouponOrder(getParamValue(0, "created_at"),
                getParamValue(0, "user_id"),
                getParamValue(2, "oneCouponID"));
        int res = iqgBetaSession.update("updateTrdCouponOrder", trdCouponOrder);
        iqgBetaSession.commit();
        if (res >0) {
            System.out.println("更新trd_coupon_order用户订单数据成功");
        }
    }

    /**
     * 更新t_order用户订单数据成功（）msf
     */
    public static void msfUpdateOrder() {
        Order order = new Order(getParamValue(0, "created_at"),
                getParamValue(2, "user_id"),
                1);
        int res = msfBetaSession.update("updateOrder", order);
        msfBetaSession.commit();
        if (res > 0) {
            System.out.println("更新t_order用户订单数据成功");
        }
    }

    public static void hsqUpdateAssistanceEvent() {
        McActivityAssistanceEvent mcActivityAssistanceEvent = new McActivityAssistanceEvent(1,
                3,
                getParamValue(2, "user_id"),
                getParamValue(2, "activityId"));
        int res = hsqBetaSession.update("updateAssistanceEvent", mcActivityAssistanceEvent);
        hsqBetaSession.commit();
        if (res > 0) {
            System.out.println("助力免单数据更新成功，助力成功");
        }
    }
}