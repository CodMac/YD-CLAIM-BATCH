package zqit.claim.util.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/*
 * 当前应用的上下文
 * 实现了ApplicationContextAware 接口，必须实现该方法；
 *通过传递applicationContext参数初始化成员变量applicationContext
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware{

	private static ApplicationContext context ;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
	
}
