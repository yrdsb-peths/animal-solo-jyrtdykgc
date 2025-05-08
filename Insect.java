import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Insect here.
 * the food for snake
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Insect extends Actor
{
    int speed = 1;
    /**
     * Act - do whatever the Insect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Insect(){
        setImage("images/ant3.png");
    }
    public void act()
    {
        // Add your action code here.
        setLocation(getX(), getY() + 1);
        MyWorld world= (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
        
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
