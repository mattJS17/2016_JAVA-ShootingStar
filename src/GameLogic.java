import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;

/**
 * @author  hyojun
 */
public class GameLogic {
	
	private static GameLogic mGameLogic;
	/**
	 * @uml.property  name="mCharacter"
	 * @uml.associationEnd  readOnly="true"
	 */
	private Character mCharacter;
	
	//Object Array
	/**
	 * @uml.property  name="enemySpaceShips"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Enemy"
	 */
	private ArrayList<Objects> EnemySpaceShips;
	/**
	 * @uml.property  name="enemyBullets"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Objects"
	 */
	private ArrayList<Objects> EnemyBullets;
	/**
	 * @uml.property  name="meteorites"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Meteorite"
	 */
	private ArrayList<Objects>  Meteorites;
	/**
	 * @uml.property  name="players"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Objects"
	 */
	private ArrayList<Objects> Players;
	
	//All Object
	/**
	 * @uml.property  name="drawObject"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Objects"
	 */
	private ArrayList<Objects> DrawObject;
	

	/**
	 * @uml.property  name="stageTime"
	 */
	private long StageTime;
	/**
	 * @uml.property  name="enemyGenTime"
	 */
	private long EnemyGenTime;
	/**
	 * @uml.property  name="meteorGenTime"
	 */
	private long MeteorGenTime;
	
	/**
	 * @uml.property  name="oFac"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ObjectFactory OFac;
	
	/**
	 * @uml.property  name="gamePoint"
	 */
	private int GamePoint;
	/**
	 * @uml.property  name="sManager"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private SoundManager SManager;
	
	/**
	 * @uml.property  name="bGM"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Clip BGM;
	
	/**
	 * @uml.property  name="frame"
	 * @uml.associationEnd  
	 */
	private JFrame frame;
	/**
	 * @uml.property  name="isRunning"
	 */
	private boolean IsRunning;

	/**
	 * @uml.property  name="thread"
	 * @uml.associationEnd  inverse="mLogic:GameThread"
	 */
	private GameThread thread;
	
	private GameLogic(){
		
		EnemySpaceShips = new ArrayList<Objects>();
		EnemyBullets = new ArrayList<Objects>();
		Meteorites = new ArrayList<Objects>();
		Players = new ArrayList<Objects>();
		//Data Init
		
		IsRunning = true; //GameRunning State 
		
		OFac = ObjectFactory.getInstance();
		//Factory 
		GamePoint = 0;
		//GamePoint 
		SManager = SoundManager.getInstance();
		SManager.StopBGM();
		//SoundManager setting
		
		SManager.getSoundFile("BGM2.wav");  //bgm
		SManager.getSoundFile("shoot.wav"); //shoot
		SManager.getSoundFile("blast.wav"); //blast
		//SoundManager SoundFile get
		
		SManager.setSound(Constants.Sound.BGM_2);
		//BGM Setting
		BGM = SManager.Loop();
		//BGM play (Loop)
	}
	
	public boolean getRunning(){
		return IsRunning;
	}
	
	/**
	 * @param  thread
	 * @uml.property  name="thread"
	 */
	public void setThread(GameThread thread)
	{
		this.thread = thread;
	}
	
	public static GameLogic getInstance(){
		if(mGameLogic==null)
			mGameLogic = new GameLogic();
		return mGameLogic;
	}
	
	public int getPoint(){
		return GamePoint;
	}
	
	
	/**
	 * @param  frame
	 * @uml.property  name="frame"
	 */
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
	
	/**
	 * @param  endPanel
	 * @uml.property  name="endPanel"
	 */
	
	public void setGameObjects(ArrayList<Objects> ob)
	{
		DrawObject = ob;  //DrawObject�� MainPanel�� ObjectArray ���� 
		Players.add(ob.get(0)); //Player Space Ship add
	}
	
