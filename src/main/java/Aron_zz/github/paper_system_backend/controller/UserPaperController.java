package Aron_zz.github.paper_system_backend.controller;

import Aron_zz.github.paper_system_backend.dto.UserWithPaperCountDTO;
import Aron_zz.github.paper_system_backend.service.UserPaperService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user-paper")
public class UserPaperController {

    @Autowired
    private UserPaperService userPaperService;

    @GetMapping("/user-count")
    public Map<String, Object> getUserWithPaperCount(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        IPage<UserWithPaperCountDTO> pageResult = userPaperService.getUsersWithPaperCount(page, size);

        Map<String, Object> result = new HashMap<>();
        result.put("records", pageResult.getRecords());  // 当前页的数据
        result.put("total", pageResult.getTotal());      // 数据总数

        return result;
    }
}
