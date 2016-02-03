import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test extends Scroll
{
    private Odelia od;
    /**
     * Constructor for objects of class Test.
     * 
     */
    public Test()
    {
        super(800, 600, 1, false);
        //super(1044, 675, 1, false);
        addObject(od = new Odelia(), getWidth()/2, getHeight()/2);
        addObject(new Penguin(), getWidth()/2 + 3000, getHeight()/2 - 100);
        makeLevel();
    }
    
    public void act()
    {
        setActorAt(od, getWidth()/2, getHeight()/2);
    }
    
    public void makeLevel()
    {
        //this is a fucking mess R I P memory heap
        
        //Left Edge that penguin is standing on
        addObject(new Box(), getWidth()/2 - 100, getHeight()/2);
        addObject(new Box(), getWidth()/2 - 100, getHeight()/2 - 100);
        
        makeZigZagJump();
        
        //Floor after climbing up
        for (int i = 1; i < 7; i++)
            addObject(new Box(), getWidth()/2 + 100 * i, getHeight()/2 - 800);
        
        makePit();
            
        //Ceiling above spot that Odelia spawns on
        for (int i = 0; i < 5; i++)
            addObject(new Box(), getWidth()/2 + (100 * i), getHeight()/2 - 200); 
            
        //Arching portion of ceiling on bottom level
        addObject(new Box(), getWidth()/2 + 500, getHeight()/2 - 300);
        addObject(new Box(), getWidth()/2 + 600, getHeight()/2 - 300);
        addObject(new Box(), getWidth()/2 + 700, getHeight()/2 - 300);
        
        //Right half of bottom level ceiling
        for (int i = 0; i < 6; i++)
            addObject(new Box(), getWidth()/2 + 800 + i * 100, getHeight()/2 - 200);
            
        //The box that allows Odelia to jump onto level above bottom level    
        addObject(new Box(), getWidth()/2 + 1400, getHeight()/2 - 200);
        
        //Left half of bottom level floor; floor that Odelia spawns on
        for (int i = 0; i < 5; i++)
            addObject(new Box(), getWidth()/2 + (i * 100), getHeight()/2 + 100); 
            
        //The "bump" on the bottom level floor  
        addObject(new Box(), getWidth()/2 + 500, getHeight()/2);
        addObject(new Box(), getWidth()/2 + 600, getHeight()/2);
        addObject(new Box(), getWidth()/2 + 700, getHeight()/2);
        
        //Right half of bottom level floor
        for (int i = 0; i < 6; i++)
            addObject(new Box(), getWidth()/2 + 800 + i * 100, getHeight()/2 + 100);
        
        //Staircase portion of the bottom level floor
        addObject(new Box(), getWidth()/2 + 1400, getHeight()/2 + 100);
        addObject(new Box(), getWidth()/2 + 1500, getHeight()/2);
        addObject(new Box(), getWidth()/2 + 1600, getHeight()/2 - 100);
        addObject(new Box(), getWidth()/2 + 1700, getHeight()/2 - 200);
        
        makeChasm();
        makeFinalArea();
    }
    
    public void makeZigZagJump()
    {
        //Vertical climbing - jump left/right
        addObject(new Box(), getWidth()/2 - 100, getHeight()/2 - 300);
        addObject(new Box(), getWidth()/2 + 100, getHeight()/2 - 400);
        addObject(new Box(), getWidth()/2 - 100, getHeight()/2 - 500);
        addObject(new Box(), getWidth()/2 + 300, getHeight()/2 - 500);
        addObject(new Box(), getWidth()/2 + 400, getHeight()/2 - 600);
        addObject(new Box(), getWidth()/2 + 500, getHeight()/2 - 600);
        addObject(new Box(), getWidth()/2 + 100, getHeight()/2 - 600);
        addObject(new Box(), getWidth()/2 - 100, getHeight()/2 - 700);           
    }
    
    public void makePit()
    {
        //Form pit left wall
        for (int i = 1; i < 3; i++)
            addObject(new Box(), getWidth()/2 + 600, getHeight()/2 - 800 + (i * 100));
        
        //area between left wall and this floor should be a death sentence
            
        //form pit floor
        for (int i = 1; i < 10; i++)
            addObject(new Box(), getWidth()/2 + 600 + i * 100, getHeight()/2 - 600);
           
        addObject(new Box(), getWidth()/2 + 800, getHeight()/2 - 800);    
        addObject(new Box(), getWidth()/2 + 1000, getHeight()/2 - 800);    
        addObject(new Box(), getWidth()/2 + 1100, getHeight()/2 - 700);
        addObject(new Box(), getWidth()/2 + 1300, getHeight()/2 - 800);
        
        //form pit right wall
        for (int i = 1; i < 3; i++)
            addObject(new Box(), getWidth()/2 + 1500, getHeight()/2 - 600 - i* 100);        
    }
    
    public void makeChasm()
    {
        for (int i = 1; i < 8; i++)
            addObject(new Box(), getWidth()/2 + 1500 + i * 100, getHeight()/2 - 800 + i * 100);
    }
    
    public void makeFinalArea()
    {
        for (int i = 1; i < 9; i++)
            addObject(new Box(), getWidth()/2 + 2200 + i * 100, getHeight()/2);
        for (int i = 1; i < 5; i++)
            addObject(new Box(), getWidth()/2 + 2300 + i * 100, getHeight()/2 - i * 100);
        for (int i = 1; i < 4; i++)
            addObject(new Box(), getWidth()/2 + 2400 + i * 100, getHeight()/2 - i * 100);
        for (int i = 1; i < 3; i++)
            addObject(new Box(), getWidth()/2 + 2500 + i * 100, getHeight()/2 - i * 100);
        addObject(new Box(), getWidth()/2 + 2700, getHeight()/2 - 100);        
    }
}
