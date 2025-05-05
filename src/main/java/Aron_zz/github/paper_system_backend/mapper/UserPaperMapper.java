package Aron_zz.github.paper_system_backend.mapper;

import Aron_zz.github.paper_system_backend.dto.UserWithPaperCountDTO;
import Aron_zz.github.paper_system_backend.entity.UserPaper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserPaperMapper extends BaseMapper<UserPaper> {
    // 可添加用户-论文关联的自定义查询

    @Select("""
            SELECT
                u.id AS userId,
                u.username,  -- 这里改为使用 `u.username` 代替 `u.name`
                u.avatar_url AS avatar,  -- 这里改为使用 `u.avatar_url` 代替 `u.avatar`
                COUNT(up.paper_id) AS paperCount
                FROM user u
                LEFT JOIN user_paper up ON u.id = up.user_id
                GROUP BY u.id
        """)
    List<UserWithPaperCountDTO> selectUsersWithPaperCount();  // 不分页
}

