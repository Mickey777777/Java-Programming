// 2025005847 박우현

import java.util.Scanner;

public class AirlineSystem extends ReservationSystem{

	public AirlineSystem(String systemTitle, Scanner sc, int row, int col) {
		super(systemTitle, sc, row, col);
	}
	
	@Override
	public void displaySeat(String systemTitle) {
		System.out.printf("[%s 예약 시스템 예약 현황] 예약 좌석: %d/ 총 좌석: %d\n", systemTitle, curSeat, maxSeat);
		System.out.println();
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<col; j++) {
				System.out.printf("[%2d%c] ", j+1, row-i+'A'-1);
			}
			System.out.println();
			
			for(int j=0; j<col; j++) {
				System.out.printf("%4s  ", seats[i][j] == 1 ? "X" : "O");
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("  앞                       통로                           뒤");
		System.out.println("-----------------------------------------------------------");
		
		for(int i=2; i<4; i++) {
			for(int j=0; j<col; j++) {
				System.out.printf("[%2d%c] ", j+1, row-i+'A'-1);
			}
			System.out.println();
			
			for(int j=0; j<col; j++) {
				System.out.printf("%4s  ", seats[i][j] == 1 ? "X" : "O");
			}
			System.out.println();
		}
		
		
	}
	

}
