package Aron_zz.github.paper_system_backend.service;

import Aron_zz.github.paper_system_backend.dto.UserWithPaperCountDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface UserPaperService {
    IPage<UserWithPaperCountDTO> getUsersWithPaperCount(int page, int size);
}
