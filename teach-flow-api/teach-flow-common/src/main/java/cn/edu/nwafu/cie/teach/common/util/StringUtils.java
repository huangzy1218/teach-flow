package cn.edu.nwafu.cie.teach.common.util;

import cn.hutool.json.JSONUtil;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.Map;

/**
 * 字符串工具类。
 *
 * @author Huang Z.Y.
 * @create 2024-11-20 00:13
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 空字符串
     */
    private static final String NULL_STR = "";

    /**
     * 下划线
     */
    private static final char SEPARATOR = '_';

    /**
     * 获取参数不为空值
     *
     * @param value defaultValue 要判断的 value
     * @return value 返回值
     */
    public static <T> T nvl(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    /**
     * 判断一个 Collection 是否为空，包含 List，Set，Queue。
     *
     * @param coll 要判断的 Collection
     * @return true=为空，false=非空
     */
    public static boolean isEmpty(Collection<?> coll) {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * 判断一个 Collection 是否非空，包含 List，Set，Queue。
     *
     * @param coll 要判断的 Collection
     * @return true=非空，false=空
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * 判断一个对象数组是否为空。
     *
     * @param objects 要判断的对象数组
     * @return true=为空，false=非空
     */
    public static boolean isEmpty(Object[] objects) {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * 判断一个对象数组是否非空。
     *
     * @param objects 要判断的对象数组
     * @return true=非空，false=空
     */
    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

    /**
     * 判断一个 Map 是否为空。
     *
     * @param map 要判断的 Map
     * @return true=为空，false=非空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return isNull(map) || map.isEmpty();
    }

    /**
     * 判断一个 Map 是否为空。
     *
     * @param map 要判断的 Map
     * @return true=非空，false=空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 判断一个字符串是否为空串。
     *
     * @param str String
     * @return true=为空，false=非空
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || NULL_STR.equals(str.trim());
    }

    /**
     * 判断一个字符串是否为非空串。
     *
     * @param str String
     * @return true=非空串，false=空串
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断一个对象是否为空。
     *
     * @param object Object
     * @return true=为空，false=非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * 判断一个对象是否非空。
     *
     * @param object Object
     * @return true=非空，false=空
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    /**
     * 判断一个对象是否是数组类型（Java 基本型别的数组）。
     *
     * @param object 对象
     * @return true=是数组，false=不是数组
     */
    public static boolean isArray(Object object) {
        return isNotNull(object) && object.getClass().isArray();
    }

    /**
     * 去空格。
     */
    public static String trim(String str) {
        return (str == null ? "" : str.trim());
    }

    /**
     * 截取字符串。
     *
     * @param str   字符串
     * @param start 开始
     * @return 结果
     */
    public static String substring(final String str, int start) {
        if (str == null) {
            return NULL_STR;
        }

        if (start < 0) {
            start = str.length() + start;
        }

        if (start < 0) {
            start = 0;
        }

        if (start > str.length()) {
            return NULL_STR;
        }

        return str.substring(start);
    }

    /**
     * 是否包含字符串。
     *
     * @param str    验证字符串
     * @param strArr 字符串组
     * @return 包含返回 true。
     */
    public static boolean inStringIgnoreCase(String str, String... strArr) {
        if (str != null && strArr != null) {
            for (String s : strArr) {
                if (str.equalsIgnoreCase(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断 url 是否与规则配置：? 表示单个字符；* 表示一层路径内的任意字符串，不可跨层级；** 表示任意层路径。
     *
     * @param pattern 匹配规则
     * @param url     需要匹配的 url
     * @return boolean
     */
    public static boolean isMatch(String pattern, String url) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(pattern, url);
    }

    /**
     * 数字左边补齐 0，使之达到指定长度。注意，如果数字转换为字符串后，长度大于 size，则只保留最后 size 个字符。
     *
     * @param num  数字对象
     * @param size 字符串指定长度
     * @return 返回数字的字符串格式，该字符串为指定长度。
     */
    public static String padL(final Number num, final int size) {
        return padL(num.toString(), size, '0');
    }

    /**
     * 字符串左补齐。如果原始字符串 s 长度大于 size，则只保留最后 size 个字符。
     *
     * @param s    原始字符串
     * @param size 字符串指定长度
     * @param c    用于补齐的字符
     * @return 返回指定长度的字符串，由原字符串左补齐或截取得到。
     */
    public static String padL(final String s, final int size, final char c) {
        final StringBuilder sb = new StringBuilder(size);
        if (s != null) {
            final int len = s.length();
            if (s.length() <= size) {
                for (int i = size - len; i > 0; i--) {
                    sb.append(c);
                }
                sb.append(s);
            } else {
                return s.substring(len - size, len);
            }
        } else {
            for (int i = size; i > 0; i--) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 将对象数组转换为字符串。
     *
     * @param array 对象数组
     * @return 转换后的字符串。
     */
    public static String arrayToString(Object[] array) {
        StringBuilder result = new StringBuilder();
        if (array != null) {
            for (Object o : array) {
                if (StringUtils.isNotNull(o)) {
                    try {
                        Object jsonObj = JSONUtil.toJsonStr(o);
                        result.append(jsonObj.toString());
                    } catch (Exception e) {
                        // 忽略异常
                    }
                }
            }
        }
        return result.toString();
    }
}
