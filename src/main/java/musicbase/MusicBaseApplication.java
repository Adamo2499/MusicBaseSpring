package musicbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"musicbase"})
public class MusicBaseApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MusicBaseApplication.class, args);
	}

}
