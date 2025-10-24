package springtask4;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import springtask4.Model.Doctor;
import springtask4.Model.DoctorDetails;
import springtask4.Model.Hospital;
import springtask4.Model.Patient;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Patient.class)
				.addAnnotatedClass(DoctorDetails.class)
				.addAnnotatedClass(Doctor.class)
				.addAnnotatedClass(Hospital.class);
			
		SessionFactory factory =  configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.close();
		factory.close();

	}

}
