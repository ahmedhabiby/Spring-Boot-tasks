package springtask32.com.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ClassPathXmlApplicationContext applicationContext = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 */
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext ( SpringConfig.class);
		
		AccountServiceImpl aci=applicationContext.getBean("account",AccountServiceImpl.class);
		aci.save("ahmed");
	}

}
