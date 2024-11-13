package unrn.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TpApplication {

	public static void main(String[] args) {
		//System.out.println(new Date());
		SpringApplication.run(TpApplication.class, args);

	}

}
