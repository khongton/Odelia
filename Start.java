import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World
{

    /**
     * Constructor for objects of class Start.
     * 
     */
    public Start()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject(new Text("Odelia", 60, true), getWidth()/2, getHeight()/2 - 100);
        addObject(new Text("Click to start", 30, true), getWidth()/2, getHeight()/2 + 100);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(null))
        {
            Greenfoot.setWorld(new Cutscene());
        }
    }
}
