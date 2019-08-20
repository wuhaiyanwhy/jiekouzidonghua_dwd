package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.CommonGuesslikeproductsModel;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonGuesslikeproducts extends FybInterfaceTest {

    private CommonGuesslikeproductsModel model;

    @Test(description = "获取商品列表")
    public void commonGuesslikeproducts() {
        setUrl("common.guesslikeproducts.uri");
        param = "needPagination=1&pageNum=1&pageLimit=10";
        process(true,true);
        model = sparseJson(CommonGuesslikeproductsModel.class);
        detailAssert();

    }

    private void detailAssert() {
        traverse(model.list);
        Map<String, Object> map = traverseObj(model);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            assertNotNull(entry.getKey(), entry.getValue());
        }

    }

    private void traverse(Object obj){
        if (obj instanceof ArrayList) {
            ArrayList<?> list = (ArrayList<?>) obj;
            for (Object item : list) {
                traverseObj(item);
            }
            return;
        } else if (obj instanceof HashMap) {
            HashMap map = (HashMap) obj;
            for (Object key : map.keySet()) {
                Object value = map.get(key);
                traverseObj(value);
            }
            return;
        }
        traverseObj(obj);

    }

    private Map<String, Object> traverseObj(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int i = 0 , len = fields.length; i < len; i++) {
            // 对于每个属性，获取属性名
            String varName = fields[i].getName();
//            System.out.println(varName);
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o;
                try {
                    o = fields[i].get(obj);
//                    System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
                    map.put(varName, o);
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }

}
