package zqit.claim.plugin.sechedule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoTask {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoTask.class);
	
	@Scheduled(cron="${corn.demoTask}") 
	public void work() {
		try {
			// 处理
			excute();
		} catch (Exception e) {
			logger.error("--> demo作业  - 失败!" + e.toString());
			e.printStackTrace();
		}
	}

	/**
	 * 处理
	 * 
	 * @return
	 */
	private void excute() {

	}
	


}
