

/**
 * @author  hyojun
 */
public class Enemy extends Objects{
	

	/**
	 * @uml.property  name="direction"
	 */
	private int Direction;
	
	/**
	 * @uml.property  name="oFac"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ObjectFactory OFac;
	
	/**
	 * @uml.property  name="currentShootTime"
	 */
	private long currentShootTime;
	
	/**
	 * @uml.property  name="x"
	 */
	private int x;
	
	/**
	 * @uml.property  name="y"
	 */
	private int y;
	
	
	public Enemy(int x, int y, int width, int height,int hp, String uri) {
		super(x, y, width, height,hp, uri);
		// TODO Auto-generated constructor stub
		setSpeed(10); //move speed 
		setShootSpeed(500); //1초에 2발
		
		x = Constants.Enemy.imagewidth - Constants.EnemyBullet.imagewidth;
		x = x/2;
		y = Constants.Enemy.imageheight - Constants.EnemyBullet.imageheight;
		y = y/2;
		
		OFac = ObjectFactory.getInstance();
		currentShootTime=0;
		
	}
	
	
	/**
	 * @param  d
	 * @uml.property  name="direction"
	 */
	public void setDirection(int d)
	{
		Direction = d;
		switch(Direction)
		{
		case Constants.Enemy.MoveUp:
			newSprite();
			GrabAniSubImage(0,0,60,60);
			GrabAniSubImage(0,60,60,60);
			GrabAniSubImage(0,120,60,60);
			GrabAniSubImage(0,60,60,60);
			setAnimator(); //UP 0
			break;
		case Constants.Enemy.MoveDown:
			newSprite();
			GrabAniSubImage(240,0,60,60);
			GrabAniSubImage(240,60,60,60);
			GrabAniSubImage(240,120,60,60);
			GrabAniSubImage(240,60,60,60);
			setAnimator(); //Down 4
			break;
		case Constants.Enemy.MoveRight:
			newSprite();
			GrabAniSubImage(120,0,60,60);
			GrabAniSubImage(120,60,60,60);
			GrabAniSubImage(120,120,60,60);
			GrabAniSubImage(120,60,60,60);
			setAnimator(); //Right 2
			break;
		case Constants.Enemy.MoveLeft:
			newSprite();
			GrabAniSubImage(360,0,60,60);
			GrabAniSubImage(360,60,60,60);
			GrabAniSubImage(360,120,60,60);
			GrabAniSubImage(360,60,60,60);
			setAnimator(); //Left 6 
			break;
		case Constants.Enemy.MoveUPnRight:
			newSprite();
			GrabAniSubImage(60,0,60,60);
			GrabAniSubImage(60,60,60,60);
			GrabAniSubImage(60,120,60,60);
			GrabAniSubImage(60,60,60,60);
			setAnimator(); //UP & Right 1
			break;
		case Constants.Enemy.MoveUPnLeft:
			newSprite();
			GrabAniSubImage(420,0,60,60);
			GrabAniSubImage(420,60,60,60);
			GrabAniSubImage(420,120,60,60);
			GrabAniSubImage(420,60,60,60);
			setAnimator(); //Up & Left 7
			break;
		case Constants.Enemy.MoveDownnRight:
			newSprite();
			GrabAniSubImage(180,0,60,60);
			GrabAniSubImage(180,60,60,60);
			GrabAniSubImage(180,120,60,60);
			GrabAniSubImage(180,60,60,60);
			setAnimator(); //Down & Right 3
			break;
		case Constants.Enemy.MoveDownnLeft:
			newSprite();
			GrabAniSubImage(300,0,60,60);
			GrabAniSubImage(300,60,60,60);
			GrabAniSubImage(300,120,60,60);
			GrabAniSubImage(300,60,60,60);
			setAnimator(); //Down & Left 5
			break;
		}
		getAnimator(0);
		setAnimSpeed(300);
		run();
	}
	
	/**
	 * @return
	 * @uml.property  name="direction"
	 */
	public int getDirection(){ return Direction ; }

	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
	
		//move Update
		//animation setting
		//animation run
		AnimationUpdate(time);//animation update
		getImage(); //image get
		