	public void GenMeteor(long time)
	{
		Meteorite temp=null; //��� ��� ���� �ӽ� ���� 
		int DirectionWidth; //���� ��ġ ���� 
		int DirectionHeight;//���� ��ġ ����
		int DirecRandom; // ���� ���� ���� 
		if(MeteorGenTime + 1000 < time) //1�ʸ��� ���� 
		{  
				DirecRandom = (int)(Math.random()*8)+1;//1~8
				DirectionWidth = (int)(Math.random()*Constants.MainPanel.Width)+1;
				DirectionHeight = (int)(Math.random()*Constants.MainPanel.Height)+1;
				//������ ����
				switch(DirecRandom)
				{
				case Constants.Meteorites.MoveUp:
					temp =  (Meteorite)OFac.CreateObject(Constants.Factory.Meteorites,DirectionWidth,
							Constants.MainPanel.Height);
					break;
				case Constants.Meteorites.MoveUPnRight:
					temp =  (Meteorite)OFac.CreateObject(Constants.Factory.Meteorites,DirectionWidth,
							Constants.MainPanel.Height);
					break;
				case Constants.Meteorites.MoveUPnLeft:
					temp =  (Meteorite)OFac.CreateObject(Constants.Factory.Meteorites,DirectionWidth,
							Constants.MainPanel.Height);
					break;
				case Constants.Meteorites.MoveDown:
					temp =  (Meteorite)OFac.CreateObject(Constants.Factory.Meteorites,DirectionWidth,
							-Constants.Meteorites.imageheight);
					break;
				case Constants.Meteorites.MoveDownnRight:
					temp =  (Meteorite)OFac.CreateObject(Constants.Factory.Meteorites,DirectionWidth,
							-Constants.Meteorites.imageheight);
					break;
				case Constants.Meteorites.MoveDownnLeft:
					temp =  (Meteorite)OFac.CreateObject(Constants.Factory.Meteorites,DirectionWidth,
							-Constants.Meteorites.imageheight);
					break;
				case Constants.Meteorites.MoveLeft:
					temp =  (Meteorite)OFac.CreateObject(Constants.Factory.Meteorites,Constants.MainPanel.Width,
							DirectionHeight);
					break;
				case Constants.Meteorites.MoveRight:
					temp =  (Meteorite)OFac.CreateObject(Constants.Factory.Meteorites,-Constants.Meteorites.imagewidth,
							DirectionHeight);
					break;
					
				}
				
				//temp�� ���
				temp.setDirection(DirecRandom);//���� ����
				temp.getImage();//�̹��� �������� 
				Meteorites.add(temp); //Meteorites �� DrawObject�� add
				DrawObject.add(temp);

			
				MeteorGenTime = time; //MeteorGenTime�� CurrentTime���� ���� 
		}
	}
	
	public void GenEnemy(long time)
	{
		Enemy temp=null; //Gen�� ���� �ӽ� ������ 
		int DirecRandom; //���� ���� ���� 
		int DirectionWidth; //��ġ ���� ���� 
		int DirectionHeight; // ��ġ ���� ���� 
		if(EnemyGenTime + 1000 < time) //1�ʿ� 1������ Gen
		{  
			
				DirecRandom = (int)(Math.random()*8)+1;//1~8
				DirectionWidth = (int)(Math.random()*Constants.MainPanel.Width)+1;
				DirectionHeight = (int)(Math.random()*Constants.MainPanel.Height)+1;
				//������ ���� ����
				switch(DirecRandom)
				{  //Random ���⸸ŭ switch 
				case Constants.Enemy.MoveUp:
					temp =  (Enemy)OFac.CreateObject(Constants.Factory.Enemy,DirectionWidth,
							Constants.MainPanel.Height);
					break;
				case Constants.Enemy.MoveUPnRight:
					temp =  (Enemy)OFac.CreateObject(Constants.Factory.Enemy,DirectionWidth,
							Constants.MainPanel.Height);
					break;
				case Constants.Enemy.MoveUPnLeft:
					temp =  (Enemy)OFac.CreateObject(Constants.Factory.Enemy,DirectionWidth,
							Constants.MainPanel.Height);
					break;
				case Constants.Enemy.MoveDown:
					temp =  (Enemy)OFac.CreateObject(Constants.Factory.Enemy,DirectionWidth,
							-Constants.Enemy.imageheight);
					break;
				case Constants.Enemy.MoveDownnRight:
					temp =  (Enemy)OFac.CreateObject(Constants.Factory.Enemy,DirectionWidth,
							-Constants.Enemy.imageheight);
					break;
				case Constants.Enemy.MoveDownnLeft:
					temp =  (Enemy)OFac.CreateObject(Constants.Factory.Enemy,DirectionWidth,
							-Constants.Enemy.imageheight);
					break;
				case Constants.Enemy.MoveLeft:
					temp =  (Enemy)OFac.CreateObject(Constants.Factory.Enemy,Constants.MainPanel.Width,
							DirectionHeight);
					break;
				case Constants.Enemy.MoveRight:
					temp =  (Enemy)OFac.CreateObject(Constants.Factory.Enemy,-Constants.Enemy.imagewidth,
							DirectionHeight);
					break;
					
				}
				
				//temp�� Enemy �����ؼ� ��� 
				temp.setDirection(DirecRandom); //���� ����
				temp.getImage(); //Image�������� 
				EnemySpaceShips.add(temp); //EnemySpaceShips�� DrawObject�� add
				DrawObject.add(temp);

			
			EnemyGenTime = time; //EnemyGenTime �� currentTime���� ���� 
		}
	}
	
