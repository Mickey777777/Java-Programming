// 2025005847 박우현


public class Airline {
	String airline;
	int row;
	int col;
	int[][] seat;
	
	public Airline(String airline, int row, int col) {
		this.airline = airline;
		this.row = row;
		this.col = col;
		makeSeat();
	}
	
	public void makeSeat() {
		seat = new int[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				seat[i][j] = 0;
			}
		}
	}
	
	public boolean getSeatIndex(String seatName, int seatArray[]) {
		
		int len = seatName.length();
		
		if(len<=1 || len>=4) {
			System.out.println("Wrong seat name. Type again");
			return false;
		}
		
		int iRow = 0;
		int iCol = 0;
		
		if(len == 2) {
			iRow = 'A' - seatName.charAt(1) + row - 1;
			iCol = Integer.parseInt(seatName.substring(0, len-1)) - 1;
			System.out.printf("rowChar: %s, colString: %s\n", seatName.charAt(1), seatName.charAt(0));
		}else if(len == 3) {
			iRow = 'A' - seatName.charAt(2) + row - 1;
			iCol = Integer.parseInt(seatName.substring(0, len-1)) - 1;
			System.out.printf("rowChar: %s, colString: %s\n", seatName.charAt(2), seatName.substring(0, 2));
		}
		
		
		if(iCol >= col || iCol < 0) {
			System.out.printf("Invalid column index: [%d]\n", iCol);
			return false;
		}
		
		if(iRow >= row || iRow < 0) {
			System.out.printf("Invalid row index: [%d]\n", iRow);
			return false;
		}
		
		
		//seatArray[0] = 'A' - sCol + row - 1;
		seatArray[0] = iRow;
		seatArray[1] = iCol;
		
		return true;
	}
	
	
	public void displaySeats() {
		System.out.println("+-----------------------------------------------------------+");
		System.out.printf(" %s 항공사 예약 현황\n", airline);
		System.out.println("+-----------------------------------------------------------+");
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.printf("| %2d%c ", j+1, row-i+'A'-1);
			}
			System.out.print("|\n");
			System.out.println("+-----------------------------------------------------------+");
			for(int j=0; j<col; j++) {
				System.out.printf("|   %c ", seat[i][j] == 1 ? 'O' : 'X');
			}
			System.out.print("|\n");
			System.out.println("+-----------------------------------------------------------+");
		}
	}
	
	public boolean reservation(int[] seatArray) {
		if(seat[seatArray[0]][seatArray[1]] == 1) {
			System.out.println("Reservation Fail(Reserved Seat)");
			return false;
		}
		
		seat[seatArray[0]][seatArray[1]] = 1;
		System.out.println("Reservation Success");
		
		return true;
	}
	
}
