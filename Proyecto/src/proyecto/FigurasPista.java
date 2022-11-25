
package proyecto;

import java.awt.Color;
import java.awt.Graphics;

public class FigurasPista {
    private int px, py, ax, ly;
    FigurasPista(int px, int py, int ax, int ly){
        this.px=px;
        this.py=py;
        this.ax=ax;
        this.ly=ly;
    }
    public void paint(Graphics g, int choice){
        if(choice==1){
            g.setColor(Color.GRAY);
            g.fillRect(px, py, ax, ly);
            g.setColor(Color.GRAY);
            g.fillRect(px, py+ly, ly, ax-ly);
        }
        
        if(choice==2){
            g.setColor(Color.GRAY);
            g.fillRect(px, py, ly, ax);
            g.setColor(Color.GRAY);
            g.fillRect(px+ly, py+(ax-ly), ax-ly, ly);
        }
        
        if(choice==3){
            g.setColor(Color.GRAY);
            g.fillRect(px, py, ax, ly);
            g.setColor(Color.GRAY);
            g.fillRect(px+(ax-ly), py+ly, ly, ax-ly);
        }
        
        if(choice==4){
            g.setColor(Color.GRAY);
            g.fillRect(px, py, ly, ax);
            g.setColor(Color.GRAY);
            g.fillRect(px-(ax-ly), py+(ax-ly), ax-ly, ly);
        }
        
        if(choice==5){
            //2
            g.setColor(Color.GRAY);
            g.fillRect(px, py, ly, ax);
            g.setColor(Color.GRAY);
            g.fillRect(px+ly, py+(ax-ly), ax-ly, ly);
            
            //union
            g.setColor(Color.GRAY);
            g.fillRect(px+ax, py+(ax-ly), ax, ly);
            
            //4
            g.setColor(Color.GRAY);
            g.fillRect(px+(2*ax)+ax-ly, py, ly, ax);
            g.setColor(Color.GRAY);
            g.fillRect(px+(2*ax), py+(ax-ly), ax-ly, ly);
        }
        
        if(choice==6){
            //1
            g.setColor(Color.GRAY);
            g.fillRect(px, py, ax, ly);
            g.setColor(Color.GRAY);
            g.fillRect(px, py+ly, ly, ax-ly);
            
            //union
            g.setColor(Color.GRAY);
            g.fillRect(px+ax, py, ax, ly);
            
            //3
            g.setColor(Color.GRAY);
            g.fillRect(px+2*ax, py, ax, ly);
            g.setColor(Color.GRAY);
            g.fillRect(px+2*ax+(ax-ly), py+ly, ly, ax-ly);
        }
        
        if(choice==7){
            //1
            g.setColor(Color.GRAY);
            g.fillRect(px, py, ax, ly);
            g.setColor(Color.GRAY);
            g.fillRect(px, py+ly, ly, ax-ly);
            
            //union
            g.setColor(Color.GRAY);
            g.fillRect(px, py+ax, ly, ax);
            
            //3
            g.setColor(Color.GRAY);
            g.fillRect(px, py+2*ax, ly, ax);
            g.setColor(Color.GRAY);
            g.fillRect(px+ly, py+2*ax+(ax-ly), ax-ly, ly);
        }
        
        if(choice==8){
            //3
            g.setColor(Color.GRAY);
            g.fillRect(px, py, ax, ly);
            g.setColor(Color.GRAY);
            g.fillRect(px+(ax-ly), py+ly, ly, ax-ly);
            
            //union
            g.setColor(Color.GRAY);
            g.fillRect(px+(ax-ly), py+ax, ly, ax);
            
            //4
            g.setColor(Color.GRAY);
            g.fillRect(px+(ax-ly), py+2*ax, ly, ax);
            g.setColor(Color.GRAY);
            g.fillRect(px, py+2*ax+(ax-ly), ax-ly, ly);
        }
        
        
    }
}
