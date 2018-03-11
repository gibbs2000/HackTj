

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card>{
	public Deck(){
		for (Suit suit: Suit.values()){
			for (int i = 1; i < 14; i++){
				this.add(new Card(suit, i));
			}
		}
	}
	public Deck(boolean b){
		super();
	}
	public void draw(int num, ArrayList<Card> hand){
		for (int i = 0; i < num; i++){
			hand.add(this.get(0));
			this.remove(0);
		}
	}
	public int valueOfHand(){
		int val = 0;
		for (Card c:this){
			val += c.getValue();
		}
		return val;
	}
	
	public void shuffle(){
		Collections.shuffle(this);
	}
	public void sort(){
		Collections.sort(this);
	}

}
