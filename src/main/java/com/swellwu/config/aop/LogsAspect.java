package com.swellwu.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springside.modules.utils.base.ObjectUtil;
import org.springside.modules.utils.mapper.JsonMapper;

/**
 * <p>Description:</p>
 * aop 定义
 *
 * @author xinjian.wu
 * @date 2017-07-08
 */
@Aspect
@Configuration
public class LogsAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //切点定义
    @Pointcut("@annotation(SearchLogs)")
    public void logsPointcutSearch() {
    }

    @Pointcut("@annotation(InsertLogs)")
    public void logsPointcutInsert() {
    }

    @Pointcut("@annotation(UpdateLogs)")
    public void logsPointcutUpdate() {
    }

    @Pointcut("execution(* com.swellwu.service.*.*(..))")
    public void allPointcut() {
    }

    @AfterThrowing(pointcut = "allPointcut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        String params = "";
        StringBuffer sb=new StringBuffer();
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                sb.append(JsonMapper.INSTANCE.toJson(joinPoint.getArgs()[i])).append(";");
            }
            params=sb.toString();
        }
        try {
            /* ========控制台输出========= */
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("方法描述:" + getDescription(joinPoint));
            System.out.println("请求参数:" + params);
            // 记录本地异常日志
        } catch (Exception ex) {
            logger.error("==异常通知异常==");
            logger.error("异常信息:{}", ex.getMessage());
        }
    }

    @Around(value = "logsPointcutSearch()")
    public Object searchProcess(ProceedingJoinPoint point) throws Throwable {
        String signature = point.getSignature().toShortString();
        Object[] args = point.getArgs();
        logger.info("search before : {},args:{}", signature, ObjectUtil.toPrettyString(args));
        Object returnVal = null;
        try {
            returnVal = point.proceed(args);
        } catch (Throwable e) {
            logger.error("{},args:{},error:{}", signature, args, e.getMessage());
            throw e;
        }
        logger.info("search after : {} {},args:{}", returnVal, signature, ObjectUtil.toPrettyString(args));

        return returnVal;
    }

    @Around(value = "logsPointcutInsert()")
    public Object insertProcess(ProceedingJoinPoint point) throws Throwable {
        String signature = point.getSignature().toShortString();
        Object[] args = point.getArgs();
        logger.info("insert before : {},args:{}", signature, ObjectUtil.toPrettyString(args));
        Object returnVal = null;
        returnVal = point.proceed(args);
        logger.info("insert after : {} {},args:{}", returnVal, signature, ObjectUtil.toPrettyString(args));
        return returnVal;
    }

    private String getDescription(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String s = signature.toShortString();
        System.out.println(s);
        return s;
    }
}
