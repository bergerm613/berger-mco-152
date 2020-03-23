package berger.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapesFrame extends JFrame
{
    private ShapeComponent shapeComponent;

    private JPanel buttonPanel;

    private JButton hallowsButton;
    private JButton glassesButton;
    private JButton platformButton;
    private JButton snitchButton;


    public ShapesFrame() {
        setSize(500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("SHAPES");

        setLayout(new BorderLayout());

        shapeComponent = new ShapeComponent();

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,1));

        hallowsButton = new JButton("Hallows");
        hallowsButton.addActionListener(actionEvent -> shapeComponent.setShape("hallows"));
        glassesButton = new JButton("Glasses");
        glassesButton.addActionListener(actionEvent -> shapeComponent.setShape("glasses"));
        platformButton = new JButton("Platform");
        platformButton.addActionListener(actionEvent -> shapeComponent.setShape("platform"));
        snitchButton = new JButton("Snitch");
        snitchButton.addActionListener(actionEvent -> shapeComponent.setShape("snitch"));

        add(shapeComponent, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.WEST);

        buttonPanel.add(hallowsButton);
        buttonPanel.add(glassesButton);
        buttonPanel.add(platformButton);
        buttonPanel.add(snitchButton);
    }

    public static void main(String[] args)
    {
        new ShapesFrame().setVisible(true);
    }
}
