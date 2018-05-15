

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
		//Bullet�� ȭ��ȿ� ������ �� ���� ���� ���� ���� 
		if(getX()>=-Constants.EnemyBullet.imagewidth &&getX()<=Constants.MainPanel.Width+Constants.EnemyBullet.imagewidth&&
				getY()>=-Constants.EnemyBullet.imageheight && getY()<=Constants.MainPanel.Height
				){//�Ѿ��� ȭ�� �ȿ� ���� ��
			
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
		}else{ //ȭ�� ������ �Ѿ� ���� ����
				
		}
	}

	@Override
	public Objects Shoot(long time) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
