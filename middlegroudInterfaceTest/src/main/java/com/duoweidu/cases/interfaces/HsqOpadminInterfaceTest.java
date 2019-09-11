package com.duoweidu.cases.interfaces;

import com.duoweidu.config.generalAssert.GeneralAssertChannel;
import com.duoweidu.utils.CallbackInterface;
import com.duoweidu.utils.ConfigFileUrl;
import com.duoweidu.utils.Uuid;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class HsqOpadminInterfaceTest extends InterfaceTest {

    @Override
    protected long limitTime() {
        return ConfigFileUrl.getLimitTime1();
    }

    @Override
    public int channel_id() {
        return ConfigFileUrl.getChannel1();
    }

    //get请求，不要断言
    @Override
    protected void process() {
        System.out.println(url);
        //通用参数
        String par = "interface_uuid=" + Uuid.getUuid();
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        System.out.println("参数：" + param);
        result = CallbackInterface.getStringResult(limitTime(), url, pathId, this.param);
    }

    //post请求,不要断言
    @Override
    protected void process(List<NameValuePair> list) {
        System.out.println(url);
        //通用参数
        list.add(new BasicNameValuePair("interface_uuid", Uuid.getUuid()));
        param = URLEncodedUtils.format(list, "Utf-8");
        System.out.println("参数：" + param);
        result = CallbackInterface.postStringResult(limitTime(), url, pathId, list);
    }

    /**
     * get请求,type=1 ==> data, type=2 ==>aaData
     * @param type
     * @param isAssert
     * @param isList
     */
    protected void process(int type, boolean isAssert, boolean isList) {
        process();
        if (isAssert == true) {
            generalAssertTest(type, isList);
        }
    }

    /**
     * post请求,type=1 ==> data, type=2 ==>aaData
     * @param list
     * @param type
     * @param isAssert
     * @param isList
     */
    protected void process(List<NameValuePair> list, int type, boolean isAssert, boolean isList) {
        process(list);
        if (isAssert == true) {
            generalAssertTest(type, isList);
        }
    }

    /**
     * type=1 ==> data, type=2 ==>aaData
     * @param type
     * @param isList
     */
    protected void generalAssertTest(int type, boolean isList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            if (type == 1) {
                JSONObject data = (JSONObject) jsonObject.get("data");
                GeneralAssertChannel.errnoAssert(ConfigFileUrl.getChannel1(), jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
                GeneralAssertChannel.dataAssert(ConfigFileUrl.getChannel1(), jsonObject.get("data").toString(), url, pathId, param, result);
                if (isList == true) {
                    GeneralAssertChannel.listAssert(ConfigFileUrl.getChannel1(), (JSONArray) data.get("list"), url, pathId, param, result);
                }
            }else if (type == 2) {
                JSONArray aaData = (JSONArray) jsonObject.get("aaData");
                GeneralAssertChannel.aaDataTest(ConfigFileUrl.getChannel1(), aaData, url, pathId, param, result);
            }
        }catch (JSONException e){
            GeneralAssertChannel.jsonAssert(ConfigFileUrl.getChannel1(), url, pathId, param, result, e);
        }

    }



}
