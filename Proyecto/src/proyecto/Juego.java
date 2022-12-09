package proyecto;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//import sliders.*;
import javax.swing.JSlider;

//public class Juego extends JPanel implements KeyListener{
public class Juego extends JPanel implements KeyListener, MouseListener, MouseMotionListener{
    private Pista pista1;
    private Pista2 pista2;
    private Ruedas ruedas;
    private Rectangle rect;
    private Auto auto;
    private float angRuedasDelanteras = 0;
    private Image trail_img;
    
    // Barras de configuración
    BarraDeAjuste barraMaxVelocidad;
    BarraDeAjuste barraAceleracion;
    //BarraDeAjuste barraRoce = new BarraDeAjuste(new Rectangle(1000, 500, 300, 50), "Roce");
    // Teclas  - True equivale a que la tecla esta siendo presionada
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
        pista1= new Pista(0,0,0,0);
        pista2= new Pista2();
        auto = new Auto(rect);
        // barras de ajuste:
        barraMaxVelocidad = new BarraDeAjuste(new Rectangle(1000, 100, 300, 50), "Velocidad", auto.getLimiteDeVelocidad());
        barraAceleracion = new BarraDeAjuste(new Rectangle(1000, 200, 300, 50), "Aceleración", auto.getLimiteDeAccel());
        auto.setLimiteDeVelocidad(barraMaxVelocidad.getVariableAjustada());
        auto.setLimiteDeAccel(barraAceleracion.getVariableAjustada());
        //ASIGNACIÓN DE IMAGENES
        trail_img = new ImageIcon(this.getClass().getResource("../images/Auto/trail_01.png")).getImage();
        trail_img.toString();
        // Timer usado para actualizar la pantalla - aprox 60fps        
        Timer timer = new Timer(15, new ActionListener(){      
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
        //pista1.paint(g, 1, this);
        pista2.paint(g, 2, this);
        pista1.paint(g, this, 1);
        barraMaxVelocidad.paint(g);
        barraAceleracion.paint(g);
        /* por implementar
        barraAceleracion.paint(g);
        barraRoce.paint(g);
        */
        auto.paint(g);
        
        // ToDo: mover parte de este codigo dentro del timer del constructor
        if(wDown){
            if(angRuedasDelanteras <= 0){
                angRuedasDelanteras+=magnitudGiro;
            }            
            auto.rotaRuedas(angRuedasDelanteras);
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

        //Restaura el ángulo de las ruedas automáticamente
        if(auto.getVelocidad() > 0){
            if(angRuedasDelanteras <= 0){
                angRuedasDelanteras+=(auto.getVelocidad()/magnitudGiro);
            }
            if(angRuedasDelanteras > 0){
                angRuedasDelanteras-=(auto.getVelocidad()/magnitudGiro);
            }
            auto.rotaRuedas(angRuedasDelanteras);
        }
        if(auto.getVelocidad() < 0){
            if(angRuedasDelanteras <= 0){
                angRuedasDelanteras-=(auto.getVelocidad()/magnitudGiro);
            }
            if(angRuedasDelanteras > 0){
                angRuedasDelanteras+=(auto.getVelocidad()/magnitudGiro);
            }
            auto.rotaRuedas(angRuedasDelanteras);
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
                break;
            case 'd':
                dDown = false;
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int[] mouseCords = {e.getX(), e.getY()};
        barraAceleracion.actualizar(mouseCords, true);
        barraMaxVelocidad.actualizar(mouseCords, true);
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    public int[] getMouseCords(MouseEvent e){
        int[] mouseCords = {e.getX(), e.getY()};

        return mouseCords;

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int[] mouseCords = {e.getX(), e.getY()};
        barraAceleracion.actualizar(mouseCords, false);
        barraMaxVelocidad.actualizar(mouseCords, false);
        auto.setLimiteDeVelocidad(barraMaxVelocidad.getVariableAjustada());
        auto.setLimiteDeAccel(barraAceleracion.getVariableAjustada());
    }
    
}

