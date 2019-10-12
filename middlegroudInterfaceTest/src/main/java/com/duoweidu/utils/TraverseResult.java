package com.duoweidu.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据model遍历数据
 */
public class TraverseResult {

    /**
     *数组或map格式
     * @param obj
     * @return
     */
    public static Map<String, Object> traverseCollection(Object obj){
        Map<String, Object> map = new HashMap<>();
        if (obj instanceof ArrayList) {
            ArrayList<?> list = (ArrayList<?>) obj;
            for (Object item : list) {
                map = traverseObj(item);
            }
            return map;
        } else if (obj instanceof HashMap) {
            HashMap map1 = (HashMap) obj;
            for (Object key : map1.keySet()) {
                Object value = map1.get(key);
                map = traverseObj(value);
            }
            return map;
        }
        traverseObj(obj);

        return map;
    }

    /**
     * obj格式
     * @param obj
     * @return
     */
    public static Map<String, Object> traverseObj(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int i = 0 , len = fields.length; i < len; i++) {
            // 对于每个属性，获取属性名
            String varName = fields[i].getName();
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o;
                try {
                    o = fields[i].get(obj);
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
