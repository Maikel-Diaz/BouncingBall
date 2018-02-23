import java.awt.Color;
import java.util.*;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private BouncingBall[] bolas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int nBolas)
    {
        int ground = 400;   // position of the ground line
        bolas = new BouncingBall[nBolas];

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        Random azar = new Random();
        for(int i = 0; i < nBolas; i++){
            int radio = azar.nextInt(20) + 5;
            int blue = azar.nextInt(256);
            int green = azar.nextInt(256);
            int yellow = azar.nextInt(256);
            Color color = new Color(blue, green, yellow);
            int posicion1 = azar.nextInt(300);
            BouncingBall ball = new BouncingBall(posicion1, 50, radio, color, ground, myCanvas);
            ball.draw();
            bolas[i] = ball;
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0; i < nBolas; i++){
                bolas[i].move();
                // stop once ball has travelled a certain distance on x axis
                if(bolas[i].getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
