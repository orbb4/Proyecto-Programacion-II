/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.awt.Color;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.sound.sampled.*;
import java.io.*;

/**
 *
 * @author bas_b
 */
public class Auto {
       
    float x = 0f;   
    float y = 0f;   
    private Ruedas ruedas;
    private float accel  = 0f; // aceleracion
    private float velocidad = 0f;
    private float angle;
    private Rectangle2D.Float rect;
    // Valores ajustables:
    private  float magnitudAccel = 0.05f;
    private  float limiteDeVelocidad = 12f;
    private  float limiteDeAccel = 0.5f;
    
    private ImageObserver obs;
    private Image img;
    
    private AudioPlayer player;
    private String loc = "../audio/bgm/;).wav";
    
    public Auto(Rectangle rectAuto){
        img = new ImageIcon(this.getClass().getResource("../images/Auto/rojo1.png")).getImage();
        ruedas = new Ruedas(new Rectangle(600, 200, 40 ,80));
        angle = 0f;
        rect = new Rectangle2D.Float(600f, 200f, 40f, 80f);
        
        player.play(loc);
    }
    public void setMagnitudAccel(float magnitudAccel){
        this.magnitudAccel = magnitudAccel;
    }
    public void setLimiteDeVelocidad(float limiteDeVelocidad){
        this.limiteDeVelocidad = limiteDeVelocidad;
    }
    public void setLimiteDeAccel(float limiteDeAccel){
        this.limiteDeAccel = limiteDeAccel;
    }
    public float getAngle(){
        return angle;
    }
    
    public void setAngle(float angle){
        this.angle = angle;
    }
    
    public void Acelerar(boolean enRetroceso){
        
        //System.out.println("Auto acelerando: " + accel);
        if(!enRetroceso){
            accel+=magnitudAccel;
        }else{
            accel-=magnitudAccel;
        }
        
        
    }
    public void Desacelerar(){
        accel = 0;
        //System.out.println("Desacelerando: " + velocidad);
        // Para evitar que al desacelerar el auto se ponga en reversa en vez
        // de detenerse.
        if(velocidad > 0){

            velocidad = Math.max(velocidad-magnitudAccel, 0);
        }else if(velocidad < 0){
            velocidad = Math.min(velocidad+magnitudAccel, 0);
        }
       
    }
    public void actualizaPosicion(){
        float roce = 0.5f;
        // Se usara para asegurar que la fuerza de roce se oponga a la del
        // movimiento
        //System.out.println(accel);     
        // Revisamos si la aceleracion sobrepasa el limite del auto y si es asi,
        // la aceleracion se queda en el valor limite en vez de seguir subiendo.
        // Se hara algo similar con la velocidad.
        accel = acotaVariable(accel, limiteDeAccel); 
        velocidad += accel;
        velocidad = acotaVariable(velocidad, limiteDeVelocidad);
        // Movemos el auto:
        rect.x += velocidad*(float)Math.sin(Math.toRadians(angle));
        rect.y -= velocidad*(float)Math.cos(Math.toRadians(angle));
        //System.out.println("Velocidad: " + velocidad);
        ruedas.setAutoRect(new Rectangle((int)rect.x, (int)rect.y, (int)rect.width, (int)rect.height));

    }
    /**
     * Revisa si una variable esta fuera de una cota dada (por izquierda o derecha)
     * y si es asi, se iguala el valor de la variable al de la cota.
     * <p>
     * Este metodo es usado en ActualizaPosicion para que el auto no pueda
     * tener velocidad o aceleracion superior a cierto valor
     * @param var variable a acotar
     * @param cota float que acotara la variable entre -cota y cota
     */
    private float acotaVariable(float var, float cota){
        if(Math.abs(var) > cota){
            if(var > 0){
                var = cota;
            }else{
                var = -cota;
            }   
        }
        return var;
    }
    public Rectangle2D.Float getRect(){
        return rect;
    }
    public void rotaRuedas(float angulo){
        ruedas.setAngulo(angulo, true, true, false, false);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform tran = g2d.getTransform();
        tran.rotate(Math.toRadians(angle), rect.x + 20, rect.y + 40);
        g2d.setTransform(tran);
        g.setColor(Color.red);
        //g2d.draw(rect);
        //g2d.fill(rect);
        g2d.drawImage(img, (int)rect.x, (int)rect.y, 40, 80, obs);
        ruedas.paint(g);
    }
}
