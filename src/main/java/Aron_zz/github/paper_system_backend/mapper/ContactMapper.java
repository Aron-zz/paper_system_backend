package Aron_zz.github.paper_system_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import Aron_zz.github.paper_system_backend.entity.Contact;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactMapper extends BaseMapper<Contact> {
    // 如果有自定义查询，可以在这里加方法
}
