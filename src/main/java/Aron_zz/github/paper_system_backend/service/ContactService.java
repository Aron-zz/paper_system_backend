package Aron_zz.github.paper_system_backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Aron_zz.github.paper_system_backend.entity.Contact;

public interface ContactService {

    // 根据用户ID分页查询联系人
    IPage<Contact> getContactsByUserId(Long userId, int page, int size);

    // 模糊查询联系人姓名（基于用户ID）
    IPage<Contact> searchContactsByName(Long userId, String nameKeyword, int page, int size);

    // 添加联系人
    Contact addContact(Contact contact);

    // 修改联系人
    boolean updateContact(Contact contact);

    // 删除联系人
    boolean deleteContact(Long id);
}

