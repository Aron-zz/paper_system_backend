package Aron_zz.github.paper_system_backend.controller;

import Aron_zz.github.paper_system_backend.entity.User;
import Aron_zz.github.paper_system_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        System.out.println("检查传入的user信息" + user);
        User createdUser = userService.register(user);
        if (createdUser != null) {
            System.out.println("显示返回给前端的用户信息："+ createdUser);
            return ResponseEntity.ok(createdUser); // 返回包含 userId 的完整用户信息
        } else {
            return ResponseEntity.badRequest().body("邮箱已被注册");
        }
    }


    // 登录接口（修改：改为 @RequestBody）
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        User user = userService.login(email, password);
        if (user != null) {
            return ResponseEntity.ok(user);  // 登录成功，返回用户信息
        } else {
            return ResponseEntity.badRequest().body("邮箱或密码错误");
        }
    }

    // 修改密码接口（修改：改为 @RequestBody）
    @PutMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody Map<String, Object> passwordRequest) {
        Long userId = Long.valueOf(passwordRequest.get("userId").toString());
        String newPassword = passwordRequest.get("newPassword").toString();

        boolean success = userService.updatePassword(userId, newPassword);
        if (success) {
            return ResponseEntity.ok("密码更新成功");
        } else {
            return ResponseEntity.badRequest().body("用户不存在");
        }
    }

    // 查询个人信息接口（修改：改为 @RequestBody）
    @GetMapping("/info")
    public ResponseEntity<?> getUserInfo(@RequestBody Map<String, Long> userRequest) {
        Long userId = userRequest.get("userId");
        User user = userService.getUserInfo(userId);
        if (user != null) {
            return ResponseEntity.ok(user);  // 返回用户信息
        } else {
            return ResponseEntity.badRequest().body("用户信息不存在");
        }
    }

    @PostMapping("/complete-profile")
    public ResponseEntity<String> completeProfile(@RequestBody User updatedUser) {
        boolean success = userService.completeProfile(updatedUser);
        if (success) {
            return ResponseEntity.ok("信息提交成功");
        } else {
            return ResponseEntity.badRequest().body("信息提交失败");
        }
    }

}
