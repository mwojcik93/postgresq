package pl.wspa.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableAutoConfiguration
@EnableJpaRepositories
@SpringBootApplication
public class PostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgresqlApplication.class, args);
    }
}
