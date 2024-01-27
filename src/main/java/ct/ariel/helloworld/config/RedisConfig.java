package ct.ariel.helloworld.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

@Configuration
public class RedisConfig {
    private static final int DEFAULT_CONNECTION_TIMEOUT = 5000;
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;
    @Bean(destroyMethod = "close")
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(1);
        jedisPoolConfig.setBlockWhenExhausted(true);
        jedisPoolConfig.setMaxWait(Duration.ofMillis(5000));
        return new JedisPool(jedisPoolConfig, host, port, DEFAULT_CONNECTION_TIMEOUT, "redis");
    }
}
