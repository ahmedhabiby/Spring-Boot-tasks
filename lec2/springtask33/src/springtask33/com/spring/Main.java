package springtask33.com.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springtask33.com.spring.SpringConfig;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ClassPathXmlApplicationContext applicationContext = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 */
		
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext ( SpringConfig.class);
		
		PersonService ps=	applicationContext.getBean("person",PersonService.class);
		
	   ps.save("ahmed");
	  
	   PersonService ps2=	applicationContext.getBean("person",PersonService.class);
		
	   ps2.save("ahmed");
	  
	   System.out.println(ps);
	   System.out.println(ps2);

	   applicationContext.close();
	}

}
