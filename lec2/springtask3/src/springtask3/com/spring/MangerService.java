package springtask3.com.spring;

import org.springframework.stereotype.Component;

@Component("manager")
public class MangerService implements UserService{

	@Override
	public void save(String name) {
		System.out.println("method save in class MangerService with name "+name);
	}

	@Override
	public void update(String name) {
		System.out.println("method update in class MangerService with name "+name);

		
	}

}
