// Program uses DrawingPanel to draw grids with concentric circles in varying sizes and locations

import java.awt.*;

public class Circles {
   public static void main (String[]   args) {
   DrawingPanel drawPanel = new DrawingPanel(500, 350);
   drawPanel.setBackground(Color.CYAN);
   Graphics g = drawPanel.getGraphics();
     drawSubfigure(g, 0, 0, 100, 5);
     drawSubfigure(g, 130, 25, 100, 5);
     drawSubfigure(g, 260, 0, 60, 5); 
     drawSubfigure(g, 360, 50, 80, 10);
     drawGrid(g, 10, 170, 48, 6, 3);
     drawGrid(g, 180, 200, 24, 6, 5);
     drawGrid(g, 330, 170, 72, 4, 2);
   }
   
   // This method draws a single concentric circle and background in various sizes and locations
   // depending on the values assigned to the variables
   public static void drawSubfigure(Graphics g, int x, int y, int diameter, int space) {
      g.setColor(Color.YELLOW);
      g.fillOval(x, y, diameter, diameter);
      for(int i = 1; i <= diameter / space / 2; i++) {
         g.setColor(Color.BLACK);
         g.drawOval(x + space * i - space, y + space * i - space, 
         diameter - (2 * space) * (i - 1), diameter - (2 * space) * (i - 1));    
      }
   }
   
   // Method draws square grids encompassing concentric circles and a pair of lines in an X pattern 
   // The size and location of figures are dependent on values assigned to parameter variables 
   public static void drawGrid(Graphics g, int x, int y, int diameter, int space, int rowColumn) {
      g.setColor(Color.GREEN);
      g.fillRect(x, y, diameter * rowColumn, diameter * rowColumn);
      for(int i = 1; i <= rowColumn; i++) { 
         for(int j = 1; j <= rowColumn; j++) { 
            g.setColor(Color.YELLOW);
            g.fillOval(x + diameter * (i - 1), y + diameter * (j - 1), diameter, diameter);
            for(int k = 1; k <= diameter / space / 2; k++) {
               g.setColor(Color.BLACK);
               g.drawOval(x + diameter * (i - 1) + space * k - space, y + diameter * (j - 1) + 
               space * k - space, diameter - 2 * space * (k - 1), diameter - 2 * space * (k - 1));
            }
         }
      }
      g.setColor(Color.BLACK);
      g.drawRect(x, y, diameter * rowColumn, diameter * rowColumn);
      g.drawLine(x, y, diameter * rowColumn + x, diameter * rowColumn + y);
      g.drawLine(x, y + diameter * rowColumn, x + diameter * rowColumn, y);
   }      
}
