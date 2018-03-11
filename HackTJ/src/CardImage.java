import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class CardImage {
	private BufferedImage[][] images = new BufferedImage[4][13];
	public CardImage(){
		File pic = new File("src/Cards.png");
		try {
			BufferedImage bi = ImageIO.read(pic);
			for (int i = 0; i < 4; i++){
				for (int j = 0; j < 13; j++){
					images[i][j] = bi.getSubimage(30*j, 50*i, 30, 50);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage[][] getImages(){
		return images;
	}
	public ArrayList<BufferedImage> getImageList(){
		ArrayList<BufferedImage> list = new ArrayList<BufferedImage>();
		
		for (BufferedImage[] b : images){
			for (BufferedImage bb : b){
				list.add(bb);
			}
		}
		return list;
	}
	public int getIndex(Card c){
		Deck deck = new Deck();
		for (int i = 0; i < deck.size(); i++){
			if (c.uuid() == deck.get(i).uuid()){
				return i;
			}
		}
		return 0;
	}
	public BufferedImage getImageFromCard(Card c){
		int index = getIndex(c);
		return getImageList().get(index);
	}

}
