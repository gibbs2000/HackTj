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
	private JButton resetButton = new JButton("Reset");
	private int lastPlayerX, lastPlayerY;
	public boolean playerTurn;
	private CardImage c;
	private JFrame frame;

	public Blackjack() {
		frame = new JFrame("Thing");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		startButton.setBounds(250, 550, 100, 60);
		hitButton.setBounds(380, 550, 100, 60);
		stayButton.setBounds(510, 550, 100, 60);
		resetButton.setBounds(640, 550, 100, 60);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		panel.add(startButton);
		panel.add(hitButton);
		panel.add(stayButton);
		panel.add(resetButton);

		frame.add(panel);
		frame.setTitle("Blackjack");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		c = new CardImage();
		this.displayCards();

		startButton.setActionCommand("Start");
		hitButton.setActionCommand("Hit");
		resetButton.setActionCommand("Reset");
		stayButton.setActionCommand("Stay");

		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});

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

	public void hit(Deck h) {
		ourDeck.draw(1, h);
		playerTurn = !playerTurn;
		if (hand.valueOfHand() > 21)
			this.bust();

		if (hand.valueOfHand() == 21)
			this.win();
		if (compHand.valueOfHand() > 21) {
			this.win();
		}
		this.displayCards();
	}

	public void displayCards() {
		for (int i = 0; i < hand.size(); i++) {
			ImagePanel img = new ImagePanel(c.getImageFromCard(hand.get(i)), 100 + i * 30, 50);
			frame.add(img);
			this.repaint();
			this.revalidate();
		}
	}

	public void bust() {
		JOptionPane.showMessageDialog(null, "You have busted!", "Bust!", 0);
		System.out.println("You bust!");
	}

	public void win() {
		JOptionPane.showMessageDialog(null, "You won!", "Win!", 2);

		System.out.println("21!");
	}

	public void stay() {
		playerTurn = !playerTurn;
	}

	public void reset() {
		ourDeck.shuffleInto(hand);
		ourDeck.shuffleInto(compHand);
	}

	public void start() {
		reset();
		ourDeck.shuffle();
		ourDeck.draw(2, hand);
		ourDeck.draw(2, compHand);
	}

	public static void main(String[] args) {
		Blackjack game = new Blackjack();
	}

}