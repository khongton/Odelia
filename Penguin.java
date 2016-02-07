 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Penguin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Penguin extends QActor
{
    private boolean canMove;
    private int distTraveled = 0;
    private int speed = 2;
    private int maxDistance;
    public Penguin()
    {
        getImage().scale(100, 100);
    }
    public Penguin(int width, int height, boolean move, int dist)
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
