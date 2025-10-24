package springtask33.com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("springtask33.com.spring")
public class SpringConfig {

	@Bean(
	        initMethod = "start",
	        destroyMethod = "end1")
	public PersonService personService() {
		return new PersonService();
	}
	
	
}
