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
    private int velocidad;
    private float angle;
    private Rectangle rect;
    
    public Auto(Rectangle rectAuto){
        ruedas = new Ruedas(new Rectangle(600, 200, 40 ,80));
        angle = 0;
        rect = new Rectangle(600, 200, 40, 80);
        
    }
    public float getAngle(){
        return angle;
    }
    public void setAngle(float angle){
        this.angle = angle;
    }
    public void Acelerar(){
        
    }
    public Rectangle getRect(){
        return rect;
    }
    public void Giro(){
        float cos = (float) Math.cos(Math.toRadians(angle));
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
