

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card>{
	ArrayList<Card> missing = new ArrayList<Card>();
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
	public ArrayList<Card> getMissing(){
		return missing;
	}
	public void draw(int num, ArrayList<Card> hand){
		for (int i = 0; i < num; i++){
			hand.add(this.get(0));
			missing.add(this.get(0));
			this.remove(0);
		}
	}
	public void addCard(Card c){
		for (int i = 0; i < missing.size(); i++){
			if (missing.get(i).uuid() == c.uuid()){
				this.add(c);
				return;
			}
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
