// 2025005847 박우현

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReservationSystem implements ReservationInterface{
	String systemTitle;
	int row;
	int col;
	Scanner sc;
	int[][] seats;
	int maxSeat;
	int curSeat;
	
	public ReservationSystem(String systemTitle, Scanner sc, int row, int col) {
		this.systemTitle = systemTitle;
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
				System.out.printf(" %s 예약 시스템\n", systemTitle);
				System.out.printf(" %s\n", "1. 좌석 예약");
				System.out.printf(" %s\n", "2. 예약 취소");
				System.out.printf(" %s\n", "3. 예약 현황 조회");
				System.out.printf(" %s\n", "4. 메인 메뉴로 돌아가기");
				System.out.println("-------------------------");
				System.out.print(" 번호를 선택해주세요: ");
				
				cmd = sc.nextInt();
				sc.nextLine();
				
				if(cmd == 1) {
					System.out.print("예약할 좌석 이름을 입력하세요: ");
					String seatName = sc.next();
					
					if(reserveSeat(seatName) == 0) {
						displaySeat(systemTitle);
					}
					
				}else if(cmd == 2) {
					System.out.print("취소할 좌석 이름을 입력하세요: ");
					String seatName = sc.next();
					
					if(cancelSeat(seatName) == 0) {
						displaySeat(systemTitle);
					}
				}else if(cmd == 3) {
					displaySeat(systemTitle);
				}else if(cmd == 4) {
					System.out.printf("%s 예약 시스템을 종료하고 메인 메뉴로 돌아갑니다.\n", systemTitle);
					break;
				}else {
					System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요(1~4).");
				}
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 선택입니다. 숫자를 다시 입력해주세요 (1~4)");
				sc.nextLine();
			}
		}
		
		
		
	}
	
	
	@Override
	public void makeSeats(int row, int col) {
		seats = new int[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				seats[i][j] = 0;
			}
		}
	}
	
	@Override
	public int reserveSeat(String seatName) {
		int[] seatArray = new int[2];
		
		if(!getSeatIndex(seatName, seatArray)) {
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
			return -1;
		}
		
		if(seats[seatArray[0]][seatArray[1]] == 1) {
			System.out.printf("[예약 실패] %s: 이미 예약된 좌석입니다.\n", seatName);
			return -1;
		}
		
		System.out.printf("[예약 성공] %s\n", seatName);
		
		seats[seatArray[0]][seatArray[1]] = 1;
		curSeat++;
		
		return 0;
	}
	
	@Override
	public int cancelSeat(String seatName) {
		int[] seatArray = new int[2];
		
		if(!getSeatIndex(seatName, seatArray)) {
			System.out.println("[예약 취소 실패]: 잘못된 좌석 이름입니다.");
			return -1;
		}
		
		if(seats[seatArray[0]][seatArray[1]] == 0) {
			System.out.printf("[예약 취소 실패] %s: 예약 되지 않은 좌석입니다.\n", seatName);
			return -1;
		}
		
		seats[seatArray[0]][seatArray[1]] = 0;
		curSeat--;
		
		System.out.printf("[예약 취소 성공] %s\n", seatName);
		return 0;
	}

	
	public boolean getSeatIndex(String seatName, int seatArray[]) {
		
		if(seatName.length() != 2 && seatName.length() != 3) { // 길이가 안맞는경우	
			return false;
		}
		
		boolean isDigit = true;
		
		String sCol = seatName.substring(0, seatName.length()-1);
		
		for(int i=0; i<sCol.length(); i++) {
			char ch = sCol.charAt(i);
			if(Character.isDigit(ch) == false) {
				isDigit = false;
				break;
			}
		}
		
		if(!isDigit) {
			System.out.printf("%s: 숫자가 아닌 잘못된 좌석 이름입니다.\n", seatName);
			return false;
		}
		
		if(Character.isDigit(seatName.charAt(seatName.length()-1)) == true) {
			return false;
		}
		
		
		int iRow = 'A' - seatName.charAt(seatName.length()-1) + row - 1;
		int iCol = Integer.parseInt(sCol)-1;
		

		if(iCol >= col || iCol < 0) {
			System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n", seatName);
			return false;
		}
		
		if(iRow >= row || iRow < 0) {
			System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n", seatName);
			return false;
		}
		
		//seatArray[0] = 'A' - sCol + row - 1;
		seatArray[0] = iRow;
		seatArray[1] = iCol;
		
		return true;
	}

	
	@Override // 자식에서 재정의
	public void displaySeat(String systemTitle) {
		System.out.printf("[%s 예약 시스템 예약 현황] 예약 좌석: %d/ 총 좌석: %d\n", systemTitle, curSeat, maxSeat);
		System.out.println();
		
		for(int i=0; i<row; i++) {
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
