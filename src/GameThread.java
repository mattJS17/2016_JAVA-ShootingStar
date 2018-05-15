import javax.swing.JFrame;


/**
 * @author  hyojun
 */
public class GameThread extends Thread{
	
	/**
	 * @uml.property  name="mFrame"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JFrame mFrame;
	
	/**
	 * @uml.property  name="mLogic"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="thread:GameLogic"
	 */
	private GameLogic mLogic;
	private long GameTime;
	private int FPS = 50;//50fps
	
	
	public  GameThread(JFrame frame){
		mFrame = frame; //repaint를 위해 Thread에서 frame 받기
		mLogic = GameLogic.getInstance();
	}
	
	
	@Override
	public void run(){
		while(mLogic.getRunning()){
	
			if(GameTime + (1000/FPS) <= System.currentTimeMillis()){
			mFrame.repaint(); //re Draw
			mLogic.Update(); // Game Update
			GameTime = System.currentTimeMillis();
			}
			
		}
	}

}
