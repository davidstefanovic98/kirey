package kirey;

import kirey.annotation.Exclude;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = "kirey.repository",
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Exclude.class))
@EnableJpaAuditing
public class KireyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KireyApplication.class, args);
	}

}
