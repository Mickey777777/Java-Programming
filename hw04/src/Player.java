// 2025005847 박우현

public class Player extends Thread{
	private static final int ROW = 5;
	private static final int COL = 5;
	private GameBoard gameBoard;
	private int lifetime;
	private int selectedCount;
	
	public Player(String name, GameBoard gameBoard) {
		super(name);
		this.gameBoard = gameBoard;
		this.lifetime = 3;
		this.selectedCount = 0;
	}
	
	public void run() {
		while(true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(this.lifetime == 0) {
				break;
			}
			
			if(gameBoard.getEmptyCellCount() == 0) {
				break;
			}
			
			int randomRow = (int)(Math.random() * ROW);
			int randomCol = (int)(Math.random() * COL);
			
			int result = gameBoard.selectCell(randomRow, randomCol);
			
			if(result == 0) {
				this.lifetime--;
				System.out.printf("%s lifetime: %d\n", this.getName(), this.lifetime);
			}else if(result == 2) {
				this.selectedCount++;
			}
			
			this.gameBoard.printBoard();
			System.out.println();
		}
		
		System.out.printf("%s thread finished! (lifetime: %d)\n", this.getName(), this.lifetime);
	}
	
	public int getLifetime() {
		return this.lifetime;
	}
	
	public int getSelectedCount() {
		return this.selectedCount;
	}
}
