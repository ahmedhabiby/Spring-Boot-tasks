package springtask3.com.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		
		/*
		 * ClassPathXmlApplicationContext applicationContext = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); PersonService ps=
		 * applicationContext.getBean("person",PersonService.class); ps.save("ahmed");
		 * ps.update("ahmed");
		 * 
		 * MangerService ms= applicationContext.getBean("manager",MangerService.class);
		 * ms.save("ahmed"); ms.update("ahmed");
		 * 
		 */
		
		
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext ( SpringConfig.class);
		 
		MangerService ms= applicationContext.getBean("manager",MangerService.class);
		 ms.save("ahmed"); 
		 ms.update("ahmed");
		 
		 PersonService ps= applicationContext.getBean("person",PersonService.class);
		 ps.save("ahmed"); 
		 ps.update("ahmed");

}
}