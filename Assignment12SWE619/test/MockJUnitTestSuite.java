
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import org.easymock.EasyMock;
import org.junit.Test;

import shape.Polygon;
import shape.Shape;

public class MockJUnitTestSuite
{
	
	/**
	 * Hey Erich here is an initial set up. I added comments to
	 * the method signature to both the interfaces (shape and polygon).  I added
	 * some example code below.  If it is not compiling
	 * you need to add the mock easy jar to the buildpath.
	 * 
	 * The jar is included in the project under the jar folder.
	 * 
	 * I found a website that has an interesting example of mock objects
	 * using a methods called expect and return.  I was hoping you could look into that
	 * to make sure I am not missing a step in the process (or additional functionality)
	 * http://www.michaelminella.com/testing/unit-testing-with-junit-and-easymock.html
	 * 
	 * but here are some other test that some fail and some error out...not sure if I am
	 * supposed to be worried since it is not implemented yet.
	 * 
	 */
	
	Shape shapeA = EasyMock.createMock(Shape.class);
	Shape shapeB = EasyMock.createMock(Shape.class);
	Shape shapeC = EasyMock.createMock(Polygon.class);
	
	Polygon polygonA = EasyMock.createMock(Polygon.class);
	Polygon polygonB = EasyMock.createMock(Polygon.class);
	Polygon polygonC = EasyMock.createMock(Polygon.class);
	
	@Test
	public void pointIsAddedToAtTheEndPolygon()
	{
		//create a new point to be added to the polygon
		Point addedPoint = new Point(5, 6);
		//add the point to the end
		polygonA.addPointAtEnd(addedPoint);
		//make sure the polygon at least has it inside
		assertTrue(polygonA.contains(addedPoint));
		//get the points and check that the point is at the end
		ArrayList<Point> polygonPoints = polygonA.points();
		Point lastPoint = polygonPoints.get(polygonPoints.size() - 1);
		assertTrue(lastPoint.equals(addedPoint));
	}
	
	@Test
	public void pointIsAddedToAtTheStartPolygon()
	{
		//create a new point to be added to the polygon
		Point addedPoint = new Point(5, 6);
		//add the point to the start
		polygonA.addPointAtStart(addedPoint);
		//make sure the polygon at least has it inside
		assertTrue(polygonA.contains(addedPoint));
		//get the points and check that the point is at the start
		ArrayList<Point> polygonPoints = polygonA.points();
		Point startPoint = polygonPoints.get(0);
		assertTrue(startPoint.equals(addedPoint));
	}
	
	@Test 
	public void theNumberOfPointsIsTheSameAsItsSize()
	{
		assertTrue(polygonA.points().size() == polygonA.numberOfPoints());
	}
	
	@Test(expected = IllegalStateException.class)
	public void removePointsForIllegalStateException()
	{
		//remove the points until you have three left
	   while(polygonB.numberOfPoints() >= 3)
	   {
		   polygonB.removeFirstPoint();
	   }
	   
	   //remove one more point. Should throw IllegalStateException since 
	   //a polygon should have at least 3 points
	   polygonB.removeFirstPoint();
	}
	
	@Test
	public void addingAndRemovalOfPoint()
	{
		//create a point that does not already exist in polygonC
		Point uniquePoint = createUniquePoint(polygonC.points());
		//check the contains method that it doesn't contain the point
		assertFalse(polygonC.contains(uniquePoint));
		//add the point
		polygonC.addPointAtStart(uniquePoint);
		//check to make sure it was added
		assertTrue(polygonC.contains(uniquePoint));
		//remove the point
		polygonC.removePoint(uniquePoint);
		//check to make sure it is not added
		assertFalse(polygonC.contains(uniquePoint));
	}

	private Point createUniquePoint(ArrayList<Point> points) 
	{
		Random randomInt = new Random();
		int x = randomInt.nextInt();
		int y = randomInt.nextInt();
		Point uniquePoint = new Point(x, y);
		
		while(points.contains(uniquePoint))
		{
			uniquePoint = new Point(randomInt.nextInt(), randomInt.nextInt());
		}
		
		return uniquePoint;
	}
}
