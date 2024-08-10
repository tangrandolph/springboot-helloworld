package ct.ariel.helloworld.demo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDO implements Serializable {
    private Long id;
    private String name;
}
