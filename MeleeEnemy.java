import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

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
    private int maxDistance;
    
    private final int WALKING_RIGHT = 0;
    private final int WALKING_LEFT = 1;
    
    private ArrayList<ImageList> animations;
    private int imageBuffer = 3;
    private int currentImage = 0;
    private int currentAnimation = WALKING_LEFT;
    
    public MeleeEnemy()
    {
        getImage().scale(100, 100);
    }
    
    public MeleeEnemy(int width, int height, boolean move, int dist)
    {
        getImage().scale(width, height);
        canMove = move;
        maxDistance = dist;
        
        animations = new ArrayList<ImageList>();
        animations.add(new ImageList("MeleeEnemy_running_left", 8));
        animations.add(new ImageList("MeleeEnemy_running_right", 8));
    }
    
    /**
     * Act - do whatever the Penguin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Animate
        if (animateBuffer())
        {
            this.currentImage = (this.currentImage + 1) % this.animations.get(this.currentAnimation).list.length;
            this.setImage(this.animations.get(this.currentAnimation).list[this.currentImage]);
        }
        
        checkMove();
    }    
    
    private boolean animateBuffer()
    {
        if (this.imageBuffer < 1)
        {
            this.imageBuffer = 10;
            return true;
        }
        else
        {
            this.imageBuffer--;
        }
        
        return false;
    }
    
    private void checkMove()
    {
        if (canMove)
        {
            if (distTraveled <= maxDistance)
            {
                setLocation(getX() + getSpeed(), getY());
                distTraveled += 2;
            }
            else 
            {
                distTraveled = 0;
                setSpeed(getSpeed() * -1);
                // getImage().mirrorHorizontally();
                
                this.currentAnimation = this.currentAnimation == WALKING_RIGHT ? WALKING_LEFT : WALKING_RIGHT;
            }
        }
    }
}
