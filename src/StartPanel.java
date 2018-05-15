import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author  hyojun
 */
public class StartPanel extends JPanel {

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
	 * @uml.property  name="lblGameName"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblGameName;
	/**
	 * @uml.property  name="lblMaker"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblMaker;
	/**
	 * @uml.property  name="bntStart"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton bntStart;
	/**
	 * @uml.property  name="bntEnd"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton bntEnd;
	/**
	 * @uml.property  name="bntSetting"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton bntSetting;
	/**
	 * @uml.property  name="lblStart"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblStart;
	/**
	 * @uml.property  name="lblEnd"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblEnd;
	/**
	 * @uml.property  name="start"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon start;
	/**
	 * @uml.property  name="start_enter"
	 * @uml.associationEnd  multiplicity="(1 1)"
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
	 * @uml.property  name="setting"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon setting;
	/**
	 * @uml.property  name="setting_in"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon setting_in;

	/**
	 * @uml.property  name="settingPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel settingPanel;
	/**
	 * @uml.property  name="lblSetting"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblSetting;
	/**
	 * @uml.property  name="exit"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon exit;
	/**
	 * @uml.property  name="exit_in"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon exit_in;
	/**
	 * @uml.property  name="play"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon Play;
	/**
	 * @uml.property  name="pause"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon Pause;
	/**
	 * @uml.property  name="bntBackSound"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton bntBackSound;
	/**
	 * @uml.property  name="bntEffect"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton bntEffect;
	/**
	 * @uml.property  name="bntClose"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton bntClose;
	/**
	 * @uml.property  name="lblBack_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblBack_1;
	/**
	 * @uml.property  name="lblBack_2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblBack_2;
	/**
	 * @uml.property  name="lblEffect_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblEffect_1;
	/**
	 * @uml.property  name="lblEffect_2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblEffect_2;

	/**
	 * @uml.property  name="act"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="this$0:StartPanel$bntAction"
	 */
	private bntAction act;
	/**
	 * @uml.property  name="bntMouse"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="this$0:StartPanel$bntListener"
	 */
	private bntListener bntMouse;

	/**
	 * @uml.property  name="flag"
	 */
	private boolean flag;

	/**
	 * @uml.property  name="explainationSkip"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon explainationSkip;
	/**
	 * @uml.property  name="explainationSkipIn"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon explainationSkipIn;
	/**
	 * @uml.property  name="bntSkip"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton bntSkip;
	/**
	 * @uml.property  name="explainationTh"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="startPanel:ExplainationThread"
	 */
	private ExplainationThread explainationTh;

	/**
	 * @uml.property  name="gamePanel"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="startPanel:GamePanel"
	 */
	private GamePanel gamePanel;
	/**
	 * @uml.property  name="startPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private StartPanel startPanel;

	/**
	 * @uml.property  name="thread"
	 */
	private Thread thread;

