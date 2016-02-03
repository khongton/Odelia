import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedActor extends Actor
{
    private GreenfootImage[] idle;
    private GreenfootImage[] walking;
    private int delay;
    
    private int curTime;
    private int curImage;
    
    // Default constructor
    public AnimatedActor()
    {
        // Do we need to do anything here?
    }
    
    public AnimatedActor(String actor, int numIdle, int numWalking, int delay)
    {
        this.idle = new GreenfootImage[numIdle];
        this.walking = new GreenfootImage[numWalking];
        
        for (int i = 0; i < numIdle; i++)
        {
            this.idle[i] = new GreenfootImage(actor + "_" + "idle" + "_" + i + ".png");
        }
        
        for (int i = 0; i < numWalking; i++)
        {
            this.walking[i] = new GreenfootImage(actor + "_" + "walking" + "_" + i + ".png");
        }
        
        this.delay = delay;
        this.curTime = 0;
        this.curImage = 0;
    }
    
    /**
     * Act - do whatever the AnimatedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (delay == curTime++)
        {
            // Check Foaad's game for modulus "algorithm" for animation
            if (++curImage == walking.length)
            {
                curImage = 0;
            }
            curTime = 0;
            this.setImage(walking[curImage]);
        }
    }    
}
