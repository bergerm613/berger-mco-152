package berger.projectile;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Projectile
{
    public static final double GRAVITY = 9.8;

    private final double angle;
    private final double velocity;
    private double time;

    public Projectile(double degreeAngle, double velocity)
    {
        this.angle = degreeAngle;
        this.velocity = velocity;
    }

    public void increaseTime(double timeIncrease)
    {
        time += timeIncrease;
    }

    public double getX()
    {
        return velocity * cos(Math.toRadians(angle)) * time;
    }

    public double getY()
    {
        return velocity * sin(Math.toRadians(angle)) * time + (-GRAVITY * time * time);
    }

    public double getTime()
    {
        return time;
    }

    public String toString()
    {
        return  time + ": (" + String.format("%.4f", getX()) + ", " + String.format("%.4f", getY()) + ")";
    }
}