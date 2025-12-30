// 2025005847 박우현 
import java.util.Scanner;

public class EmployeeApp {
	
	private static final int MAX_NUM = 5;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee[] employee = new Employee[MAX_NUM];
		
		for(int i=0; i<MAX_NUM; i++) employee[i] = new Employee(); 
		
		employee[0].setAge(34);
		employee[0].setName("Alan", "Cooper");
		employee[0].setPosition("Senior Engineer");
		employee[0].setSalary(6500000);
		
		employee[1].setAge(26);
		employee[1].setName("Brendan", "Eich");
		employee[1].setPosition("Junior Engineer");
		employee[1].setSalary(5000000);
		
		employee[2].setAge(38);
		employee[2].setName("Dennis", "Richie");
		employee[2].setPosition("Chief Engineer");
		employee[2].setSalary(7800000);
		
		employee[3].setAge(42);
		employee[3].setName("Larry", "Wall");
		employee[3].setPosition("Team Leader");
		employee[3].setSalary(8200000);
		
		employee[4].setAge(46);
		employee[4].setName("Richard", "Stallman");
		employee[4].setPosition("Project Manager");
		employee[4].setSalary(9000000);
		
		int menu;
		
		while(true) {
			printMenu();
			menu = sc.nextInt();
			
			if(menu == 1) {
				displayAllPositions(employee);
			}else if(menu == 2) {
				displayAllSalary(employee);
			}else if(menu == 3) {
				displayAllInformation(employee);
			}else if(menu == 0) {
				System.out.println("Bye!");
				break;
			}else {
				System.out.println("Wrong number. Type again!");
			}
		}
	
		sc.close();
	}
	
	private static void printMenu() {
		System.out.println("========================================");
		System.out.println("1. Display all positions");
		System.out.println("2. Display all salaries");
		System.out.println("3. Display all information");
		System.out.println("0. Quit");
		System.out.println("========================================");
		System.out.print("-> ");
	}
	
	private static void displayAllPositions(Employee[] employee) {
		System.out.println("----------------------------------------");
		System.out.printf("%-20s %-20s\n", "Name", "Position");
		System.out.println("----------------------------------------");
		for(int i=0; i<MAX_NUM; i++) {
			System.out.printf("%-20s: %-19s\n", employee[i].getName(), employee[i].getPosition());
		}
	}
	
	private static void displayAllSalary(Employee[] employee) {
		System.out.println("----------------------------------------");
		System.out.printf("%-20s %-20s\n", "Name", "Salary");
		System.out.println("----------------------------------------");
		for(int i=0; i<MAX_NUM; i++) {
			System.out.printf("%-20s: %,d\n", employee[i].getName(), employee[i].getSalary());
		}
	}
	
	private static void displayAllInformation(Employee[] employee) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("%-22s%-18s%-15s%-8s\n", "Name", "Age", "Position", "Salary");
		System.out.println("---------------------------------------------------------------");
		for(int i=0; i<MAX_NUM; i++) {
			employee[i].printEmployee();
		}
	}

}
