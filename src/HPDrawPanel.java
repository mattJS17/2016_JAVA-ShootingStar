import java.awt.*;
import javax.swing.*;

/**
 * @author  hyojun
 */
public class HPDrawPanel extends JPanel {

	/**
	 * @uml.property  name="x"
	 */
	private int x;
	/**
	 * @uml.property  name="pl"
	 */
	private int pl;
	/**
	 * @uml.property  name="count"
	 */
	private int count;
	/**
	 * @uml.property  name="hP"
	 */
	private int HP;

	public HPDrawPanel() {
		//this.setBackground(Color.cyan);		
		this.setPreferredSize(new Dimension(600, 100));
		this.setOpaque(false);
		
		pl = 15;
		x = 80 + pl;
		HP = 100;
		count = 4;
	}

	/**
	 * @return
	 * @uml.property  name="count"
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param  count
	 * @uml.property  name="count"
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return
	 * @uml.property  name="x"
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param  x
	 * @uml.property  name="x"
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return
	 * @uml.property  name="hP"
	 */
	public int getHP() {
		return HP;
	}

	/**
	 * @param  hp
	 * @uml.property  name="hP"
	 */
	public void setHP(int hp) {
		HP = hp;
		if (hp > 74)
			count = 4;
		else if (hp > 49)
			count = 3;
		else if (hp > 24)
			count = 2;
		else if (hp > 0)
			count = 1;
		else
			count = 0;
	}

	private void HPRed(Graphics page, int x) {

		page.setColor(new Color(255, 50, 50));
		page.fillRect(x, 15, 83, 70);
	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);

		page.setColor(Color.white);
		page.fillArc(30+pl, 10, 80, 80, 90, 180);
		page.fillArc(400+pl, 10, 80, 80, 270, 180);
		page.fillRect(70+pl, 10, 370, 80);

		for (int i = 0; i < getCount(); i++) {
			HPRed(page, x);
			x += 90;
		}
		x= 80 +pl;
	}

}
