
import java.util.InputMismatchException;
import java.util.Scanner;

public class AirlineReservationApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SwissAirline swissAirline = new SwissAirline("SwissAirline", sc, 7, 10);
		TaiwanAirline taiwanAirline = new TaiwanAirline("TaiwanAirline", sc, 6, 10);
		SeoulAirline seoulAirline = new SeoulAirline("SeoulAirline", sc, 4, 10);
		
		while(true) {
			int cmd = -1;
			
			try {
				printMenu();
				cmd = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 선택입니다. 숫자를 다시 입력해주세요 (0~4)");
				sc.nextLine();
			}
			
			if(cmd == 1) {
				swissAirline.menu();
			}else if(cmd == 2) {
				taiwanAirline.menu();
			}else if(cmd == 3) {
				seoulAirline.menu();
			}else if(cmd == 4) {
				System.out.println("-------------------------------------------------------");
				System.out.println("전체 예약 현황");
				System.out.printf("Swiss Airline 예약 현황: %2d/ %2d\n", swissAirline.curSeat, swissAirline.maxSeat);
				System.out.printf("Taiwan Airline 예약 현황: %2d/ %2d\n", taiwanAirline.curSeat, taiwanAirline.maxSeat);
				System.out.printf("Seoul Airline 예약 현황: %2d/ %2d\n", seoulAirline.curSeat, seoulAirline.maxSeat);
			}else if(cmd == 0) {
				break;
			}else {
				System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요 (0~4)");
			}
			
		}
		
		System.out.println("항공사 통합 예약 시스템을 종료합니다.");
		sc.close();

	}
	
	private static void printMenu() {
		System.out.println("--------------------------------------------------------");
		System.out.println("  항공사 통합 예약 시스템을 방문해 주셔서 감사합니다.");
		System.out.println("--------------------------------------------------------");
		System.out.printf("%6s %s\n", "1.", "Swiss Airline 예약 시스템");
		System.out.printf("%6s %s\n", "2.", "Taiwan Airline 예약 시스템");
		System.out.printf("%6s %s\n", "3.", "Seoul Airline 예약 시스템");
		System.out.printf("%6s %s\n", "4.", "전체 예약 현황 조회");
		System.out.printf("%6s %s\n", "0.", "예약 시스템 종료");
		System.out.println("--------------------------------------------------------");
		System.out.print("메뉴를 선택해주세요: ");
	}

}
