/**
 * 
 */
/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.po.TbSbuser;
import com.example.demo.util.JsonUtils;
import com.example.demo.util.RedisUtils;
import com.example.demo.util.JSONResult;

@RestController//使用SpringBoot中@RestController =  SpringMVC中的@Controller + @ResponseBody
public class RedisController{
	
	@Autowired
	private RedisUtils redisUtils;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private UserController springBootDemoUserController;
	
	/**
	 * 设置一个字符串
	 * @return
	 */
	@RequestMapping("/testStringRedis")
	public JSONResult testStringRedis() {
		//将字符串对象存放在redis中
		stringRedisTemplate.opsForValue().set("Json:string", "SpringBoot整合Redis！");
		return JSONResult.ok(stringRedisTemplate.opsForValue().get("Json:string"));
	}
	
	/**
	 * 设置一个JSON字符串
	 * @return
	 */
	@RequestMapping("/testJsonStringRedis")
	public JSONResult testJsonStringRedis() {
		String id = "11111111111";
		JSONResult result = springBootDemoUserController.queryUserInfoById(id);
		
		//将对象存放在redis中
		stringRedisTemplate.opsForValue().set("Json:TbSbuser", JsonUtils.objectToJson(result.getData()));
		//从redis中取出对象并且转换为实体对象，返回到前段展示
		TbSbuser TbSbuser = JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("Json:TbSbuser"), TbSbuser.class);
		
		return JSONResult.ok(TbSbuser);
	}
	
	/**
	 * 设置一个字符串
	 * @return
	 */
	@RequestMapping("/testStringRedis_1")
	public JSONResult testStringRedis_1() {
		//将字符串对象存放在redis中
		redisUtils.set("Json:string", "SpringBoot整合Redis！",1000);
		return JSONResult.ok(redisUtils.get("Json:string"));
	}
	
	/**
	 * 设置一个JSON字符串
	 * @return
	 */
	@RequestMapping("/testJsonStringRedis_1")
	public JSONResult testJsonStringRedis_1() {
		String id = "27e300bcaf054dceb2aa75edbcf3ca84";
		JSONResult result = springBootDemoUserController.queryUserInfoById(id);
		
		//将对象存放在redis中
		redisUtils.set("Json:tbsbuser", JsonUtils.objectToJson(result.getData()),1000);
		//从redis中取出对象并且转换为实体对象，返回到前段展示
		TbSbuser TbSbuser = JsonUtils.jsonToPojo(redisUtils.get("Json:tbsbuser"), TbSbuser.class);
		
		return JSONResult.ok(TbSbuser);
	}
	
}