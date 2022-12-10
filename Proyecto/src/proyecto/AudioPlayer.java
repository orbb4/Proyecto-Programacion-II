
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author bas_b
 */
public class AudioPlayer{

    boolean isPlaybackCompleted;
    
    public static void play(String ubi){
        
        // getAudioInputStream() also accepts a File or InputStream
        try{
            InputStream in = AudioPlayer.class.getClassLoader().getResourceAsStream("j");
            System.out.println(in);
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(in);
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            SwingUtilities.invokeLater(() -> {
            // A GUI element to prevent the Clip's daemon Thread
            // from terminating at the end of the main()
            JOptionPane.showMessageDialog(null, "Close to exit!");
            });
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}