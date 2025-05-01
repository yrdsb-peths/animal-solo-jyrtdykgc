import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label label;
    public int level = 1;
    public MyWorld() {
        super(600, 400, 1, false);
        Snake snake = new Snake();
        addObject(snake, 300, 300);
        label = new Label(0, 50);
        addObject(label, 20, 20);
        createInsect();
    }
    //end the game + draw gameover
    public void gameOver()
    {
        Label gameOver = new Label("Game Over", 100);
        addObject(gameOver, 300, 200);
    }
    
    //method to increase score
    public void increaseScore()
    {
        score++;
        label.setValue(score);
        if(score % 2 == 0)
        {
            level += 3;
        }
    }
    //create an insect at rendon location at top os screen
    public void createInsect()
    {
        Insect insect = new Insect();
        insect.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(insect, x, y);
        
    
    }
}
