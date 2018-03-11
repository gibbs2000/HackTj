import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Blackjack extends JPanel{
	
	private Deck hand = new Deck(false);
	private Deck ourDeck = new Deck();
	private JButton startButton = new JButton("Start");
	private JButton hitButton = new JButton("Hit");
	private JButton stayButton = new JButton("Stay");
	
	public Blackjack() {
		JFrame frame = new JFrame("Thing");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		startButton.setBounds(250, 550, 100, 60);
		hitButton.setBounds(380, 550, 100, 60);
		stayButton.setBounds(510, 550, 100, 60);
		
		frame.setSize(900, 700);
		frame.setVisible(true);
		panel.add(startButton);
		panel.add(hitButton);
		panel.add(stayButton);
		frame.add(panel);
		frame.setTitle("Blackjack");
		
		
		startButton.setActionCommand("Start");
		hitButton.setActionCommand("Hit");
		stayButton.setActionCommand("Stay");
		}
	
    public void actionPerformed(ActionEvent ae) {

        String action = ae.getActionCommand();

        if (action.equals("Start")) {
        	this.start();
        }
        else if (action.equals("Hit")) {
        	this.hit();
        }
        else if (action.equals("Stay")) {
        	this.stay();
        }

    }

	
	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
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
	
	public void stay() {
		
	}
	
	public void start() {
		ourDeck.shuffle();
		ourDeck.draw(2, hand);
	}
	
    public static void main(String[] args) {
    	Blackjack game = new Blackjack();
    }
	
}