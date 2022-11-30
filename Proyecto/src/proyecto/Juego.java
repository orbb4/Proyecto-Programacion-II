package proyecto;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private float angRuedasDelanteras = 0;
    // teclas (true equivale a que la tecla esta siendo presionada)
    private boolean wDown = false;
    private boolean sDown = false;
    private boolean aDown = false;
    private boolean dDown = false;
    
    
    public Juego(){
        
        //CONFIGURACIONES INICIALES
        this.setFocusable(true);
        this.setLayout(null); 
        //INSTANCIACIONES 
        rect = new Rectangle(600, 200, 40, 80);
        pista1= new Pista();

        auto = new Auto(rect);
        // Timer usado para actualizar la pantalla - aprox 60fps
        Timer timer = new Timer (16, new ActionListener (){      
        public void actionPerformed(ActionEvent e)
            {
                
                repaint();
            }
        });
        timer.start();
    }
    public void paint(Graphics g){
        int maxAnguloRuedas = 16;
        float magnitudGiro = 2f;
        boolean retroceso = true;
        
        super.paint(g);
        this.setBackground(Color.GREEN);
        pista1.paint(g, this);
        auto.paint(g);
        // ToDo: mover parte de este codigo dentro del timer del constructor
        if(wDown){
            auto.Acelerar(!retroceso);
        }
        if(sDown){
            auto.Acelerar(retroceso);
        }
        if(aDown){
            if(angRuedasDelanteras >= -maxAnguloRuedas){
                angRuedasDelanteras-=magnitudGiro;
            }            
            auto.rotaRuedas(angRuedasDelanteras);
            auto.setAngle(auto.getAngle()-magnitudGiro);
        }
        if(dDown){
            if(angRuedasDelanteras <= maxAnguloRuedas){
                angRuedasDelanteras+=magnitudGiro;
            }    
            auto.rotaRuedas(angRuedasDelanteras);
            auto.setAngle(auto.getAngle()+magnitudGiro);
        }
        
        if(!(wDown || sDown)){
             auto.Desacelerar();
        }
        
        auto.actualizaPosicion();
        
        
    }
    @Override
    public void keyPressed(KeyEvent event){
        
    }
    // Codigo movido desde keyPressed, ya que estando dentro del metodo anterior
    // se generaba un pequeño delay
    @Override
    public void keyTyped(KeyEvent ke) {
        char ch = ke.getKeyChar();
        switch(ch){
            case 'w':
                 wDown = true;
                 break;
            case 's':
                sDown = true;
                break;
            case 'a':
                aDown = true;
                break;
            case 'd':
                dDown = true;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        char ch = ke.getKeyChar();
        switch(ch){
            case 'w':
                 wDown = false;
                 break;
            case 's':
                sDown = false;
                break;
            case 'a':
                aDown = false;
                //angRuedasDelanteras = 0;
                break;
            case 'd':
                dDown = false;
                //angRuedasDelanteras = 0;
                break;
        }
    }
}

