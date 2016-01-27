package edu.ucsb.cs56.w16.drawings.sdbistarkey.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Skyler Bistarkey-Rez 
   @version for CS56, W16, UCSB
   
*/
public class SmartPhone extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of smart phone
       @param y y coord of lower left corner of smart phone
       @param width width of the smartphone
       @param height height of smartphone
       @param radius radius of the home button
    */
    public SmartPhone(double x, double y, double width, double height, double radius)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.

	double innerScreenX = 10 + x;
	double innerScreenY = 10 + y;
	double innerScreenWidth = width - 20;
	double innerScreenHeight = height - 20;
	double homeButtonX = (x + width/2.0 - radius/2.0);
	double homeButtonY = (y + (height + innerScreenHeight)/2.0 + radius/2.0);

	
        // Make the body of the phone
        
        Rectangle2D.Double phoneBody = 
            new Rectangle2D.Double(x, y, width, height);
	
        // make the screen. it'll be inside the main body by 100px on each
	// border
	Rectangle2D.Double screen =
	    new Rectangle2D.Double(innerScreenX, innerScreenY,
				   innerScreenWidth, innerScreenHeight);

	Ellipse2D.Double homeButton =
	    new Ellipse2D.Double(homeButtonX, homeButtonY, radius, radius);
	
	
        // put the whole phone together
	
        GeneralPath wholeHouse = this.get();
        wholeHouse.append(phoneBody, false);
        wholeHouse.append(screen, false);
	wholeHouse.append(homeButton, false);
    }
}
