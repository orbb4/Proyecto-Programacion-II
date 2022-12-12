
package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Representa las partes a usar para la creación de una pista
 * 
 */
public class FigurasPista {
    private int px, py, ax, ly;
    private Image curva2;
    private Image vertical;
    private Image horizontal;
    private Image curva1;
    private Image curva3;
    private Image curva4;
    private Toolkit t;
    /**
     * El constructor de la clase FiguraPista. Establecerá el tamaño de la pieza
     * junto a su posición
     * @param px coordenada x de la pieza
     * @param py coordenada y de la pieza
     * @param ly ancho y alto de la pieza
     */
    FigurasPista(int px, int py, int ly){
        this.px=px;
        this.py=py;
        this.ly=ly;
        ax=ly;
        t = Toolkit.getDefaultToolkit(); 
        vertical = new ImageIcon(this.getClass().getResource("../images/vertical.png")).getImage();
        horizontal = new ImageIcon(this.getClass().getResource("../images/horizontal.png")).getImage();
        curva2 = new ImageIcon(this.getClass().getResource("../images/curva2.png")).getImage();
        curva1 = new ImageIcon(this.getClass().getResource("../images/curva1.png")).getImage();
        curva3 = new ImageIcon(this.getClass().getResource("../images/curva3.png")).getImage();
        curva4 = new ImageIcon(this.getClass().getResource("../images/curva4.png")).getImage();
    }

