// 2025005847 박우현
import java.util.Scanner;
public class CalculateInt {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번째 정수를 입력: ");
		int a = scanner.nextInt();
		System.out.print("두 번째 정수를 입력: ");
		int b = scanner.nextInt();
		System.out.print("세 번째 정수를 입력: ");
		int c = scanner.nextInt();
		System.out.print("결과: ");
		System.out.println(a+b+c);
		scanner.close();
	}

}
