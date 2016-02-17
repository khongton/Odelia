import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The class that creates the game over screen and allows the player to restart the game.
 * 
 * @author Kevin Hongtongsak, Jeremy Billote
 * @version 2.16.16
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
