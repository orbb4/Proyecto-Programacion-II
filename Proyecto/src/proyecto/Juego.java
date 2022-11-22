package proyecto;
import java.awt.*;
import javax.swing.*;
public class Juego extends JPanel{
    public Juego(){
        this.setLayout(null); 
        
    }
    public void paint(Graphics g){       
        super.paint(g);
        this.setBackground(Color.GREEN);
        // prototipo. Se deberia llamar al paint de una instancia de Auto
        g.setColor(Color.RED);
        g.fillRect(500, 500, 40, 80);
    }
    
}

