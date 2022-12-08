/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.io.File;
import javax.sound.sampled.*;

/**
 *
 * @author bas_b
 */
public class AudioPlayer{

    boolean isPlaybackCompleted;
    
    public static void play(String ubi){
        
        try{
            File inputStream = new File(ubi);
            if(inputStream.exists()){
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);
                Clip audioClip = AudioSystem.getClip();
                audioClip.open(audioStream);
                audioClip.start();
            }
            else{
                System.out.println("lol");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}