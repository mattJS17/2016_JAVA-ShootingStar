
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author  hyojun
 */
public class Animator {
	
	/**
	 * @uml.property  name="mFrames"
	 */
	private ArrayList<BufferedImage> mFrames;
	
	/**
	 * @uml.property  name="sprite"
	 */
	private BufferedImage sprite;
	
	/**
	 * @uml.property  name="running"
	 */
	private volatile boolean running = false;
	
	/**
	 * @uml.property  name="previousTime"
	 */
	private long previousTime;

	/**
	 * @uml.property  name="speed"
	 */
	private long speed;
	/**
	 * @uml.property  name="frameAtPause"
	 */
	private int frameAtPause;

	/**
	 * @uml.property  name="currentFrame"
	 */
	private int currentFrame=0;
	
	public Animator(ArrayList<BufferedImage> mSprite){
		mFrames = mSprite;
	}

	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public void update(long time){
		if(running){
			if(time-previousTime>= speed){
				currentFrame++;
				try{
				sprite = mFrames.get(currentFrame);
				}catch(IndexOutOfBoundsException e){
					currentFrame = 0;
					sprite = mFrames.get(currentFrame);
				}
				
				previousTime = time;
			}
		}
	}
	
	public BufferedImage getImage(){
		try{
		return mFrames.get(currentFrame);
		}catch(IndexOutOfBoundsException e){
			currentFrame = 0;
			return mFrames.get(currentFrame);
		}
	}
	
	
	
	public void run(){
		running = true;
		previousTime=0;
		frameAtPause=0;
		currentFrame=0;
	}
	
	public void stop(){
		running = false;
		previousTime=0;
		frameAtPause=0;
		currentFrame=0;
	}
	
	public void pause(){
		running=false;
		frameAtPause=currentFrame;
	}
	
	public void resume(){
		running=true;
		currentFrame=frameAtPause;
	}

}
