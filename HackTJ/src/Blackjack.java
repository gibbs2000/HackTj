import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Blackjack extends JPanel{
	
	private Deck hand = new Deck(false);
	private Deck ourDeck = new Deck();
	
	public Blackjack() {
        setPreferredSize(new Dimension(900, 700));
        setBackground(new Color(0xFAF8EF));
        setFont(new Font("SansSerif", Font.BOLD, 48));
        setFocusable(true);
        
	}
	
	public void hit() {
		ourDeck.draw(1, hand);
		if(hand.valueOfHand() > 21)
			this.bust();
		if(hand.valueOfHand() == 21)
			this.win();
	}
	
	public void bust() {
		System.out.println("You bust!");
	}
	
	public void win() {
		System.out.println("21!");
	}
	
	public void start() {
		ourDeck.shuffle();
		ourDeck.draw(2, hand);
	}
	
	
}