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
    private Rectangle rect;
    
    public Auto(Ruedas r, Rectangle rectAuto){
        rect = rectAuto;
        ruedas = r;
        angle = ruedas.getAngle();
        rect = new Rectangle(600, 200, 40, 80);
        
    }
    public void Acelerar(){
        
    }
    public void Giro(){
        angle = ruedas.getAngle();
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform tran = g2d.getTransform();
        tran.rotate(angle, rect.x + 20, rect.y + 40);
        g2d.setTransform(tran);
        angle++;
        g.setColor(Color.red);
        g2d.draw(rect);
        g2d.fill(rect);
    }
}
