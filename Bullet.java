import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bullet that is instantiated in front of instances of the RangedEnemy class.
 * 
 * @author Kevin Hongtongsak, Jeremy Billote
 * @version 2.16.16
 */
public class Bullet extends QActor
{
    private boolean canMove;
    private int distTraveled = 0;
    private int speed = 4;
    private int maxDistance;
    
    public Bullet()
    {
        getImage().scale(75, 75);
    }
    
    public Bullet(int width, int height, boolean move, int dist)
    {
        getImage().scale(width, height);
        canMove = move;
        maxDistance = dist;
    }
    
    public Bullet(int width, int height, boolean move, int dist, int speed)
    {
        getImage().scale(width, height);
        canMove = move;
        maxDistance = dist;
        this.speed = speed;
    }
    
    /**
     * Act - do whatever the Penguin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkMove();
        checkCollision();
    }    
    
    /**
     * Removes the bullet from the world if it hits a box.
     */
    private void checkCollision()
    {
        if (isTouching(Box.class))
            getWorld().removeObject(this);
    }
    
    /**
     * Allow bullet movement.
     */
    private void checkMove()
    {
        if (canMove)
        {
            if (distTraveled <= maxDistance)
            {
                setLocation(getX() + speed, getY());
                distTraveled += 4;
            }
            else 
            {
                getWorld().removeObject(this);
            }
        }
    }
}
