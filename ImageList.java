import greenfoot.*;

/**
 * Write a description of class ImageList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageList  
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
