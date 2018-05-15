
/**
 * @author  hyojun
 */
public class Meteorite extends Objects{

	
	/**
	 * @uml.property  name="direction"
	 */
	private int Direction;
	public Meteorite(int x, int y, int w, int h,int hp,String imagePath) {
		super(x, y, w, h,hp,imagePath);
		// TODO Auto-generated constructor stub
		setSpeed(10);

		
		newSprite();
		GrabAniSubImage(0,0,50,50);
		setAnimator(); //UP 0
	}
	
	/**
	 * @param  direction
	 * @uml.property  name="direction"
	 */
	public void setDirection(int direction)
	{
		Direction = direction;
	}
	
	
	


	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		run(); //animation run
		AnimationUpdate(time);//animation update
		getImage(); //image get
		
		if(getX()>=-Constants.Meteorites.imagewidth &&getX()<=Constants.MainPanel.Width&&
				getY()>=-Constants.Meteorites.imageheight && getY()<=Constants.MainPanel.Height
				){  //화면안에 있을떄 
		switch(Direction)
		{
		case Constants.Meteorites.MoveUp:
			setY(getY()-getSpeed());
			break;
		case Constants.Meteorites.MoveDown:
			setY(getY()+getSpeed());
			break;
		case Constants.Meteorites.MoveRight:
			setX(getX()+getSpeed());
			break;
		case Constants.Meteorites.MoveLeft:
			setX(getX()-getSpeed());
			break;
		case Constants.Meteorites.MoveUPnRight:
			setY(getY()-getDiagonalSpeed());
			setX(getX()+getDiagonalSpeed());
			break;
		case Constants.Meteorites.MoveUPnLeft:
			setY(getY()-getDiagonalSpeed());
			setX(getX()-getDiagonalSpeed());
			break;
		case Constants.Meteorites.MoveDownnRight:
			setY(getY()+getDiagonalSpeed());
			setX(getX()+getDiagonalSpeed());
			break;
		case Constants.Meteorites.MoveDownnLeft:
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
		return null;
	}
}
