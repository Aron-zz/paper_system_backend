package Aron_zz.github.paper_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Aron_zz.github.paper_system_backend.mapper.ContactMapper;
import Aron_zz.github.paper_system_backend.entity.Contact;
import Aron_zz.github.paper_system_backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public List<Contact> getAllContactsByUserId(Long userId) {
        QueryWrapper<Contact> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId).orderByDesc("updated_at");
        List<Contact> contacts = contactMapper.selectList(wrapper);
        for (Contact contact : contacts) {
            System.out.println("联系记录: " + contact);
        }
        return contacts;
    }


    @Override
    public IPage<Contact> searchContactsByName(Long userId, String nameKeyword, int page, int size) {
        Page<Contact> contactPage = new Page<>(page, size);
        QueryWrapper<Contact> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .like("name", nameKeyword)
                .orderByDesc("updated_at");
        return contactMapper.selectPage(contactPage, wrapper);
    }

    @Override
    public Contact addContact(Contact contact) {
        System.out.println("插入前 contact = " + contact);
        int rows = contactMapper.insert(contact);
        return rows > 0 ? contact : null;
    }


    @Override
    public boolean updateContact(Contact contact) {
        return contactMapper.updateById(contact) > 0;
    }

    @Override
    public boolean deleteContact(Long id) {
        return contactMapper.deleteById(id) > 0;
    }
}

