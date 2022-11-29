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
    private float[] accel  = {0f, 0f}; // aceleracion
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
        
        System.out.println("Auto acelerando");
        System.out.println(angle);
        
        accel[0] +=  0.1*(float)Math.sin(Math.toRadians(angle));
        if(retroceso){
            accel[1] +=  -0.1*(float)Math.cos(Math.toRadians(angle));
        }else{
            accel[1] +=  0.1*(float)Math.cos(Math.toRadians(angle));
        }
        
    }
    
    public void actualizaPosicion(){
        float limiteDeVelocidad = 0.05f;
        float limiteDeAccel = 0.05f;
        // revisamos si la aceleracion sobrepasa el limite del auto, si es asi
        // la aceleracion se queda en el valor limite en vez de seguir subiendo
        if(Math.abs(accel[0]) > limiteDeAccel){
            if(accel[0] > 0){
                accel[0] = limiteDeAccel;
            }else{
                accel[0] = -limiteDeAccel;
            }         
        }
        if(Math.abs(accel[1]) > limiteDeAccel){
            if(accel[1] > 0){
                accel[1] = limiteDeAccel;
            }else{
                accel[1] = -limiteDeAccel;
            }         
        }
        velocidad[0] += accel[0];
        if(Math.abs(velocidad[0]) > limiteDeVelocidad){
            if(velocidad[0] > 0){
                velocidad[0] = limiteDeVelocidad;
            }else{
                velocidad[0] = -limiteDeVelocidad;
            }   
        }
        if(Math.abs(velocidad[1]) > limiteDeVelocidad){
            if(velocidad[1] > 0){
                velocidad[1] = limiteDeVelocidad;
            }else{
                velocidad[1] = -limiteDeVelocidad;
            }   
        }
        rect.x += velocidad[0];  
        velocidad[1] += accel[1];
        if(velocidad[1] > limiteDeVelocidad){
            velocidad[1] = limiteDeVelocidad;
        }
        rect.y += velocidad[1];
        System.out.println("Velocidad: " + velocidad[0] + ", " + velocidad[1] + " Accel: " + accel[0] + ", " + accel[1]);
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
