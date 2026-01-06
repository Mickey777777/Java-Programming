import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchExceptionApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while(true) {
			try {
				System.out.println("1. Start");
				System.out.println("2. Stop");
				System.out.println("0. Exit");
				System.out.print("Enter a number(0~2): ");
				
				num = sc.nextInt();
				
				if(num == 0) break;
				
				
			}catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				sc.nextLine();
			}
		}
		
		System.out.println("Exit Program");
		sc.close();

	}

}
