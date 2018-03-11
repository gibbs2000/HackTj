

public class Card implements Comparable<Card>{
	private Suit suit;
	private int value;
	
	public Card(Suit s, int val){
		this.suit = s;
		this.value = val;
	}
	public int uuid(){
		int increment = 0;
		switch (getSuit()){
		case HEARTS:
			increment = 0;
			break;
		case SPADES:
			increment = 1;
			break;
		case DIAMONDS:
			increment = 2;
			break;
		case CLUBS:
			increment = 3;
			break;
		}
		return increment*13+getValue();
	}
	
	@Override
	public int compareTo(Card o) {
		return uuid()-o.uuid();
	}


	public Suit getSuit() {
		return suit;
	}


	public void setSuit(Suit suit) {
		this.suit = suit;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}

}
