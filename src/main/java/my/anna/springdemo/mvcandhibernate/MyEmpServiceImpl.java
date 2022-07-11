package my.anna.springdemo.mvcandhibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.anna.springdemo.mvcandhibernate.entities.Emp;
import my.anna.springdemo.mvcandhibernate.entities.EmpDAO;

@Service
public class MyEmpServiceImpl implements MyEmpService {
	
	@Autowired
	private EmpDAO empDAO;

	@Override
	@Transactional
	public List<Emp> getAllEmployees() {
		return empDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Emp newEmp) {
		empDAO.saveEmployee(newEmp);
		
	}

	@Override
	@Transactional
	public Emp getEmployee(int id) {
		return empDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		empDAO.deleteEmployee(id);
		
	}

}
