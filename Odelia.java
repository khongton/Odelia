import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Odelia is the protagonist of the game.
 * All methods necesasary to allow for proper player movement is handled here.
 * 
 * @author Kevin Hongtongsak, Jeremy Billote
 * @version 2.16.16
 */
public class Odelia extends QActor
{
    public int speed = 5;
    public int ySpeed = 0;
    public int jumpStr = 22;
    public boolean onGround;
    private int soundBuffer = 10;
    private boolean attacking = false;
    private boolean facingLeft = true;
    
    public Odelia()
    {
        super("Odelia", 14, 4, 9);
    }
    
    /**
     * Act - do whatever the Odelia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        
        setAnimationFrame();
        getDirection();
        move();
        // moveDebug();
        collisions();
        
        if ((getCurrentAnimation() == CurrentAnimation.WALKING_RIGHT.ordinal() || getCurrentAnimation() == CurrentAnimation.WALKING_LEFT.ordinal()) && onGround)
        {
            // Play footstep sound effect
            bufferSound();
        }
    }
    
    /**
     * This method controls when each animation frame will be used during any of Odelia's actions.
     */
    public void setAnimationFrame()
    {
        final int IMAGE_BUFFER = 3;
        
        //Set the frame based on the current status of Odelia.
        if (!Greenfoot.isKeyDown("control"))
        {
            if (getCurrentAnimation() != CurrentAnimation.WALKING_LEFT.ordinal() && Greenfoot.isKeyDown("left"))
            {
                setImageBuffer(IMAGE_BUFFER);
                setCurrentImage(0);
                setAnimation(CurrentAnimation.WALKING_LEFT.ordinal());
            }
            else if (getCurrentAnimation() != CurrentAnimation.WALKING_RIGHT.ordinal() && Greenfoot.isKeyDown("right"))
            {
                setImageBuffer(IMAGE_BUFFER);
                setCurrentImage(0);
                setAnimation(CurrentAnimation.WALKING_RIGHT.ordinal());
            }
            else if (getCurrentAnimation() == CurrentAnimation.WALKING_LEFT.ordinal() && !Greenfoot.isKeyDown("left"))
            {
                setImageBuffer(IMAGE_BUFFER);
                setCurrentImage(0);
                setAnimation(CurrentAnimation.IDLE_LEFT.ordinal());
            }
            else if (getCurrentAnimation() == CurrentAnimation.WALKING_RIGHT.ordinal() && !Greenfoot.isKeyDown("right"))
            {
                setImageBuffer(IMAGE_BUFFER);
                setCurrentImage(0);
                setAnimation(CurrentAnimation.IDLE_RIGHT.ordinal());
            }
        }
        else
        {
            if (facingLeft)
            {
                setImageBuffer(IMAGE_BUFFER);
                setCurrentImage(0);
                setAnimation(CurrentAnimation.ATTACK_LEFT.ordinal());
            }
            else
            {
                setImageBuffer(IMAGE_BUFFER);
                setCurrentImage(0);
                setAnimation(CurrentAnimation.ATTACK_RIGHT.ordinal());
            }
        }        
    }
    
    /**
     * Play footstep sounds when running.
     */
    private void bufferSound()
    {
        if (soundBuffer-- < 1)
        {
            soundBuffer = 10;
            Greenfoot.playSound("running.wav");
        }
    }
    
    /**
     * No gravity movement. For testing purposes only.
     */
    public void moveDebug()
    {
       if (Greenfoot.isKeyDown("left"))
            setLocation(getX() - 10, getY());
       if (Greenfoot.isKeyDown("right"))
            setLocation(getX() + 10, getY());
       if (Greenfoot.isKeyDown("up"))
            setLocation(getX(), getY() - 10);
       if (Greenfoot.isKeyDown("down"))
            setLocation(getX(), getY() + 10);
    }
    
    /**
     * Get input from player to determine the speed and velocity of Odelia's next movement action.
     */
    public void getDirection()
    {
       if (Greenfoot.isKeyDown("left"))
       {
            setLocation(getX() - speed, getY());
            facingLeft = true;
       }
       if (Greenfoot.isKeyDown("right"))
       {
            setLocation(getX() + speed, getY());
            facingLeft = false;
       }
       if (Greenfoot.isKeyDown("up") && onGround)
       {
            ySpeed -= jumpStr;
       }
    }
    
    /**
     * Carry out the actual movement.
     */
    public void move()
    {
        ySpeed++;
        setLocation(getX(), getY() + ySpeed/2);
        onGround = false;
    }
   
    /**
     * Handle collisions with other game objects in the game.
     */
    public void collisions() 
    {
        checkEnemy();
        
        //Continually check in 4 directions to ensure that Odelia doesn't fall through the ground
        while (getOneObjectAtOffset(1, getImage().getHeight()/2 + 1, Box.class) != null)
        {
            setLocation(getX(), getY() - 1);
            onGround = true;
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(1, -getImage().getHeight()/2 - 1, Box.class) != null)
        {
            setLocation(getX(), getY() + 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(getImage().getWidth()/2+1, 0, Box.class) != null)
        {
            setLocation(getX() - 1, getY());
        }
        while (getOneObjectAtOffset(-getImage().getWidth()/2-1, 0, Box.class) != null)
        {
            setLocation(getX() + 1, getY());
        }
    }
    
    /**
     * Check if an enemy has touched Odelia or if Odelia has assassinated the politician.
     */
    public void checkEnemy()
    {
        //First if checks whether or not the attack has connected with the Politician
        if (isTouching(Politician.class) && 
            (getCurrentAnimation() == CurrentAnimation.ATTACK_LEFT.ordinal() || 
            getCurrentAnimation() == CurrentAnimation.ATTACK_RIGHT.ordinal()))
        {
            Greenfoot.setWorld(new Restart(true, (DemoWorld) getWorld()));
        }
        else if (isTouching(Spikes.class)) 
        {
            Greenfoot.setWorld(new Restart(false, (DemoWorld) getWorld()));
        }
        else if (getOneIntersectingObject(Bullet.class) != null)
        {
            Greenfoot.setWorld(new Restart(false, (DemoWorld) getWorld()));
        }
        else if (getOneIntersectingObject(MeleeEnemy.class) != null)
        {
            Greenfoot.setWorld(new Restart(false, (DemoWorld) getWorld()));   
        }
    }
}

