import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DemoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DemoWorld extends SWorld
{
    private Odelia od;
    private GreenfootSound bgm;
    
    /**
     * Constructor for objects of class DemoWorld.
     * 
     */
    public DemoWorld()
    {
        super(800, 600, 1, 2500, 3000);
        addMainActor(od = new Odelia(), 200, getHeight() - 100, 200, 60);
        setScrollingBackground(this.getBackground());
        makeLevel();
        placeInstructions();
        placeEnemies();
        
        bgm = new GreenfootSound("bgm.mp3");
        // bgm.playLoop();
    }
    
    public void started()
    {
        bgm.playLoop();
    }
    
    public void stopped()
    {
        bgm.pause();
    }
    
    public void placeInstructions()
    {
        addObject(new Text("Left/Right for movement.\nUp to jump.", 25, true),
            300, getHeight() - 300);
        addObject(new Text("Dodge the guards!", 25, true), 900, getHeight() - 300);
        addObject(new Text("Find the politician and assassinate him!", 25, true),
            1800, getHeight() - 300);
    }
    
    public void placeEnemies()
    {
        //Politician
        addObject(new Penguin(), 1100, getHeight() + 2000);
        
        //Zigzag Shooter
        addObject(new RangedEnemy(100, 100, false, 0), 1800, getHeight() + 600);
        
        //Top level enemy
        addObject(new MeleeEnemy(50, 50, true, 700), 1100, getHeight() - 100);
        
        //Pit enemy
        addObject(new MeleeEnemy(50, 50, true, 200), 700, getHeight() + 1200);
        
        //Enemy before politician
        addObject(new MeleeEnemy(50, 50, true, 330), 500, getHeight() + 1600);
    }
    
    public void makeLevel()
    {
        makeStartingArea();
        makeBottomKink();
        makeBottomRightHalf();
        makeStaircase();
        makeZigZagJump();
        makeLowerLevel();
        makePit();
        makeFinalArea();
    }

    
    public void makeBottomKink()
    {
        //the ceiling and floor kink on bottom level
        for (int i = 0; i < 3; i++) {
            addObject(new Box(), 800 + i * 100, getHeight() - 100);
        }
    }
    
    public void makeBottomRightHalf()
    {
        //Right half of bottom floor
        for (int i = 0; i < 8; i++) {
            addObject(new Box(), 1100 + i * 100, getHeight());
        }
    }
    
    public void makeStaircase()
    {
        addObject(new Box(), 1900, getHeight() + 100);
        addObject(new Box(), 2000, getHeight() + 200);
        addObject(new Box(), 2100, getHeight() + 300);
    }
    
    public void makeStartingArea()
    {
        //Wall to left of Odelia spawn
        addObject(new Box(), 100, getHeight() - 100);
        addObject(new Box(), 100, getHeight() - 200);
        
        //Floor that Odelia spawns on       
        for (int i = 0; i < 6; i++)
            addObject(new Box(), 200 + i * 100, getHeight());
    }
    
    public void makeZigZagJump()
    {
          addObject(new Box(75, 75), 2300, getHeight() + 400);
          addObject(new Box(75, 75), 2100, getHeight() + 500);
          addObject(new Box(75, 75), 2300, getHeight() + 600);
          addObject(new Box(75, 75), 2100, getHeight() + 700);
          
          for (int i = 0; i < 17; i++)
            addObject(new Spikes(), 1965 + i * 30, getHeight() + 1040);
          
          addObject(new Box(), 1800, getHeight() + 700);
          addObject(new Box(), 1700, getHeight() + 700);
          addObject(new Box(), 1700, getHeight() + 600);
          
          addObject(new Box(75, 75), 2300, getHeight() + 800);
          addObject(new Box(75, 75), 2100, getHeight() + 900);
    }
    
    public void makeLowerLevel()
    {
        for (int i = 1; i < 6; i++)
           addObject(new Box(), 2000 - i * 100, getHeight() + 1000);
    }
    
    public void makePit()
    {
        //Right part of pit
        addObject(new Box(), 1500, getHeight() + 1100);
        addObject(new Box(), 1500, getHeight() + 1200);
        addObject(new Box(), 1500, getHeight() + 1300);
        
        //Left part of bit
        addObject(new Box(), 500, getHeight() + 1200);
        addObject(new Box(), 500, getHeight() + 1100);
        
        //Interior of pit
        addObject(new Box(), 1300, getHeight() + 1000);
        addObject(new Box(), 1100, getHeight() + 1000);
        addObject(new Box(), 1000, getHeight() + 1100);
        addObject(new Box(), 1000, getHeight() + 1200);
        addObject(new Box(), 600, getHeight() + 1200);
      
        //Bottom part of pit
        for (int i = 0; i < 10; i++)
            addObject(new Box(), 1400 - i * 100, getHeight() + 1300);
        
        //Place spikes in pit
        for (int i = 0; i < 13; i++)    
            addObject(new Spikes(), 1435 - i * 30, getHeight() + 1245);  
        //Prevent overlap with box
        addObject(new Spikes(), 1065, getHeight() + 1245);
        //area between left wall and this floor should be a death sentence
        // edit this when we gte an actual spike sprite
        // final int SPIKE_WIDTH = 30;
        // final int NUM_SPIKES = 15;
        // for (int i = 1; i < NUM_SPIKES; i++)
            // addObject(new Spikes(), getWidth()/2 + 635 + i * SPIKE_WIDTH, getHeight()/2 - 658);
     
    }
    
    public void makeFinalArea()
    {      
        addObject(new Box(), 300, getHeight() + 1200);
        
        //Make staircase leading down
        for (int i = 1; i < 6; i++)
            addObject(new Box(), 100, getHeight() + 1200 + 100 * i);
        for (int i = 1; i < 5; i++)
            addObject(new Box(), 200, getHeight() + 1300 + 100 * i);
        for (int i = 1; i < 4; i++)
            addObject(new Box(), 300, getHeight() + 1400 + 100 * i);
        for (int i = 1; i < 3; i++)
            addObject(new Box(), 400, getHeight() + 1500 + 100 * i);

        //Spawn final floors and wall
        for (int i = 0; i < 4; i++) {
            addObject(new Box(), 500 + i * 100, getHeight() + 1700);
            addObject(new Box(), 800, getHeight() + 1800 + i * 100);
            addObject(new Box(), 800 + i * 100, getHeight() + 2100);
        }
    }
}