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
    GreenfootImage[] tile = new GreenfootImage[4];
    public Snake()
    {
        for (int i = 0; i < tile.length; i++)
        {
        tile[i] = new GreenfootImage("images/snake_tile/tile00" + i + ".png");
        }
        setImage(tile[0]);
    }
    int imageIndex = 0;
    public void animateSnake()
    {
        setImage(tile[imageIndex]);
        imageIndex = (imageIndex + 1) % tile.length;
    }
        
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
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
