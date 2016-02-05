 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends QActor
{
    public Box(int width, int height)
    {
        getImage().scale(width, height);
    }
    
    public Box()
    {
        getImage().scale(100, 100);
    }
    
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }    
}
