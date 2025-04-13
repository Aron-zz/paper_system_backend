package Aron_zz.github.paper_system_backend.controller;

import Aron_zz.github.paper_system_backend.dto.PaperRequest;
import Aron_zz.github.paper_system_backend.entity.Paper;
import Aron_zz.github.paper_system_backend.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 删除论文
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePaper(@PathVariable Long id) {
        boolean removed = paperService.removeById(id);
        if (removed) {
            return ResponseEntity.ok("删除成功");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("论文不存在");
        }
    }

    // 修改论文
    @PutMapping("/update")
    public ResponseEntity<String> updatePaper(@RequestBody Paper paper) {
        boolean updated = paperService.updateById(paper);
        if (updated) {
            return ResponseEntity.ok("更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("更新失败");
        }
    }

    // 新增论文接口
    @PostMapping("/add")
    public ResponseEntity<Boolean> addPaper(@RequestBody Paper paper) {
        boolean savedPaper = paperService.save(paper);
        if (savedPaper) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // 根据用户 ID 和论文标题进行模糊查询
    @GetMapping("/search")
    public List<Paper> searchPapers(@RequestParam Long userId, @RequestParam String query) {
        return paperService.searchPapersByUserIdAndTitle(userId, query);
    }

    @PostMapping("/{userId}/papers")
    public ResponseEntity<Map<String, Object>> addPaper(@PathVariable Long userId,
                                                        @RequestBody PaperRequest request) {
        Long paperId = paperService.savePaperWithUser(request, userId);
        Map<String, Object> result = new HashMap<>();
        result.put("paperId", paperId);
        result.put("msg", "论文添加成功");
        return ResponseEntity.ok(result);
    }




}
