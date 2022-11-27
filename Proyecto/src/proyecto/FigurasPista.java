
package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FigurasPista {
    private int px, py, ax, ly;
    private Image curva2;
    private Image vertical;
    private Image horizontal;
    private Image curva1;
    private Image curva3;
    private Image curva4;
    private Toolkit t;

    FigurasPista(int px, int py, int ax, int ly){
        this.px=px;
        this.py=py;
        this.ax=ax;
        this.ly=ly;
        t = Toolkit.getDefaultToolkit(); 
        vertical = new ImageIcon(this.getClass().getResource("../images/vertical.png")).getImage();
        horizontal = new ImageIcon(this.getClass().getResource("../images/horizontal.png")).getImage();
        curva2 = new ImageIcon(this.getClass().getResource("../images/curva2.png")).getImage();
        curva1 = new ImageIcon(this.getClass().getResource("../images/curva1.png")).getImage();
        curva3 = new ImageIcon(this.getClass().getResource("../images/curva3.png")).getImage();
        curva4 = new ImageIcon(this.getClass().getResource("../images/curva4.png")).getImage();
    }
    public void paint(Graphics g, int choice, JPanel panel){
        if(choice==1){
            /*g.setColor(Color.GRAY);
            g.fillRect(px, py, ax, ly);
            g.setColor(Color.GRAY);
            g.fillRect(px, py+ly, ly, ax-ly);*/
            
            g.drawImage(curva1, px, py, ly, ly, panel);
            g.drawImage(vertical, px, py+ly, ly, ax-ly, panel);
            g.drawImage(horizontal, px+ly, py, ax/2, ly, panel);
        }
        
        if(choice==2){
            /*g.setColor(Color.GRAY);
            g.fillRect(px, py, ly, ax);
            g.setColor(Color.GRAY);
            g.fillRect(px+ly, py+(ax-ly), ax-ly, ly);*/
            
            g.drawImage(vertical, px, py, ly, ax-ly, panel);
            g.drawImage(curva3, px, py+ax-ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py+(ax-ly), ax/2, ly, panel);
        }
        
        if(choice==3){
            /* codigo antiguo, queda aqui por si es que
            g.setColor(Color.GRAY);
            g.fillRect(px, py, ax, ly);      
            g.fillRect(px+(ax-ly), py+ly, ly, ax-ly);
            g.fillRect(px+(ax-ly), py, ly, ly);
        */
            g.drawImage(horizontal, px, py, ax/2, ly, panel);
            g.drawImage(curva2, px+(ax-ly), py, ly, ly, panel);
            g.drawImage(vertical, px+(ax-ly), py+ly, ly, ax-ly, panel);            
        }
        
        if(choice==4){
            /*g.setColor(Color.GRAY);
            g.fillRect(px, py, ly, ax);
            g.setColor(Color.GRAY);
            g.fillRect(px-(ax-ly), py+(ax-ly), ax-ly, ly);*/
            
            g.drawImage(vertical, px, py, ly, ax-ly, panel);
            g.drawImage(curva4, px, py+ax-ly, ly, ly, panel);
            g.drawImage(horizontal, px-(ax-ly), py+(ax-ly), ax/2, ly, panel);
        }
        
        if(choice==5){
            /* //2
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
            g.fillRect(px+(2*ax), py+(ax-ly), ax-ly, ly); */
            
            //2:
            g.drawImage(vertical, px, py, ly, ax-ly, panel);
            g.drawImage(curva3, px, py+ax-ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py+(ax-ly), ax/2, ly, panel);
            
            //union:
            g.drawImage(horizontal, px+ly+(ax/2), py+(ax-ly), ax, ly, panel);
            
            //4:
            g.drawImage(vertical, px+(2*ax)+ax-ly, py, ly, ax-ly, panel);
            g.drawImage(curva4, px+(2*ax)+ax-ly, py+ax-ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly+(ax/2)+ax, py+(ax-ly), ax/2, ly, panel);
        }
        
        if(choice==6){
            /* //1
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
            g.fillRect(px+2*ax+(ax-ly), py+ly, ly, ax-ly); */
            
            //1:
            g.drawImage(curva1, px, py, ly, ly, panel);
            g.drawImage(vertical, px, py+ly, ly, ax-ly, panel);
            g.drawImage(horizontal, px+ly, py, ax/2, ly, panel);
            
            //union:
            g.drawImage(horizontal, px+ly+(ax/2), py, ax, ly, panel);
            
            //3:
            g.drawImage(horizontal, px+ly+(ax/2)+ax, py, ax/2, ly, panel);
            g.drawImage(curva2, px+ly+2*(ax/2)+ax, py, ly, ly, panel);
            g.drawImage(vertical, px+ly+2*(ax/2)+ax, py+ly, ly, ax-ly, panel);  
        }
        
        if(choice==7){
             /* //1
            g.setColor(Color.GRAY);
            g.fillRect(px, py, ax, ly);
            g.setColor(Color.GRAY);
            g.fillRect(px, py+ly, ly, ax-ly);
            
            //union
            g.setColor(Color.GRAY);
            g.fillRect(px, py+ax, ly, ax);
            
            //2
            g.setColor(Color.GRAY);
            g.fillRect(px, py+2*ax, ly, ax);
            g.setColor(Color.GRAY);
            g.fillRect(px+ly, py+2*ax+(ax-ly), ax-ly, ly); */
             
            //1:
            g.drawImage(curva1, px, py, ly, ly, panel);
            g.drawImage(vertical, px, py+ly, ly, ax-ly, panel);
            g.drawImage(horizontal, px+ly, py, ax/2, ly, panel);
            
            //union:
            g.drawImage(vertical, px, py+ax, ly, ax, panel);
            
            //2:
            g.drawImage(vertical, px, py+2*ax, ly, ax-ly, panel);
            g.drawImage(curva3, px, py+(2*ax)+ax-ly, ly, ly, panel);
            g.drawImage(horizontal, px+ly, py+(2*ax)+ax-ly, ax/2, ly, panel);
            
            
            
        }
        
        if(choice==8){
            /* //3
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
            g.fillRect(px, py+2*ax+(ax-ly), ax-ly, ly); */
            
            //3:
            g.drawImage(horizontal, px, py, ax/2, ly, panel);
            g.drawImage(curva2, px+(ax-ly), py, ly, ly, panel);
            g.drawImage(vertical, px+(ax-ly), py+ly, ly, ax-ly, panel); 
            
            //union:
            g.drawImage(vertical, px+(ax-ly), py+ax, ly, ax, panel);
            
            //4:
            g.drawImage(vertical, px+(ax-ly), py+2*ax, ly, ax-ly, panel);
            g.drawImage(curva4, px+(ax-ly), py+2*ax+(ax-ly), ly, ly, panel);
            g.drawImage(horizontal, px, py+2*ax+(ax-ly), ax/2, ly, panel);
            
        }
        
        
    }
}
