package springtask3.com.spring;

import org.springframework.stereotype.Component;

@Component("person")

public class PersonService implements UserService {
	
	PersonService(){}

	@Override
	public void save(String name) {
		System.out.println("method save in class PersonService with name "+name);
		
	}

	@Override
	public void update(String name) {
		System.out.println("method update in class PersonService with name "+name);
		
	}

}
