package kovalev.cardchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardCheckerApplication {

	/**
	 * http://127.0.0.1:8084/hystrix
	 *
	 * http://127.0.0.1:8084/actuator
	 *
	 * http://127.0.0.1:8084/actuator/hystrix.stream
	 *
	 *
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(CardCheckerApplication.class, args);
	}

}
