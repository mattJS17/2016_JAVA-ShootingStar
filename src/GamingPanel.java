import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author  hyojun
 */
public class GamingPanel extends JPanel {

	/**
	 * @uml.property  name="gameScreenPanel"
	 * @uml.associationEnd  
	 */
	private JPanel GameScreenPanel;
	/**
	 * @uml.property  name="backgroundIcon"
	 * @uml.associationEnd  
	 */
	private ImageIcon backgroundIcon;

	/**
	 * @uml.property  name="lblHP"
	 * @uml.associationEnd  
	 */
	private JLabel lblHP;
	/**
	 * @uml.property  name="hPBackgroundPanel"
	 * @uml.associationEnd  
	 */
	private HPDrawPanel HPBackgroundPanel;

	/**
	 * @uml.property  name="lblScore"
	 * @uml.associationEnd  
	 */
	private JLabel lblScore;
	/**
	 * @uml.property  name="lblOnlyScore"
	 * @uml.associationEnd  
	 */
	private JLabel lblOnlyScore;
	/**
	 * @uml.property  name="score"
	 */
	private int Score;

	/**
	 * @uml.property  name="bntExit"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton bntExit;
	/**
	 * @uml.property  name="exit"
	 * @uml.associationEnd  readOnly="true"
	 */
	private ImageIcon exit;
	/**
	 * @uml.property  name="exit_Press"
	 * @uml.associationEnd  readOnly="true"
	 */
	private ImageIcon exit_Press;
	/**
	 * @uml.property  name="ex"
	 * @uml.associationEnd  readOnly="true" inverse="this$0:GamingPanel$Exit"
	 */
	private Exit ex;
	/**
	 * @uml.property  name="mex"
	 * @uml.associationEnd  readOnly="true" inverse="this$0:GamingPanel$mouseExit"
	 */
	private mouseExit Mex;
	
	/**
	 * @uml.property  name="mainPanel"
	 * @uml.associationEnd  inverse="panel:MainPanel"
	 */
	private MainPanel mainPanel;
	/**
	 * @uml.property  name="startPanel"
	 * @uml.associationEnd  readOnly="true"
	 */
	private StartPanel startPanel;

	/**
	 * @uml.property  name="frame"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JFrame frame;
	
	public void start()
	{
		backgroundIcon = new ImageIcon("Gaming_Background.png");

		GameScreenPanel = new JPanel() {
			public void paintComponent(Graphics page) {
				super.paintComponent(page);
				page.drawImage(backgroundIcon.getImage(), 0, 0, null);
				setOpaque(false);

			}
		};
		
		mainPanel = new MainPanel(frame);
		mainPanel.setGamingPanel(this);
		
		mainPanel.setBounds(0, 0, 1200, 800);
		add(mainPanel);
		
		GameScreenPanel.setBounds(0, 0, 1200, 900);
		GameScreenPanel.setLayout(null);
		add(GameScreenPanel);

		Font fntHP = new Font("BernhardFashion BT", Font.BOLD, 70);
		Font fntScore = new Font("BernhardFashion BT", Font.BOLD, 60);
		Font fntScoreInt = new Font("BernhardFashion BT", Font.BOLD, 90);

		// 체력
		lblHP = new JLabel("HP");
		lblHP.setFont(fntHP);
		lblHP.setForeground(Color.white);
		lblHP.setBounds(10, 800, 600, 100);
		lblHP.setHorizontalTextPosition(SwingConstants.LEFT);
		lblHP.setVerticalTextPosition(SwingConstants.CENTER);
		GameScreenPanel.add(lblHP);

		HPBackgroundPanel = new HPDrawPanel();
		HPBackgroundPanel.setBounds(00, 800, 550, 100);
		GameScreenPanel.add(HPBackgroundPanel);

		// 점수
		

		lblScore = new JLabel("SCORE :");
		lblScore.setFont(fntScore);
		lblScore.setForeground(Color.white);
		lblScore.setBounds(610, 800, 500, 100);
		GameScreenPanel.add(lblScore);

		lblOnlyScore = new JLabel("" + 0);
		lblOnlyScore.setText("" + mainPanel.getPoint());
		lblOnlyScore.setFont(fntScoreInt);
		lblOnlyScore.setForeground(Color.white);
		lblOnlyScore.setBounds(950, 767, 300, 150);
		lblOnlyScore.setHorizontalTextPosition(SwingConstants.LEFT);
		lblOnlyScore.setVerticalTextPosition(SwingConstants.CENTER);
		GameScreenPanel.add(lblOnlyScore);

		// 탈출구
		/*Mex = new Exit();
		Mex = new mouseExit();

		addMouseListener(Mex);

		exit = new ImageIcon("Exit.png");
		Image imgExit = exit.getImage();
		Image imgExit_1 = imgExit.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		exit.setImage(imgExit_1);

		exit_Press = new ImageIcon("Exit_out.png");
		Image imgExit_press = exit_Press.getImage();
		Image imgExit_press_1 = imgExit_press.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		exit_Press.setImage(imgExit_press_1);

		bntExit = new JButton(exit);
		bntExit.setBounds(1100, 00, 100, 100);
		bntExit.setFocusPainted(false);
		bntExit.setBorderPainted(false);
		bntExit.setContentAreaFilled(false);
		bntExit.addActionListener(ex);
		bntExit.addMouseListener(Mex);
		GameScreenPanel.add(bntExit);*/
	}
	
	public void Update(int HP,int Score)
	{
		HPBackgroundPanel.setHP(HP);
		lblOnlyScore.setText(Score+"");

		
	}
	
	public GamingPanel(JFrame frame) {

		setPreferredSize(new Dimension(1200, 900));
		setLayout(null);
		
		this.frame = frame;
	}

	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}// exit

	private class mouseExit implements MouseListener {
		public void mousePressed(MouseEvent event) {
		}

		public void mouseReleased(MouseEvent event) {

		}

		public void mouseClicked(MouseEvent event) {

		}

		public void mouseEntered(MouseEvent event) {
			Object obj = event.getSource();
			
			if(obj == bntExit){
			bntExit.setIcon(exit_Press);
			}

		}

		public void mouseExited(MouseEvent event) {
			Object obj = event.getSource();
			
			if(obj == bntExit){
			bntExit.setIcon(exit);
			}
		}

	}

}
