import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends QActor
{
    private int speed = 2;
    private boolean facingLeft = false;
    
    public int getSpeed()
    {
        return this.speed;
    }
    
    public void setSpeed(int newSpeed)
    {
        facingLeft = newSpeed > 0 ? false : true;
        this.speed = newSpeed;
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
