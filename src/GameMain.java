


import javax.swing.JFrame;



	public class GameMain 
	{

		public static void main(String[] args){
			JFrame frame = new JFrame("ShootingStar");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			
			GamingPanel gamingPanel =new GamingPanel(frame);
			StartPanel startPanel =new StartPanel(frame);
			EndPanel endPanel = new EndPanel();
			
			GamePanel gamePanel =  GamePanel.getInstance();
			gamePanel.setPanel(startPanel, gamingPanel, endPanel);
			gamePanel.setPanel(Constants.Panel.StartPanel);
			//GamePanel startPanel setting
			
			//startPanel.setGamePanel(gamePanel);
			
			
			//Frame�� �Ű������� ������ ������ Panel���� Frame�� keyListener�� ��� �ϱ� ����
			frame.getContentPane().add(gamePanel);
			frame.pack();
			frame.setVisible(true);
		
			
		}
		
	}
