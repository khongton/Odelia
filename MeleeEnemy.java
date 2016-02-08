import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MeleeEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MeleeEnemy extends Enemy
{
    private boolean canMove;
    private int distTraveled = 0;
    private int speed = 2;
    private int maxDistance;
    public MeleeEnemy()
    {
        getImage().scale(100, 100);
    }
    
    public MeleeEnemy(int width, int height, boolean move, int dist)
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
                distTraveled = 0;
                speed = -speed;
            }
        }
    }
}
