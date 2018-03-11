import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Blackjack extends JPanel {

	private Deck hand = new Deck(false);
	private Deck compHand = new Deck(false);
	private Deck ourDeck = new Deck();
	private JButton startButton = new JButton("Start");
	private JButton hitButton = new JButton("Hit");
	private JButton stayButton = new JButton("Stay");
	public boolean playerTurn;

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

		stayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stay();
			}
		});

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});

		hitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (playerTurn)
					hit(hand);
				else
					hit(compHand);
			}
		});

	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}

	public void hit(Deck h) {
		ourDeck.draw(1, h);
		playerTurn = !playerTurn;
		if (hand.valueOfHand() > 21)
			this.bust();

		if (hand.valueOfHand() == 21)
			this.win();

	}

	public void bust() {
		JOptionPane.showMessageDialog(null, "You have busted!", "Bust!", 0);
		System.out.println("You bust!");
	}

	public void win() {
		JOptionPane.showMessageDialog(null, "You won!", "Win!", 1);

		System.out.println("21!");
	}

	public void stay() {
		playerTurn = !playerTurn;
	}

	public void reset() {

	}

	public void start() {
		ourDeck.shuffle();
		ourDeck.draw(2, hand);
		ourDeck.draw(2, compHand);
	}

	public static void main(String[] args) {
		Blackjack game = new Blackjack();
	}

}