/*
Justin Freemantle
ICS3U Ms Krasteva
My ISP Splash Screen
*/

import java.awt.*;
import hsa.Console;
import java.lang.*;

public class SplashScreen extends Thread
{
    Console c;

    public void splashScreen ()
    {
	//draws the background
	c.setColor (Color.blue);
	c.fillRect (0, 0, 640, 500);
	//sets the font
	//text moves on screen
	for (int i = 0 ; i < 500 ; i++)
	{
	    c.setColor (Color.white);
	    //erases
	    c.fillRect (0, 60, 640, 50);
	    c.fillRect (710 - i, 350, 240, 50);
	    //delay
	    try
	    {
		Thread.sleep (5);
	    }
	    catch (InterruptedException e)
	    {
	    }
	}
	//draws the lightbulb
	for (int i = 0 ; i < 350 ; i++)
	{
	    c.setColor (Color.blue); //erase
	    c.fillRect (-81 + i, 150, 100, 155);
	    c.setColor (Color.gray); //base
	    c.fillRect (-60 + i, 230, 60, 60);
	    c.fillOval (-45 + i, 275, 30, 30);
	    c.setColor (Color.blue); //bulb
	    c.fillOval (-80 + i, 150, 100, 100);
	    c.setColor (Color.black);
	    c.drawOval (-80 + i, 150, 100, 100);
	    c.setColor (Color.white);
	    c.drawLine (-60 + i, 250, i, 250); //stripes
	    c.drawLine (-60 + i, 270, i, 270);
	    //delay
	    try
	    {
		Thread.sleep (5);
	    }
	    catch (InterruptedException e)
	    {
	    }
	}
	//delay
	try
	{
	    Thread.sleep (500);
	}
	catch (InterruptedException e)
	{
	}
	c.setColor (Color.yellow); //bulb lights up
	c.fillOval (270, 150, 100, 100);
	//delay
	try
	{
	    Thread.sleep (500);
	}
	catch (InterruptedException e)
	{
	}
	c.setColor (Color.blue); //bulb
	c.fillOval (270, 150, 100, 100);
	c.setColor (Color.black); //bulb
	c.drawOval (270, 150, 100, 100);
	//delay
	try
	{
	    Thread.sleep (500);
	}
	catch (InterruptedException e)
	{
	}
	c.setColor (Color.yellow); //bulb
	c.fillOval (270, 150, 100, 100);
	//delay
	try
	{
	    Thread.sleep (1000);
	}
	catch (InterruptedException e)
	{
	}

    }


    public SplashScreen (Console con)
    {
	c = con;
	splashScreen ();
    }
}


