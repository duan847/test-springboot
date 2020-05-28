package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private String key = "redis:test";


/**
     * hello
     */
    @GetMapping
    public Object hello() {
        return "你好啊";
    }

    /**
     * 设置key的值
     */
    @GetMapping("set")
    public String set() {
        redisTemplate.opsForValue().set(key, "java");
        //redis中包含刚刚设置的key
        return "设置key成功。";
    }

    /**
     * 设置key的值
     */
    @GetMapping("get")
    public Object get() {
        return redisTemplate.opsForValue().get(key);
    }

}
