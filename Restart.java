import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restart extends World
{

    /**
     * Constructor for objects of class Restart.
     * 
     */
    public Restart(boolean success)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1044, 675, 1, false);
        if (success)
        {
            addObject(new Text("You assassinated the penguin."), getWidth()/2, getHeight()/2);
            addObject(new Text("Press enter to restart", 30), getWidth()/2, getHeight()/2 + 40);
        }
        else
        {
            addObject(new Text("You died."), getWidth()/2, getHeight()/2);
            addObject(new Text("Press enter to restart", 30), getWidth()/2, getHeight()/2 + 40);
        }
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
            Greenfoot.setWorld(new DemoWorld());
    }
}
