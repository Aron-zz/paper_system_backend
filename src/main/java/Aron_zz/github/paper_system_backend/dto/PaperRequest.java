package Aron_zz.github.paper_system_backend.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PaperRequest {
    private String title;
    private String paperAbstract;
    private LocalDate publishedAt;
    private String doi;
    private Integer authorOrder;
    private String contribution;
}

