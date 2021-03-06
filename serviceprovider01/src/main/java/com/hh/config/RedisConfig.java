package com.hh.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {





        @Bean
        public CacheManager cacheManager(RedisConnectionFactory factory) {
            RedisCacheManager cacheManager =  RedisCacheManager.create(factory);

            return cacheManager;

        }

        @Bean
        public RedisTemplate<String, String> getRedisTemplate(RedisConnectionFactory factory) {
            RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
            redisTemplate.setConnectionFactory(factory);
            //key序列化方式,但是如果方法上有Long等非String类型的话，会报类型转换错误
            //所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现ObjectRedisSerializer
            RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
            redisTemplate.setKeySerializer(redisSerializer);
//        redisTemplate.setHashKeySerializer(redisSerializer);
//        redisTemplate.setValueSerializer(redisSerializer);
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);
 StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
            // key采用String的序列化方式
            redisTemplate.setKeySerializer(stringRedisSerializer);
            // hash的key也采用String的序列化方式
            redisTemplate.setHashKeySerializer(stringRedisSerializer);
            // value序列化方式采用jackson
            redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
            // hash的value序列化方式采用jackson
            redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
            redisTemplate.afterPropertiesSet();
        return redisTemplate;
        }
    }

