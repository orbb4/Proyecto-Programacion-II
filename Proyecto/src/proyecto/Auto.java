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
    private float[] velocidad = {0f, 0f};
    private float angle;
    private Rectangle2D.Float rect;
    
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
    public void Acelerar(boolean retroceso){
        float magnitudAccel = 0.001f;
        System.out.println("Auto acelerando");
        System.out.println(angle);
        if(!retroceso){
            accel+=magnitudAccel;
        }else{
            accel-=magnitudAccel;
        }
        
        
    }
    
    public void actualizaPosicion(){
        float limiteDeVelocidad = 0.1f;
        float limiteDeAccel = 0.05f;
        float roce = 0.04f;
        System.out.println(accel);
        // Revisamos si la aceleracion sobrepasa el limite del auto y si es asi,
        // la aceleracion se queda en el valor limite en vez de seguir subiendo.
        // Se hara algo similar con la velocidad.
        accel = acotaVariable(accel, limiteDeAccel);
        // Velocidad eje x
        velocidad[0] +=  accel*(float)Math.sin(Math.toRadians(angle));      
        velocidad[0] = acotaVariable(velocidad[0], limiteDeVelocidad);
        // Velocidad eje y
        velocidad[1] -= accel*(float)Math.cos(Math.toRadians(angle));
        velocidad[1] = acotaVariable(velocidad[1], limiteDeVelocidad);
        rect.x += velocidad[0];  
        
        rect.y += velocidad[1];
        // Manejo del roce de la pista contra el auto
        for(int i = 0; i < 2; i++){
            if(velocidad[i]>0){
                velocidad[i]-=roce;
                if(velocidad[i] < 0){
                    velocidad[i] = 0;
                }
            }else if(velocidad[i] < 0){
                velocidad[i]+=roce;
                if(velocidad[i] > 0){
                    velocidad[i] = 0;
                }
            }
        
        }

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
    public void rotaRuedas(int angulo){
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
