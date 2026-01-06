// 2025005847 박우현

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReservationApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AirlineSystem airlineSystem = new AirlineSystem("항공사", sc, 4, 10);
		BusSystem busSystem = new BusSystem("버스", sc, 3, 10);
		
		while(true) {
			int cmd = -1;
			
			try {
				printMenu();
				cmd = sc.nextInt();
				
				if(cmd == 1) {
					airlineSystem.menu();
				}else if(cmd == 2) {
					busSystem.menu();
				}else if(cmd == 0) {
					break;
				}else {
					System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요 (0~2)");
				}
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 선택입니다. 숫자를 다시 입력해주세요 (0~2)");
				sc.nextLine();
			}
			
			
			
		}
		
		System.out.println("K-Startup 통합 예약 시스템을 종료합니다.");
		sc.close();

	}
	
	private static void printMenu() {
		System.out.println("----------------------------------------------");
		System.out.println("  K-Startup의 통합 예약 시스템을 방문해 주셔서 감사합니다.");
		System.out.printf("%6s %s\n", "1.", "항공사 예약 시스템");
		System.out.printf("%6s %s\n", "2.", "버스 예약 시스템");
		System.out.printf("%6s %s\n", "0.", "통합 예약 시스템 종료");
		System.out.println("----------------------------------------------");
		System.out.print(" 메뉴를 선택해주세요: ");
	}

}
