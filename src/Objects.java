import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * @author  hyojun
 */
public abstract class Objects {

	/**
	 * @uml.property  name="x"
	 */
	private int x;
	/**
	 * @uml.property  name="y"
	 */
	private int y; //x,y좌표값
	
	/**
	 * @uml.property  name="width"
	 */
	private int width;
	/**
	 * @uml.property  name="height"
	 */
	private int height; //이미지의 크기
	
	/**
	 * @uml.property  name="speed"
	 */
	private int speed; // 속도값
	
	/**
	 * @uml.property  name="shootSpeed"
	 */
	private int shootSpeed; //발사 속도 값 
	
	/**
	 * @uml.property  name="image"
	 */
	private BufferedImage image;
	
	/**
	 * @uml.property  name="mSheet"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private SpriteSheet mSheet;
	
	/**
	 * @uml.property  name="mSprite"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.awt.image.BufferedImage"
	 */
	private ArrayList<BufferedImage> mSprite;
	
	/**
	 * @uml.property  name="mArrayAnimator"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Animator"
	 */
	private ArrayList<Animator> mArrayAnimator; 
	
	/**
	 * @uml.property  name="mainAnimator"
	 * @uml.associationEnd  
	 */
	private Animator MainAnimator;
	
	/**
	 * @uml.property  name="diagonalSpeed"
	 */
	private double diagonalSpeed;
	
	/**
	 * @uml.property  name="isAlive"
	 */
	private boolean IsAlive;
	
	/**
	 * @uml.property  name="hp"
	 */
	private int hp;
	
	/**
	 * @uml.property  name="animSpeed"
	 */
	private int AnimSpeed;

	
	public Objects(int x,int y,int width,int height,int hp,String uri){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		IsAlive = true;
		this.hp = hp;
		
		
		mArrayAnimator = new ArrayList<Animator>();
		try {
			//image 경로 찾아가서 image가져오기
			image =ImageIO.read(new File(uri));
			mSheet = new SpriteSheet(image);
		//	mSheet = new SpriteSheet(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
	
	public abstract void update(long time);
	
	public abstract Objects Shoot(long time);
	

	
	public void Draw(Graphics page,JPanel panel)
	{
		page.drawImage(image,x,y, panel);
	}
	

	
	//get()
	/**
	 * @return
	 * @uml.property  name="x"
	 */
	public int getX(){
		return x;
	}

	/**
	 * @return
	 * @uml.property  name="y"
	 */
	public int getY(){
		return y;
	}
	public int getW(){
		return width;
	}
	public int getH(){
		return height;
	}
	
	public boolean getAlive() { return IsAlive; }
	
	public int getDiagonalSpeed() {return (int)diagonalSpeed;}
	
	
	/**
	 * @return
	 * @uml.property  name="speed"
	 */
	public int getSpeed(){ return speed; }
	
	/**
	 * @return
	 * @uml.property  name="shootSpeed"
	 */
	public int getShootSpeed() {return shootSpeed;}
	
	public int getHP() {return hp; }
	
	//set()
	/**
	 * @param  speed
	 * @uml.property  name="speed"
	 */
	public void setSpeed(int speed) { this.speed = speed; 
	int temp = this.speed*this.speed; // Speed^2
	diagonalSpeed = (double)temp/2; // (Speed^2)/2
	diagonalSpeed = Math.sqrt(diagonalSpeed); // root((Speed^2)/2)
	//대각선 속도 값 
	}
	/**
	 * @param  speed
	 * @uml.property  name="shootSpeed"
	 */
	public void setShootSpeed(int speed) { shootSpeed = speed; }
	
	public void setDead() { IsAlive = false; }
	
	/**
	 * @param  a
	 * @uml.property  name="x"
	 */
	public void setX(int a){
		x=a;
	}



	/**
	 * @param  a
	 * @uml.property  name="y"
	 */
	public void setY(int a){
		y= a;
	}
	public void setW(int a){
		width =a;
	}
	public void setH(int a){
		height =a;
	}
	
	public void run(){
		for(Animator ani : mArrayAnimator)
		{
			ani.run();
		}
	}
	
	public void stop(){
		MainAnimator.stop();
	}
	
	public void pause(){
		MainAnimator.pause();
	}
	
	public void resum(){
		MainAnimator.resume();
	}
	
	public void setAnimator(){
		Animator newAnim = new Animator(mSprite);
		//System.out.println("newAnim Image="+newAnim.getImage());
		mArrayAnimator.add(newAnim);
		MainAnimator = mArrayAnimator.get(mArrayAnimator.size()-1);
		//System.out.println("MainAnimator Image="+MainAnimator.getImage());
		//mSprite.clear();
		//System.out.println("size="+mArrayAnimator.size());
	}
	
	public void getAnimator(int i){
		//System.out.println("getAnimator="+mArrayAnimator.get(i).getImage());
		MainAnimator = mArrayAnimator.get(i);
	}
	
	public void newSprite(){
		mSprite = new ArrayList<BufferedImage>();
	}

	public void GrabAniSubImage(int x,int y,int width,int height){
		BufferedImage sprite = mSheet.grabSprite(x, y, width, height);
		mSprite.add(sprite);
		//System.out.println("addSprite x="+x);
	}
	
	public void AnimationUpdate(long time)
	{
		MainAnimator.update(time);
	}
	
	public void getImage(){
		//System.out.println("MainAnimator="+MainAnimator);
		image = MainAnimator.getImage();
	}
	
	public void setAnimSpeed(int a){
		for(Animator ani : mArrayAnimator)
		{
			ani.setSpeed(a);
		}
	}
	
	public void Collision(int damage)
	{
		hp -= damage;
	}
	

	
	
}
