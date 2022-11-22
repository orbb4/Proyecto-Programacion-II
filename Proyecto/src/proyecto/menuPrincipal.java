package proyecto;
import java.awt.*;
import javax.swing.*;
public class menuPrincipal extends JPanel{
    public menuPrincipal(){
        this.setLayout(null);          
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