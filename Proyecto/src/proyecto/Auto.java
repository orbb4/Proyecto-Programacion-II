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
    private Polygon p;
    
    public Auto(Ruedas r){
        ruedas = r;
        angle = ruedas.getAngle();
    }
    public void Acelerar(){
        
    }
    public void Giro(){
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));
        
        p = new Polygon();
        
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
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillPolygon(p);   
    }
}
