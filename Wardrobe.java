import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class instantiates the scene where Odelia preps for her mission.
 * 
 * @author Kevin Hongtongsak
 * @version 2.16.16
 */
public class Wardrobe extends World
{
    private boolean openedWardrobe = false;
    private boolean changedClothes = false;
    private boolean weaponsGathered = false;
    private boolean leftHouse = false;
    private GreenfootSound opening, changing, door, knife;
    private int numClicks = 0;
    /**
     * Constructor for objects of class Wardrobe.
     * 
     */
    public Wardrobe()
    {    
        super(800, 600, 1); 
        door = new GreenfootSound("door.wav");
        door.setVolume(85);
        door.play();
    }
    
    public void act()
    {
        if (numClicks == 0)
            wardrobeOpening();
        else if (numClicks == 1)
            clothesChanging();
        else if (numClicks == 2)
            weaponGathering();
        else if (numClicks == 3)
            leavingHouse();
        else if (numClicks == 4)
            startGame();
    }
    
    public void startGame()
    {
        if (Greenfoot.mouseClicked(null))
        {
            Greenfoot.setWorld(new DemoWorld());
        }
    }
    
    public void wardrobeOpening()
    {
        if (Greenfoot.mouseClicked(null))
        {
            addObject(new Text("Well, it's time\n to get ready.", 40, true), 200, 100);
            opening = new GreenfootSound("opening.wav");
            opening.setVolume(75);
            opening.play();
            openedWardrobe = true;
            numClicks++;
        }
    }
    
    public void clothesChanging()
    {
        if (Greenfoot.mouseClicked(null))
        {
            changing = new GreenfootSound("changing.wav");
            changing.setVolume(75);
            changing.play();
            addObject(new Text("I haven't put these on in a while...", 40, true), getWidth()/2, 200);
            changedClothes = true;
            numClicks++;
        }
    }
    
    public void weaponGathering()
    {
        if (Greenfoot.mouseClicked(null))
        {
            changing.stop();
            knife = new GreenfootSound("knife.wav");
            knife.setVolume(75);
            knife.play();
            addObject(new Text("This is still sharp \nafter all these years?", 40, true), getWidth()/2 + 100, 300);
            numClicks++;
        }
    }
    
    public void leavingHouse()
    {
        if (Greenfoot.mouseClicked(null))
        {
            knife.stop();
            door.play();
            addObject(new Text("Good.\n It'll be a quick job then.", 40, true), getWidth()/2, 400);
            numClicks++;
        }
    }
}
