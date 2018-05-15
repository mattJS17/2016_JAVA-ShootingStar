

/**
 * @author  hyojun
 */
public class EnemyBullet extends Objects{
	
	/**
	 * @uml.property  name="bulletDirection"
	 */
	private int BulletDirection; 

	public EnemyBullet(int x, int y, int width, int height,int hp, String uri,int Direction) {
		super(x, y, width, height,hp, uri);
		setSpeed(10); //move speed 
		BulletDirection = Direction;
		
		if(BulletDirection==Constants.EnemyBullet.Up || BulletDirection==Constants.EnemyBullet.Down){
			newSprite();
			GrabAniSubImage(0,0,25,25);
			GrabAniSubImage(0,25,25,25);
			setAnimator(); //UP & Down
		}
		else {
			
			newSprite();
			GrabAniSubImage(25,0,25,25);
			GrabAniSubImage(25,25,25,25);
			setAnimator(); //Right & Left
		}
		
		setAnimSpeed(300);
		run();
		
		
	}


	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		//Bullet이 화면안에 있으면 각 방향 값에 맞춰 직진 
		if(getX()>=-Constants.EnemyBullet.imagewidth &&getX()<=Constants.MainPanel.Width+Constants.EnemyBullet.imagewidth&&
				getY()>=-Constants.EnemyBullet.imageheight && getY()<=Constants.MainPanel.Height
				){//총알이 화면 안에 있을 때
			
			//animation setting
			AnimationUpdate(time);//animation update
			getImage(); //image get
			
			switch(BulletDirection){
			case Constants.EnemyBullet.Up:
				setY(getY()-getSpeed());
				//mBullet.set(i,tempBullet);
				break;
			case Constants.EnemyBullet.Down:
				setY(getY()+getSpeed());
				//mBullet.set(i, tempBullet);
				break;
			case Constants.EnemyBullet.left:
				setX(getX()-getSpeed());
				//mBullet.set(i, tempBullet);
				break;
			case Constants.EnemyBullet.right:
				setX(getX()+getSpeed());
				//mBullet.set(i, tempBullet);
				break;
			}
		}else{ //화면 밖으로 총알 나감 삭제
				
		}
	}

	@Override
	public Objects Shoot(long time) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
