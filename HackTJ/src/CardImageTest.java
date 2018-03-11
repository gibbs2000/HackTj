import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardImageTest {
	public static void main(String[] args){
		CardImage ci = new CardImage();
		BufferedImage[][] bis = ci.getImages();
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		
		for (BufferedImage[] b : bis){
			for (BufferedImage bb : b){
				images.add(bb);
			}
		}
		
		Card c = new Card(Suit.SPADES, 1);
		int index = ci.getIndex(c);
		frame.getContentPane().add(new JLabel(new ImageIcon(ci.getImageFromCard(c))));
		frame.pack();
		frame.setVisible(true);
	}
}
