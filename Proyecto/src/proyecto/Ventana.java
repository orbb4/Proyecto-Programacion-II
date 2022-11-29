package proyecto;
import java.awt.*;
import javax.swing.*;

import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Ventana extends JFrame {
    
private final Color COLOR_PANEL = new Color(50, 50, 160);
    private menuPrincipal menuPrincipal; // minusculas :(
    private Juego nuevoJuego;
    
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
        nuevoJuego = new Juego();
        //this.add(menuPrincipal);
        this.add(nuevoJuego);
        this.addKeyListener(nuevoJuego);
        
        //CONFIGURACION DE ELEMENTOS
        //menuPrincipal.setBounds(0, 0, 1370, 700);
        nuevoJuego.setBounds(0, 0, 1370, 700);
        //menuPrincipal.setVisible(false);
        nuevoJuego.setVisible(true);

   }        
}         