package ct.ariel.helloworld.http;

import ct.ariel.helloworld.mapper.UserMapper;
import ct.ariel.helloworld.domain.UserDO;
import ct.ariel.helloworld.core.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DemoController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    @GetMapping("/checkpreload")
    public String checkpreload() {
        String s = "health check";
        log.info(s);
        return s;
    }

    @GetMapping("/hello")
    public String hello() {
        log.info("hello world");

        List<UserDO> mariaResult = userMapper.selectAll();
        log.info("Demo get all items from mariadb ariel, table user\n{}", mariaResult.toString());

        String redisResult = redisService.get("hello");
        log.info("Demo get data from redis: key is hello, value is {}", redisResult);
        return "world";
    }
}
