import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author  hyojun
 */
public class MainPanel extends JPanel{
	
	/**
	 * @uml.property  name="mframe"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JFrame mframe;
	
	/**
	 * @uml.property  name="objectArray"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Character"
	 */
	private ArrayList<Objects> ObjectArray;
	
	/**
	 * @uml.property  name="mCharacter"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Character mCharacter;
	
	/**
	 * @uml.property  name="mGameThread"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private GameThread mGameThread;
	
	/**
	 * @uml.property  name="mGameLogic"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private GameLogic mGameLogic;
	
	/**
	 * @uml.property  name="obFactory"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ObjectFactory ObFactory;
	
	/**
	 * @uml.property  name="backgroundImage"
	 */
	private BufferedImage backgroundImage;
	
	/**
	 * @uml.property  name="panel"
	 * @uml.associationEnd  inverse="mainPanel:GamingPanel"
	 */
	private GamingPanel panel;
	
	public void setGameStart()
	{
		try {
			//image 경로 찾아가서 image가져오기
			backgroundImage =ImageIO.read(new File(Constants.MainPanel.Background));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
		ObjectArray = new ArrayList<Objects>();
		ObFactory = ObjectFactory.getInstance();
		//ObjectArray , Factory Init
		
		ObjectArray.add(ObFactory.CreateObject(Constants.Factory.Player, 100, 100));
		mCharacter = (Character)ObjectArray.get(0);
		mCharacter.getImage();
		//Player SpaceShip Create
		
		mGameLogic = GameLogic.getInstance(); //get GameLogic
		mGameLogic.setFrame(mframe); // set Frame
		
		
		mGameLogic.setGameObjects(ObjectArray);
		//GameLogic에 ObjectArray 넘기기 
		
	
		mGameThread = new GameThread(mframe); //Thread Create
		mGameLogic.setThread(mGameThread);//Logic에 Thread 넘기기 
		mGameThread.start(); // Thread run
	}
	
	public void setGamingPanel(GamingPanel panel)
	{
		this.panel = panel; //GamingPanel에서 Hp 와 Point Update를 위한 UpCall
	}
	
	public MainPanel(JFrame frame)
	{	
		mframe = frame;
		setPreferredSize(new Dimension(Constants.MainPanel.Width,Constants.MainPanel.Height));
		MyKeyListener keyListener = new MyKeyListener();
		mframe.addKeyListener(keyListener);
		
		frame.pack();
		mframe.setFocusable(true);
		mframe.requestFocusInWindow();
		
		setGameStart();
	}
	
	public int getPoint()
	{
		return mGameLogic.getPoint();
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		g.drawImage(backgroundImage,0,0,this);
		int total = ObjectArray.size();
		for(int i=0;i<total;i++){
			ObjectArray.get(i).Draw(g, this);
			total = ObjectArray.size();
		}
		
		panel.Update(mGameLogic.getHP(), mGameLogic.getPoint());
		
	}

	
	private class MyKeyListener extends KeyAdapter{
		  public void keyPressed(KeyEvent e){
		   int key = e.getKeyCode();
		   switch(key){
		   case KeyEvent.VK_UP:  //방향키가 눌리면 Player 에 있는 각 방향마다 bool값을 true, false로 조정
			   	mCharacter.setUpFlag(true);
		    break;
		   case KeyEvent.VK_DOWN:
			   mCharacter.setDownFlag(true);
		    break;
		   case KeyEvent.VK_LEFT:
			   mCharacter.setLeftFlag(true);
		    break;
		   case KeyEvent.VK_RIGHT:
			   mCharacter.setRightFlag(true);
		
		    break;
		    
		   case KeyEvent.VK_W:  //WASD로 각 방향 총알 발싸
				mCharacter.setShootUpFlag(true);
			   break;
		   case KeyEvent.VK_A:
			   mCharacter.setShootLEFTFlag(true);
			   break;
		   case KeyEvent.VK_S:
			   mCharacter.setShootDOWNFlag(true);
			   break;
		   case KeyEvent.VK_D:
			   mCharacter.setShootRIGHTFlag(true);
			   break;
			   
		    
		   }
		   
		  }
		  
	public void keyReleased(KeyEvent e){
			  int key = e.getKeyCode();
			   switch(key){
			   case KeyEvent.VK_UP:
				   mCharacter.setUpFlag(false);
			    break;
			    
			   case KeyEvent.VK_DOWN:
				   mCharacter.setDownFlag(false);
			    break;
			    
			   case KeyEvent.VK_LEFT:
				   mCharacter.setLeftFlag(false);
			    break;
			    
			   case KeyEvent.VK_RIGHT:
				   mCharacter.setRightFlag(false);
			    break;
			    
			   case KeyEvent.VK_W:  //WASD로 각 방향 총알 발싸
					mCharacter.setShootUpFlag(false);
				   break;
			   case KeyEvent.VK_A:
				   mCharacter.setShootLEFTFlag(false);
				   break;
			   case KeyEvent.VK_S:
				   mCharacter.setShootDOWNFlag(false);
				   break;
			   case KeyEvent.VK_D:
				   mCharacter.setShootRIGHTFlag(false);
				   break;
				   
			   } 
		  }
	} 
	
	
}
