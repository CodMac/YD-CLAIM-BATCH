package zqit.claim.mapper;

import zqit.claim.entity.Demo;

/**
 * 
 * @author Administrator
 * 继承 tk.mybatis.mapper.common.Mapper<T> 时 ，自动注册bean到上下文，不需要重复的 @Mapper 扫描注册
 */
public interface DemoMapper extends tk.mybatis.mapper.common.Mapper<Demo>{
	
}
