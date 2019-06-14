package com.example.demo.redis;

import java.net.UnknownHostException;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by 10064028 on 2018/11/19.
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfigure {

    @Autowired
    private RedisProperties properties;

    @Bean
    @ConditionalOnMissingBean(RedisConnectionFactory.class)
    JedisConnectionFactory redisConnectionFactory()
            throws UnknownHostException {
        return createJedisConnectionFactory();
    }

    @Bean
    @ConditionalOnMissingBean(RedisTemplate.class)
    RedisTemplate<String, Object> redisTemplate() throws UnknownHostException {
        RedisTemplate template = new StringRedisTemplate(redisConnectionFactory());
        FastJson2JsonRedisSerializer<Object> fastJson2JsonRedisSerializer = new FastJson2JsonRedisSerializer<>(Object.class);
        template.setValueSerializer(fastJson2JsonRedisSerializer);
        template.setHashValueSerializer(fastJson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "service.redis", value = "enable", havingValue = "true")
    RedisService redisService() throws UnknownHostException {
        return new RedisServiceImpl(redisTemplate());
    }

    private JedisConnectionFactory createJedisConnectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        return new JedisConnectionFactory(new RedisSentinelConfiguration(properties.getSentinel().getMaster(), new HashSet<>(properties.getSentinel().getNodes())), poolConfig);
    }
}
