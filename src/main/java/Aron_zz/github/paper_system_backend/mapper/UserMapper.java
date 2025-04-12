package Aron_zz.github.paper_system_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import Aron_zz.github.paper_system_backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 这里可以写自定义SQL方法（可选）
    // 根据邮箱查询用户
    @Select("SELECT * FROM user WHERE email = #{email}")
    User selectByEmail(String email);
}

