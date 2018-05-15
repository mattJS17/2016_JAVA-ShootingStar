import java.awt.image.BufferedImage;

/**
 * @author  hyojun
 */
public class SpriteSheet {
	
	/**
	 * @uml.property  name="mSpriteSheet"
	 */
	private BufferedImage mSpriteSheet;
	
	public SpriteSheet(BufferedImage spriteSheet){
		mSpriteSheet = spriteSheet;
	}
	public BufferedImage grabSprite(int x,int y,int width,int height){
		BufferedImage sprite = mSpriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}
	

}

