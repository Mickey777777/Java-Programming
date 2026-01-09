//2025005847 박우현

import java.util.*;

public class FindingJokerApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameDealer gameDealer = new GameDealer();
		
		Player computer = new Player("Computer");
		Player human = new Player("Human");
		
		System.out.println("<< 카드 생성 >>");
		
		for(int i=1; i<=gameDealer.deck.size(); i++) {
			System.out.print(gameDealer.deck.get(i-1));
			if(i%13==0) System.out.println();
		}
		System.out.println();
		System.out.println();
		
		System.out.println("다음 단계 게임 진행을 위해 Enter 키를 누르세요!");
		sc.nextLine();
		
		gameDealer.shuffle();
		gameDealer.deal(computer, human);
		
		System.out.println("<< 1 단계 >>");
		System.out.println("딜러가 나누어 준 카드");
		System.out.println("---------------------------------------------------------------------------------");
		computer.printCard();
		System.out.println("---------------------------------------------------------------------------------");
		human.printCard();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("다음 단계 게임 진행을 위해 Enter 키를 누르세요!");
		sc.nextLine();
		
		int stage = 2;
		
		while(true) {
			System.out.printf("<<%3d 단계 >>: 같은 번호를 가지는 카드 공개\n", stage++);
			System.out.println();
			
			computer.checkSameCard();
			computer.printCard();
			System.out.println("---------------------------------------------------------------------------------");
			human.checkSameCard();
			human.printCard();
			System.out.println("---------------------------------------------------------------------------------");
			
			if(computer.holdingCardList.size() <= 1 || human.holdingCardList.size() <= 1) {
				break;
			}
			
			System.out.println("상대방의 카드 한 장 선택");
			
			List<Card> humanCards = new ArrayList<>(human.holdingCardList);
			List<Card> computerCards = new ArrayList<>(computer.holdingCardList);
			
			computer.chooseCard(human, humanCards);
			human.chooseCard(computer, computerCards);
			System.out.println("---------------------------------------------------------------------------------");
			computer.printCard();
			System.out.println("---------------------------------------------------------------------------------");
			human.printCard();
			System.out.println("---------------------------------------------------------------------------------");
			
			
			
			System.out.println("다음 단계 게임 진행을 위해 Enter 키를 누르세요!");
			sc.nextLine();
		}
		
		String jokerName = whoHasJoker(computer, human);
		
		System.out.printf("경기 종료: %s 이 Joker 를 가지고 있음", jokerName);
		sc.close();
	}
	
	private static String whoHasJoker(Player computer, Player human) {
		for(Card card : computer.holdingCardList) {
			if(card.numString.equals("Joker")) {
				return computer.name;
			}
		}
		
		return human.name;
	}

}
