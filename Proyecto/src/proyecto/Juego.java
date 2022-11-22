package proyecto;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class Juego extends JPanel{
    public Juego(){
        this.setFocusable(true);
        this.setLayout(null); 
        this.addKeyListener(new KeyChecker());
        
    }
    public void paint(Graphics g){       
        super.paint(g);
        this.setBackground(Color.GREEN);
        // prototipo. Se deberia llamar al paint de una instancia de Auto
        g.setColor(Color.RED);
        g.fillRect(500, 500, 40, 80);
    }
    
class KeyChecker extends KeyAdapter{
    public void keyPressed(KeyEvent event){
        char ch = event.getKeyChar();
        System.out.println(event.getKeyChar());
    }
}
}

