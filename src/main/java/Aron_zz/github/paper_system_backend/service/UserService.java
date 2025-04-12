package Aron_zz.github.paper_system_backend.service;

import Aron_zz.github.paper_system_backend.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    User register(User user);
    User login(String email, String password);
    boolean updatePassword(Long userId, String newPassword);
    User getUserInfo(Long userId);

    boolean completeProfile(User updatedUser);

    String uploadAvatar(MultipartFile file, Long userId);

    void resetPassword(String email, String newPassword);

    boolean updateUserInfo(User user);
}

