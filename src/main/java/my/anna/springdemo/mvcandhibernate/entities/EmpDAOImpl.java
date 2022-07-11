package my.anna.springdemo.mvcandhibernate.entities;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmpDAOImpl implements EmpDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	//@Transactional // Automatically open-close transactions! - moved transactional on service lvl
	public List<Emp> getAllEmployees() {
		
		System.out.println("List<Emp> getAllEmployees()");

		Session session = sessionFactory.getCurrentSession();
//		List<Emp> allEmpInDatabase = session.createQuery("from Emp", Emp.class)
//				.getResultList();
		
		Query<Emp> query = session.createQuery("from Emp", Emp.class);
		
		System.out.println("List<Emp> getAllEmployees(): created query");
		List<Emp> allEmpInDatabase = query.getResultList();

		System.out.println("List<Emp> getAllEmployees(): result = " + allEmpInDatabase);

		return allEmpInDatabase;
	}

	@Override
	public void saveEmployee(Emp newEmp) {
		System.out.println("public void saveEmployee(Emp newEmp)");
		
		Session session = sessionFactory.getCurrentSession();
		
		//session.save(newEmp);
		
		session.saveOrUpdate(newEmp); // Manage save or update on the database level, not in the controller
		
	}

	@Override
	public Emp getEmployee(int id) {


		Session session = sessionFactory.getCurrentSession();
		
		//return session.find(Emp.class, id);
		return session.get(Emp.class, id);

	}

}
