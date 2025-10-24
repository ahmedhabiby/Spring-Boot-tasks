package springtask32.com.spring;

import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements UserService {
 private  PersonService personservice ;
 
 
	public AccountServiceImpl(PersonService personservice) {
	this.personservice = personservice;
}


	@Override
	public void save(String name) {
		
		personservice.save(name);
	}


}
