package springtask4;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import springtask4.Model.Player;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Player.class);
			
		SessionFactory factory =  configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction t=  session.beginTransaction();
		Player p1=new Player(1L,"Ahmed",20,true);
		Player p2=new Player(2L,"Mohamed",22,false);
		Player p3=new Player(3L,"Ali",30,true);
		Player p4=new Player(4L,"Osama",51,false);
		//save
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		//get
		Player found=session.get(Player.class, 1L);
		System.out.println(found.toString());
		//update
		found.setName("Ahmed Habiby");
		       session.update(found);
		       
				System.out.println(found.toString());
				
				//delete
				session.delete(found);
				System.out.println("found deleted");


				t.commit();

		session.close();
		factory.close();

	}

}
