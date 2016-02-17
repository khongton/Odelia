import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * A quick and simple class that displays text on-screen.
 * 
 * @author Kevin Hongtongsak
 * @version 2.16.16
 */
public class Text extends Actor
{   
    public Text(String text) 
    {
        setImage(new GreenfootImage(text, 40, Color.BLACK, null));
    }
    
    public Text (String text, int size) 
    {
        setImage(new GreenfootImage(text, size, Color.BLACK, null));
    }
    
    public Text(String text, int size, boolean isWhite)
    {
        setImage(new GreenfootImage(text, size, Color.WHITE, null));
    }
    
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
