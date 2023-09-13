package backend.shop.com.multiplexshop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
@EnableJpaAuditing
public class MultiplexshopApplication {
	public static void main(String[] args) {
		SpringApplication.run(MultiplexshopApplication.class, args);
		//git feat_product branch init

	}

}
