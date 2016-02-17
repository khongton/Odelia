import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The game's start screen class. 
 * 
 * @author Kevin Hongtongsak, Jeremy Billote
 * @version 2.16.16
 */
public class Start extends World
{
    public Start()
    {    
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
