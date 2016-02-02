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
        super(1044, 675, 1, false);
        addObject(od = new Odelia(), getWidth()/2, getHeight()/2);
        addObject(new Penguin(), getWidth()/2 - 100, getHeight()/2 - 200);
        makeLevel();
    }
    
    public void act()
    {
        setActorAt(od, getWidth()/2, getHeight()/2);
    }
    
    public void makeLevel()
    {
        addObject(new Box(), getWidth()/2 - 100, getHeight()/2);
        addObject(new Box(), getWidth()/2, getHeight()/2 + 100);
        addObject(new Box(), getWidth()/2 - 100, getHeight()/2 - 100);
        for (int i = 0; i < 5; i++)
            addObject(new Box(), getWidth()/2 + (100 * i), getHeight()/2 - 200);
            
        addObject(new Box(), getWidth()/2 + 500, getHeight()/2 - 300);
        addObject(new Box(), getWidth()/2 + 600, getHeight()/2 - 300);
        addObject(new Box(), getWidth()/2 + 700, getHeight()/2 - 300);
        for (int i = 0; i < 6; i++)
            addObject(new Box(), getWidth()/2 + 800 + i * 100, getHeight()/2 - 200);
        addObject(new Box(), getWidth()/2 + 1400, getHeight()/2 - 200);
        for (int i = 0; i < 6; i++)
            addObject(new Box(), getWidth()/2 + (i * 100), getHeight()/2 + 100);
           
        addObject(new Box(), getWidth()/2 + 500, getHeight()/2);
        addObject(new Box(), getWidth()/2 + 600, getHeight()/2);
        addObject(new Box(), getWidth()/2 + 600, getHeight()/2 - 100);
        addObject(new Box(), getWidth()/2 + 700, getHeight()/2);
        for (int i = 0; i < 6; i++)
            addObject(new Box(), getWidth()/2 + 800 + i * 100, getHeight()/2 + 100);
            
        addObject(new Box(), getWidth()/2 + 1400, getHeight()/2 + 100);
        addObject(new Box(), getWidth()/2 + 1500, getHeight()/2);
        addObject(new Box(), getWidth()/2 + 1600, getHeight()/2 - 100);
        addObject(new Box(), getWidth()/2 + 1700, getHeight()/2 - 200);
    }
}
