package Aron_zz.github.paper_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import Aron_zz.github.paper_system_backend.entity.Paper;
import Aron_zz.github.paper_system_backend.entity.UserPaper;
import Aron_zz.github.paper_system_backend.mapper.PaperMapper;
import Aron_zz.github.paper_system_backend.mapper.UserPaperMapper;
import Aron_zz.github.paper_system_backend.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private UserPaperMapper userPaperMapper;

    @Override
    public List<Paper> getAllPapers() {
        return paperMapper.selectList(null);
    }

    @Override
    public List<Paper> getPapersByUserId(Long userId) {
        // 查找该用户关联的所有论文ID
        List<Long> paperIds = userPaperMapper.selectList(new QueryWrapper<UserPaper>()
                        .eq("user_id", userId))
                .stream()
                .map(UserPaper::getPaperId)
                .collect(Collectors.toList());

        if (paperIds.isEmpty()) return List.of();

        return paperMapper.selectBatchIds(paperIds);
    }
}

