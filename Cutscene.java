import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cutscene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cutscene extends World
{
    private int numClicks = 0;
    private boolean sceneOneStart = false;
    private boolean sceneOneOver = false;
    private boolean sceneTwoStart = false;
    private boolean sceneTwoOver = false;
    private boolean sceneThreeStart = false;
    private GreenfootSound walk, kiss, bed, blanket, door;
    /**
     * Constructor for objects of class Cutscene.
     * 
     */
    public Cutscene()
    {    
        super(800, 600, 1);
        addObject(new Text("Click to continue", 20, true), getWidth() - 100, getHeight() - 20);
    }
    
    public void act()
    {
        sceneOne();
        sceneTwo();
    }
    
    public void sceneTwo()
    {
        if (!sceneOneOver)
        {
            return;
        }
        else 
        {
            if (!sceneTwoStart)
            {
                this.removeObjects(getObjects(Text.class));
                addObject(new Text("Click to continue", 20, true), getWidth() - 100, getHeight() - 20);
                sceneTwoStart = true;
            }
            produceScene2();
        }
    }
    
    public void produceScene2()
    {        
        if (Greenfoot.mouseClicked(null) && numClicks == 0)
        {
            walk.stop();
            addObject(new Text("Are you walking me\nto school tomorrow?", 35, true), 600, 100);
            bed = new GreenfootSound("creak.wav");
            bed.setVolume(85);
            bed.play();
            numClicks++;
        }
        else if (Greenfoot.mouseClicked(null) && numClicks == 1)
        {
            addObject(new Text("Sorry Lea, I can't.\nI have work early.", 40, true), 200, 200);
            numClicks++;
        }
        else if (Greenfoot.mouseClicked(null) && numClicks == 2)
        {
            bed.stop();
            addObject(new Text("I'll tuck you in.", 40, true), 200, 300);
            blanket = new GreenfootSound("blanket.wav");
            blanket.setVolume(85);
            blanket.play();
            numClicks++;
        }
        else if (Greenfoot.mouseClicked(null) && numClicks == 3)
        {
            blanket.stop();
            addObject(new Text("Good night, Lea.", 40, true), 200, 400);
            kiss = new GreenfootSound("kiss.wav");
            kiss.setVolume(85);
            kiss.play();
            numClicks++;
        }
        else if (Greenfoot.mouseClicked(null) && numClicks == 4)
        {   
            kiss.stop();
            addObject(new Text("Good night, mom.", 40, true), 600, 500);
            numClicks++;
        }
        else if (Greenfoot.mouseClicked(null) && numClicks == 5)
        {
            Greenfoot.setWorld(new Wardrobe());
        }
    }
    
    public void sceneOne()
    {
        if (!sceneOneOver)
        {
            if (Greenfoot.mouseClicked(null) && numClicks == 0)
            {
                addObject(new Text("Lea.", 40, true), 200, 100);
                numClicks++;
            }
            else if (Greenfoot.mouseClicked(null) && numClicks == 1)
            {
                addObject(new Text("Yeah mom?", 35, true), 600, 200);
                numClicks++;
            }
            else if (Greenfoot.mouseClicked(null) && numClicks == 2)
            {
                addObject(new Text("It's bedtime.", 40, true), 200, 300);
                numClicks++;
            }
            else if (Greenfoot.mouseClicked(null) && numClicks == 3)
            {
                addObject(new Text("Already?", 35, true), 600, 400);
                numClicks++;
            }
            else if (Greenfoot.mouseClicked(null) && numClicks == 4)
            {
                addObject(new Text("Yup. You have\nschool tomorrow.", 40, true), 200, 500);
                walk = new GreenfootSound("walk.wav");
                walk.setVolume(85);
                walk.play();
                numClicks++;
            }
            else if (Greenfoot.mouseClicked(null) && numClicks == 5)
            {
                sceneOneOver = true;
                numClicks = 0;
            }
        }
    }
}
