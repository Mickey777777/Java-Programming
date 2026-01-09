//2025005847 박우현

import java.util.*;

public class GameDealer {
	private static final int COMPUTER_CARD_NUM = 27;
	private static final int HUMAN_CARD_NUM = 26;
	
	List<Card> deck;
	
	public GameDealer() {
		deck = new ArrayList<>();
		makeDeck();
	}
	
	private void makeDeck() {
		String[] suit = {"♣", "♠", "◆", "♥"}; // Joker: 🃟 (Joker suit)
		String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String joker = "Joker";
		String jokerSuit = "🃟";
		
		for(String s : suit) {
			for(String n : number) {
				deck.add(new Card(s, n));
			}
		}
		
		deck.add(new Card(jokerSuit, joker));
		
	}
	
	public void shuffle() {
		Collections.shuffle(this.deck);
	}
	
	public void deal(Player computer, Player human) {
		for(int i=0; i<COMPUTER_CARD_NUM; i++) {
			computer.holdingCardList.add(deck.get(0));
			deck.remove(0);
		}
		
		for(int i=0; i<HUMAN_CARD_NUM; i++) {
			human.holdingCardList.add(deck.get(0));
			deck.remove(0);
		}
	}
	
}
