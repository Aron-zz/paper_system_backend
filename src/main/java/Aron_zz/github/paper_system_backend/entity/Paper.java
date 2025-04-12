package Aron_zz.github.paper_system_backend.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("paper")
@AllArgsConstructor
@NoArgsConstructor
public class Paper {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    @TableField("abstract")
    private String paperAbstract;

    private String doi;

    private LocalDate publishedAt;

    @TableField("created_at")
    private LocalDateTime createdAt;

}


