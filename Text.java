 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
