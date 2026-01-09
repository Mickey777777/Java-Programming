//2025005847 박우현


public class Card {
	String suit;
	String numString;
	
	public Card(String suit, String numString) {
		this.suit = suit;
		this.numString = numString;
	}
	
	@Override
	public String toString() {
		return String.format("(%s%5s)", this.suit, this.numString);
	}
}
