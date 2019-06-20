package zqit.claim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

import zqit.claim.plugin.dynamicDatasource.DynamicDataSourceRegister;

//配置文件
@PropertySource("classpath:zqit/claim/plugin/sechedule/taskCorn.properties")

//注册动态多数据源
@Import({ DynamicDataSourceRegister.class }) 

//sechedule定时任务
@EnableScheduling


@SpringBootApplication
public class YdClaimBatchApp extends SpringBootServletInitializer // 需要打包为war时， 继承SpringBootServletInitializer，同时重写configure方法
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(YdClaimBatchApp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(YdClaimBatchApp.class, args);
	}

}
