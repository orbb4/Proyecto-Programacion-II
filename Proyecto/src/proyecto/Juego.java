package proyecto;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class Juego extends JPanel{
    private Ruedas ruedas;
    private Rectangle rect;
    public Juego(){
<<<<<<< HEAD
        this.setFocusable(true);
        this.setLayout(null); 
        this.addKeyListener(new KeyChecker());
        
=======
        rect = new Rectangle(600, 200, 40, 80);
        this.setLayout(null); 
        ruedas = new Ruedas(rect);
>>>>>>> rena
    }
    public void paint(Graphics g){       
        super.paint(g);
        this.setBackground(Color.GREEN);
        // prototipo. Se deberia llamar al paint de una instancia de Auto
        g.setColor(Color.RED);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
        ruedas.paint(g);
        
    }
    
class KeyChecker extends KeyAdapter{
    public void keyPressed(KeyEvent event){
        char ch = event.getKeyChar();
        System.out.println(event.getKeyChar());
    }
}
}