	/**
	 * @uml.property  name="frame"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JFrame frame;
	/**
	 * @uml.property  name="sManager"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private SoundManager SManager;
	/**
	 * @uml.property  name="clip"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Clip clip;
	
	
	public StartPanel(JFrame frame ) {

		setPreferredSize(new Dimension(1200, 900));
		setLayout(null);
		
		this.frame = frame;
		startPanel = this;
		
		gamePanel = GamePanel.getInstance();
		SManager = SoundManager.getInstance();
		
	
		SManager.getSoundFile("BGM1.wav");
		SManager.setSound(Constants.Sound.BGM_1);
		//clip = SManager.Loop();
		
		backgroundIcon = new ImageIcon("START_Background.jpg");

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

		Font fntName = new Font("Star Jedi", Font.ITALIC, 100);
		Font fntMaker = new Font("CommercialScript BT", Font.BOLD, 50);

		// 게임이름
		lblGameName = new JLabel("Shooting Star");
		lblGameName.setForeground(Color.yellow);
		lblGameName.setFont(fntName);
		lblGameName.setBounds(300, 0, 1170, 300);
		backgroundPanel.add(lblGameName);

		act = new bntAction();
		bntMouse = new bntListener();

		Font fntbntName = new Font("Blippo Blk BT", Font.BOLD, 30);
		// 시작 버튼
		start = new ImageIcon("bntStart.png");
		Image img = start.getImage();
		Image img1 = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		start.setImage(img1);

		start_enter = new ImageIcon("bntStart_push.png");
		Image img2 = start_enter.getImage();
		Image img3 = img2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		start_enter.setImage(img3);

		bntStart = new JButton(start);
		bntStart.setBounds(700, 254, 200, 200);
		bntStart.setHorizontalTextPosition(SwingConstants.CENTER);
		bntStart.setVerticalTextPosition(SwingConstants.CENTER);
		bntStart.setBorderPainted(false);// 테두리 설정
		bntStart.setContentAreaFilled(false);// 배경 색 설정
		bntStart.setFocusPainted(false); // 포커스 설정
		bntStart.setLayout(null);
		bntStart.addActionListener(act);
		bntStart.addMouseListener(bntMouse);
		backgroundPanel.add(bntStart);

		lblStart = new JLabel("START");
		lblStart.setFont(fntbntName);
		lblStart.setBounds(25, 25, 150, 150);
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblStart.setForeground(Color.white);
		bntStart.add(lblStart);

		// 끝내기 버튼
		stop = new ImageIcon("bntStop.png");
		Image img4 = stop.getImage();
		Image img5 = img4.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		stop.setImage(img5);

		stop_enter = new ImageIcon("STOP_Push.png");
		Image img6 = stop_enter.getImage();
		Image img7 = img6.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		stop_enter.setImage(img7);

		bntEnd = new JButton(stop);
		bntEnd.setBounds(950, 250, 200, 200);
		bntEnd.setHorizontalTextPosition(SwingConstants.CENTER);
		bntEnd.setVerticalTextPosition(SwingConstants.CENTER);
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

		// 설정
		Font fntSetting = new Font("Star Jedi", Font.PLAIN, 60);

		setting = new ImageIcon("bntSetting.png");
		Image settingImg = setting.getImage();
		Image settingImg1 = settingImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		setting.setImage(settingImg1);

		setting_in = new ImageIcon("bntSetting_in.png");
		Image setting_inImg = setting_in.getImage();
		Image setting_inImg1 = setting_inImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		setting_in.setImage(setting_inImg1);

		bntSetting = new JButton(setting);
		bntSetting.setForeground(Color.blue);
		bntSetting.setBackground(Color.white);
		bntSetting.setBounds(0, 800, 100, 100);
		bntSetting.setBorderPainted(false);// 테두리 설정
		bntSetting.setContentAreaFilled(false);// 배경 색 설정
		bntSetting.setFocusPainted(false); // 포커스 설정
		bntSetting.addActionListener(act);
		bntSetting.addMouseListener(bntMouse);
		backgroundPanel.add(bntSetting);

		settingPanel = new JPanel();
		settingPanel.setBackground(new Color(200, 200, 200));
		settingPanel.setBounds(100, 500, 440, 300);
		settingPanel.setLayout(null);
		settingPanel.setVisible(false);
		settingPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		backgroundPanel.add(settingPanel);

		lblSetting = new JLabel("SETTINGS");
		lblSetting.setFont(fntSetting);
		lblSetting.setForeground(Color.black);
		lblSetting.setBounds(0, 0, 380, 80);
		lblSetting.setVerticalAlignment(SwingConstants.CENTER);
		lblSetting.setHorizontalAlignment(SwingConstants.CENTER);
		settingPanel.add(lblSetting);

		Play = new ImageIcon("SoundStart.png");
		Image setPlay = Play.getImage();
		Image getPlay = setPlay.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Play.setImage(getPlay);

		Pause = new ImageIcon("soundStop.png");
		Image PauseImg = Pause.getImage();
		Image PauseImg1 = PauseImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Pause.setImage(PauseImg1);

		Font fntSetting_1 = new Font("Yj SOSEL", Font.BOLD, 25);

		bntBackSound = new JButton(Play);
		bntBackSound.setBounds(80, 100, 100, 100);
		bntBackSound.setBorderPainted(false);
		bntBackSound.setContentAreaFilled(false);
		bntBackSound.setFocusPainted(false);
		bntBackSound.addActionListener(act);
		settingPanel.add(bntBackSound);

		lblBack_1 = new JLabel("BACKGROUND");
		lblBack_1.setFont(fntSetting_1);
		lblBack_1.setBounds(30, 220, 200, 30);
		lblBack_1.setForeground(Color.black);
		lblBack_1.setHorizontalTextPosition(SwingConstants.CENTER);
		settingPanel.add(lblBack_1);

		lblBack_2 = new JLabel("MUSIC");
		lblBack_2.setFont(fntSetting_1);
		lblBack_2.setBounds(30, 250, 200, 30);
		lblBack_2.setForeground(Color.black);
		lblBack_2.setHorizontalAlignment(SwingConstants.CENTER);
		settingPanel.add(lblBack_2);

		bntEffect = new JButton(Play);
		bntEffect.setBounds(280, 100, 100, 100);
		bntEffect.setBorderPainted(false);
		bntEffect.setContentAreaFilled(false);
		bntEffect.setFocusPainted(false);
		bntEffect.addActionListener(act);
		settingPanel.add(bntEffect);

		lblEffect_1 = new JLabel("SOUND");
		lblEffect_1.setFont(fntSetting_1);
		lblEffect_1.setBounds(220, 220, 200, 30);
		lblEffect_1.setForeground(Color.black);
		lblEffect_1.setHorizontalAlignment(SwingConstants.CENTER);
		settingPanel.add(lblEffect_1);

		lblEffect_2 = new JLabel("EFFECT");
		lblEffect_2.setFont(fntSetting_1);
		lblEffect_2.setBounds(220, 250, 200, 30);
		lblEffect_2.setForeground(Color.black);
		lblEffect_2.setHorizontalAlignment(SwingConstants.CENTER);
		settingPanel.add(lblEffect_2);

		exit = new ImageIcon("out.png");
		Image exitImg = exit.getImage();
		Image exitImg1 = exitImg.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		exit.setImage(exitImg1);

		exit_in = new ImageIcon("out_in.png");
		Image exit_inImg = exit_in.getImage();
		Image exit_inImg1 = exit_inImg.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		exit_in.setImage(exit_inImg1);

		bntClose = new JButton(exit);
		bntClose.setBounds(370, 5, 60, 60);
		bntClose.setFont(new Font("Blippo Blk BT", Font.BOLD, 5));
		bntClose.setBorderPainted(false);
		bntClose.setContentAreaFilled(false);
		bntClose.setFocusPainted(false);
		bntClose.addMouseListener(bntMouse);
		bntClose.addActionListener(act);
		settingPanel.add(bntClose);

		// 제작자 이름
		lblMaker = new JLabel("Without 14");
		lblMaker.setFont(fntMaker);
		lblMaker.setForeground(Color.yellow);
		lblMaker.setBounds(0, 800, 1190, 100);
		lblMaker.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaker.setVerticalAlignment(SwingConstants.BOTTOM);
		backgroundPanel.add(lblMaker);

		flag = true;

		explainationSkip = new ImageIcon("skip.png");
		Image imgSkipGet = explainationSkip.getImage();
		Image imgSkipSet = imgSkipGet.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		explainationSkip.setImage(imgSkipSet);

		explainationSkipIn = new ImageIcon("skip_in.png");
		Image imgSkipInGet = explainationSkipIn.getImage();
		Image imgSkipInSet = imgSkipInGet.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		explainationSkipIn.setImage(imgSkipInSet);

		bntSkip = new JButton(explainationSkip);
		bntSkip.setBounds(1050, 0, 120, 120);
		bntSkip.setFocusable(false);
		bntSkip.setBorderPainted(false);
		bntSkip.setContentAreaFilled(false);
		bntSkip.setVisible(false);
		bntSkip.addActionListener(act);
		bntSkip.addMouseListener(bntMouse);
		add(bntSkip);

		 explainationTh = new ExplainationThread(this,frame);
	      explainationTh.setBounds(200, 0, 800, 900);
	      //explainationTh.setVisible(false);
	      add(explainationTh);
	      
	      clip = SManager.Loop();
	}


	private class bntAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			Object obj = event.getSource();
			if (obj == bntStart) {
				remove(backgroundPanel);
				setBackground(Color.black);
				bntSkip.setVisible(true);
				explainationTh.setGamePanel(gamePanel);
				explainationTh.setVisible(true);
			 thread = new Thread(explainationTh);
				thread.start();

			} else if (obj == bntEnd) {
				System.exit(0);

			} else if (obj == bntSetting) {

				if (flag == true) {
					settingPanel.setVisible(true);
					bntSetting.setIcon(setting_in);
					bntStart.setEnabled(false);
					bntEnd.setEnabled(false);
					lblStart.setVisible(false);
					lblEnd.setVisible(false);
					flag = false;
				} else {
					settingPanel.setVisible(false);
					bntSetting.setIcon(setting);
					bntStart.setEnabled(true);
					bntEnd.setEnabled(true);
					lblStart.setVisible(true);
					lblEnd.setVisible(true);
					flag = true;
				}

			} else if (obj == bntClose) {
				settingPanel.setVisible(false);
				bntSetting.setIcon(setting);
				bntStart.setEnabled(true);
				bntEnd.setEnabled(true);
				lblStart.setVisible(true);
				lblEnd.setVisible(true);

			} else if (obj == bntBackSound) {
				if (SoundManager.getFlag_BGM() == true) {
					bntBackSound.setIcon(Pause);
					SoundManager.setFlag_BGM(false);
					clip.stop();
				} else {
					bntBackSound.setIcon(Play);
					SoundManager.setFlag_BGM(true);
					clip.start();
				}

			} else if (obj == bntEffect) {
				if (SoundManager.getFlag_Effect() == true) {
					bntEffect.setIcon(Pause);
					SoundManager.setFlag_Effect(false);

				} else {
					bntEffect.setIcon(Play);
					SoundManager.setFlag_Effect(true);
				}
			} else if (obj == bntSkip) {
				gamePanel.removePanel(Constants.Panel.StartPanel);
				//gamePanel.removePanel(startPanel);
				
				gamePanel.setPanel(Constants.Panel.GamingPanel);
				//gamePanel.setPanel(new GameingPanel());
				thread.stop();
			}
		}
	}

	// 작동 약션 넣고 싶음
	private class bntListener implements MouseListener {

		public void mousePressed(MouseEvent event) {
		}

		public void mouseReleased(MouseEvent event) {
		}

		public void mouseClicked(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) {// 커서 기준
			Object obj = event.getSource();

			if (obj == bntStart) {
				bntStart.setIcon(start_enter);
				lblStart.setForeground(new Color(180, 180, 180));

			} else if (obj == bntEnd) {
				bntEnd.setIcon(stop_enter);
				lblEnd.setForeground(new Color(180, 180, 180));

			} else if (obj == bntClose) {
				bntClose.setIcon(exit_in);

			} else if (obj == bntSetting) {
				bntSetting.setIcon(setting_in);

			} else if (obj == bntSkip) {
				bntSkip.setIcon(explainationSkipIn);
			}
		}

		public void mouseExited(MouseEvent event) {// 커서 기분
			Object obj = event.getSource();

			if (obj == bntStart) {
				bntStart.setIcon(start);
				lblStart.setForeground(Color.white);

			} else if (obj == bntEnd) {
				bntEnd.setIcon(stop);
				lblEnd.setForeground(Color.white);

			} else if (obj == bntClose) {
				bntClose.setIcon(exit);

			} else if (obj == bntSkip) {
				bntSkip.setIcon(explainationSkip);
			}
		}
	}
}