    /**
     * Recibe un par de coordenadas que serán asignadas para posicionar la figura
     * @param x coordenada x a establecer para la figura
     * @param y coordenada x a establecer para la figura
     */
    public void setXY(int x, int y){
        px = x;
        py = y;
    }
    /**
     * Devuelve las coordenadas de la figura en la forma {x, y}
     * @return un array de coordenadas de la forma {x, y}
     */
    public int[] getXY(){
        int[] xy = {px, py};
        return xy;
    }
    /**
     * 
     * @param g permite que los graficos se pinten en pantalla
     * @param choice número que representa la figura a dibujar   
     * @param panel el panel donde será dibujada la figura
     */
    public void paint(Graphics g, int choice, JPanel panel){
        if(choice==1){
            g.drawImage(curva1, px, py, ly, ly, panel);
            g.drawImage(vertical, px, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py, ly, ly, panel);
        }
        
        if(choice==2){
            g.drawImage(vertical, px, py, ly, ly, panel);
            g.drawImage(curva3, px, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py+ly, ly, ly, panel);
        }
        
        if(choice==3){
            g.drawImage(horizontal, px, py, ly, ly, panel);
            g.drawImage(curva2, px+ly, py, ly, ly, panel);
            g.drawImage(vertical, px+ly, py+ly, ly, ly, panel);            
        }
        
        if(choice==4){
            g.drawImage(vertical, px, py, ly, ly, panel);
            g.drawImage(curva4, px, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px-ly, py+ly, ly, ly, panel);
        }
        
        if(choice==5){
            //2:
            g.drawImage(vertical, px, py, ly, ly, panel);
            g.drawImage(curva3, px, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py+ly, ly, ly, panel);
            
            //union:
            g.drawImage(horizontal, px+ly+ly, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly+ly+ly, py+ly, ly, ly, panel);
            
            //4:
            g.drawImage(vertical, px+4*ly+ly, py, ly, ly, panel);
            g.drawImage(curva4, px+4*ly+ly, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+3*ly, py+ly, ly, ly, panel);
        }
        
        if(choice==6){
            //1:
            g.drawImage(curva1, px, py, ly, ly, panel);
            g.drawImage(vertical, px, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py, ly, ly, panel);
            
            //union:
            g.drawImage(horizontal, px+ly+ly, py, ly, ly, panel);
            g.drawImage(horizontal, px+ly+ly+ly, py, ly, ly, panel);
            //3:
            g.drawImage(horizontal, px+ly+ly+2*ly, py, ly, ly, panel);
            g.drawImage(curva2, px+ly+2*ly+2*ly, py, ly, ly, panel);
            g.drawImage(vertical, px+ly+2*ly+2*ly, py+ly, ly, ly, panel);  
        }
        
        if(choice==7){
            //1:
            g.drawImage(curva1, px, py, ly, ly, panel);
            g.drawImage(vertical, px, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py, ly, ly, panel);
            
            //union:
            g.drawImage(vertical, px, py+2*ly, ly, ly, panel);
            g.drawImage(vertical, px, py+3*ly + ly, ly, ly, panel);
            //2:
            g.drawImage(vertical, px, py+ly + ly*2, ly, ly, panel);
            g.drawImage(curva3, px, py+(4*ly)+ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py+(4*ly)+ly, ly, ly, panel);
            
            
            
        }
        
        if(choice==8){
            //3:
            g.drawImage(horizontal, px, py, ly, ly, panel);
            g.drawImage(curva2, px+ly, py, ly, ly, panel);
            g.drawImage(vertical, px+ly, py+ly, ly, ly, panel); 
            
            //union:
            g.drawImage(vertical, px+ly, py+2*ly, ly, ly, panel);
            g.drawImage(vertical, px+ly, py+2*ly+ly, ly, ly, panel);
            
            //4:
            g.drawImage(vertical, px+ly, py+2*ly+ly + ly, ly, ly, panel);
            g.drawImage(curva4, px+ly, py+4*ly+ly, ly, ly, panel);
            g.drawImage(horizontal, px, py+4*ly+ly, ly, ly, panel);
            
        }
        
         if(choice==9){
            //g.drawImage(vertical, px, py, ly, ax, panel);
            g.drawImage(vertical, px, py, ly, ly, panel);
            g.drawImage(vertical, px, py+ly, ly, ly, panel);
        }
        if(choice==10){
            //g.drawImage(horizontal, px, py, ax, ly, panel);
            g.drawImage(horizontal, px, py, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py, ly, ly, panel);
        }
        //cuadrado vertical:
        if(choice==11){
            g.drawImage(vertical, px, py, ly, ly, panel);
        }
        //cuadrado horizontal:
        if(choice==12){
            g.drawImage(horizontal, px, py, ly, ly, panel);
        }
        //forma de serpiente:
        if(choice==13){
            //1:
            g.drawImage(curva1, px, py, ly, ly, panel);
            g.drawImage(vertical, px, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py, ly, ly, panel);
            //4:
            g.drawImage(vertical, px, py+2*ly, ly, ly, panel);
            g.drawImage(curva4, px, py+3*ly, ly, ly, panel);
            g.drawImage(horizontal, px-ly, py+3*ly, ly, ly, panel);
        }
        
        if(choice==14){
            //1:
            g.drawImage(curva1, px, py, ly, ly, panel);
            g.drawImage(vertical, px, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py, ly, ly, panel);
            //3:
            g.drawImage(horizontal, px+2*ly, py, ly, ly, panel);
            g.drawImage(curva2, px+3*ly, py, ly, ly, panel);
            g.drawImage(vertical, px+3*ly, py+ly, ly, ly, panel);  
        }
        
        if(choice==15){
            //2:
            g.drawImage(vertical, px, py, ly, ly, panel);
            g.drawImage(curva3, px, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py+ly, ly, ly, panel);
            //4:
            g.drawImage(vertical, px+3*ly, py, ly, ly, panel);
            g.drawImage(curva4, px+3*ly, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+2*ly, py+ly, ly, ly, panel);
        }
        
        if(choice==16){
            //2:
            g.drawImage(vertical, px, py, ly, ly, panel);
            g.drawImage(curva3, px, py+ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py+ly, ly, ly, panel);
            //curva3:
            g.drawImage(curva2, px+2*ly, py+ly, ly, ly, panel);
            //9:
            g.drawImage(vertical, px+2*ly, py+2*ly, ly, ly, panel);
            g.drawImage(vertical, px+2*ly, py+3*ly, ly, ly, panel);
        }
    }
}
