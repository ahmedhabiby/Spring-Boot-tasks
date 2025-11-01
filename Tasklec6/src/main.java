
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class main {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().addAnnotatedClass(Post.class).addAnnotatedClass(User1.class)
				.addAnnotatedClass(Friends.class).addAnnotatedClass(User_details.class).configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.getCurrentSession();

		Transaction transaction = session.beginTransaction();
		/*
		 * User1 u1=new User1("ahmed",22); session.save(u1); User_details ud1=new
		 * User_details("elbagour",0100120); ud1.setUser1(u1); session.save(ud1);
		 */

		/*
		 * User1 u1=new User1("ahmed",22); session.save(u1); Post p1 = new Post(
		 * "Welcome Post", "This is my first post!", u1); Post p2 = new Post(
		 * "Java Tips", "Always use try-catch to handle errors.", u1); Post p3 = new
		 * Post( "Hibernate Notes",
		 * "EAGER loads data immediately, LAZY loads when needed.", u1);
		 * 
		 * List<Post> posts = Arrays.asList(p1, p2, p3); u1.setPosts(posts);
		 * session.save(p1); session.save(p2); session.save(p3);
		 */
		
		/*
		 * User1 u1=new User1("ahmed",22); User1 u2=new User1("ali",22); User1 u3=new
		 * User1("osama",22); session.save(u1); session.save(u2); session.save(u3);
		 * List<User1> l1 = Arrays.asList(u1, u2); List<User1> l2 = Arrays.asList(u3,
		 * u2); List<User1> l3 = Arrays.asList(u3, u1);
		 * 
		 * Friends f1 = new Friends("School Friends", l1); Friends f2 = new
		 * Friends("Work Friends", l2); Friends f3 = new Friends("Gym Friends", l3);
		 * 
		 * List<Friends> l4 = Arrays.asList(f1, f2); List<Friends> l5 =
		 * Arrays.asList(f3, f2); List<Friends> l6 = Arrays.asList(f3, f1);
		 * 
		 * u1.setFriends(l4); u1.setFriends(l5); u1.setFriends(l6);
		 * 
		 * session.save(f1); session.save(f2); session.save(f3);
		 */
		
		
		// using cascade 
		
		
		
		/*
		 * User1 u1=new User1("ahmed",22); User_details ud1=new
		 * User_details("elbagour",0100120); // ud1.setUser1(u1);
		 * //session.persist(ud1);
		 */
		
		/*
		 * User1 u1=new User1("ahmed",22);
		 * 
		 * Post p1 = new Post( "Welcome Post", "This is my first post!", u1); Post p2 =
		 * new Post( "Java Tips", "Always use try-catch to handle errors.", u1); Post p3
		 * = new Post( "Hibernate Notes",
		 * "EAGER loads data immediately, LAZY loads when needed.", u1);
		 * 
		 * List<Post> posts = Arrays.asList(p1, p2, p3); u1.setPosts(posts);
		 * session.persist(p1); session.persist(p2); session.persist(p3);
		 */
		 
		/*
		 * User1 u1=new User1("ahmed",22); User1 u2=new User1("ali",22); User1 u3=new
		 * User1("osama",22);
		 * 
		 * List<User1> l3 = Arrays.asList(u1, u2,u3);
		 * 
		 * Friends f1 = new Friends("School Friends", l3); Friends f2 = new
		 * Friends("Work Friends", l3); Friends f3 = new Friends("Gym Friends", l3);
		 * 
		 * 
		 * 
		 * session.persist(f1); session.persist(f2); session.persist(f3);
		 * 
		 */
		
		
		  
		User1 u2 = session.get(User1.class, 1L);
		  System.out.println(u2.toString());
		//  System.out.println(u2.getUserDetail());
		  
		  transaction.commit();
			session.close(); 
			factory.close();

	}

}
