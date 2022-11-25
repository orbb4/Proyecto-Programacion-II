
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
    }
}
