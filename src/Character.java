import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



/**
 * @author  hyojun
 */
public class Character extends Objects{
	
	/**
	 * @uml.property  name="uP_flag"
	 */
	private boolean UP_flag=false;
	/**
	 * @uml.property  name="dOWN_flag"
	 */
	private boolean DOWN_flag=false;
	/**
	 * @uml.property  name="lEFT_flag"
	 */
	private boolean LEFT_flag=false;
	/**
	 * @uml.property  name="rIGHT_flag"
	 */
	private boolean RIGHT_flag=false;
	
	/**
	 * @uml.property  name="sHOOT_UP_FLAG"
	 */
	private boolean SHOOT_UP_FLAG = false;
	/**
	 * @uml.property  name="sHOOT_RIGHT_FLAG"
	 */
	private boolean SHOOT_RIGHT_FLAG = false;
	/**
	 * @uml.property  name="sHOOT_DOWN_FLAG"
	 */
	private boolean SHOOT_DOWN_FLAG = false;
	/**
	 * @uml.property  name="sHOOT_LEFT_FLAG"
	 */
	private boolean SHOOT_LEFT_FLAG = false;
	
	/**
	 * @uml.property  name="currentShootTime"
	 */
	private long currentShootTime=0; //발사 속도 기준값 
	
	/**
	 * @uml.property  name="oFac"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ObjectFactory OFac;
	
	/**
	 * @uml.property  name="x"
	 */
	private int x;
	/**
	 * @uml.property  name="y"
	 */
	private int y;
	
	public Character(int _x,int _y,int _width,int _height,int hp,String _uri){
		super(_x,_y,_width,_height,hp,_uri);	
		setSpeed(10); //move speed 
		setShootSpeed(100); //1초에 2발
		
		OFac = ObjectFactory.getInstance();

		x = Constants.Player.imagewidth - Constants.Bullet.imagewidth;
		x = x/2;
		y = Constants.Player.imageheight - Constants.Bullet.imageheight;
		y = y/2;
		
		//animation setting
		

		newSprite();
		GrabAniSubImage(0,0,Constants.Player.imagewidth,Constants.Player.imageheight);
		GrabAniSubImage(0,60,60,60);
		GrabAniSubImage(0,120,60,60);
		GrabAniSubImage(0,60,60,60);
		setAnimator(); //UP 0
		
		newSprite();
		GrabAniSubImage(60,0,60,60);
		GrabAniSubImage(60,60,60,60);
		GrabAniSubImage(60,120,60,60);
		GrabAniSubImage(60,60,60,60);
		setAnimator(); //UP & Right 1
		
		newSprite();
		GrabAniSubImage(120,0,60,60);
		GrabAniSubImage(120,60,60,60);
		GrabAniSubImage(120,120,60,60);
		GrabAniSubImage(120,60,60,60);
		setAnimator(); //Right 2
		
		newSprite();
		GrabAniSubImage(180,0,60,60);
		GrabAniSubImage(180,60,60,60);
		GrabAniSubImage(180,120,60,60);
		GrabAniSubImage(180,60,60,60);
		setAnimator(); //Down & Right 3
	
	
		newSprite();
		GrabAniSubImage(240,0,60,60);
		GrabAniSubImage(240,60,60,60);
		GrabAniSubImage(240,120,60,60);
		GrabAniSubImage(240,60,60,60);
		setAnimator(); //Down 4
		
		newSprite();
		GrabAniSubImage(300,0,60,60);
		GrabAniSubImage(300,60,60,60);
		GrabAniSubImage(300,120,60,60);
		GrabAniSubImage(300,60,60,60);
		setAnimator(); //Down & Left 5



		newSprite();
		GrabAniSubImage(360,0,60,60);
		GrabAniSubImage(360,60,60,60);
		GrabAniSubImage(360,120,60,60);
		GrabAniSubImage(360,60,60,60);
		setAnimator(); //Left 6 
	
	

	
		newSprite();
		GrabAniSubImage(420,0,60,60);
		GrabAniSubImage(420,60,60,60);
		GrabAniSubImage(420,120,60,60);
		GrabAniSubImage(420,60,60,60);
		setAnimator(); //Up & Left 7

	
		getAnimator(0);
		setAnimSpeed(300);
		run(); //animation run
		
	}

	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		
		//move Update
		setDirection();
		//animation setting
		AnimationUpdate(time);//animation update
		getImage(); //image get
		
		
		if(UP_flag==true && (LEFT_flag==false || RIGHT_flag==false) &&getY()>=0)
		{
			//move UP
			setY(getY()-getSpeed());
		}
		else if(UP_flag==true && (LEFT_flag==true || RIGHT_flag==true) && getY() >=0)
		{
			//move UP and (Left or Right)
			setY(getY()-getDiagonalSpeed());
		}
		else if(DOWN_flag==true && (LEFT_flag==false || RIGHT_flag==false) && getY()<=Constants.MainPanel.Height-getH())
		{
			//move DOWN
			setY(getY()+getSpeed());
		}
		else if(DOWN_flag==true && (LEFT_flag==true || RIGHT_flag==true) && getY()<=Constants.MainPanel.Height-getH())
		{
			//move DOWN and (Left or Right)
			setY(getY()+getDiagonalSpeed());
		}
		
