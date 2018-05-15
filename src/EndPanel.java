import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author  hyojun
 */
public class EndPanel extends JPanel {

	/**
	 * @uml.property  name="lblScore"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblScore;
	/**
	 * @uml.property  name="bntRestart"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton bntRestart;
	/**
	 * @uml.property  name="bntEnd"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton bntEnd;
	/**
	 * @uml.property  name="start"
	 * @uml.associationEnd  readOnly="true"
	 */
	private ImageIcon start;
	/**
	 * @uml.property  name="start_enter"
	 * @uml.associationEnd  readOnly="true"
	 */
	private ImageIcon start_enter;
	/**
	 * @uml.property  name="stop"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon stop;
	/**
	 * @uml.property  name="stop_enter"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon stop_enter;
	/**
	 * @uml.property  name="lblRestart"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblRestart;
	/**
	 * @uml.property  name="lblEnd"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblEnd;

	/**
	 * @uml.property  name="backgroundPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel backgroundPanel;
	/**
	 * @uml.property  name="backgroundIcon"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon backgroundIcon;

	/**
	 * @uml.property  name="act"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="this$0:EndPanel$bntAction"
	 */
	private bntAction act;
	/**
	 * @uml.property  name="bntMouse"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="this$0:EndPanel$bntListener"
	 */
	private bntListener bntMouse;

	public EndPanel() {

		setPreferredSize(new Dimension(1200, 900));
		setLayout(null);

		backgroundIcon = new ImageIcon("END_Background.jpg");

		backgroundPanel = new JPanel() {
			public void paintComponent(Graphics page) {

				page.drawImage(backgroundIcon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(page);

			}
		};
		backgroundPanel.setBounds(0, 0, 1200, 900);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		Font fntScore = new Font("Hobo BT", Font.BOLD, 90);

		// 게임이름
		
		lblScore = new JLabel("SCORE >> " + 0);
		lblScore.setForeground(Color.yellow);
		lblScore.setFont(fntScore);
		lblScore.setBounds(0, 300, 1100, 200);
		lblScore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScore.setVerticalAlignment(SwingConstants.BOTTOM);
		backgroundPanel.add(lblScore);

		act = new bntAction();
		bntMouse = new bntListener();

		// 시작 버튼
		/*start = new ImageIcon("bntStart.png");
		Image start_main = start.getImage();
		Image start_main1 = start_main.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		start.setImage(start_main1);

		start_enter = new ImageIcon("bntSTART_push.png");
		Image start_enter_1 = start_enter.getImage();
		Image start_enter1 = start_enter_1.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		start_enter.setImage(start_enter1);

		bntRestart = new JButton(start);
		bntRestart.setBounds(650, 554, 200, 200);
		bntRestart.setBorderPainted(false);// 테두리 설정
		bntRestart.setContentAreaFilled(false);// 배경 색 설정
		bntRestart.setFocusPainted(false); // 포커스 설정
		bntRestart.setLayout(null);
		bntRestart.addActionListener(act);
		bntRestart.addMouseListener(bntMouse);
		backgroundPanel.add(bntRestart);

		//Font fntbntName = new Font("Blippo Blk BT", Font.BOLD, 30);

		lblRestart = new JLabel("RESTART");
		lblRestart.setFont(fntbntName);
		lblRestart.setBounds(35, 25, 150, 150);
		lblRestart.setForeground(Color.white);
		bntRestart.add(lblRestart);*/
		// private JLabel lblRestart, lblEnd;
		// 끝내기 버튼
		Font fntbntName = new Font("Blippo Blk BT", Font.BOLD, 30);
		stop = new ImageIcon("bntStop.png");
		Image stop_main = stop.getImage();
		Image stop_main1 = stop_main.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		stop.setImage(stop_main1);

		stop_enter = new ImageIcon("STOP_push.png");
		Image stop_enter_1 = stop_enter.getImage();
		Image stop_enter1 = stop_enter_1.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		stop_enter.setImage(stop_enter1);

		bntEnd = new JButton(stop);
		bntEnd.setBounds(700, 550, 200, 200);
		bntEnd.setBorderPainted(false);// 테두리 설정
		bntEnd.setContentAreaFilled(false);// 배경 색 설정
		bntEnd.setFocusPainted(false); // 포커스 설정
		bntEnd.setLayout(null);
		bntEnd.addActionListener(act);
		bntEnd.addMouseListener(bntMouse);
		backgroundPanel.add(bntEnd);

		lblEnd = new JLabel("END");
		lblEnd.setForeground(Color.white);
		lblEnd.setBounds(25, 25, 150, 150);
		lblEnd.setFont(fntbntName);
		lblEnd.setHorizontalAlignment(SwingConstants.CENTER);
		bntEnd.add(lblEnd);
	}
	
	public void setPoint(int Score)
	{
		lblScore.setText("SCORE >> " + Score);
	}

	private class bntAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			Object obj = event.getSource();

			if (obj == bntRestart) {

			} else if (obj == bntEnd) {
				System.exit(0);
			}
		}
	}

	// 작동 약션 넣고 싶음
	private class bntListener implements MouseListener {

		public void mousePressed(MouseEvent event) {// 누를때
			// 누를때 사진 작아지고
		}

		public void mouseReleased(MouseEvent event) {// 땔때
			// 사진 커지고
		}

		public void mouseClicked(MouseEvent event) {

		}

		public void mouseEntered(MouseEvent event) {// 커서 기준
			Object obj = event.getSource();

			if (obj == bntRestart) {
				bntRestart.setIcon(start_enter);

			} else if (obj == bntEnd) {
				bntEnd.setIcon(stop_enter);
			}
		}

		public void mouseExited(MouseEvent event) {// 커서 기분
			Object obj = event.getSource();

			if (obj == bntRestart) {
				bntRestart.setIcon(start);

			} else if (obj == bntEnd) {
				bntEnd.setIcon(stop);
			}

		}
	}
}
