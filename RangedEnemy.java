import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RangedEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RangedEnemy extends Enemy
{
    private boolean canMove;
    private int distTraveled = 0;
    private int speed = 2;
    private int maxDistance;
    
    private int attackBuffer = 125;
    private int width;
    private int height;
    
    public RangedEnemy()
    {
        getImage().scale(100, 100);
    }
    
    public RangedEnemy(int width, int height, boolean move, int dist)
    {
        getImage().scale(width, height);
        canMove = move;
        maxDistance = dist;
        
        this.width = width;
        this.height = height;
    }
    
    private boolean attackBuffer()
    {
        if (attackBuffer < 1)
        {
            attackBuffer = 125;
            return true;
        }
        else
        {
            attackBuffer--;
            return false;
        }
    }
    
    /**
     * Act - do whatever the Penguin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (attackBuffer())
        {
            getWorld().addObject(new Bullet(40, 40, true, 1000), 1865, 1210);
        }
    }
}
