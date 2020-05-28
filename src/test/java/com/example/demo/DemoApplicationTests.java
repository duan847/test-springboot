//package com.example.demo;
//
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class DemoApplicationTests {
//
//
//	@Autowired
//	private StringRedisTemplate redisTemplate;
//
//	private String key = "redis:test";
//
//	/**
//	 * 设置key的值
//	 */
//	@Test
//	public void test01set() {
//		redisTemplate.opsForValue().set(key, "java");
//		//redis中包含刚刚设置的key
//		assertThat(redisTemplate.hasKey(key), is(true));
//		System.out.println("设置key成功。");
//	}
//
//	/**
//	 * 设置key的值，并且设置过期时间
//	 */
//	@Test
//	public void test02setAndTimeout() {
//		redisTemplate.opsForValue().set(key, "java");
//		//设置60秒过期
//		redisTemplate.expire(key, 60, TimeUnit.SECONDS);
//		//redis中包含刚刚设置的key
//		assertThat(redisTemplate.hasKey(key), is(true));
//		System.out.println("设置key成功。");
//	}
//
//
//	/**
//	 * 根据通配符查询keys
//	 */
//	@Test
//	public void test03keys() {
//		//查询所有key
//		System.out.println("查询redis中所有key：{}"+ redisTemplate.keys("*"));
//		//查询stud开头的key
//		System.out.println("查询redis中key为redis:t开头的key：{}"+ redisTemplate.keys("redis:t*"));
//	}
//
//	/**
//	 * 根据key获取值
//	 */
//	@Test
//	public void test04get() {
//		String value = redisTemplate.opsForValue().get(key);
//		//redis中包含刚刚设置的key
//		assertThat(redisTemplate.hasKey(key), is(true));
//		System.out.println("查询redis中key为study的值：{}"+ value);
//	}
//
//	/**
//	 * 根据key删除key
//	 */
//	@Test
//	public void test05delete() {
//		redisTemplate.delete(key);
//		//redis中不包含刚刚设置的key
//		assertThat(redisTemplate.hasKey(key), is(false));
//		System.out.println("根据key：{}删除key"+ key);
//
//	}
//
//}
