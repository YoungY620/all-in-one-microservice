package cn.yy.allinonehomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AllinoneHomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllinoneHomeworkApplication.class, args);
	}

}
