import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Odelia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Odelia extends AnimatedActor
{
    private final String[] idleImages = { "odelia_idle_0.png", "odelia_idle_1.png", "odelia_idle_2.png" };
    
    public Odelia()
    {
        super("Odelia", 2, 8, 60);
    }
    
    /**
     * Act - do whatever the Odelia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Animate actor
        super.act();
    }    
}
