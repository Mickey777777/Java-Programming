// 2025005847 박우현 
public class Employee {
	private int age;
	private String fullName;
	private String position;
	private int salary;
	
	public Employee() {
		this.age = 0;
		this.fullName = "";
		this.position = "";
		this.salary = 0;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String firstname, String lastname) {
		this.fullName = firstname + " " + lastname;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.fullName;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public void printEmployee() {
		System.out.printf("%-23s%2d%23s    %,d\n", this.fullName, this.age, this.position, this.salary);
	}
	
	
	
}
