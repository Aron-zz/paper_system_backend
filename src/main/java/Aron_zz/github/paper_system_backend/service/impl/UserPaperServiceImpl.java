package Aron_zz.github.paper_system_backend.service.impl;

import Aron_zz.github.paper_system_backend.dto.UserWithPaperCountDTO;
import Aron_zz.github.paper_system_backend.mapper.UserPaperMapper;
import Aron_zz.github.paper_system_backend.service.UserPaperService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaperServiceImpl implements UserPaperService {

    @Autowired
    private UserPaperMapper userPaperMapper;

    @Override
    public IPage<UserWithPaperCountDTO> getUsersWithPaperCount(int page, int size) {
        Page<UserWithPaperCountDTO> pageParam = new Page<>(page, size);
        return userPaperMapper.selectUsersWithPaperCount(pageParam);
    }
}
