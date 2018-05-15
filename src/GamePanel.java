import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * @author  hyojun
 */
public class GamePanel extends JPanel{
	
	/**
	 * @uml.property  name="startPanel"
	 * @uml.associationEnd  inverse="gamePanel:StartPanel"
	 */
	private  StartPanel startPanel;
	/**
	 * @uml.property  name="gamingPanel"
	 * @uml.associationEnd  
	 */
	private  GamingPanel gamingPanel;
	/**
	 * @uml.property  name="endPanel"
	 * @uml.associationEnd  
	 */
	private  EndPanel endPanel;
	
	private static GamePanel gamePanel=null;
	/**
	 * @uml.property  name="currentPanel"
	 */
	private int currentPanel ;
	
	public static GamePanel getInstance()
	{ //SingleTon pattern
		if(gamePanel == null)
		{
			gamePanel = new GamePanel();
		}
		return gamePanel;
	}
	
	private GamePanel(){ //window size setting
		setPreferredSize(new Dimension(1200, 900));
		setLayout(null);	
	}
	
	public void setPanel(StartPanel startPanel,GamingPanel gamingPanel,EndPanel endPanel)
	{
		this.startPanel = startPanel;
		this.gamingPanel = gamingPanel;
		this.endPanel = endPanel;
		startPanel.setBounds(0,0,1200,900);
		gamingPanel.setBounds(0,0,1200,900);
		endPanel.setBounds(0,0,1200,900);
	}
	
	public void removePanel(int currentPanel)
	{
		switch(currentPanel)
		{
		case Constants.Panel.StartPanel:
			gamePanel.remove(startPanel);
			break;
		case Constants.Panel.GamingPanel:
			gamePanel.remove(gamingPanel);
			break;
		case Constants.Panel.EndPanel:
			gamePanel.remove(endPanel);
			break;
		}
	}

	
	public void setPoint(int Point)
	{
		endPanel.setPoint(Point);
	}
	
	public  void setPanel(int i)
	{
		currentPanel = i;
		switch(i)
		{
		case Constants.Panel.StartPanel:
			gamePanel.add(startPanel);
			break;
		case Constants.Panel.GamingPanel:
			gamingPanel.start();
			gamePanel.add(gamingPanel);
			break;
		case Constants.Panel.EndPanel:
			gamePanel.add(endPanel);
			gamePanel.repaint();
			break;
		}
	}

}
