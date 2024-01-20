package ct.ariel.helloworld.mapper;

import ct.ariel.helloworld.model.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<UserDo> selectAll();
}
