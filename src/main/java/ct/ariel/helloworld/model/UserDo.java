package ct.ariel.helloworld.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDo implements Serializable {
    private Long id;
    private String name;
}
