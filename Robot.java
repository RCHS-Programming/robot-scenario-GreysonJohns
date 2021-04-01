import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage robotImage1= new GreenfootImage("man01.png");
    private GreenfootImage robotImage2= new GreenfootImage("man02.png");
    
    private GreenfootImage gameOver= new GreenfootImage("gameover.png");
    
    private int lives = 3;
    private int pizzaCollected;
    public void act() 
    {
        robotMovement();
        detectWallColision();
        detectBlockColision();
        detectHome();
        lookForPizza();
        endGame();
    }    
    
    public void robotMovement()
    {
        if (Greenfoot.isKeyDown("w"))
        {
            setLocation (getX(), getY() -3);
            animate();
        }
        if (Greenfoot.isKeyDown("s"))
        {
            setLocation (getX(), getY() +3);
            animate();
        }
        if (Greenfoot.isKeyDown("a"))
        {
            setLocation (getX() -3, getY());
            animate();
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setLocation (getX() +3, getY());
            animate();
        }
        
       
    }
    
    public void detectWallColision()
    {
        if (isTouching(Wall.class))
        {
            setLocation (50,50);
            
            Greenfoot.playSound("hurt.wav");
            
            removeLife();
        }
    }
    
        public void detectBlockColision()
    {
        if (isTouching(Block.class))
        {
            setLocation (50,50);
            
            Greenfoot.playSound("hurt.wav");
            
            removeLife();
        }
    }
    
    public void lookForPizza()
    {
        if(isTouching(Pizza.class))
        {
            removeTouching(Pizza.class);
            
            pizzaCollected++;
            
            Greenfoot.playSound("eat.wav");
            
            getWorld().showText ("Score:" + pizzaCollected, 70, 550);
            
            
        }
    }
    
    public void detectHome()
    {
        if(isTouching(Home.class))
        
        {
            if (pizzaCollected < 5)
            {
                getWorld().showText ("Collect all the Pizza, Then go Home.", 400, 50);
            }
        
            if (pizzaCollected == 5)
            {
                Greenfoot.stop();
                
                Greenfoot.playSound("yipee.wav");
                
                getWorld().showText ("You Win!", 400, 50);
            }
        }
    }
    
    public void animate()
    {
        if(getImage() == robotImage1)
        {
            setImage(robotImage2);
        }
        else
        {
            setImage(robotImage1);
        }
    }
    
    public void removeLife()
    {
        getWorld().showText ("Lives:" + lives, 70, 575);
        
        lives = lives - 1;
        
    }
    
    public void endGame()
    {
        if (lives < 0)
        {
            Greenfoot.stop();
            
            setImage(gameOver);
        }
    }
    
    public void showStatus()
    {
        getWorld().showText("Lives:" + lives, 70, 575);
        getWorld().showText("Score:" + pizzaCollected, 70, 550);
    }
}
