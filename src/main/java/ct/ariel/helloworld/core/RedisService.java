package ct.ariel.helloworld.core;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    public String get(String key) {
        if(StringUtils.isBlank(key)) {
            return null;
        }
        try(Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        } catch(Throwable e) {
            System.out.println("RedisService get error");
        }
        return null;
    }


}
