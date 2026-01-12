// 2025005847 박우현

public class GameBoard {
	String[][] board;
	private static final int ROW = 5;
	private static final int COL = 5;
	
	
	public GameBoard() {
		board = new String[ROW][COL];
		makeBoard();
	}
	
	private void makeBoard() {
		for(int i=0; i<ROW; i++) {
			for(int j=0; j<COL; j++) {
				board[i][j] = " ";
			}
		}
		int bombCount = 0;
		
		while(bombCount < 5) {
			int randomRow = (int)(Math.random() * ROW);
			int randomCol = (int)(Math.random() * COL);
			
			if(this.board[randomRow][randomCol].equals(" ")) {
				this.board[randomRow][randomCol] = "B";
				bombCount++;
			}
		}
	}
	
	synchronized public int getEmptyCellCount() {
		int ret = 0;
		
		for(int i=0; i<ROW; i++) {
			for(int j=0; j<COL; j++) {
				if(this.board[i][j].equals(" ") || this.board[i][j].equals("B")) ret++;
			}
		}
		
		return ret;
	}
	
	synchronized public void printBoard() {
		System.out.println("+------------------------+");
		for(int i=0; i<ROW; i++) {
			for(int j=0; j<COL; j++) {
				if(j==COL-1) {
					System.out.printf("| %2s |\n", this.board[i][j]);
				}else {
					System.out.printf("| %2s ", this.board[i][j]);
				}
			}
			System.out.println("+------------------------+");
		}
	}
	
	synchronized public int selectCell(int randomRow, int randomCol) {
		
		// 0 - 지뢰
		// 1 - 이미 선택
		// 2 - 성공
		
		String threadName = Thread.currentThread().getName();
		
		System.out.printf("%s: [%d][%d] select=> ", threadName, randomRow, randomCol);
		
		String cell = this.board[randomRow][randomCol];
		if(cell.equals("B")) {
			System.out.println("Mine found");
			String bombName = String.format("B%c", threadName.charAt(threadName.length()-1)); 
			board[randomRow][randomCol] = bombName;
			return 0;
		}else if(cell.equals(" ")) {
			System.out.println("SUCCESS");
			this.board[randomRow][randomCol] = threadName;
			return 2;
		}else {
			System.out.println("Another thread already chose.");
			return 1;
		}
	}
	
	
}
