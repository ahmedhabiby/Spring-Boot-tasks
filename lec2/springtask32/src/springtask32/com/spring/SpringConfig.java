package springtask32.com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("springtask3.com.spring")
public class SpringConfig {

	@Bean("account")
	public AccountServiceImpl accountServiceImpl() {
		return new AccountServiceImpl(personService());
	}
	
	@Bean
	public PersonService personService() {
		return new PersonService();
	}
	
}
