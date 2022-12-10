package proyecto;
import java.awt.*;
import javax.swing.*;

import java.awt.Color;
import java.io.InputStream;
import javax.sound.sampled.*;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Ventana extends JFrame {
    
private final Color COLOR_PANEL = new Color(50, 50, 160);
    private menuPrincipal menuPrincipal; // minusculas :(
    private Juego nuevoJuego;
    
    //AUDIO
    InputStream inputStream;
    AudioInputStream audioStream;
    AudioFormat audioFormat;
    DataLine.Info info;
    SourceDataLine sourceDataLine;
    private static final int BUFFER_SIZE = 4096;
    private AudioPlayer player;
    private String loc = "../audio/bgm/m.wav";
            
    public Ventana(){
        super();
        
        //CONFIGURACIONES INICIALES
        this.setLayout(null);
        this.setTitle("Simulador de Conduccion");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setSize(1370, 700); 
        this.setVisible(true); 
        this.setResizable(true);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            
        //INTEGRACION DE ELEMENTOS VARIOS
        //menuPrincipal = new menuPrincipal();
        nuevoJuego = new Juego(2);
        //this.add(menuPrincipal);
        this.add(nuevoJuego);
        this.addKeyListener(nuevoJuego);
        this.addMouseListener(nuevoJuego);
        this.addMouseMotionListener(nuevoJuego);
        //CONFIGURACION DE ELEMENTOS
        //menuPrincipal.setBounds(0, 0, 1370, 700);
        nuevoJuego.setBounds(0, 0, 1370, 700);
        //menuPrincipal.setVisible(false);
        nuevoJuego.setVisible(true);
        player.play(loc);
   }        
}         