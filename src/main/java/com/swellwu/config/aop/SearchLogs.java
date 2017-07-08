package com.swellwu.config.aop;

import java.lang.annotation.*;

/**
 * <p>Description:</p>
 * 表示搜索功能的注解
 * @author xinjian.wu
 * @date 2017-07-08
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SearchLogs {

    LogsEnum parentCode();//模块code

    LogsEnum funcCode() ;// 功能code

    String type() default "";//保留字段

}
