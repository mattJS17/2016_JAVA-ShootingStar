
public class Constants {
	
	public static class Panel{
		static final int StartPanel = 1;
		static final int GamingPanel = 2;
		static final int EndPanel = 3;
	}
	
	public static class Bullet{
		 static final int Up = 1;
		 static final int Down = 2;
		 static final int left = 3;
		static final int right = 4; //Player Bullet Direction
		static final int imagewidth=25;
		static final int imageheight=25;
		static final String ImagePath="PlayerLaser.png";
		static final int Damage = 10;
	}
	
	public static class EnemyBullet{
		 static final int Up = 1;
		 static final int Down = 2;
		 static final int left = 3;
		static final int right = 4; //EnemyBullet Direction
		static final int imagewidth=25;
		static final int imageheight=25;
		static final String ImagePath="EnemyLasers.png";
		static final int Damage = 20;
	}
	
	public static class Factory{
		static final int Player = 1;
		static final int P_Up_Bullet = 2;
		static final int P_Down_Bullet = 3;
		static final int P_Right_Bullet = 4;
		static final int P_Left_Bullet = 5;
		static final int Enemy=6;
		static final int Meteorites = 7;
		static final int E_Up_Bullet = 8;
		static final int E_Down_Bullet = 9;
		static final int E_Right_Bullet = 10;
		static final int E_Left_Bullet = 11;
	}
	
	public static class MainPanel{
		static final int Width = 1200;
		static final int Height = 800;
		static final String Background = "background.jpg";
	}
	
	public static class Player{
		static final int Width = 60;
		static final int Height = 60;
		static final int StartX = 10;
		static final int StartY = 10;
		static final String ImagePath="Player.png";
		static final int imagewidth=60;
		static final int imageheight=60;
		static final int HP = 100;
	}
	
	public static class Stage{
		static final int NextStage = 10;
	}
	
	public static class Sound{
		static final int BGM_1 = 0;
		static final int BGM_2 = 1;
		static final int Shoot = 2;
		static final int Blast = 3;
	}
	
	public static class Enemy{
		static final int MoveUp=1;
		static final int MoveDown=2;
		static final int MoveLeft=3;
		static final int MoveRight=4;
		static final int MoveUPnRight=5;
		static final int MoveUPnLeft=6;
		static final int MoveDownnRight=7;
		static final int MoveDownnLeft=8;
		
		static final int GenUp =9;
		static final int GenDown = 10;
		static final int GenLeft = 11;
		static final int GenRight = 12;
		
		static final String ImagePath="EnemySpaceShip.png";
		static final int imagewidth=60;
		static final int imageheight=60;
		static final int HP = 30;
		static final int Point = 100;
	}
	
	public static class Meteorites{
		static final int MoveUp=1;
		static final int MoveDown=2;
		static final int MoveLeft=3;
		static final int MoveRight=4;
		static final int MoveUPnRight=5;
		static final int MoveUPnLeft=6;
		static final int MoveDownnRight=7;
		static final int MoveDownnLeft=8;
		static final String ImagePath="stars.png";
		static final int imagewidth=50;
		static final int imageheight=50;
		static final int HP = 10;
		static final int Damage = 10;
		static final int Point = 50;
	}
}
