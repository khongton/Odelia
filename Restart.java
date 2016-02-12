import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restart extends World
{
    private DemoWorld dw;
    /**
     * Constructor for objects of class Restart.
     * 
     */
    public Restart(boolean success, DemoWorld world)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false);
        dw = world;
        dw.bgm.stop();
        if (success)
        {
            addObject(new Text("You assassinated the politician."), getWidth()/2, getHeight()/2);
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
