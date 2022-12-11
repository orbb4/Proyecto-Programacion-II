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
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//import sliders.*;
import javax.swing.JSlider;

//public class Juego extends JPanel implements KeyListener{
public class Juego extends JPanel implements KeyListener, MouseListener, MouseMotionListener{
    private Pista pista0;
    private Pista pista1;
    private Pista pista2;
    private Pista pista3;
    private Pista pistaElegida;
    private Ruedas ruedas;
    private Rectangle rect;
    private Auto auto;
    private float angRuedasDelanteras = 0;
    private Image trail_img;
    private int numPistaElegida;
    private ArrayList<Rectangle> colliders;
    private Toolkit t;
    // Barras de configuración
    BarraDeAjuste barraMaxVelocidad;
    BarraDeAjuste barraAceleracion;
    BarraDeAjuste barraTipoPista;
    //BarraDeAjuste barraRoce = new BarraDeAjuste(new Rectangle(1000, 500, 300, 50), "Roce");
    // Teclas  - True equivale a que la tecla esta siendo presionada
    private boolean wDown = false;
    private boolean sDown = false;
    private boolean aDown = false;
    private boolean dDown = false;
    
    public Juego(int numPistaElegida){
        
        //CONFIGURACIONES INICIALES
        this.setFocusable(true);
        this.setLayout(null); 
        
        //INSTANCIACIONES 
        rect = new Rectangle(600, 200, 20, 40); //40-80
        pista0= new Pista(2, 50, 78);
        pista1= new Pista(0, 0, 78);
        pista2= new Pista(0, 0, 78);
        pista3= new Pista(0, 0, 78);
        auto = new Auto(rect);
        t = Toolkit.getDefaultToolkit(); 
        this.numPistaElegida = numPistaElegida;
        
        switch(numPistaElegida){
            case 0:
                pistaElegida = pista0;
                break;
            case 1:
                pistaElegida = pista1;
                break;
            case 2:
                pistaElegida = pista2;
                break;
            case 3:
                pistaElegida = pista3;
                break;  
        }
        // barras de ajuste:
        barraMaxVelocidad = new BarraDeAjuste(new Rectangle(1065, 50, 245, 40), "Velocidad", auto.getLimiteDeVelocidad(), 12);
        barraAceleracion = new BarraDeAjuste(new Rectangle(1065, 150, 245, 40), "Aceleración", auto.getLimiteDeAccel(), 12);
        barraTipoPista = new BarraDeAjuste(new Rectangle(1065, 250, 245, 40), "Tipo Pista", numPistaElegida, 4);
        auto.setLimiteDeVelocidad(barraMaxVelocidad.getVariableAjustada());
        auto.setLimiteDeAccel(barraAceleracion.getVariableAjustada());
        //ASIGNACIÓN DE IMAGENES
        trail_img = new ImageIcon(this.getClass().getResource("../images/Auto/trail_01.png")).getImage();
        trail_img.toString();
        // Timer usado para actualizar la pantalla - aprox 60fps        
        Timer timer = new Timer(15, new ActionListener(){      
        public void actionPerformed(ActionEvent e)
            {
                for(Rectangle collider: pistaElegida.getColliders( barraTipoPista.numBarrasEncendidas())){
                    if(auto.getRect().getBounds2D().intersects(collider)){
                        auto.colisiona();
                        break;
                    }                   
                }
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
        this.setBackground(new Color(130, 235, 40));
        g.setColor(new Color(40, 40, 40));
        g.fillRect(990, 0, 400, 755);
        g.setColor(Color.WHITE);
        g.fillRect(990, 0, 10, 800);
        pistaElegida.paint(g, numPistaElegida, this);
        barraMaxVelocidad.paint(g);
        barraAceleracion.paint(g);
        barraTipoPista.paint(g);
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
        //System.out.println(angRuedasDelanteras);
        if(aDown==false && dDown==false){
            //Restaura el ángulo de las ruedas automáticamente
            if(auto.getVelocidad() > 0){
                if(angRuedasDelanteras < 0){
                    angRuedasDelanteras+=(auto.getVelocidad()/magnitudGiro);
                }
                if(angRuedasDelanteras > 0){
                    angRuedasDelanteras-=(auto.getVelocidad()/magnitudGiro);
                }
                auto.rotaRuedas(angRuedasDelanteras);
            }
            if(auto.getVelocidad() < 0){
                if(angRuedasDelanteras < 0){
                    angRuedasDelanteras-=(auto.getVelocidad()/magnitudGiro);
                }
                if(angRuedasDelanteras > 0){
                    angRuedasDelanteras+=(auto.getVelocidad()/magnitudGiro);
                }
                auto.rotaRuedas(angRuedasDelanteras);
            }
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
        barraTipoPista.actualizar(mouseCords, true);
        auto.setLimiteDeVelocidad(barraMaxVelocidad.getVariableAjustada());
        auto.setLimiteDeAccel(barraAceleracion.getVariableAjustada());
        System.out.println(numPistaElegida);
        numPistaElegida = barraTipoPista.numBarrasEncendidas();
                switch(numPistaElegida){
            case 0:
                pistaElegida = pista0;
                break;
            case 1:
                pistaElegida = pista1;
                break;
            case 2:
                pistaElegida = pista2;
                break;  
            case 3:
                pistaElegida = pista3;
                break;  
        }
        
        
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
        barraTipoPista.actualizar(mouseCords, false);
        auto.setLimiteDeVelocidad(barraMaxVelocidad.getVariableAjustada());
        auto.setLimiteDeAccel(barraAceleracion.getVariableAjustada());
        
    }
    
}

