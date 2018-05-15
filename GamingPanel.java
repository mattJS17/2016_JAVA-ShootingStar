import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GamingPanel extends JPanel {

	private JPanel GameScreenPanel;
	private ImageIcon backgroundIcon;

	private JLabel lblHP;
	private HPDrawPanel HPBackgroundPanel;

	private JLabel lblScore, lblOnlyScore;
	private int Score;

	private JButton bntExit;
	private ImageIcon exit, exit_Press;
	private Exit ex;
	private mouseExit Mex;

	public GamingPanel() {

		setPreferredSize(new Dimension(1200, 900));
		setLayout(null);

		backgroundIcon = new ImageIcon("Gaming_Background.png");

		GameScreenPanel = new JPanel() {
			public void paintComponent(Graphics page) {
				super.paintComponent(page);
				page.drawImage(backgroundIcon.getImage(), 0, 0, null);
				setOpaque(false);

			}
		};
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
		Score = 0;

		lblScore = new JLabel("SCORE :");
		lblScore.setFont(fntScore);
		lblScore.setForeground(Color.white);
		lblScore.setBounds(610, 800, 500, 100);
		GameScreenPanel.add(lblScore);

		lblOnlyScore = new JLabel("" + Score);
		lblOnlyScore.setFont(fntScoreInt);
		lblOnlyScore.setForeground(Color.white);
		lblOnlyScore.setBounds(950, 767, 300, 150);
		lblOnlyScore.setHorizontalTextPosition(SwingConstants.LEFT);
		lblOnlyScore.setVerticalTextPosition(SwingConstants.CENTER);
		GameScreenPanel.add(lblOnlyScore);

		// 탈출구
		ex = new Exit();
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
		GameScreenPanel.add(bntExit);
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
			Score = Score + 100;
			lblOnlyScore.setText("" + Score);

			int hp;

			hp = HPBackgroundPanel.getHP();
			hp -= 1;

			HPBackgroundPanel.setHP(hp);
			// System.out.println(""+hp);
			// System.out.println(""+HPBackgroundPanel.getCount());
			HPBackgroundPanel.repaint();
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
