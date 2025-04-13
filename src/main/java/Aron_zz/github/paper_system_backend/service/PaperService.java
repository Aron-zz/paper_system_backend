package Aron_zz.github.paper_system_backend.service;

import Aron_zz.github.paper_system_backend.dto.PaperRequest;
import Aron_zz.github.paper_system_backend.entity.Paper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PaperService extends IService<Paper> {
    List<Paper> getAllPapers();
    List<Paper> getPapersByUserId(Long userId);

    // 根据用户id模糊搜索论文
    List<Paper> searchPapersByUserIdAndTitle(Long userId, String query);

    Long savePaperWithUser(PaperRequest request, Long userId);
}

