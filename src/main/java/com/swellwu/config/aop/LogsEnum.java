package com.swellwu.config.aop;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description:</p>
 * 定义log层级，用于logs注解上
 *
 * @author xinjian.wu
 * @date 2017-07-08
 */
public enum LogsEnum {

    //父级
    MEM_M1("MEM_M1", "学生管理"),

    //子
    MEM_M1_F1("MEM_M1_F1", "学生信息查询"),
    MEM_M1_F2("MEM_M1_F2", "学生信息插入");


    private final String key;
    private final String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    LogsEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 根据key获取value
     *
     * @param key : 键值key
     * @return String
     */
    public static String getValueByKey(String key) {
        LogsEnum[] enums = LogsEnum.values();
        for (int i = 0; i < enums.length; i++) {
            if (enums[i].getKey().equals(key)) {
                return enums[i].getValue();
            }
        }
        return "";
    }

    /**
     * 转换为MAP集合
     *
     * @returnMap<String, String>
     */
    public static Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        LogsEnum[] enums = LogsEnum.values();
        for (int i = 0; i < enums.length; i++) {
            map.put(enums[i].getKey().toString(), enums[i].getValue());
        }
        return map;
    }
    }
