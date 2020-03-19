/**
 * 拦截器配置类
 * @author Arvin_Cheng
 *
 */
package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.configuration.interceptor.FirstInterceptor;
import com.example.demo.configuration.interceptor.ThreeInterceptor;
import com.example.demo.configuration.interceptor.TowInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter{

	/**
	 * 此方法表示需要注册拦截器的方法
	 * 拦截器按照顺序执行
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**	
		 * 拦截器按照顺序执行
		 */
		//FirstInterceptor类和TowInterceptor类，表示自己定义的拦截器类，此拦截器必须实现HandlerInterceptor接口，
		//当第一个拦截器正常通过时，第二个拦截器将会正常工作，否则第二个拦截器将不进行拦截处理（First表示请求）
		registry.addInterceptor(new FirstInterceptor()).addPathPatterns("/First/**");
		
		//.addPathPatterns("/Tow/**").addPathPatterns("/First/**")  表示First请求可以被多个拦截器拦截，表示可以被第二个拦截器拦截
		registry.addInterceptor(new TowInterceptor()).addPathPatterns("/Tow/**").addPathPatterns("/First/**");
		
		//.addPathPatterns("/Three/**").addPathPatterns("/First/**")  表示First请求可以被多个拦截器拦截，表示可以被第三个拦截器拦截
		registry.addInterceptor(new ThreeInterceptor()).addPathPatterns("/Three/**").addPathPatterns("/First/**");
		super.addInterceptors(registry);
	}
}