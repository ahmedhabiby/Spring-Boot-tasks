package springtask32.com.spring;

public class PersonService implements UserService {

	@Override
	public void save(String name) {
		System.out.println("person name is "+name);
	}

}
