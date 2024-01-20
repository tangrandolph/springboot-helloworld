package ct.ariel.helloworld.http;

import ct.ariel.helloworld.mapper.UserMapper;
import ct.ariel.helloworld.model.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Demo {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello world");
        List<UserDo> result = userMapper.selectAll();
        return result.toString();
    }
}
