package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {
	
	@Bean(name= "jedisPool")
    @Autowired
    public JedisPool jedisPool(@Qualifier("jedisPoolConfig") JedisPoolConfig config,
                   @Value("${spring.redis.host}")String host,
                   @Value("${spring.redis.port}")int port,
                   @Value("${spring.redis.timeout}")int timeout
                   ) {
            return new JedisPool(config, host, port,timeout,false);
    }

    @Bean(name= "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig (@Value("${spring.redis.pool.max-active}")int maxTotal,
                @Value("${spring.redis.pool.max-idle}")int maxIdle,
                @Value("${spring.redis.pool.max-wait}")int maxWaitMillis) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(maxTotal);
            config.setMaxIdle(maxIdle);
            config.setMaxWaitMillis(maxWaitMillis);
            return config;
        }
	
}