	public int getHP()
	{
		if(Players.size()==0)
			return 0;
		return Players.get(0).getHP(); //Player Hp Return
	}
	
	public void Update(){
		Objects temp;
		//�ӽÿ� temp 
		
		Objects Player = Players.get(0);
		//player�� ���� ���� ��Ƴ���
		long time = System.currentTimeMillis();
		//�ð� ������ �Լ� ȣ�� �ϱ� ���� ������ ��� ���� 
		
		//----------------------------------------------------------------------
		//1.ȭ�� �����͵� ���ֱ�
		//�� ����� ���� �͵� 
		int total = EnemySpaceShips.size(); //��ü ũ��
		Object removeTemp; //����� ���� �ӽ� Object
		for(int i=0;i<total;i++)
		{   //��ü ũ�� ��ŭ  �ݺ�
			if(EnemySpaceShips.get(i).getAlive()==false)
			{ // ȭ�� ���� => IsAlive = false
				removeTemp = EnemySpaceShips.get(i); //��������� temp�� ��� 
				EnemySpaceShips.remove(i); //EnemySpaceShips���� ���� 
				i--;
				total--; //�Ѱ� ������ ArrayList�� ������ �з����� i�� total�� 1�� ����
				for(Object ob : DrawObject)
				{ //DrawObject��ŭ ����
					if(ob == removeTemp)
					{ //���������� ��Ƴ��� ���� ��ġ�ҽ� DrawObject������ ����
						DrawObject.remove(ob);
						break;
					}
				}
			}
		}
		
		//Meteorites ȭ�� ������ �������� Ȯ��
		total = Meteorites.size();
		for(int i=0;i<total;i++)
		{
			if(Meteorites.get(i).getAlive()==false)
			{ // ȭ�� ����
				removeTemp = Meteorites.get(i); //�ӽ� ������ ����
				Meteorites.remove(i);
				i--;
				total--;  //�� EnemySpaceShips�� ���� ������� ó��
				for(Object ob : DrawObject)
				{
					if(ob == removeTemp)
					{
						DrawObject.remove(ob);
						break;
					}
				}
			}
		}
		
		//----------------------------------------------------------------------
		
		
		//Gen Enemy
		GenEnemy(time);  //Enemy�� Meteorite ���� (time)���� 
		GenMeteor(time);
		
		
		//----------------------------------------------------------------------
		//move DrawObject�� ��ü ũ�⸸ŭ ���鼭 update 
		total = DrawObject.size();
		for(int i=0;i<total;i++)
		{ 
			DrawObject.get(i).update(time);
		} //all Objects update  
		
		
		//----------------------------------------------------------------------
		//Player Shoot 
		temp  = Player.Shoot(time); //get Payer and shoot
		//if ( temp == null) �̸� ���� ��� �ð� 
		if(temp != null)
		{
			SManager.setSound(Constants.Sound.Shoot); //Shoot sound ����
			SManager.Play(); // ���� ���
			Players.add(temp); //Players�� bullet add
			DrawObject.add(temp); //DrawObject���� add
		}
		
		//Enemy Shoot
		for(Objects ob : EnemySpaceShips) 
		{ //EnemySpaceShips��ŭ ����
			temp  = ob.Shoot(time); //Enemy�鵵 shoot�Լ��� Ȯ�� 
			if(temp != null)
			{//shoot�� null�� �ƴ� bullet�� return ������ 
				EnemyBullets.add(temp);  //enemybullets�� 
				DrawObject.add(temp); //drawObject�� add
			}
		}
		//----------------------------------------------------------------------
		
		//----------------------------------------------------------------------
		//Collision
		//Meteorites Collision
		for(Objects ob : Meteorites)
		{
			if(Collision.CheckCollision(Player, ob)) //Player vs Meteorite
			{ // ��� �浹�� hp ����
				Player.Collision(Constants.Meteorites.Damage);
				ob.Collision(Constants.Meteorites.HP); //�浹�� � �ı�
				//��� �ڽ��� HP��ŭ�� damage�� ����.
			}
			
			for(int i=1;i<Players.size();i++) //Player_Bullet�� Meteorite�� �浹���� Ȯ��
			{ //0 �� index�� player �̱� ������ ���� 
				if(Collision.CheckCollision(Players.get(i),ob))
				{ //�浹�̸� �Ѿ˻��� �� � ������
					ob.Collision(Constants.Bullet.Damage); //Bullet Damage
					DrawObject.remove(Players.get(i));//DrawObject���� Bullet ����
					Players.remove(i);//Players������ Bullet����
				}
			}

		}
		//Collision enemy Bullet
		total = EnemyBullets.size();
		for(int i=0;i<total;i++)
		{
			if(Collision.CheckCollision(Player, EnemyBullets.get(i)))
			{ // �� �Ѿ˰� �浹�� hp ����
				Player.Collision(Constants.EnemyBullet.Damage); //Player���� ���ŭ�� ������ 
				removeTemp = EnemyBullets.get(i); //Bullet �ӽ� ����
				EnemyBullets.remove(i); //EnemyBullet���� Bullet����
				DrawObject.remove(removeTemp); //DrawObject���� Bullet����
				
				i--;  // i�� total�� 1�� ���� (�ϳ����� �Ǹ� �ڷ� �и��� ����)
				total --;
				
			}
		}
		//Enemy Collision
		for(Objects ob : EnemySpaceShips)
		{
			for(int i=1;i<Players.size();i++)
			{ //0 �� index�� player �̱� ������ ���� 
				if(Collision.CheckCollision(Players.get(i),ob))
				{ //PlayerBullet�� �浹 Ȯ�� 
					ob.Collision(Constants.Bullet.Damage); //EnemySpaceShips�� Damage
					DrawObject.remove(Players.get(i));//DrawObject�� 
					Players.remove(i);//Players���� Bullet ���� 
				}
			}
		}
		//----------------------------------------------------------------------
		
		
		
		
		//----------------------------------------------------------------------
		//hp Check
		if(Player.getHP()<=0)
		{//GameOver
			//remove all
			DrawObject.clear();
			SManager.Clear();
			Players.clear();
			EnemyBullets.clear();
			EnemySpaceShips.clear(); //All Object Remove
			if(BGM!=null) //BGM !=null �Ͻ� BGM Stop
			BGM.stop();
			
			
			IsRunning=false; //Game Running False
			
			GamePanel.getInstance().removePanel(Constants.Panel.GamingPanel);
			GamePanel.getInstance().setPanel(Constants.Panel.EndPanel);
			GamePanel.getInstance().setPoint(GamePoint);
			//GamePanel���� GamingPanel remove�� EndPanel�� Point Setting
			//EndPanel add
			
			return ; //return 
		}
		
		//Enemy Hp Check
		total = EnemySpaceShips.size();
		for(int i=0;i<total;i++)
		{  //EnemySpaceShips Hp Check 
			if(EnemySpaceShips.get(i).getHP()<=0)
			{ //0���� ������ 

				GamePoint += Constants.Enemy.Point;  //GamePoint EnemyPoint��ŭ ���� 
					removeTemp = (Object)EnemySpaceShips.get(i);//������ �ӽ� Object�� ���� 
					EnemySpaceShips.remove(i);
					DrawObject.remove(removeTemp);
					//EnemySpaceShips�� DrawObject���� remove
					
					SManager.setSound(Constants.Sound.Blast);
					SManager.Play(); //������ �Ҹ� ������ Play
					
					i--;  //��ü ũ�� �ϳ� ���̰� i�� ���� 
					total--;	
					
				
				
			}
		}
		//Meteor Hp Check
		total = Meteorites.size();
		for(int i=0;i<total;i++)
		{
			if(Meteorites.get(i).getHP()<=0)
			{  //��� ü�� ������ ã�� 

					GamePoint += Constants.Meteorites.Point; //GamePoint MeteoritesPoint��ŭ ����
					removeTemp = (Object)Meteorites.get(i); //������ �ӽ� ����
					Meteorites.remove(i);  // remove 
					DrawObject.remove(removeTemp);
					
					SManager.setSound(Constants.Sound.Blast);
					SManager.Play(); //������ �Ҹ� play
					
					i--; //��ü ũ�� �Ѱ� ���� 
					total--;	
			
				
			}
		}
		//----------------------------------------------------------------------
		
		
		
	}

}
