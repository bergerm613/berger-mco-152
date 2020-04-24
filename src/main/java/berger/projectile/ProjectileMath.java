package berger.projectile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;

public class ProjectileMath
{
    public static void main(String[] args)
    {
        final int NUM_PROJECTILES = 5;
        Random rand = new Random();

        List<Projectile> projectiles = new ArrayList<>();

        for (int i = 0; i < NUM_PROJECTILES; i++)
        {
            projectiles.add(new Projectile(
                    rand.nextDouble() * 180,
                    rand.nextDouble() * 100 ));
        }

        for (Projectile projectile : projectiles)
        {
            for (int i = 0; i < 11; i++)
            {
                System.out.println(projectile);
                projectile.increaseTime(1);
            }
        }
    }
}