package Aron_zz.github.paper_system_backend.service.impl;

import Aron_zz.github.paper_system_backend.dto.PaperRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import Aron_zz.github.paper_system_backend.entity.Paper;
import Aron_zz.github.paper_system_backend.entity.UserPaper;
import Aron_zz.github.paper_system_backend.mapper.PaperMapper;
import Aron_zz.github.paper_system_backend.mapper.UserPaperMapper;
import Aron_zz.github.paper_system_backend.service.PaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {

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

    // 使用 IService 提供的 save 方法
    @Override
    public boolean save(Paper paper) {
        return super.save(paper);  // 调用 IService 的 save 方法
    }

    // 根据用户 ID 和论文标题进行模糊查询
    // 根据用户 ID 和论文标题进行模糊查询
    @Override
    public List<Paper> searchPapersByUserIdAndTitle(Long userId, String query) {
        // 获取用户相关的论文 ID 列表
        List<Long> paperIds = userPaperMapper.selectList(new QueryWrapper<UserPaper>().eq("user_id", userId))
                .stream()
                .map(UserPaper::getPaperId)
                .collect(Collectors.toList());

        // 创建 QueryWrapper，用于根据标题模糊查询
        QueryWrapper<Paper> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", query);  // 根据标题进行模糊查询

        // 将查询结果限定为该用户的论文
        queryWrapper.in("id", paperIds);  // 只查询该用户相关的论文

        return this.list(queryWrapper);  // 执行查询
    }

    @Override
    public Long savePaperWithUser(PaperRequest request, Long userId) {
        Paper paper = new Paper();
        paper.setTitle(request.getTitle());
        paper.setPaperAbstract(request.getPaperAbstract());
        paper.setPublishedAt(request.getPublishedAt());
        paper.setDoi(request.getDoi());
        this.save(paper);  // 插入 paper 表

        UserPaper userPaper = new UserPaper();
        userPaper.setUserId(userId);
        userPaper.setPaperId(paper.getId());
        userPaper.setAuthorOrder(request.getAuthorOrder());
        userPaper.setContribution(request.getContribution());
        userPaperMapper.insert(userPaper); // 插入 user_paper 表

        return paper.getId();
    }


}

