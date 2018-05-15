

/**
 * @author  hyojun
 */
public class PlayerBullet extends Objects{
	
	/**
	 * @uml.property  name="bulletDirection"
	 */
	private int BulletDirection; 

	public PlayerBullet(int x, int y, int width, int height,int hp, String uri,int Direction) {
		super(x, y, width, height,hp, uri);
		setSpeed(20); //move speed 
		BulletDirection = Direction;
		
		if(BulletDirection==Constants.Bullet.Up || BulletDirection==Constants.Bullet.Down){
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
		
		
	}


	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		//Bullet�� ȭ��ȿ� ������ �� ���� ���� ���� ���� 
		if(getX()>=-Constants.Bullet.imagewidth &&getX()<=Constants.MainPanel.Width+Constants.Bullet.imagewidth&&
				getY()>=-Constants.Bullet.imageheight && getY()<=Constants.MainPanel.Height
				){//�Ѿ��� ȭ�� �ȿ� ���� ��
			
			//animation setting
			run(); //animation run
			AnimationUpdate(time);//animation update
			getImage(); //image get
			
			switch(BulletDirection){
			case Constants.Bullet.Up:
				setY(getY()-getSpeed());
				//mBullet.set(i,tempBullet);
				break;
			case Constants.Bullet.Down:
				setY(getY()+getSpeed());
				//mBullet.set(i, tempBullet);
				break;
			case Constants.Bullet.left:
				setX(getX()-getSpeed());
				//mBullet.set(i, tempBullet);
				break;
			case Constants.Bullet.right:
				setX(getX()+getSpeed());
				//mBullet.set(i, tempBullet);
				break;
			}
		}else{ //ȭ�� ������ �Ѿ� ���� ����
				
		}
	}

	@Override
	public Objects Shoot(long time) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
