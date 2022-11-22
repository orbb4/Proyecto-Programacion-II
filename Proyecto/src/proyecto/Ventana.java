package proyecto;
import java.awt.*;
import javax.swing.*;

import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Ventana extends JFrame {
    
    private final Color COLOR_PANEL = new Color(50, 50, 160);
    private menuPrincipal menuPrincipal; // minusculas :(
    public Ventana(){
        super();
        this.setLayout(null);
        this.setTitle("Simulador de Conduccion");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setSize(1370, 700); 
        
        /*this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(200,200));*/

        this.setVisible(true); 
        this.setResizable(true);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        menuPrincipal = new menuPrincipal();     
        menuPrincipal.setBounds(0, 0, 1370, 700);
        this.add(menuPrincipal);      

   }        
}         