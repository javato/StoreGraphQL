package org.jroldan.store.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.jroldan.store.*"})
@EntityScan(basePackages = {"org.jroldan.store.*"})
@EnableJpaRepositories(basePackages = {"org.jroldan.store.*"})
public class ControllerLauncher {

	public static void main(String[] args) {
		SpringApplication.run(ControllerLauncher.class, args);
	}

}
