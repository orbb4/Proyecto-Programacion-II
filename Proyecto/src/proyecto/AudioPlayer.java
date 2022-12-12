package proyecto;
import java.io.*;
import javax.sound.sampled.*;


/**
 * Un reproductor de audio
 * @author bas_b
 */
public class AudioPlayer{

    /**
     * Reproduce el audio ubicado en la dirección dada
     *@param ubi ubicación del archivo a reproducir
    */
    public void play(String ubi){
        try{
            File f=new File(ubi);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(f);
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            Clip c = (Clip) AudioSystem.getLine(info);
            c.open(audioStream);
            c.start();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}