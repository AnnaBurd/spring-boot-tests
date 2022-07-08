package my.anna.springdemo.mvcandhibernate;

import java.util.List;

import my.anna.springdemo.mvcandhibernate.entities.Emp;

public interface MyEmpService {
	
	public List<Emp> getAllEmployees();

	public void saveEmployee(Emp newEmp);

}
