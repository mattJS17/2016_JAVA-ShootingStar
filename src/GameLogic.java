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
		DrawObject = ob;  //DrawObject와 MainPanel의 ObjectArray 연결 
		Players.add(ob.get(0)); //Player Space Ship add
	}
	
	public void GenMeteor(long time)
	{
		Meteorite temp=null; //운석을 담기 위한 임시 변수 
		int DirectionWidth; //랜덤 위치 변수 
		int DirectionHeight;//랜덤 위치 변수
		int DirecRandom; // 랜덤 방향 변수 
		if(MeteorGenTime + 1000 < time) //1초마다 생성 
		{  
				DirecRandom = (int)(Math.random()*8)+1;//1~8
				DirectionWidth = (int)(Math.random()*Constants.MainPanel.Width)+1;
				DirectionHeight = (int)(Math.random()*Constants.MainPanel.Height)+1;
				//시작점 설정
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
				
				//temp에 담고
				temp.setDirection(DirecRandom);//방향 설정
				temp.getImage();//이미지 가져오기 
				Meteorites.add(temp); //Meteorites 와 DrawObject에 add
				DrawObject.add(temp);

			
				MeteorGenTime = time; //MeteorGenTime을 CurrentTime으로 설정 
		}
	}
	
	public void GenEnemy(long time)
	{
		Enemy temp=null; //Gen을 위해 임시 데이터 
		int DirecRandom; //방향 랜덤 변수 
		int DirectionWidth; //위치 랜덤 변수 
		int DirectionHeight; // 위치 랜덤 변수 
		if(EnemyGenTime + 1000 < time) //1초에 1마리씩 Gen
		{  
			
				DirecRandom = (int)(Math.random()*8)+1;//1~8
				DirectionWidth = (int)(Math.random()*Constants.MainPanel.Width)+1;
				DirectionHeight = (int)(Math.random()*Constants.MainPanel.Height)+1;
				//시작점 랜덤 설정
				switch(DirecRandom)
				{  //Random 방향만큼 switch 
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
				
				//temp에 Enemy 생성해서 담기 
				temp.setDirection(DirecRandom); //방향 설정
				temp.getImage(); //Image가져오기 
				EnemySpaceShips.add(temp); //EnemySpaceShips와 DrawObject에 add
				DrawObject.add(temp);

			
			EnemyGenTime = time; //EnemyGenTime 을 currentTime으로 설정 
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
		//임시용 temp 
		
		Objects Player = Players.get(0);
		//player를 따로 뺴서 담아놓음
		long time = System.currentTimeMillis();
		//시간 여러번 함수 호출 하기 보다 변수에 담아 놓음 
		
		//----------------------------------------------------------------------
		//1.화면 나간것들 없애기
		//적 비행기 나간 것들 
		int total = EnemySpaceShips.size(); //전체 크기
		Object removeTemp; //지우기 위한 임시 Object
		for(int i=0;i<total;i++)
		{   //전체 크기 만큼  반복
			if(EnemySpaceShips.get(i).getAlive()==false)
			{ // 화면 나감 => IsAlive = false
				removeTemp = EnemySpaceShips.get(i); //지우기위해 temp에 담기 
				EnemySpaceShips.remove(i); //EnemySpaceShips에서 삭제 
				i--;
				total--; //한개 삭제시 ArrayList는 앞으로 밀려오니 i와 total을 1씩 감소
				for(Object ob : DrawObject)
				{ //DrawObject만큼 루프
					if(ob == removeTemp)
					{ //삭제용으로 담아놓은 값과 일치할시 DrawObject에서도 삭제
						DrawObject.remove(ob);
						break;
					}
				}
			}
		}
		
		//Meteorites 화면 밖으로 나갔는지 확인
		total = Meteorites.size();
		for(int i=0;i<total;i++)
		{
			if(Meteorites.get(i).getAlive()==false)
			{ // 화면 나감
				removeTemp = Meteorites.get(i); //임시 삭제용 저장
				Meteorites.remove(i);
				i--;
				total--;  //위 EnemySpaceShips와 같은 방식으로 처리
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
		GenEnemy(time);  //Enemy와 Meteorite 생성 (time)으로 
		GenMeteor(time);
		
		
		//----------------------------------------------------------------------
		//move DrawObject의 전체 크기만큼 돌면서 update 
		total = DrawObject.size();
		for(int i=0;i<total;i++)
		{ 
			DrawObject.get(i).update(time);
		} //all Objects update  
		
		
		//----------------------------------------------------------------------
		//Player Shoot 
		temp  = Player.Shoot(time); //get Payer and shoot
		//if ( temp == null) 이면 아직 대기 시간 
		if(temp != null)
		{
			SManager.setSound(Constants.Sound.Shoot); //Shoot sound 설정
			SManager.Play(); // 사운드 재생
			Players.add(temp); //Players에 bullet add
			DrawObject.add(temp); //DrawObject에도 add
		}
		
		//Enemy Shoot
		for(Objects ob : EnemySpaceShips) 
		{ //EnemySpaceShips만큼 루프
			temp  = ob.Shoot(time); //Enemy들도 shoot함수로 확인 
			if(temp != null)
			{//shoot이 null이 아닌 bullet이 return 됫을시 
				EnemyBullets.add(temp);  //enemybullets와 
				DrawObject.add(temp); //drawObject에 add
			}
		}
		//----------------------------------------------------------------------
		
		//----------------------------------------------------------------------
		//Collision
		//Meteorites Collision
		for(Objects ob : Meteorites)
		{
			if(Collision.CheckCollision(Player, ob)) //Player vs Meteorite
			{ // 운석과 충돌시 hp 감소
				Player.Collision(Constants.Meteorites.Damage);
				ob.Collision(Constants.Meteorites.HP); //충돌시 운석 파괴
				//운석에 자신의 HP만큼의 damage를 가함.
			}
			
			for(int i=1;i<Players.size();i++) //Player_Bullet과 Meteorite가 충돌인지 확인
			{ //0 번 index는 player 이기 때문에 제외 
				if(Collision.CheckCollision(Players.get(i),ob))
				{ //충돌이면 총알삭제 및 운석 데미지
					ob.Collision(Constants.Bullet.Damage); //Bullet Damage
					DrawObject.remove(Players.get(i));//DrawObject에서 Bullet 삭제
					Players.remove(i);//Players에서도 Bullet삭제
				}
			}

		}
		//Collision enemy Bullet
		total = EnemyBullets.size();
		for(int i=0;i<total;i++)
		{
			if(Collision.CheckCollision(Player, EnemyBullets.get(i)))
			{ // 적 총알과 충돌시 hp 감소
				Player.Collision(Constants.EnemyBullet.Damage); //Player에게 운석만큼의 데미지 
				removeTemp = EnemyBullets.get(i); //Bullet 임시 저장
				EnemyBullets.remove(i); //EnemyBullet에서 Bullet삭제
				DrawObject.remove(removeTemp); //DrawObject에서 Bullet삭제
				
				i--;  // i와 total을 1씩 감소 (하나삭제 되면 뒤로 밀리기 때문)
				total --;
				
			}
		}
		//Enemy Collision
		for(Objects ob : EnemySpaceShips)
		{
			for(int i=1;i<Players.size();i++)
			{ //0 번 index는 player 이기 때문에 제외 
				if(Collision.CheckCollision(Players.get(i),ob))
				{ //PlayerBullet과 충돌 확인 
					ob.Collision(Constants.Bullet.Damage); //EnemySpaceShips에 Damage
					DrawObject.remove(Players.get(i));//DrawObject와 
					Players.remove(i);//Players에서 Bullet 삭제 
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
			if(BGM!=null) //BGM !=null 일시 BGM Stop
			BGM.stop();
			
			
			IsRunning=false; //Game Running False
			
			GamePanel.getInstance().removePanel(Constants.Panel.GamingPanel);
			GamePanel.getInstance().setPanel(Constants.Panel.EndPanel);
			GamePanel.getInstance().setPoint(GamePoint);
			//GamePanel에서 GamingPanel remove후 EndPanel에 Point Setting
			//EndPanel add
			
			return ; //return 
		}
		
		//Enemy Hp Check
		total = EnemySpaceShips.size();
		for(int i=0;i<total;i++)
		{  //EnemySpaceShips Hp Check 
			if(EnemySpaceShips.get(i).getHP()<=0)
			{ //0보다 작을시 

				GamePoint += Constants.Enemy.Point;  //GamePoint EnemyPoint만큼 증가 
					removeTemp = (Object)EnemySpaceShips.get(i);//삭제용 임시 Object에 저장 
					EnemySpaceShips.remove(i);
					DrawObject.remove(removeTemp);
					//EnemySpaceShips와 DrawObject에서 remove
					
					SManager.setSound(Constants.Sound.Blast);
					SManager.Play(); //터지는 소리 설정후 Play
					
					i--;  //전체 크기 하나 줄이고 i도 감소 
					total--;	
					
				
				
			}
		}
		//Meteor Hp Check
		total = Meteorites.size();
		for(int i=0;i<total;i++)
		{
			if(Meteorites.get(i).getHP()<=0)
			{  //운석중 체력 낮은거 찾기 

					GamePoint += Constants.Meteorites.Point; //GamePoint MeteoritesPoint만큼 증가
					removeTemp = (Object)Meteorites.get(i); //삭제용 임시 저장
					Meteorites.remove(i);  // remove 
					DrawObject.remove(removeTemp);
					
					SManager.setSound(Constants.Sound.Blast);
					SManager.Play(); //터지는 소리 play
					
					i--; //전체 크기 한개 감소 
					total--;	
			
				
			}
		}
		//----------------------------------------------------------------------
		
		
		
	}

}
