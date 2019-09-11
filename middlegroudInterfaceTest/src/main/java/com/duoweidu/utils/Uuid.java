package com.duoweidu.utils;

import java.util.UUID;

/**
 * 生成随机的uuid
 */
public class Uuid {

    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
