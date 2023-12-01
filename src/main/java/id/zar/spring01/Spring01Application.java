package id.zar.spring01;

import id.zar.spring01.DbModel.AuthModel;
import id.zar.spring01.repository.AuthRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring01Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring01Application.class, args);
	}

	@Bean
	CommandLineRunner runner(AuthRepository repo)
	{
		return args -> {
//			AuthModel auth = new AuthModel();
			AuthModel auth = AuthModel.builder().username("admin").password("123").email("admin@gmail.com").build();
			repo.insert(auth);
		};
	}
}
