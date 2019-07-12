package com.duoweidu.config.generalAssert;

import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.sql.SqlDetailMultiChannel2;
import com.duoweidu.utils.ConfigFileUrl;

public class GeneralAssertMultiChannel2 extends GeneralAssert {

    /**
     * 不是调试状态才往库里插入数据，线上环境会插入报错次数
     */
    @Override
    public void genErrno(String uri, int path_id, String param, int status, String errnoResult) {
        if ("false".equals(ConfigFileUrl.getDebug())) {
            //插入报错数据
            SqlDetailMultiChannel2.insertErrnoResult(path_id, param, status, errnoResult);
            GeneralConfig.errnoList.add(uri);
            if ("prod".equals(ConfigFileUrl.getEnv())) {
                //插入报错次数
                SqlDetailMultiChannel2.updatePathErrnoCount(path_id);
            }
        }
    }
}
