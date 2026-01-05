import java.util.InputMismatchException;
import java.util.Scanner;

public class ReservationSystem implements ReservationInterface{
	String airline;
	int row;
	int col;
	Scanner sc;
	char[][] seats;
	int maxSeat;
	int curSeat;
	
	public ReservationSystem(String airline, Scanner sc, int row, int col) {
		this.airline = airline;
		this.sc = sc;
		this.row = row;
		this.col = col;
		makeSeats(row, col);
		this.maxSeat = row*col;
		this.curSeat = 0;
	}
	
	public void menu() {
		int cmd = -1;
		while(true) {
			try {
				System.out.println("-------------------------");
				System.out.printf(" %s\n", airline);
				System.out.printf(" %s\n", "1. 좌석 예약");
				System.out.printf(" %s\n", "2. 예약 취소");
				System.out.printf(" %s\n", "3. 예약 현황 조회");
				System.out.printf(" %s\n", "4. 메인 메뉴로 돌아가기");
				System.out.println("-------------------------");
				System.out.print("메뉴를 선택하세요: ");
				
				cmd = sc.nextInt();
				sc.nextLine();
				
				if(cmd == 1) {
					System.out.print("예약할 좌석 이름을 입력하세요: ");
					String seatName = sc.next();
					
					if(reserveSeat(seatName)) {
						System.out.printf("[예약 성공] %s\n", seatName);
						displaySeat(airline);
					}
					
				}else if(cmd == 2) {
					System.out.print("취소할 좌석 이름을 입력하세요: ");
					String seatName = sc.next();
					
					if(cancelSeat(seatName)) {
						System.out.printf("[예약 취소 성공] %s\n", seatName);
						displaySeat(airline);
					}
				}else if(cmd == 3) {
					displaySeat(airline);
				}else if(cmd == 4) {
					System.out.printf("%s 을 종료하고 메인 메뉴로 돌아갑니다.\n", airline);
					break;
				}else {
					System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요 (1~4)");
				}
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요 (1~4)");
				sc.nextLine();
			}
		}
		
		
		
	}
	
	
	@Override
	public void makeSeats(int row, int col) {
		seats = new char[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				seats[i][j] = ' ';
			}
		}
	}
	
	@Override
	public boolean reserveSeat(String seatName) {
		int[] seatArray = new int[2];
		
		if(!getSeatIndex(seatName, seatArray)) {
			System.out.printf("[예약 실패] %s\n", seatName);
			return false;
		}
		
		if(seats[seatArray[0]][seatArray[1]] == 'O') {
			System.out.printf("[예약 실패] %s: 이미 예약된 좌석입니다.\n", seatName);
			return false;
		}
		
		
		seats[seatArray[0]][seatArray[1]] = 'O';
		curSeat++;
		
		return true;
	}
	
	@Override
	public boolean cancelSeat(String seatName) {
		int[] seatArray = new int[2];
		
		if(!getSeatIndex(seatName, seatArray)) {
			System.out.printf("[예약 취소 실패] %s\n", seatName);
			return false;
		}
		
		if(seats[seatArray[0]][seatArray[1]] == ' ') {
			System.out.printf("[예약 취소 실패] %s: 예약 되지 않은 좌석입니다.\n", seatName);
			return false;
		}
		
		seats[seatArray[0]][seatArray[1]] = ' ';
		curSeat--;
		
		
		return true;
	}

	
	@Override
	public boolean getSeatIndex(String seatName, int seatArray[]) {
		
		boolean isDigit = true;
		for(int i=0; i<seatName.length()-1; i++) {
			char ch = seatName.charAt(i);
			if(Character.isDigit(ch) == false) {
				isDigit = false;
				break;
			}
		}
		
		if(!isDigit) {
			System.out.printf("%s: 숫자가 아닌 잘못된 좌석입니다.\n", seatName);
			return false;
		}
		
		char sRow = seatName.charAt(seatName.length()-1);
		String sCol = seatName.substring(0, seatName.length()-1);
		
		
		int iRow = sRow-'A';
		int iCol = Integer.parseInt(sCol)-1;
		

		if(iRow < 0 ) {
			System.out.printf("%s: 숫자가 아닌 잘못된 좌석입니다.\n", seatName);
			return false;
		}
		
		if(iRow >= row || iCol >= col) {
			System.out.printf("%s: 잘못된 좌석입니다.\n", seatName);
			return false;
		}
		
		//seatArray[0] = 'A' - sCol + row - 1;
		seatArray[0] = iRow;
		seatArray[1] = iCol;
		
		return true;
	}

	
	@Override
	public void displaySeat(String airline) {
		System.out.printf("\n[%s 예약 현황] 예약 좌석: %d/ 총 좌석: %d\n", airline, curSeat, maxSeat);
		System.out.println("-----------------------------------------------------------");
		for(int i=col-1;i>=0;i--) {
			for(int j=0;j<row;j++) {
				System.out.printf("[%2d%c] ",1+j,'A'+i);
			}
			System.out.println();
			for(int j=0;j<row;j++) {
				System.out.printf("   %c  ",this.seats[j][i]);
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------");
	}
	
	
}
