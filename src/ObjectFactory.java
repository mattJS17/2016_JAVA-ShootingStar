
public class ObjectFactory {
	
	private static ObjectFactory mObjectFactory;
	
	private ObjectFactory(){
		
	}
	
	public static ObjectFactory getInstance(){
		if(mObjectFactory==null){
			mObjectFactory = new ObjectFactory();
		}
		return mObjectFactory;
	}
	
	public Objects CreateObject(int name,int x,int y)
	{
		switch (name){
		case Constants.Factory.Player:
			return new Character(x,y,Constants.Player.Width,Constants.Player.Height,Constants.Player.HP,Constants.Player.ImagePath);
		case Constants.Factory.P_Up_Bullet:
			return new PlayerBullet(x,y,Constants.Bullet.imagewidth,Constants.Bullet.imageheight,0,Constants.Bullet.ImagePath,Constants.Bullet.Up);
		case Constants.Factory.P_Down_Bullet:
			return new PlayerBullet(x,y,Constants.Bullet.imagewidth,Constants.Bullet.imageheight,0,Constants.Bullet.ImagePath,Constants.Bullet.Down);
		case Constants.Factory.P_Left_Bullet:
			return new PlayerBullet(x,y,Constants.Bullet.imagewidth,Constants.Bullet.imageheight,0,Constants.Bullet.ImagePath,Constants.Bullet.left);
		case Constants.Factory.P_Right_Bullet:
			return new PlayerBullet(x,y,Constants.Bullet.imagewidth,Constants.Bullet.imageheight,0,Constants.Bullet.ImagePath,Constants.Bullet.right);
		case Constants.Factory.Enemy:
			return new Enemy(x,y,Constants.Enemy.imagewidth,Constants.Enemy.imageheight,Constants.Enemy.HP,Constants.Enemy.ImagePath);
		case Constants.Factory.Meteorites:
			return new Meteorite(x,y,Constants.Meteorites.imagewidth,Constants.Meteorites.imageheight,Constants.Meteorites.HP,Constants.Meteorites.ImagePath);
		case Constants.Factory.E_Up_Bullet:
			return new EnemyBullet(x,y,Constants.Bullet.imagewidth,Constants.Bullet.imageheight,0,Constants.EnemyBullet.ImagePath,Constants.Bullet.Up);
		case Constants.Factory.E_Down_Bullet:
			return new EnemyBullet(x,y,Constants.Bullet.imagewidth,Constants.Bullet.imageheight,0,Constants.EnemyBullet.ImagePath,Constants.Bullet.Down);
		case Constants.Factory.E_Left_Bullet:
			return new EnemyBullet(x,y,Constants.Bullet.imagewidth,Constants.Bullet.imageheight,0,Constants.EnemyBullet.ImagePath,Constants.Bullet.left);
		case Constants.Factory.E_Right_Bullet:
			return new EnemyBullet(x,y,Constants.Bullet.imagewidth,Constants.Bullet.imageheight,0,Constants.EnemyBullet.ImagePath,Constants.Bullet.right);
 
		}
		return null;
	}

}