		if(getX()>=-Constants.Enemy.imagewidth &&getX()<=Constants.MainPanel.Width&&
				getY()>=-Constants.Enemy.imageheight && getY()<=Constants.MainPanel.Height
				){  //화면안에 있을떄 
		switch(Direction)
		{
		case Constants.Enemy.MoveUp:
			setY(getY()-getSpeed());
			break;
		case Constants.Enemy.MoveDown:
			setY(getY()+getSpeed());
			break;
		case Constants.Enemy.MoveRight:
			setX(getX()+getSpeed());
			break;
		case Constants.Enemy.MoveLeft:
			setX(getX()-getSpeed());
			break;
		case Constants.Enemy.MoveUPnRight:
			setY(getY()-getDiagonalSpeed());
			setX(getX()+getDiagonalSpeed());
			break;
		case Constants.Enemy.MoveUPnLeft:
			setY(getY()-getDiagonalSpeed());
			setX(getX()-getDiagonalSpeed());
			break;
		case Constants.Enemy.MoveDownnRight:
			setY(getY()+getDiagonalSpeed());
			setX(getX()+getDiagonalSpeed());
			break;
		case Constants.Enemy.MoveDownnLeft:
			setY(getY()+getDiagonalSpeed());
			setX(getX()-getDiagonalSpeed());
			break;
		}
		}else{ // 화면 밖으로 나갔을 떄
			setDead(); //죽은걸로 처리 
		}
	}

	@Override
	public Objects Shoot(long time) {
		// TODO Auto-generated method stub
		Objects Bullet=null;
		if(currentShootTime+getShootSpeed() < time)
		{
		switch(Direction)
		{
		case Constants.Enemy.MoveUp: 
			if(getX()>Constants.MainPanel.Width/2) 
				Bullet = OFac.CreateObject(Constants.Factory.E_Left_Bullet, getX(), getY()+y);
			else
				Bullet = OFac.CreateObject(Constants.Factory.E_Right_Bullet, getX()+Constants.Enemy.imagewidth, getY()+y);
			break;
		case Constants.Enemy.MoveDown:
			if(getX()>Constants.MainPanel.Width/2) 
				Bullet = OFac.CreateObject(Constants.Factory.E_Left_Bullet, getX(), getY()+y);
			else
				Bullet = OFac.CreateObject(Constants.Factory.E_Right_Bullet, getX()+Constants.Enemy.imagewidth, getY()+y);
			break;
		case Constants.Enemy.MoveRight:
			if(getY()>Constants.MainPanel.Height/2) 
				Bullet = OFac.CreateObject(Constants.Factory.E_Up_Bullet, getX()+x, getY());
			else
				Bullet = OFac.CreateObject(Constants.Factory.E_Down_Bullet, getX()+x, getY()+Constants.Enemy.imageheight);
			break;
		case Constants.Enemy.MoveLeft:
			if(getY()>Constants.MainPanel.Height/2) 
				Bullet = OFac.CreateObject(Constants.Factory.E_Up_Bullet, getX()+x, getY());
			else
				Bullet = OFac.CreateObject(Constants.Factory.E_Down_Bullet, getX()+x, getY()+Constants.Enemy.imageheight);
			break;
		case Constants.Enemy.MoveUPnRight:
			Bullet = OFac.CreateObject(Constants.Factory.E_Left_Bullet, getX(), getY()+y);
			break;
		case Constants.Enemy.MoveUPnLeft:
			Bullet = OFac.CreateObject(Constants.Factory.E_Right_Bullet, getX()+Constants.Enemy.imagewidth, getY()+y);
			break;
		case Constants.Enemy.MoveDownnRight:
			Bullet = OFac.CreateObject(Constants.Factory.E_Left_Bullet, getX(), getY()+y);
			break;
		case Constants.Enemy.MoveDownnLeft:
			Bullet = OFac.CreateObject(Constants.Factory.E_Right_Bullet, getX()+Constants.Enemy.imagewidth, getY()+y);
			break;
		}
		
		Bullet.getImage();
		currentShootTime = time;
		return Bullet;
		}
		return null;
	}
	

}
