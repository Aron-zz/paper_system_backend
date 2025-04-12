package Aron_zz.github.paper_system_backend.mapper;

import Aron_zz.github.paper_system_backend.entity.UserPaper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPaperMapper extends BaseMapper<UserPaper> {
    // 可添加用户-论文关联的自定义查询
}

