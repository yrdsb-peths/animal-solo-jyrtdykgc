import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound snakeHiss = new GreenfootSound("snake hiss sound.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[4];
    GreenfootImage[] idleLeft = new GreenfootImage[4];
    
    // snake facing right
    String facing = "right";
    SimpleTimer timer = new SimpleTimer();
    public Snake()
    {
        for (int i = 0; i < idleRight.length; i++)
        {
        idleRight[i] = new GreenfootImage("images/idle" + i + ".png");
        idleRight[i].scale(100, 100);
        }
        
        for (int i = 0; i < idleLeft.length; i++)
        {
        idleLeft[i] = new GreenfootImage("images/idle" + i + ".png");
        idleLeft[i].mirrorHorizontally();
        idleLeft[i].scale(100, 100);
        }
        timer.mark();
        setImage(idleRight[0]);
    }
    int imageIndex = 0;
    public void animateSnake()
    {
        if (timer.millisElapsed() < 250)
        {
            return;
        }
        timer.mark();
        if (facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
        
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("left"))
        {
            move(-1);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
            facing = "right";
        }
         
        eat();
        animateSnake();
        //remove food if snake touch the food & spawn new food
        
    }
    
    public void eat()
    {
        if(isTouching(Insect.class))
        {
            removeTouching(Insect.class);
            MyWorld world = (MyWorld) getWorld();
            world.createInsect();
            world.increaseScore();
        }
    }
}
