package Aron_zz.github.paper_system_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import Aron_zz.github.paper_system_backend.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 这里可以写自定义SQL方法（可选）
}

