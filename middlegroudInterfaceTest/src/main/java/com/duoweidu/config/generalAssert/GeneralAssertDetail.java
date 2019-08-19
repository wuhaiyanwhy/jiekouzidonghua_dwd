package com.duoweidu.config.generalAssert;

import org.testng.Assert;

import java.util.*;

public class GeneralAssertDetail extends GeneralAssertChannel {

    /**
     * 不相等报错文案
     * @param channelId
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     * @return
     */
    static private String equalsFailed(int channelId, String resultKey, String uri, int pathId, String param, String result) {
        return distinguishParamFailed(channelId, "返回的" + resultKey + "不正确;", uri, pathId, param, 7, result);
    }

    /**
     * 不应相等报错文案
     * @param channelId
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     * @return
     */
    static private String notEqualsFailed(int channelId, String resultKey, String uri, int pathId, String param, String result) {
        return distinguishParamFailed(channelId, "返回的" + resultKey + "不正确（不应相等）;", uri, pathId, param, 7, result);
    }

    /**
     * 判断返回结果是否为true
     * @param channelId
     * @param condition
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertTrue(int channelId, String resultKey, boolean condition,  String uri, int pathId, String param, String result) {
        try {
            Assert.assertTrue(condition);
        }catch (AssertionError e) {
            fail( "\n" + e.getMessage() + "\n" + distinguishParamFailed(channelId, "返回的" + resultKey + "不为true;", uri, pathId, param, 7, result));
        }

    }

    /**
     * 判断返回结果为false
     * @param channelId
     * @param condition
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertFalse(int channelId, String resultKey, boolean condition, String uri, int pathId, String param, String result) {
        try {
            Assert.assertFalse(condition);
        }catch (AssertionError e) {
            fail( "\n" + e.getMessage() + "\n" + distinguishParamFailed(channelId, "返回的" + resultKey + "不为false;", uri, pathId, param, 7, result));
        }

    }

    /**
     * 判断返回结果是否相等(Object)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, Object actual, Object expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }
    }

    /**
     * 判断返回结果是否相等(String)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, String actual, String expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回结果是否相等(double)
     * @param channelId
     * @param actual
     * @param expected
     * @param delta
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, double actual, double expected, double delta, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回结果是否相等(float)
     * @param channelId
     * @param actual
     * @param expected
     * @param delta
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, float actual, float expected, float delta, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回结果是否相等(long)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, long actual, long expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回结果是否相等(boolean)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, boolean actual, boolean expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回结果是否相等(byte)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, byte actual, byte expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回结果是否相等(char)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, char actual, char expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回结果是否相等(short)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, short actual, short expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回结果是否相等(int)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, int actual, int expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回结果不为空(Object)
     * @param channelId
     * @param object
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNotNull(int channelId, String resultKey, Object object, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNotNull(object);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + distinguishParamFailed(channelId, "返回的" + resultKey + "不应为空;", uri, pathId, param, 7, result));
        }
    }

    /**
     * 判断返回的结果是否为空(Object)
     * @param channelId
     * @param object
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNull(int channelId, String resultKey, Object object, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNull(object);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + distinguishParamFailed(channelId, "返回的" + resultKey + "不为空;", uri, pathId, param, 7, result));
        }

    }

    /**
     * 判断返回的结果是否相同(Object)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertSame(int channelId, String resultKey, Object actual, Object expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertSame(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + distinguishParamFailed(channelId, "返回的" + resultKey + "不正确（不相同）;", uri, pathId, param, 7, result));
        }

    }

    /**
     * 判断返回的结果是否不相同(Object)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNotSame(int channelId, String resultKey, Object actual, Object expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNotSame(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + distinguishParamFailed(channelId, "返回的" + resultKey + "不正确（不应相同）;", uri, pathId, param, 7, result));
        }

    }

    /**
     * 判断返回结果是否相等(Collection<?>)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, Collection<?> actual, Collection<?> expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的结果是否相等(Iterator<?>)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, Iterator<?> actual, Iterator<?> expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的结果是否相等(Iterable<?>)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, Iterable<?> actual, Iterable<?> expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的结果是否相等(Object[])
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, Object[] actual, Object[] expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否相等，但没有特定但顺序(Object[])
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEqualsNoOrder(int channelId, String resultKey, Object[] actual, Object[] expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEqualsNoOrder(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + distinguishParamFailed(channelId, "返回的" + resultKey + "不正确(顺序是否相等);", uri, pathId, param, 7, result));
        }

    }

    /**
     * 判断返回的结果是否相等(Set<?>)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, Set<?> actual, Set<?> expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否相等(Map<?, ?>)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEquals(int channelId, String resultKey, Map<?, ?> actual, Map<?, ?> expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + equalsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否不相等(Object)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNotEquals(int channelId, String resultKey, Object actual, Object expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNotEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + notEqualsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否不相等(long)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNotEquals(int channelId, String resultKey, long actual, long expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNotEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + notEqualsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否不相等(boolean)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNotEquals(int channelId, String resultKey, boolean actual, boolean expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNotEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + notEqualsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否不相等(byte)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNotEquals(int channelId, String resultKey, byte actual, byte expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNotEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + notEqualsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否不相等(char)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNotEquals(int channelId, String resultKey, char actual, char expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNotEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + notEqualsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否不相等(short)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNotEquals(int channelId, String resultKey, short actual, short expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNotEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + notEqualsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否不相等(int)
     * @param channelId
     * @param actual
     * @param expected
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNotEquals(int channelId, String resultKey, int actual, int expected, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNotEquals(actual, expected);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + notEqualsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否不相等(float)
     * @param channelId
     * @param actual1
     * @param actual2
     * @param delta
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNotEquals(int channelId, String resultKey, float actual1, float actual2, float delta, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNotEquals(actual1, actual2, delta);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + notEqualsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否不相等(double)
     * @param channelId
     * @param actual1
     * @param actual2
     * @param delta
     * @param resultKey
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertNotEquals(int channelId, String resultKey, double actual1, double actual2, double delta, String uri, int pathId, String param, String result) {
        try {
            Assert.assertNotEquals(actual1, actual2, delta);
        }catch (AssertionError e) {
            fail("\n" + e.getMessage() + "\n" + notEqualsFailed(channelId, resultKey, uri, pathId, param, result));
        }

    }

    /**
     * 判断返回的数据是否为空(ArrayList)
     * @param channelId
     * @param resultKey
     * @param actual
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEmpty(int channelId, String resultKey, ArrayList actual, String uri, int pathId, String param, String result) {
        if (actual.size() <= 0) {
            GeneralAssertChannel.detailedAssert(channelId, "返回的" + resultKey + "不应为空；", uri, pathId, param, result);
        }
    }

    /**
     * 判断返回的数据是否为空(String)
     * @param channelId
     * @param resultKey
     * @param actual
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEmpty(int channelId, String resultKey, String actual, String uri, int pathId, String param, String result) {
        if (actual == null || actual.isEmpty()) {
            GeneralAssertChannel.detailedAssert(channelId, "返回的" + resultKey + "不应为空" + "，实际返回：" +
                    actual, uri, pathId, param, result);
        }
    }

    /**
     * 判断返回的数据是否为空/0(int)
     * @param channelId
     * @param resultKey
     * @param actual
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEmpty(int channelId, String resultKey, int actual, String uri, int pathId, String param, String result) {
        String actuals = String.valueOf(actual);
        if (actuals == null || actuals.isEmpty() || actuals.equals("0") ) {
            GeneralAssertChannel.detailedAssert(channelId, "返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    actual, uri, pathId, param, result);
        }
    }

    /**
     * 判断返回的数据是否为空(boolean)
     * @param channelId
     * @param resultKey
     * @param actual
     * @param uri
     * @param pathId
     * @param param
     * @param result
     */
    static public void assertEmpty(int channelId, String resultKey, boolean actual, String uri, int pathId, String param, String result) {
        assertEmpty(channelId, resultKey, String.valueOf(actual), uri, pathId, param, result);
    }


}