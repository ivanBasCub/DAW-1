package exercises;

public class Employee {

	private int salary;
	private String name;
	
	public Employee(int salary, String name) {
		super();
		setSalary(salary);
		setName(name);
	}
	
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getSalary() ==((Employee) obj).getSalary()){
			return true;
		}else {
			return false;
		}
	}
}
