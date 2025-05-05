package Aron_zz.github.paper_system_backend.controller;

import Aron_zz.github.paper_system_backend.dto.UserWithPaperCountDTO;
import Aron_zz.github.paper_system_backend.service.UserPaperService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user-paper")
public class UserPaperController {

    @Autowired
    private UserPaperService userPaperService;

    @GetMapping("/user-count")
    public Map<String, Object> getUserWithPaperCount() {
        List<UserWithPaperCountDTO> users = userPaperService.getUsersWithPaperCount();

        Map<String, Object> result = new HashMap<>();
        result.put("records", users);
        result.put("total", users.size());

        return result;
    }

}
