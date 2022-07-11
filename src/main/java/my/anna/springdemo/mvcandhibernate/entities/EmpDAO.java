package my.anna.springdemo.mvcandhibernate.entities;

import java.util.List;

public interface EmpDAO {
	
	public List<Emp> getAllEmployees();

	public void saveEmployee(Emp newEmp);

	public Emp getEmployee(int id);

	public void deleteEmployee(int id);

}
