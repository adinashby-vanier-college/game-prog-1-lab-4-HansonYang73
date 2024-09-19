// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Lobster extends Actor
{

    /**
     * 
     */
    public Lobster()
    {
        turn(Greenfoot.getRandomNumber(360));
    }

    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
        eat();
        zombie();
    }

    /**
     * 
     */
    public void moveAround()
    {
        move(4);
        if (Greenfoot.getRandomNumber(10) == 1) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if (isAtEdge()) {
            turn(180);
        }
    }

    /**
     * 
     */
    public void eat()
    {
        Actor crab = getOneIntersectingObject(Crab.class);
        if (crab != null) {
            World gameOverWorld =  new  GameOverWorld();
            World world = getWorld();
            world.removeObject(crab);
            Greenfoot.playSound("gameover.wav");
            Greenfoot.setWorld(gameOverWorld);
        }
    }

    /**
     * 
     */
    public void zombie()
    {
        Actor worm = getOneIntersectingObject(Worm.class);
        if (worm != null) {
            World world = getWorld();
            world.addObject( new  Lobster(), worm.getX(), worm.getY());
            world.removeObject(worm);
        }
    }
}
