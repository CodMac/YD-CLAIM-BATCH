package zqit.claim.plugin.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TaskInterceptor {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 定义一个切入点
	 */
	@Pointcut(" execution(* zqit.claim..*Task.work(..)) ")
    public void taskMethodPointcut(){}
	
	@Before("taskMethodPointcut()") 
	public void beforeInter(JoinPoint point) throws Throwable {
		
		Signature signature = point.getSignature();
		String declaringTypeName = signature.getDeclaringTypeName();//方法全路径
        Method method = ((MethodSignature) signature).getMethod(); //获取被拦截的方法  
        String methodName = method.getName(); //获取被拦截的方法名  
        String packagMethod= declaringTypeName + "." + methodName;
        
		logger.debug("<AOP-ASPECT> - Task - BEFORE - " + packagMethod);
	}

	@After("taskMethodPointcut()")
	public void afterInter(JoinPoint point) {
		
		Signature signature = point.getSignature();
		String declaringTypeName = signature.getDeclaringTypeName();//方法全路径
        Method method = ((MethodSignature) signature).getMethod(); //获取被拦截的方法  
        String methodName = method.getName(); //获取被拦截的方法名  
        String packagMethod= declaringTypeName + "." + methodName;
        
        logger.debug("<AOP-ASPECT> - Task - AFTER - " + packagMethod);
	}

	/**
	 * 拦截器具体实现
	 * @throws Throwable 
	 * 
	 */
	@Around("taskMethodPointcut()")
	public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
		long beginTime = System.currentTimeMillis();
		
		MethodSignature signature = (MethodSignature) pjp.getSignature(); 
		String declaringTypeName = signature.getDeclaringTypeName();//方法全路径
        Method method = signature.getMethod(); //获取被拦截的方法  
        String methodName = method.getName(); //获取被拦截的方法名  
        String packagMethod= declaringTypeName + "." + methodName;
        
        Object r = null;
        Object[] args = pjp.getArgs();
        r = pjp.proceed(args);
        
        long endTime = System.currentTimeMillis();
        long arroundTime = endTime - beginTime;
        logger.info("<AOP-ASPECT> - Task - ARROUND - " + packagMethod + " , arround-time : " + arroundTime +"ms");
		
        return r;
	}
	

}
