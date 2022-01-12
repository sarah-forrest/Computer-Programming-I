// This program draws a train figure using the drawing panel.
// Ovals and rectangles of various colors and locations are used to contruct the figure.

import java.awt.*;

public class Doodle {
   public static void main (String[]   args) {
   DrawingPanel drawPanel = new DrawingPanel(450, 275);
   drawPanel.setBackground(Color.BLACK);
   Graphics g = drawPanel.getGraphics();
      g.setColor(Color.YELLOW);
      g.fillRect(250, 50, 70, 100);
      g.fillRect(160, 75, 15, 25);
      g.setColor(Color.BLUE);
      g.fillRect(150, 100, 100, 50);
      g.setColor(Color.RED);
      g.fillOval(150, 140, 40, 40);
      g.fillOval(210, 140, 40, 40);
      g.fillOval(260, 120, 60, 60);
      g.setColor(Color.BLUE);
      g.fillRect(160, 155, 150, 8);
      g.fillRect(265, 70, 40, 25);
   }
}