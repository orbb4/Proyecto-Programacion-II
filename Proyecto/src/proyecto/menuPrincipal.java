package proyecto;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
public class menuPrincipal extends JPanel{
    public menuPrincipal(){
        this.setLayout(null);          
    }
    //colision con botones:
    public void mousePressed(MouseEvent me) {
        //colision boton jugar:
        if(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 175  && me.getY() <= 225){
            System.out.println("jugar");
        }
        
        //colision boton configuración:
        
        //colision boton salir:

    }
    
    
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.CYAN);
        g.fillRect(400, 300, 600,150);
        g.setColor(Color.CYAN);
        g.fillRect(400, 500, 600,150);
        g.setColor(Color.BLACK);
        g.setFont( new Font( "Arial", Font.BOLD, 50 ) );
        g.drawString("JUGAR", 600, 400);
        
        g.setColor(Color.BLACK);
        g.setFont( new Font( "Arial", Font.BOLD, 50 ) );
        g.drawString("CONFIGURACIÓN", 500, 580); 
        
        g.setColor(Color.BLACK);
        g.setFont( new Font( "Arial", Font.BOLD, 100 ) );
        g.drawString("MENÚ PRINCIPAL", 300, 100);

    }
}

