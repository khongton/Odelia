import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wardrobe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wardrobe extends World
{
    private boolean openedWardrobe = false;
    private boolean changedClothes = false;
    private boolean weaponsGathered = false;
    private boolean leftHouse = false;
    private GreenfootSound opening, changing, door;
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
    
    //TO DO
    //finish the sounds and text for the weapons gathering and leaving the hoiuse
    //push to git tomorrow morning
    
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
    }
    
    public void wardrobeOpening()
    {
        if (Greenfoot.mouseClicked(null))
        {
            addObject(new Text("Well, it's time\n to get ready.", 40, true), 200, 200);
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
            addObject(new Text("I haven't put these on in a while...", 40, true), getWidth()/2, 300);
            changedClothes = true;
            numClicks++;
        }
    }
    
    public void weaponGathering()
    {
    }
    
    public void leavingHouse()
    {
    }
}
