import java.util.Scanner;

public class SeoulAirline extends ReservationSystem{

	public SeoulAirline(String airline, Scanner sc, int row, int col) {
		super(airline, sc, row, col);
	}
	
	@Override
	public void displaySeat(String airline) {
		System.out.println();
		System.out.printf("[%s 예약 현황] 예약 좌석: %d/ 총 좌석: %d\n", airline, curSeat, maxSeat);
		System.out.println("-----------------------------------------------------------");
		
		for(int i=3; i>=2; i--) {
			for(int j=0; j<col; j++) {
				System.out.printf("[%2d%c] ", j+1, 'A'+i);
			}
			System.out.println();
			
			for(int j=0; j<col; j++) {
				System.out.printf("%4s  ", seats[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------");
		System.out.println("  앞                       통로                         뒤");
		System.out.println("-----------------------------------------------------------");
		
		for(int i=1; i>=0; i--) {
			for(int j=0; j<col; j++) {
				System.out.printf("[%2d%c] ", j+1, 'A'+i);
			}
			System.out.println();
			
			for(int j=0; j<col; j++) {
				System.out.printf("%4s  ", seats[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------------------------------------");
		
	}
	

}
