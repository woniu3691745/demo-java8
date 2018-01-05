package spring.aop.app.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-03 11:06
 */
@Component
@Aspect
public class LogAopAdviseDefine {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // 定义一个 Pointcut, 使用 切点表达式函数 来描述对哪些 Join point 使用 advise.
    @Pointcut("within(spring.aop.WebController)")
//    @Pointcut("execution(* spring.aop.WebController.method2(..))")
    public void pointcut() {
    }


    // 定义 advise
//    @Before("pointcut()")
//    public void logMethodInvokeParam(JoinPoint joinPoint) {
//        logger.info("--->  Before method {} invoke, param: {}---", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
//    }
//
//    @AfterReturning(pointcut = "pointcut()", returning = "retVal")
//    public void logMethodInvokeResult(JoinPoint joinPoint, Object retVal) {
//        logger.info("--->  After method {} invoke, result: {}---", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
//    }
//
//    @AfterThrowing(pointcut = "pointcut()", throwing = "exception")
//    public void logMethodInvokeException(JoinPoint joinPoint, Exception exception) {
//        logger.info("---method {} invoke exception: {}---", joinPoint.getSignature().toShortString(), exception.getMessage());
//    }
//
//    @Around("pointcut()")
//    public Object logMethodAroundInvokeResult(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("----> asdasdasd");
//        return "error123";
//    }

    @Before(value = "pointcut()  &&  args(name)")
    public void doSomething(String name) {
        logger.info("---page: {}---", name);
    }
}
