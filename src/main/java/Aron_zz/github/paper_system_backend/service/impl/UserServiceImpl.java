package Aron_zz.github.paper_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import Aron_zz.github.paper_system_backend.entity.User;
import Aron_zz.github.paper_system_backend.mapper.UserMapper;
import Aron_zz.github.paper_system_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User register(User user) {
        // 检查邮箱是否重复
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", user.getEmail());
        if (userMapper.selectOne(wrapper) != null) {
            return null; // 邮箱已注册
        }
        int rows = userMapper.insert(user);

        System.out.println("注册后用户ID: " + user.getId()); // 打印看是否有值
        System.out.println("注册后user的信息" + user);
        if (rows > 0) {
            return user; // 注册成功后 MyBatis 会自动填充 user.id
        } else {
            return null;
        }
    }

    @Override
    public User login(String email, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email).eq("password", password);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public boolean updatePassword(Long userId, String newPassword) {
        User user = userMapper.selectById(userId);
        if (user == null) return false;
        user.setPassword(newPassword);
        return userMapper.updateById(user) > 0;
    }

    @Override
    public User getUserInfo(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public boolean completeProfile(User updatedUser) {
        User user = userMapper.selectById(updatedUser.getId());
        if (user == null) return false;

        user.setContact(updatedUser.getContact());
        user.setBirthday(updatedUser.getBirthday());
        user.setGender(updatedUser.getGender());
        user.setOrganization(updatedUser.getOrganization());
        user.setAvatarUrl(updatedUser.getAvatarUrl()); // 可为 null
        user.setUpdatedAt(LocalDateTime.now());

        return userMapper.updateById(user) > 0;
    }

    @Override
    public String uploadAvatar(MultipartFile file, Long userId) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("文件为空");
        }

        String folderPath = "D:/avatar/";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String fileName = userId + ".jpg"; // 可根据需求加时间戳避免覆盖
        File dest = new File(folderPath + fileName);

        try {
            file.transferTo(dest);
        } catch (IOException | IllegalStateException e) {
            throw new RuntimeException("文件保存失败", e);
        }

        String avatarUrl = "http://localhost:8080/avatar/" + fileName;

        User user = userMapper.selectById(userId);
        if (user == null) {
            throw new IllegalArgumentException("用户不存在");
        }

        user.setAvatarUrl(avatarUrl);
        userMapper.updateById(user);

        return avatarUrl;
    }

    @Override
    // 忘记密码逻辑
    public void resetPassword(String email, String newPassword) {
        // 1. 查找用户
        User user = userMapper.selectByEmail(email);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        // 2. 更新密码
        user.setPassword(newPassword);
        userMapper.updateById(user);
    }


}

