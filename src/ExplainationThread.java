import java.awt.*;
import javax.swing.*;

/**
 * @author  hyojun
 */
public class ExplainationThread extends JPanel implements Runnable {

	/**
	 * @uml.property  name="explaination"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon explaination;
	/**
	 * @uml.property  name="imgExSet"
	 */
	private Image imgExSet;
	/**
	 * @uml.property  name="imgExGet"
	 */
	private Image imgExGet;
	
	/**
	 * @uml.property  name="lblExplaination"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblExplaination;
	/**
	 * @uml.property  name="delayTime"
	 */
	private int delayTime;
	/**
	 * @uml.property  name="upThread"
	 */
	private Thread upThread;
	/**
	 * @uml.property  name="gamePanel"
	 * @uml.associationEnd  
	 */
	private GamePanel gamePanel;
	/**
	 * @uml.property  name="startPanel"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="explainationTh:StartPanel"
	 */
	private StartPanel startPanel;
	/**
	 * @uml.property  name="frame"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JFrame frame;

	public ExplainationThread(StartPanel startPanel,JFrame frame) {
		setPreferredSize(new Dimension(600, 900));
		setBackground(Color.black);
		setLayout(null);
		
		this.frame = frame;

		this.startPanel = startPanel;
		
		
		upThread = null;
		delayTime = 30;
		upThread = new Thread(this);

		explaination = new ImageIcon("explaination.png");
		imgExSet = explaination.getImage();
		imgExGet = imgExSet.getScaledInstance(600, 900, java.awt.Image.SCALE_SMOOTH);
		explaination.setImage(imgExGet);

		lblExplaination = new JLabel(explaination);
		lblExplaination.setBounds(0, 850, 600, 900);
		add(lblExplaination);
	}
	
	/**
	 * @param  gamePanel
	 * @uml.property  name="gamePanel"
	 */
	public void setGamePanel(GamePanel gamePanel)
	{
		this.gamePanel = gamePanel;
	}



	@Override
	public void run() {
		for (int i = 1; i < 100; i++) {

			lblExplaination.setBounds(0, 850 - i*10 , 600, 900);
			try {
				Thread.sleep(delayTime);
			} catch (Exception e) {

			}
		}
		gamePanel.removePanel(Constants.Panel.StartPanel);
		gamePanel.setPanel(Constants.Panel.GamingPanel);
		

		

		
		
		
	}
}
