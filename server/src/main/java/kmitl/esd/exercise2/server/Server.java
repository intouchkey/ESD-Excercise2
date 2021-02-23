package kmitl.esd.exercise2.server;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Web server
 */
@SpringBootApplication
public class Server {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Server.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8000"));
		app.run(args);
	}

}
