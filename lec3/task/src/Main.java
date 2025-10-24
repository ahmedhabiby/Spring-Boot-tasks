
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.teacher;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration configuration = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(teacher.class);
				
		SessionFactory factory =  configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.close();
		factory.close();
}
}