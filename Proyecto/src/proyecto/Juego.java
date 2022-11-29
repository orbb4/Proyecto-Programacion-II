package proyecto;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class Juego extends JPanel implements KeyListener{
    private Pista pista1;
    private Ruedas ruedas;
    private Rectangle rect;
    private Auto auto;
    private int angRuedasDelanteras = 0;
    
    public Juego(){
        
        //CONFIGURACIONES INICIALES
        this.setFocusable(true);
        this.setLayout(null); 
        //INSTANCIACIONES 
        rect = new Rectangle(600, 200, 40, 80);
        pista1= new Pista();

        auto = new Auto(rect);
    }
    public void paint(Graphics g){       
        super.paint(g);
        this.setBackground(Color.GREEN);
        pista1.paint(g, this);
        auto.paint(g);
    }
    @Override
    public void keyPressed(KeyEvent event){
        char ch = event.getKeyChar();
        System.out.println("!!");

        if(ch == 'w'){
            auto.Acelerar();
            Juego.this.repaint();
        }
        if(ch == 'd' && angRuedasDelanteras < 20){
            angRuedasDelanteras++;
            auto.rotaRuedas(angRuedasDelanteras);
            Juego.this.repaint();
        }
        if(ch == 'a' && angRuedasDelanteras > -20){
            angRuedasDelanteras--;
            auto.rotaRuedas(angRuedasDelanteras);
            Juego.this.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}

