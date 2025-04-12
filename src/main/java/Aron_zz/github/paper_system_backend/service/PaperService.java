package Aron_zz.github.paper_system_backend.service;

import Aron_zz.github.paper_system_backend.entity.Paper;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PaperService {
    List<Paper> getAllPapers();
    List<Paper> getPapersByUserId(Long userId);
}

