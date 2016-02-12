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
    private int enemyNum;
    
    public RangedEnemy()
    {
        getImage().scale(100, 100);
    }
    
    public RangedEnemy(int width, int height, boolean move, int dist, int enemyNum)
    {
        getImage().scale(width, height);
        canMove = move;
        maxDistance = dist;
        
        this.width = width;
        this.height = height;
        this.enemyNum = enemyNum;
    }
    
    private boolean attackBuffer()
    {
        if (attackBuffer < 1)
        {
            attackBuffer = 175;
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
        if (attackBuffer() && enemyNum == 1)
        {
            getWorld().addObject(new Bullet(20, 20, true, 1000), 1845, 1210);
        }
        
        if (attackBuffer() && enemyNum == 2)
        {
            getWorld().addObject(new Bullet(20, 20, true, 1000, 6), 1695, getWorld().getHeight() + 1705);
        }
        
        if (attackBuffer() && enemyNum == 3)
        {
            getWorld().addObject(new Bullet(20, 20, true, 1000, 5), 1595, getWorld().getHeight() + 1905);
        }
    }
}
