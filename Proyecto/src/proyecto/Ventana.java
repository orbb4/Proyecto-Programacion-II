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
    private Juego nuevoJuego;
    
    //AUDIO
    private AudioPlayer player;
    private String loc = ".\\src\\audio\\bgm\\m.wav";
            
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
        player = new AudioPlayer();
        nuevoJuego = new Juego(2);
        nuevoJuego = new Juego(1);
        this.add(nuevoJuego);
        this.addKeyListener(nuevoJuego);
        this.addMouseListener(nuevoJuego);
        this.addMouseMotionListener(nuevoJuego);
        //CONFIGURACION DE ELEMENTOS
        nuevoJuego.setBounds(0, 0, 1370, 700);
        player.play(loc);
   }        
}         