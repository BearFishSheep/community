package com.nocoder.community.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class ServiceLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    // 第一个*：所有返回值，后面是要作用的包名
    // 第二个和第三个*：service包下所有类的所有方法
    // ..：所有参数
    @Pointcut("execution(* com.nocoder.community.service.*.*(..))")
    public void pointcut() {
        // 切入点
    }

    @Before("pointcut()")   // 切入点的名字
    public void before(JoinPoint joinPoint) {
        // 用户[ip]，在[时间]，访问了[com.nocoder.community.service.xxx.yyy]
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();

        String ip = request.getRemoteHost();
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String target = joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName();

        logger.info(String.format("用户[%s]，在[%s]，访问了[%s]", ip, now, target));
    }
}
