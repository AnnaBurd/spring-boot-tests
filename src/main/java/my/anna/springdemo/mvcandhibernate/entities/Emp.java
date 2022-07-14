package my.anna.springdemo.mvcandhibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employees")
@NoArgsConstructor
@Getter
@Setter
public class Emp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private String name;
	
	private String surname;
	
	private String department;
	
	private int salary;

	public Emp(String name, String surname, String department, int salary) {
		this.name = name;
		this.surname = surname;
		this.department = department;
		this.salary = salary;
	}
}
