import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;

/**
 * Write a description of class AnimatedActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedActor extends Actor
{
    // Keep track of current animation
    private enum CURRENT_ANIMATION
    {
        IDLE_LEFT, IDLE_RIGHT, WALKING_LEFT, WALKING_RIGHT;
    }
    
    // Store arrays for both animations in an array list
    private class ImageList
    {
        public GreenfootImage[] list;
        
        public ImageList(String prefix, int numImages)
        {
            this.list = new GreenfootImage[numImages];
            
            for (int i = 0; i < numImages; i++)
            {
                this.list[i] = new GreenfootImage(prefix + "_" + i + ".png");
            }
        }
    }
    
    private ArrayList<ImageList> animations;
    private int imageBuffer;
    private int currentImage;
    private int currentAnimation;
    
    // Default constructor
    public AnimatedActor()
    {
        // Do we need to do anything here?
    }
    
    public AnimatedActor(String actor, int numIdle, int numWalking)
    {
        animations = new ArrayList<ImageList>();
        
        // Initialize idle animations
        animations.add(new ImageList(actor + "_idle_left", numIdle));
        animations.add(new ImageList(actor + "_idle_right", numIdle));
        
        // Initialize walking animation
        animations.add(new ImageList(actor + "_run_left", numWalking));
        animations.add(new ImageList(actor + "_run_right", numWalking));
        
        this.imageBuffer = 3;
        this.currentImage = 0;
        this.currentAnimation = CURRENT_ANIMATION.IDLE_LEFT.ordinal();
    }
    
    private boolean animateBuffer()
    {
        if (imageBuffer < 1)
        {
            imageBuffer = 10;
            return true;
        }
        else
        {
            imageBuffer--;
        }
        
        return false;
    }
    
    /**
     * Act - do whatever the AnimatedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (currentAnimation != CURRENT_ANIMATION.WALKING_LEFT.ordinal() && Greenfoot.isKeyDown("left"))
        {
            this.imageBuffer = 3;
            this.currentImage = 0;
            this.currentAnimation = CURRENT_ANIMATION.WALKING_LEFT.ordinal();
        }
        else if (currentAnimation != CURRENT_ANIMATION.WALKING_RIGHT.ordinal() && Greenfoot.isKeyDown("right"))
        {
            this.imageBuffer = 3;
            this.currentImage = 0;
            this.currentAnimation = CURRENT_ANIMATION.WALKING_RIGHT.ordinal();
        }
        else if (currentAnimation == CURRENT_ANIMATION.WALKING_LEFT.ordinal() && !Greenfoot.isKeyDown("left"))
        {
            this.imageBuffer = 3;
            this.currentImage = 0;
            this.currentAnimation = CURRENT_ANIMATION.IDLE_LEFT.ordinal();
        }
        else if (currentAnimation == CURRENT_ANIMATION.WALKING_RIGHT.ordinal() && !Greenfoot.isKeyDown("right"))
        {
            this.imageBuffer = 3;
            this.currentImage = 0;
            this.currentAnimation = CURRENT_ANIMATION.IDLE_RIGHT.ordinal();
        }
        
        if (animateBuffer())
        {
            currentImage = (currentImage + 1) % animations.get(currentAnimation).list.length;
            this.setImage(animations.get(currentAnimation).list[currentImage]);
        }
    }    
}