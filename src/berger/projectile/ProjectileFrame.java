package berger.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileFrame extends JFrame
{
    private JTextArea projectileCoordinates;

    private JTextField velocity;
    private JTextField angle;
    private JButton calculateButton;
    private JLabel velocityLabel;
    private JLabel angleLabel;

    private JScrollPane scroll;

    private JPanel leftPanel;

    public ProjectileFrame()
    {
        setSize(400,300);
        setTitle("Projectile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        projectileCoordinates = new JTextArea();

        velocity = new JTextField();
        angle = new JTextField();
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(actionEvent -> getProjectile());

        velocityLabel = new JLabel("Velocity");
        angleLabel = new JLabel("Angle (degrees)");

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3,2));

        leftPanel.add(velocityLabel);
        leftPanel.add(velocity);
        leftPanel.add(angleLabel);
        leftPanel.add(angle);
        leftPanel.add(calculateButton);

        add(projectileCoordinates, BorderLayout.CENTER);
        projectileCoordinates.setEditable(false);
        scroll = new JScrollPane(projectileCoordinates);
        add(scroll);

        add(leftPanel, BorderLayout.WEST);
    }

    private void getProjectile()
    {
        Projectile projectile = new Projectile(Double.parseDouble(angle.getText()), Double.parseDouble(velocity.getText()));

        for (int i = 0; i <= 30; i++)
        {
            projectileCoordinates.append(String.format("time %d: (%.2f, %.2f)\n",
                                                        i,
                                                        projectile.getX(),
                                                        projectile.getY()) );
            projectile.increaseTime(1);
        }

    }

    public static void main(String[] args)
    {
        new ProjectileFrame().setVisible(true);
    }
}