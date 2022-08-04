package edu.mriabov.springuniversity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("edu.mriabov.springuniversity.repository")
@org.springframework.boot.autoconfigure.domain.EntityScan("edu.mriabov.springuniversity.model")
public class SpringUniversityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringUniversityApplication.class, args);
    }

}
