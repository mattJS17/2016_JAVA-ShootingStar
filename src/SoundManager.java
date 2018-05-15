import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * @author  hyojun
 */
public class SoundManager {
	
	private static boolean flag_BackSound = true;
	private static boolean flag_EffectSound = true;
	
    /**
	 * @uml.property  name="clip"
	 * @uml.associationEnd  
	 */
    private Clip clip;
    
    /**
	 * @uml.property  name="bGM"
	 * @uml.associationEnd  
	 */
    private Clip BGM;
    
    /**
	 * @uml.property  name="clipArray"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="javax.sound.sampled.Clip"
	 */
    private ArrayList<Clip> ClipArray;
    
    private static SoundManager mSoundManager=null;
	
    private SoundManager() {	
    	
    	ClipArray = new ArrayList<Clip>();
    }
    
    public static  void setFlag_BGM(boolean flag)
    {
    	flag_BackSound = flag;
    }
    
    public static  void setFlag_Effect(boolean flag)
    {
    	flag_EffectSound = flag;
    }
    
    public static boolean getFlag_BGM() { return flag_BackSound ; }
    public static boolean getFlag_Effect() { return flag_EffectSound ; }
    
    public static SoundManager getInstance(){
    	if(mSoundManager ==null)
    	{
    		mSoundManager = new SoundManager();
    		return mSoundManager;
    	}
    	return mSoundManager;
    }
    
    public void getSoundFile(String fileName)
    {
    	  try {
              File file = new File(fileName);
              
              if (file.exists()) {
                  AudioInputStream sound = AudioSystem.getAudioInputStream(file);
               
                  clip = AudioSystem.getClip();
                  clip.open(sound);
                  ClipArray.add(clip);
              }
              else {
                  throw new RuntimeException("FILE CAN'T FIND : " + fileName);
              }
          }
          catch (MalformedURLException e) {
              e.printStackTrace();
              throw new RuntimeException("MALFORMED URL: " + e);
          }
          catch (UnsupportedAudioFileException e) {
              e.printStackTrace();
              throw new RuntimeException("UNSUPPORTED FILE : " + e);
          }
          catch (IOException e) {
              e.printStackTrace();
              throw new RuntimeException("INPUT / OUTPUT ERROR : " + e);
          }
          catch (LineUnavailableException e) {
              e.printStackTrace();
              throw new RuntimeException("EXCEPTION ERROR: " + e);
          }  
    }
    
    public void StopBGM(){
    	BGM.stop();
    }
    
    public void Clear()
    {
    	for(int i=0;i<ClipArray.size();i++)
    	{
    		ClipArray.get(i).stop();
    	}
    }
    
    public void setSound(int i)
    {
    	clip = ClipArray.get(i);
    }
    
    // play, stop, loop the sound clip
    public void Play(){
    	if(flag_EffectSound==true){
        clip.setFramePosition(0);  //frameposition
        clip.start();
    	}
    }
    public void Stop(int soundNumber) {
 
        clip.stop();
        clip.close();
    }
    public Clip Loop(){
    	if(flag_BackSound==true){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        BGM = clip;
        return clip;
    	}return null;
    }
}