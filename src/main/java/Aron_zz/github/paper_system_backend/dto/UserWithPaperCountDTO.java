package Aron_zz.github.paper_system_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithPaperCountDTO {
    private Long userId;
    private String username;
    private String avatar;
    private Integer paperCount;
}

