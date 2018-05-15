


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
			
			
			//Frame을 매개변수로 보내는 이유는 Panel에서 Frame에 keyListener를 등록 하기 위함
			frame.getContentPane().add(gamePanel);
			frame.pack();
			frame.setVisible(true);
		
			
		}
		
	}
