package proyecto;
import java.awt.*;
import java.awt.geom.Rectangle2D;
public class BarraDeAjuste {
    private Rectangle barraRect;
    private Rectangle rectBarritas;
    private String nombreDelAjuste;
    private int valorAjuste = 5;
    private int numDeBarritas = 12;
    private int anchoBarritas = 20;
    private int bordesX = 10;
    private int bordesY = 5;   
    private int espacioEntreBarras;   
    // Colores!
    private Color colorBarritas;
    private Color cyan = new Color(100, 170, 155);
    
    public BarraDeAjuste(Rectangle barraRect, String nombreDelAjuste){
        this.barraRect = barraRect;
        this.nombreDelAjuste = nombreDelAjuste;
        rectBarritas = new Rectangle(barraRect.x+bordesX, barraRect.y+bordesY, anchoBarritas, barraRect.height-bordesY*4);
        espacioEntreBarras = (barraRect.width - 2*bordesX - numDeBarritas*anchoBarritas)/numDeBarritas;
        System.out.println(espacioEntreBarras);
        
    }
    public void paint(Graphics g){
        
        // Obtenemos posicion x tal que el string a dibujar esté centrado :)
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(g2d.getFont().deriveFont(17f));
        FontMetrics fontMetrics = g2d.getFontMetrics();
        Rectangle2D strRect = fontMetrics.getStringBounds(nombreDelAjuste, g2d);
        int strRectX = (barraRect.width - (int)strRect.getWidth())/2 + barraRect.x;
        int strRectY = barraRect.y - bordesY*2;  
        g.setColor(cyan);
        
        g2d.drawString(nombreDelAjuste, strRectX, strRectY);
        // signo - 
        g.fillRect(barraRect.x - barraRect.height - espacioEntreBarras*2, barraRect.y, barraRect.height, barraRect.height);
        
        // signo +
        g.fillRect(barraRect.x +  + espacioEntreBarras*2 + barraRect.width, barraRect.y, barraRect.height, barraRect.height);
        // Barra
        g.setColor(Color.WHITE);
        g.fillRect(barraRect.x, barraRect.y, barraRect.width, barraRect.height);
        // Barritas
        g.setColor(cyan);
        for(int i = 0; i < numDeBarritas; i++){
            g.fillRect(rectBarritas.x+ i*(espacioEntreBarras + anchoBarritas), rectBarritas.y+bordesY, rectBarritas.width, rectBarritas.height);
        }
    }
}
