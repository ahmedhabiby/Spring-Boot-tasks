package springtask33.com.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("person")
@Scope("prototype")
public class PersonService implements UserService{

	@Override
	public void save(String name) {
		// TODO Auto-generated method stub
		System.out.println("Person name is "+name);
	}
	
	void start() {
		System.out.println("Start App");

	}
	
	void end1() {
		System.out.println("End App");

	}

}