		if(LEFT_flag==true &&(UP_flag==false || DOWN_flag==false) && getX()>=0){
			//move Left and (Down or Up)
			setX(getX()-getSpeed());
		}
		else if(LEFT_flag==true &&(UP_flag==true || DOWN_flag==true) && getX()>=0){
			//move Left
			setX(getX()-getDiagonalSpeed());
		}
		else if(RIGHT_flag==true &&(UP_flag==false || DOWN_flag==false) && getX()<=Constants.MainPanel.Width-getW()){
			//move Right
			setX(getX()+getSpeed());
		}
		else if(RIGHT_flag==true &&(UP_flag==true || DOWN_flag==true) && getX()<=Constants.MainPanel.Width-getW()){
			//move Right and (Down or Up)
			setX(getX()+getDiagonalSpeed());
		}
	

	}
	
	@Override
	public Objects Shoot(long time) {
		// TODO Auto-generated method stub
		Objects Bullet;

		
		if(currentShootTime+getShootSpeed() < time)
		{
			if(SHOOT_UP_FLAG == true)
				Bullet = OFac.CreateObject(Constants.Factory.P_Up_Bullet, getX()+x, getY());
			else if(SHOOT_DOWN_FLAG == true)
				Bullet = OFac.CreateObject(Constants.Factory.P_Down_Bullet, getX()+x, getY()+Constants.Player.imageheight);
			else if(SHOOT_LEFT_FLAG==true)
				Bullet = OFac.CreateObject(Constants.Factory.P_Left_Bullet, getX(), getY()+y);
			else if(SHOOT_RIGHT_FLAG==true)
				Bullet = OFac.CreateObject(Constants.Factory.P_Right_Bullet, getX()+Constants.Player.imagewidth, getY()+y);
			else 
				return null;
			
			currentShootTime = time;
			Bullet.getImage();
			return Bullet;
			
		}
		return null;
	}
	
	
	
	public void setDirection(){
		if(UP_flag==true && LEFT_flag==false && RIGHT_flag==false && DOWN_flag==false){
			//UP
			getAnimator(0);
		}
		else if(UP_flag==true && RIGHT_flag==true && LEFT_flag==false && DOWN_flag==false){
			//UP & Right
			getAnimator(1);
		}
		else if(UP_flag==true && RIGHT_flag==false && LEFT_flag==true && DOWN_flag==false){
			//UP & Left
			getAnimator(7);
		}
		else if(UP_flag==false && RIGHT_flag==true && LEFT_flag==false && DOWN_flag==false ){
			//RIGHT
			getAnimator(2);
		}
		else if(UP_flag==false && RIGHT_flag==false && LEFT_flag==true && DOWN_flag==false){
			//LEFT
			getAnimator(6);
		}
		else if(UP_flag==false && RIGHT_flag==false && LEFT_flag==false && DOWN_flag==true ){
			//DOWN
			getAnimator(4);
		}
		else if(UP_flag==false && RIGHT_flag==false && LEFT_flag==true && DOWN_flag==true ){
			//DOWN & LEFT
			getAnimator(5);
		}
		else if(UP_flag==false && RIGHT_flag==true && LEFT_flag==false && DOWN_flag==true ){
			//DOWN & RIGHT
			getAnimator(3);
		}
	}

	
	public void setUpFlag(boolean flag){
		UP_flag=flag;
	}
	public void setDownFlag(boolean flag){
		DOWN_flag=flag;
	}
	public void setLeftFlag(boolean flag){
		LEFT_flag=flag;
	}
	public void setRightFlag(boolean flag){
		RIGHT_flag=flag;
	}
	
	public boolean getUpFlag(){
		return UP_flag;
	}
	public boolean getDownFlag(){
		return DOWN_flag;
	}
	public boolean getLeftFlag(){
		return LEFT_flag;
	}
	public boolean getRightFlag(){
		return RIGHT_flag;
	}
	
	public void setShootUpFlag(boolean flag){ SHOOT_UP_FLAG = flag; }
	public void setShootRIGHTFlag(boolean flag){ SHOOT_RIGHT_FLAG = flag; }
	public void setShootDOWNFlag(boolean flag){ SHOOT_DOWN_FLAG = flag; }
	public void setShootLEFTFlag(boolean flag){ SHOOT_LEFT_FLAG = flag; }
	
	public boolean getShootUpFlag(){ return SHOOT_UP_FLAG; }
	public boolean getShootRIGHTFlag(){ return SHOOT_RIGHT_FLAG; }
	public boolean getShootDOWNFlag(){ return SHOOT_DOWN_FLAG; }
	public boolean getShootLEFTFlag(){ return SHOOT_LEFT_FLAG; }


	
	

}
