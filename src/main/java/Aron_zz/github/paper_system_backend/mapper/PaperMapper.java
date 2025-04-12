package Aron_zz.github.paper_system_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import Aron_zz.github.paper_system_backend.entity.Paper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperMapper extends BaseMapper<Paper> {
    // 可添加自定义方法
}


