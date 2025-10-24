package springtask4;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import springtask4.Model.Account;
import springtask4.Model.Actor;
import springtask4.Model.Auther;
import springtask4.Model.Book;
import springtask4.Model.Car;
import springtask4.Model.Category;
import springtask4.Model.Child;
import springtask4.Model.City;
import springtask4.Model.Classroom;
import springtask4.Model.Country;
import springtask4.Model.Course;
import springtask4.Model.Customer;
import springtask4.Model.Department;
import springtask4.Model.Doctor;
import springtask4.Model.Driver;
import springtask4.Model.Employee;
import springtask4.Model.Flight;
import springtask4.Model.Hotel;
import springtask4.Model.Invoice;
import springtask4.Model.Library;
import springtask4.Model.Movie;
import springtask4.Model.Orderr;
import springtask4.Model.Parent;
import springtask4.Model.Passport;
import springtask4.Model.Patient;
import springtask4.Model.Payment;
import springtask4.Model.Product;
import springtask4.Model.Project;
import springtask4.Model.Rolee;
import springtask4.Model.Room;
import springtask4.Model.School;
import springtask4.Model.Student;
import springtask4.Model.Subject;
import springtask4.Model.Teacher;
import springtask4.Model.Ticket;
import springtask4.Model.Transaction;
import springtask4.Model.Userr;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Passport.class)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Orderr.class)
				.addAnnotatedClass(Auther.class)
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Userr.class)
				.addAnnotatedClass(Rolee.class)
				.addAnnotatedClass(Library.class)
				.addAnnotatedClass(Invoice.class)
				.addAnnotatedClass(Payment.class)
				.addAnnotatedClass(Project.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Patient.class)
				.addAnnotatedClass(Doctor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Flight.class)
				.addAnnotatedClass(Ticket.class)
				.addAnnotatedClass(Actor.class)
				.addAnnotatedClass(Movie.class)
				.addAnnotatedClass(Child.class)
				.addAnnotatedClass(Parent.class)
				.addAnnotatedClass(Classroom.class)
				.addAnnotatedClass(School.class)
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(Driver.class)
				.addAnnotatedClass(Room.class)
				.addAnnotatedClass(Hotel.class)
				.addAnnotatedClass(Transaction.class)
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(City.class)
				.addAnnotatedClass(Country.class);
				
			
		SessionFactory factory =  configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.close();
		factory.close();

	}

}
