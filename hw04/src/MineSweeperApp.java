// 2025005847 박우현

import java.util.*;

public class MineSweeperApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameBoard gameBoard = new GameBoard();
		Player p1 = new Player("P1", gameBoard);
		Player p2 = new Player("P2", gameBoard);
		Player p3 = new Player("P3", gameBoard);
		
		System.out.println("==================================================");
		System.out.printf("%32s\n", "Mine Sweeper Game");
		System.out.println("==================================================");
		System.out.println();
		
		gameBoard.printBoard();
		System.out.println();
		System.out.println("Enter키를 누르면 게임이 시작됩니다.");
		sc.nextLine();
		
		p1.start();
		p2.start();
		p3.start();
		
		try {
			p1.join();
			p2.join();
			p3.join();
		}catch(InterruptedException e) {}
		
		System.out.println();
		System.out.println("[Game Result]");
		System.out.println("=======================");
		System.out.printf("%s selected: %d, remained lifetime: %d\n", p1.getName(), p1.getSelectedCount(), p1.getLifetime());
		System.out.printf("%s selected: %d, remained lifetime: %d\n", p2.getName(), p2.getSelectedCount(), p2.getLifetime());
		System.out.printf("%s selected: %d, remained lifetime: %d\n", p3.getName(), p3.getSelectedCount(), p3.getLifetime());
		
		sc.close();
	}

}
