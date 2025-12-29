// 2025005847 박우현
import java.util.Scanner;
public class CoffeeShop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아메리카노 판매 수: ");
		int a = scanner.nextInt();
		System.out.print("카페라떼 판매 수: ");
		int b = scanner.nextInt();
		System.out.print("카푸치노 판매 수: ");
		int c = scanner.nextInt();
		int price = a*2000 + b*3000 + c*3500;
		System.out.printf("총 매출은 %,d 입니다.", price);
		scanner.close();
	}

}
