//2025005847 박우현

import java.util.*;

public class Player {
	String name;
	List<Card> openCardList;
	List<Card> holdingCardList;
	
	public Player(String name) {
		this.name = name;
		this.openCardList = new ArrayList<>();
		this.holdingCardList = new ArrayList<>();
	}
	
	public void printCard() {
		System.out.printf("[%s]\n", this.name);
		System.out.printf("Open card list: %d\n", this.openCardList.size());
		for(int i=0; i<openCardList.size(); i++) {
			System.out.printf("%s", this.openCardList.get(i));
			if((i+1)%10==0 || i==openCardList.size()-1) System.out.println();
		}
		
		if(openCardList.size() == 0) System.out.println();
		
		System.out.printf("Holding card list: %d\n", this.holdingCardList.size());
		for(int i=0; i<holdingCardList.size(); i++) {
			System.out.printf("[%2d]%s", i, this.holdingCardList.get(i));
			if((i+1)%10==0 || i==holdingCardList.size()-1) System.out.println();
		}
		
	}
	
	public void checkSameCard() {
		int i=0;
		
		while(i < this.holdingCardList.size()) {
			Card card = this.holdingCardList.get(i);
			boolean found = false;
			
			for(int j=i+1; j<this.holdingCardList.size(); j++) {
				Card dupCard = this.holdingCardList.get(j);
				if(dupCard.numString.equals(card.numString)) {
					
					openCardList.add(card);
					openCardList.add(dupCard);
					
					this.holdingCardList.remove(card);
					this.holdingCardList.remove(dupCard);
					
					found = true;
					break;
				}
			}
			
			if(!found) i++;
		}				
	}
	
	public void chooseCard(Player p, List<Card> availableCard) {
		int availableCardSize = availableCard.size();
		int randomIdx = (int)(Math.random() * availableCardSize);
		
		Card choose = availableCard.get(randomIdx);
		
		this.holdingCardList.add(choose);
		p.holdingCardList.remove(choose);

		System.out.printf("%-8s: %-12s[%2d]%s 가져옴 \n", this.name, p.name+" 의", randomIdx, choose);
		
		checkSameCard();
	}
}
