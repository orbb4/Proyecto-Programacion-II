package proyecto;
import java.awt.*;
import javax.swing.*;
public class Juego extends JPanel{
    private Ruedas ruedas;
    private Rectangle rect;
    public Juego(){
        rect = new Rectangle(600, 200, 40, 80);
        this.setLayout(null); 
        ruedas = new Ruedas(rect);
    }
    public void paint(Graphics g){       
        super.paint(g);
        this.setBackground(Color.GREEN);
        // prototipo. Se deberia llamar al paint de una instancia de Auto
        g.setColor(Color.RED);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
        ruedas.paint(g);
        
    }
    
}

