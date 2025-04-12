package Aron_zz.github.paper_system_backend.controller;

import Aron_zz.github.paper_system_backend.entity.Paper;
import Aron_zz.github.paper_system_backend.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    // 获取所有论文
    @GetMapping("/all")
    public ResponseEntity<List<Paper>> getAllPapers() {
        List<Paper> papers = paperService.getAllPapers();
        return ResponseEntity.ok(papers);
    }

    // 根据用户ID获取该用户的论文
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Paper>> getPapersByUserId(@PathVariable Long userId) {
        List<Paper> papers = paperService.getPapersByUserId(userId);
        return ResponseEntity.ok(papers);
    }
}
