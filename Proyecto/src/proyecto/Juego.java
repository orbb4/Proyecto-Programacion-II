package proyecto;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class Juego extends JPanel{
    private Pista pista1;
    private Ruedas ruedas;
    private Rectangle rect;
    private Auto auto;
    private int angRuedasDelanteras = 0;
    
    public Juego(){
        
        //CONFIGURACIONES INICIALES
        this.setFocusable(true);
        this.setLayout(null); 
        this.addKeyListener(new KeyChecker());
        //INSTANCIACIONES 
        rect = new Rectangle(600, 200, 40, 80);
        ruedas = new Ruedas(rect);
        pista1= new Pista();
        auto = new Auto(ruedas);
    }
    public void paint(Graphics g){       
        super.paint(g);
        this.setBackground(Color.GREEN);
        ruedas.paint(g);
        pista1.paint(g, this);
        auto.paint(g);

        Toolkit.getDefaultToolkit().sync(); //para la inestabilidad del framerate
        g.dispose();
        repaint();
    }
    class KeyChecker extends KeyAdapter{
        public void keyPressed(KeyEvent event){
            char ch = event.getKeyChar();
            System.out.println(event.getKeyChar());
            
            if(ch == 'w'){
                auto.Acelerar();
                Juego.this.repaint();
            }
            if(ch == 'd' && angRuedasDelanteras < 20){
                angRuedasDelanteras++;
                ruedas.setAngulo(angRuedasDelanteras, true, true, false, false);
                Juego.this.repaint();
            }
            if(ch == 'a' && angRuedasDelanteras > -20){
                angRuedasDelanteras--;
                ruedas.setAngulo(angRuedasDelanteras, true, true, false, false);
                Juego.this.repaint();
            }
        }
    }
}

