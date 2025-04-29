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
    public Snake()
    {
        setImage("images/snake.png");
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
        //remove food if snake touch the food & spawn new food
        if(isTouching(Insect.class))
        {
            removeTouching(Insect.class);
            MyWorld world = (MyWorld) getWorld();
            world.createInsect();
            world.increaseScore();
        }
    }
}
