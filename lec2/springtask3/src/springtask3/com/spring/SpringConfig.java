package springtask3.com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("springtask3.com.spring")
public class SpringConfig {

	@Bean
	public MangerService mangerService() {
		return new MangerService();
	}
	
	@Bean
	public PersonService personService() {
		return new PersonService();
	}
	
}
