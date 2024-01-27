package ct.ariel.helloworld.http;

import ct.ariel.helloworld.mapper.UserMapper;
import ct.ariel.helloworld.model.UserDo;
import ct.ariel.helloworld.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Demo {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello world");
        List<UserDo> mariaResult = userMapper.selectAll();
        System.out.println("Demo get all items from mariadb ariel, table user\n" + mariaResult.toString());

        String redisResult = redisService.get("hello");
        System.out.println("Demo get data from redis: key is hello, value is " + redisResult);
        return "world";
    }
}
