import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Odelia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    private final int ATTACK_LEFT = 0;
    private final int ATTACK_RIGHT = 1;
    
    private ArrayList<ImageList> attackAnimation;
    
    private int attackAnimationBuffer = 10;
    private int currentAttackFrame = 0;
    
    public Odelia()
    {
        super("Odelia", 14, 4, 9);
        
        /*
        attackAnimation = new ArrayList<ImageList>();
        attackAnimation.add(new ImageList("Odelia_attack_left", 9));
        attackAnimation.add(new ImageList("Odelia_attack_right", 9));
        */
    }
    
    /**
     * Act - do whatever the Odelia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        
        // Just in case we need to tweak this
        final int IMAGE_BUFFER = 3;
        
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
        
        getDirection();
        move();
        // moveDebug();
        collisions();
        
        if ((getCurrentAnimation() == CurrentAnimation.WALKING_RIGHT.ordinal() || getCurrentAnimation() == CurrentAnimation.WALKING_LEFT.ordinal()) && onGround)
        {
            // Play footstep sound effect
            bufferSound();
        }
       
        // Prevent endless falls
        // if (getY() > 350)
        // {
            // Greenfoot.setWorld(new Restart(false));
        // }
    }
    
    private boolean attackAnimationBuffer()
    {
        if (attackAnimationBuffer < 1)
        {
            attackAnimationBuffer = 10;
            return true;
        }
        else
        {
            attackAnimationBuffer--;
        }
        
        return false;
    }
    
    private void attack()
    {
        attacking = true;
        
        // Animate
        /*
        if (attackAnimationBuffer())
        {
            if (facingLeft)
            {
                currentAttackFrame = (currentAttackFrame + 1) % attackAnimation.get(ATTACK_LEFT).list.length;
                this.setImage(attackAnimation.get(ATTACK_LEFT).list[currentAttackFrame]);
            }
            else
            {
                currentAttackFrame = (currentAttackFrame + 1) % attackAnimation.get(ATTACK_RIGHT).list.length;
                this.setImage(attackAnimation.get(ATTACK_RIGHT).list[currentAttackFrame]);
            }
        }
        */
        
        while (currentAttackFrame < attackAnimation.get(ATTACK_LEFT).list.length)
        {
            if (facingLeft)
            {
                if (attackAnimationBuffer())
                    this.setImage(attackAnimation.get(ATTACK_LEFT).list[currentAttackFrame++]);
            }
            else
            {
                if (attackAnimationBuffer())
                    this.setImage(attackAnimation.get(ATTACK_RIGHT).list[currentAttackFrame++]);
            }
        }
        
        attackAnimationBuffer = 10;
        currentAttackFrame = 0;
        
        attacking = false;
    }
    
    private void bufferSound()
    {
        if (soundBuffer-- < 1)
        {
            soundBuffer = 10;
            Greenfoot.playSound("running.wav");
        }
    }
    
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
    
    public void move()
    {
        ySpeed++;
        setLocation(getX(), getY() + ySpeed/2);
        onGround = false;
    }
    
    //Update this with collision detecter from other game
    public void collisions() 
    {
        if (isTouching(Penguin.class))
            Greenfoot.setWorld(new Restart(true));
        else if (isTouching(Spikes.class))
            Greenfoot.setWorld(new Restart(false));
        else if (getOneIntersectingObject(Bullet.class) != null)
            Greenfoot.setWorld(new Restart(false));
        else if (getOneIntersectingObject(MeleeEnemy.class) != null)
            Greenfoot.setWorld(new Restart(false));
        
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
}

