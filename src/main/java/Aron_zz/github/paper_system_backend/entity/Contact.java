package Aron_zz.github.paper_system_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

public class Contact {

    @TableId(value = "id", type = IdType.AUTO) // 如果是数据库自增主键
    private Long id;                // 联系人ID
    private Long userId;            // 所属用户ID
    private String name;            // 联系人姓名
    private String phone;           // 联系电话
    private String email;           // 邮箱
    private String address;         // 地址
    private String relationship;    // 与用户的关系
    private LocalDateTime createdAt;  // 创建时间
    private LocalDateTime updatedAt;  // 更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", relationship='" + relationship + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
