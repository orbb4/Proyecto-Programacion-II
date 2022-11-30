/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

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
    float magnitudAccel = 0.05f;
    
    public Auto(Rectangle rectAuto){
        
        ruedas = new Ruedas(new Rectangle(600, 200, 40 ,80));
        angle = 0f;
        rect = new Rectangle2D.Float(600f, 200f, 40f, 80f);
        
    }
    public float getAngle(){
        return angle;
    }
    public void setAngle(float angle){
        this.angle = angle;
    }
    public void Acelerar(boolean enRetroceso){
        
        System.out.println("Auto acelerando: " + accel);
        if(!enRetroceso){
            accel+=magnitudAccel;
        }else{
            accel-=magnitudAccel;
        }
        
        
    }
    public void Desacelerar(){
        accel = 0;
        System.out.println("Desacelerando: " + velocidad);
        if(velocidad > 0){
            // Para evitar que al desacelerar el auto se ponga en reversa en vez
            // de detenerse.
            velocidad = Math.max(velocidad-magnitudAccel, 0);
        }else if(velocidad < 0){
            velocidad = Math.min(velocidad+magnitudAccel, 0);
        }
       
    }
    public void actualizaPosicion(){
        float limiteDeVelocidad = 10f;
        float limiteDeAccel = 1.5f;
        float roce = 0.5f;
        // Se usara para asegurar que la fuerza de roce se oponga a la del
        // movimiento
        System.out.println(accel);     
        // Revisamos si la aceleracion sobrepasa el limite del auto y si es asi,
        // la aceleracion se queda en el valor limite en vez de seguir subiendo.
        // Se hara algo similar con la velocidad.
        accel = acotaVariable(accel, limiteDeAccel); 
        velocidad += accel;
        velocidad = acotaVariable(velocidad, limiteDeVelocidad);
        // Movemos el auto:
        rect.x += velocidad*(float)Math.sin(Math.toRadians(angle));
        rect.y -= velocidad*(float)Math.cos(Math.toRadians(angle));
        System.out.println("Velocidad: " + velocidad);
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
    public void Giro(){
        float cos = (float)Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));
        
        
        /*
        //para los sigueintes puntos se considera que el auto está en horizontal (angulo 0)
        
        //punto adelante-izquierda del auto
        float px = 140f;
        float py = -60f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));
        
        //punto atras-izquierda del auto
        px = -140f;
        py = -100f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));
        
        //punto atras-derecha del auto
        px = -140f;
        py = 100f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        //punto adelante-derecha del auto
        px = 140f;
        py = 60f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));
*/
    }
    public void rotaRuedas(float angulo){
        ruedas.setAngulo(angulo, true, true, false, false);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform tran = g2d.getTransform();
        tran.rotate(Math.toRadians(angle), rect.x + 20, rect.y + 40);
        g2d.setTransform(tran);
        //angle++;
        g.setColor(Color.red);
        g2d.draw(rect);
        g2d.fill(rect);
        ruedas.paint(g);
    }
}
