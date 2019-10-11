package com.duoweidu.config.sql;

import com.duoweidu.model.hsqTable.McActivityAssistanceEvent;
import com.duoweidu.model.hsqTable.TraSubOrder;
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

    private static SqlDetail instance;

    public static SqlDetail getInstance() {
        if (instance == null) {
            instance = new SqlDetail();
        }
        return instance;
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
    public String getProtocol() {
        return SqlGeneral.getServerHostValue(channel_id()).getProtocol();
    }

    /**
     * 获取服务主机表的服务器名称
     *
     * @return
     */
    public String getServerName() {
        return SqlGeneral.getServerHostValue(channel_id()).getServer_name();
    }

    /**
     * 获取接口路径表的路径
     * @param name
     * @return
     */
    public String getPath(String name) {
        return SqlGeneral.getInterfacePathValue(channel_id(), name).getPath();
    }

    /**
     * 获取接口路径表的id
     * @param name
     * @return
     */
    public int getPathId(String name) {
        return SqlGeneral.getInterfacePathValue(channel_id(), name).getId();
    }

    /**
     * 获取接口表的报错次数
     * @param id
     * @return
     */
    public int getPathErrnoCount(int id) {
        return SqlGeneral.getInterfacePathValue(id, channel_id()).getErrno_count();
    }

    /**
     * 更新报错次数，根据path_id 自增1
     * @param id
     */
    public void updatePathErrnoCount(int id) {
        SqlGeneral.updateInterfacePathErrnoCount(id, channel_id(), getPathErrnoCount(id) + 1);
    }

    /**
     * 获取参数表的参数值
     * @param name
     * @return
     */
    public String getParamValue(String name) {
        return SqlGeneral.getParamValue(channel_id(), name).getValue();
    }

    /**
     * 获取参数表的参数值
     *
     * @param env
     * @param name
     * @return
     */
    public String getParamValue(int env, String name) {
        return SqlGeneral.getParamValue(channel_id(), env, name).getValue();
    }

    /**
     * 插入构建状态
     * @param enabled
     * @param message_status
     */
    public void insertBuild(int enabled, int message_status) {
        SqlGeneral.insertBuildValue(channel_id(), enabled, message_status);
    }

    /**
     * 获取构建状态
     * @return
     */
    public ArrayList<Integer> getBuildEnabled() {
        return SqlGeneral.getBuildEnabled(channel_id());
    }

    /**
     * 获取发送短信状态
     * @return
     */
    public ArrayList<Integer> getBuildMessageStatus() {
        return SqlGeneral.getBuildMessageStatus(channel_id());
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
    public void insertErrnoResult(int path_id, String params, int status, String result) {
        SqlGeneral.insertErrnoResult(channel_id(), path_id, getBuildId() + 1, params, status, result);
    }

    /**
     * 更新product_order用户订单数据成功(iqg)
     */
    public void iqgUptadeOrder() {
        ProductOrder productOrder = new ProductOrder(getParamValue(0, "created_at"),
                getParamValue(2, "user_id"),
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
    public void iqgUptadeOneCouponOrder() {
        TrdCouponOrder trdCouponOrder = new TrdCouponOrder(getParamValue(0, "created_at"),
                getParamValue(2, "user_id"),
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
    public void msfUpdateOrder() {
        Order order = new Order(getParamValue(0, "created_at"),
                getParamValue(2, "user_id"),
                1);
        int res = msfBetaSession.update("updateOrder", order);
        msfBetaSession.commit();
        if (res > 0) {
            System.out.println("更新t_order用户订单数据成功");
        }
    }

    /**
     * 更新助力免单数据
     */
    public void hsqUpdateAssistanceEvent() {
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

    /**
     * 获取当前渠道的名字
     * @return
     */
    public String getChannelName() {
        return SqlGeneral.getChannelName(channel_id());
    }

    /**
     * 根据渠道、环境、名称更新参数表value值
     * @param name
     * @param value
     */
    public void updatePathValue(String name, String value) {
        SqlGeneral.updatePathValue(channel_id(), name, value);
    }

    /**
     * 获取结算价
     * @param orderId
     */
    public int getSettlementPrice(String orderId) {

        TraSubOrder traSubOrder = new TraSubOrder();
        traSubOrder.setOrder_id(orderId);
        TraSubOrder traSubOrder1 = hsqBetaSession.selectOne("selectSubOrder", traSubOrder);
        int settlement_price = traSubOrder1.getSettlement_price();

        return settlement_price;
    }
}