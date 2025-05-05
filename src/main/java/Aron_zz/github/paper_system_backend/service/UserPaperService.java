package Aron_zz.github.paper_system_backend.service;

import Aron_zz.github.paper_system_backend.dto.UserWithPaperCountDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface UserPaperService {
    List<UserWithPaperCountDTO> getUsersWithPaperCount();
}
