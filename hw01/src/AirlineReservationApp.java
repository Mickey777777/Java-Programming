// 2025005847 박우현

import java.util.Scanner;

public class AirlineReservationApp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Airline airline = new Airline(4, 10);
		
		airline.displaySeats();
		
		while(true) {
			System.out.print("좌석이름을 입력하세요: ");
			String seatName = sc.nextLine();
			int[] seatArray = new int[2];
			
			if(seatName.equals("quit")) 
				break;
			
			if(!airline.getSeatIndex(seatName, seatArray)) 
				continue;

			System.out.printf("[%d][%d] -> ", seatArray[0], seatArray[1]);
			
			if(!airline.reservation(seatArray)) 
				continue;
			
			airline.displaySeats();	
		}
		System.out.println("프로그램 종료");
		sc.close();
	}
	
}
