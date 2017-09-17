package com.mybatis.aop;

import com.mybatis.config.DbContextHolder;
import com.mybatis.config.ReadOnlyConnection;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * aop controller打印请求信息切面
 *
 * Created by yunkai on 2017/6/12.
 */
@Aspect
@Component
public class ControllerAspect{

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("execution(public * com.*.controller.*.*(..))")
    public void apiLog() {}

    /**
     * 运行controller之前打印请求信息
     */
    @Before("apiLog()")
    public void doBefore(JoinPoint jp) {
        RequestAttributes attribute = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servlet = (ServletRequestAttributes) attribute;
        HttpServletRequest request = servlet.getRequest();
        //请求路径
        logger.info("请求路径：                   " + request.getRequestURI().toString());
        //请求方式
        logger.info("请求方式：                   " + request.getMethod());
        //请求ip
        logger.info("请求IP：                     " + request.getRemoteAddr());
        //请求类
        logger.info("请求类：                     " + jp.getSignature().getDeclaringTypeName());
        //请求方法
        logger.info("请求方法：                   " + jp.getSignature().getName());
        //请求参数
        if(request.getMethod().equals("GET")){
            String queryString = request.getQueryString();
            if(!StringUtils.isEmpty(queryString)) {
                String[] stringArr = queryString.split("&");
                if(stringArr != null && stringArr.length > 0) {
                    for(int i = 0; i < stringArr.length; i++) {
                        String[] params = stringArr[i].split("=");
                        logger.info("请求参数名：     " + params[0] + "         请求参数值：     " + params[1]);
                    }
                }
            }
        }else {
            Object[] valueParams = jp.getArgs();
            Signature signature = jp.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            String[] stringParams = methodSignature.getParameterNames();
            if(stringParams != null && stringParams.length > 0 ) {
                for(int i =0; i < stringParams.length; i++) {
                    logger.info("请求参数名：     " + stringParams[i] + "         请求参数值：     " + valueParams[i]);
                }
            }
        }
    }

    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {
        try {
            logger.info("set database connection to read only");
            DbContextHolder.setDbType(DbContextHolder.DbType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            logger.info("result = {}", result);
            return result;
        }finally {
            DbContextHolder.clearDbType();
            logger.info("restore database connection");
        }
    }
}
