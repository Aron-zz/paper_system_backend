package Aron_zz.github.paper_system_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Data
@TableName("user_paper")
@AllArgsConstructor
@NoArgsConstructor

public class UserPaper {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;
    @Getter
    @TableField("paper_id")  // 如果列名不是 paper_id，需要指定
    private Long paperId;
    private Integer authorOrder;
    private String contribution;

    // 手动添加 getter（确保方法名严格匹配）
    public Long getPaperId() {
        return this.paperId;
    }

}
