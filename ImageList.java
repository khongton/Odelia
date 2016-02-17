import greenfoot.*;

/**
 * An arrray list of GreenfootImages which animation frames are loaded into.
 * 
 * @author Jeremy Billote
 * @version 2.16.16
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
