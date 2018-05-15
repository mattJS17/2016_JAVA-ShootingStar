import java.awt.*;
import javax.swing.*;

public class explainationThread extends JPanel implements Runnable {

	private ImageIcon explaination;
	private Image imgExSet, imgExGet;
	private JLabel lblExplaination;
	private int delayTime;
	private Thread upThread;

	public explainationThread() {
		setPreferredSize(new Dimension(600, 900));
		setBackground(Color.black);
		setLayout(null);

		upThread = null;
		delayTime = 10000;
		upThread = new Thread(this);

		explaination = new ImageIcon("explaination.png");
		imgExSet = explaination.getImage();
		imgExGet = imgExSet.getScaledInstance(600, 900, java.awt.Image.SCALE_SMOOTH);
		explaination.setImage(imgExGet);

		lblExplaination = new JLabel(explaination);
		lblExplaination.setBounds(0, 850, 600, 900);
		add(lblExplaination);
	}

	public void start() {
		upThread.start();
	}

	public void stop() {
		upThread.stop();
	}

	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.println("adfadfa");
			lblExplaination.setBounds(0, 850 - i * 50, 600, 900);
			try {
				upThread.sleep(delayTime);

			} catch (Exception e) {

			}
		}
	}
}
