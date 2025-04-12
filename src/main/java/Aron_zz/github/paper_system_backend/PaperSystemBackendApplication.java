package Aron_zz.github.paper_system_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("Aron_zz.github.paper_system_backend.mapper")
public class PaperSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaperSystemBackendApplication.class, args);
	}

}


