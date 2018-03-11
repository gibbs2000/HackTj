
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardImageTest {
	public static void main(String[] args){
		CardImage ci = new CardImage();
		BufferedImage[][] bis = ci.getImages();
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		JPanel panel = new JPanel(new FlowLayout());
		
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		
		for (BufferedImage[] b : bis){
			for (BufferedImage bb : b){
				images.add(bb);
			}
		}
		
		Card c = new Card(Suit.SPADES, 1);
		Card c2 = new Card(Suit.HEARTS, 13);
		
		JPanel cards = new JPanel(new GridLayout(4, 5));
		
		for(BufferedImage img: images){
			cards.add(new JLabel(new ImageIcon(img)));
		}
		//cards.setSize(new Dimension(400, 200));
		//cards.setSize(cards.getMaximumSize());
		//cards.add(new JLabel(new ImageIcon(ci.getImageFromCard(c))));
		//cards.add(new JLabel(new ImageIcon(ci.getImageFromCard(c2))));
		
		frame.add(cards, BorderLayout.NORTH);
		
		
		
		panel.add(new JButton("Deck of Cards"));
		frame.add(panel, BorderLayout.CENTER);
		
		Deck r = new Deck();
		r.shuffle();
		Card rand = r.get(0);
		JPanel randomCard = new JPanel(new FlowLayout());
		randomCard.add(new JLabel(new ImageIcon(ci.getImageFromCard(rand))));
		frame.add(randomCard, BorderLayout.SOUTH);
		
		
		frame.pack();
		frame.setSize(new Dimension(400, 400));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
