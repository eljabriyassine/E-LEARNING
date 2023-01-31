package Prof;

import javax.swing.*;
import java.awt.*;

public class Table extends JComponent {
    // Image in which we're going to draw
    private Image image;
    // Graphics2D object ==> used to draw on
    private Graphics2D g2;
    // Mouse coordinates
    public Table(){

    }
    public void draw(int i,int j,int k, int l) {
        setDoubleBuffered(false);


        if (g2 != null) {
            // draw line if g2 context not null
            g2.drawLine(i, j, k, l);
//                    yassine.draw1(oldX,oldY,currentX,currentY);
            repaint();
        }
    }
    protected void paintComponent(Graphics g) {
        if (image == null) {
            // image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        g.drawImage(image, 0, 0, null);
    }

}
