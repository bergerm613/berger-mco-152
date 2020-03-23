package berger.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent
{

    private String shape = "";

    @Override
    protected void paintComponent(Graphics g)
    {
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        g.translate(centerX, centerY);

        super.paintComponent(g);

        if (shape.equals("glasses"))
        {
            drawGlasses(g);
        }
        else if (shape.equals("hallows"))
        {
            drawHallows(g);
        }
        else if (shape.equals("snitch"))
        {
            drawSnitch(g);
        }
        else if (shape.equals("platform"))
        {
            drawPlatform(g);
        }
    }

    public void setShape(String shape)
    {
        this.shape = shape;
        repaint();
    }

    private void drawGlasses(Graphics g)
    {
        g.setColor(new Color(128, 0, 0));
        g.drawLine(-20, 0, 20, 0);

        g.fillOval(20,-50, 100, 100);
        g.fillOval(-120,-50, 100, 100);

        g.setColor(Color.WHITE);
        g.fillOval(25,-45, 90, 90);
        g.fillOval(-115,-45, 90, 90);
    }

    private void drawHallows(Graphics g)
    {
        g.setColor(new Color(0, 100, 0));
        g.fillPolygon(new int[] {150, -150, 0}, new int[] {75, 75, -125}, 3);
        g.setColor(Color.WHITE);
        g.drawOval(-75,-75, 150, 150);
        g.drawLine(0,-125, 0, 75);
    }

    private void drawSnitch(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillOval(-30,-30, 60, 60);
        g.fillPolygon(new int[] {-5, -130, -75}, new int[] {5, 5, -30}, 3);
        g.fillPolygon(new int[] {5, 130, 75}, new int[] {5, 5, -30}, 3);

        g.setColor(new Color(255,215,0));
        g.fillOval(-25,-25, 50, 50);
        g.fillPolygon(new int[] {-10, -125, -75}, new int[] {0, 0, -25}, 3);
        g.fillPolygon(new int[] {10, 125, 75}, new int[] {0, 0, -25}, 3);
    }

    private void drawPlatform(Graphics g)
    {
        g.setColor(new Color(128, 0, 0));
        g.fillOval(-125,-125, 250, 250);

        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(-100,-100, 200, 200);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Droid Serif", Font.BOLD, 100));
        g.drawString("9",-60,35);
        g.setFont(new Font("Droid Serif", Font.BOLD, 50));
        g.drawString("3",20,-10);
        g.drawString("4",20,40);
        g.drawLine(15,0,55,0);
    }
}
