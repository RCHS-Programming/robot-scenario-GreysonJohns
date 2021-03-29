import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RobotWorld here.
 * 
 * @author (Greyson Johns) 
 * @version (1.0)
 */
public class RobotWorld extends World
{

    /**
     * Constructor for objects of class RobotWorld.
     * 
     */
    public RobotWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        addObject (new Robot(), 50, 50);
        
        addObject(new Wall(), 50, 150);
        addObject(new Wall(), 100, 150);
        addObject(new Wall(), 150, 150);
        addObject(new Wall(), 200, 150);
        addObject(new Wall(), 215, 150);
        
        addObject(new Wall(), 750, 150);
        addObject(new Wall(), 700, 150);
        addObject(new Wall(), 650, 150);
        addObject(new Wall(), 600, 150);
        addObject(new Wall(), 550, 150);
        addObject(new Wall(), 535, 150);
        
        addObject (new Home(), 750, 550);
        
        addObject (new Scorepanel(), 75, 550);
        
        addObject (new Block(), 375, 145);
        
        addObject ( new Pizza(), 445, 145);
        addObject ( new Pizza(), 320, 145);
        addObject ( new Pizza(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(81));
        addObject ( new Pizza(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(386) + 215);
        addObject ( new Pizza(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(386) + 215) ;
    }
}
