package Aron_zz.github.paper_system_backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import Aron_zz.github.paper_system_backend.entity.Contact;
import Aron_zz.github.paper_system_backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // 1. 根据 userId 分页查询联系人
    @GetMapping("/by-user/{userId}")
    public IPage<Contact> getContactsByUserId(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        System.out.println("调用 getContactsByUserId, userId = " + userId);

        return contactService.getContactsByUserId(userId, page, size);
    }

    // 2. 模糊搜索联系人姓名（userId + name）
    @GetMapping("/search")
    public IPage<Contact> searchContactsByName(
            @RequestParam Long userId,
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return contactService.searchContactsByName(userId, keyword, page, size);
    }

    // 3. 新增联系人
    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        Contact result = contactService.addContact(contact);
        if (result != null) {
            return result;
        } else {
            throw new RuntimeException("添加失败");
        }
    }


    // 4. 修改联系人
    @PutMapping
    public boolean updateContact(@RequestBody Contact contact) {
        return contactService.updateContact(contact);
    }

    // 5. 删除联系人
    @DeleteMapping("/{id}")
    public boolean deleteContact(@PathVariable Long id) {
        return contactService.deleteContact(id);
    }
}

