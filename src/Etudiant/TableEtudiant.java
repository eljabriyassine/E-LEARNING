package Etudiant;

import javax.swing.*;
import java.awt.*;

public class TableEtudiant extends JPanel{
    private Image image;
    // Graphics2D object ==> used to draw on
    private Graphics2D g2;
    public TableEtudiant(){

    }
    public void Frame(){
        JFrame frame = new JFrame("Etudiant");
        Container content = frame.getContentPane();
        content.add(this, BorderLayout.CENTER);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
    public void draw(int odlX, int oldY , int currentX , int currentY) {


        // coord x,y when drag mouse
        if (g2 != null) {
            // draw line if g2 context not null
            g2.drawLine(odlX, oldY , currentX ,currentY);
            // refresh draw area to repaint
            repaint();
            // store current coords x,y as olds x,y
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
