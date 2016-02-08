import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends QActor
{
    private boolean canMove;
    private int distTraveled = 0;
    private int speed = 1;
    private int maxDistance;
    
    public Bullet()
    {
        getImage().scale(100, 100);
    }
    
    public Bullet(int width, int height, boolean move, int dist)
    {
        getImage().scale(width, height);
        canMove = move;
        maxDistance = dist;
    }
    
    /**
     * Act - do whatever the Penguin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkMove();
    }    
    
    private void checkMove()
    {
        if (canMove)
        {
            if (distTraveled <= maxDistance)
            {
                setLocation(getX() + speed, getY());
                distTraveled += 2;
            }
            else 
            {
                getWorld().removeObject(this);
            }
        }
    }
}
