import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is only here to allow instances of it to be instantiated in
 * the world. 
 * 
 * The empty act method is necesary for compilation.
 * 
 * @author Kevin Hongtongsak
 * @version 2.16.16
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
