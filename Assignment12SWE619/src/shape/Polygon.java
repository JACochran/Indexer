package shape;

import java.awt.Point;
import java.util.ArrayList;

public interface Polygon extends Shape
{
	/**
	 * Returns the total number of
	 * points contained in this polygon
	 * @return number of points in the polygon
	 */
	public int numberOfPoints();
	
	/**
	 * Return the list of coordinate points
	 * of the polygon on a 2D plane.
	 * Points must be in successive order meaning 
	 * the points going from the beginning of the list
	 * to the end would be connected continuously.
	 * @return a list of coordinate points
	 */
	public ArrayList<Point> points();
	/**
	 * Adds the point to the beginning of the list
	 * of points in the polygon.
	 * @param point point to be added
	 * 
	 * @throws NullPointerException if point is null
	 */
	public void addPointAtStart(Point point);
	
	/**
	 * Adds the point to the end of the list of points
	 * in the polygon.
	 * 
	 * @param point point to be added
	 * @throws NullPointerException if point is null
	 */
	public void addPointAtEnd(Point point);
	
	/**
	 * Returns true if the point passed in
	 * is in this Polygon returns false if the 
	 * point is not in the polygon
	 * @param point the point to be tested if it is in the polygon
	 * @return true if the point is in the polygon, false otherwise
	 */
	public boolean contains (Point point);
	
	/**
	 * Removes the point from the polygon if
	 * the polygon contains the given point.
	 * @throws IllegalStateException is thrown if there
	 * are less than 3 points in the polygon (there must
	 * be at least three points in order to make a polygon)
	 * @throws NullPointerException if point is null
	 * @param point the point to be removed from the polygon
	 */
	public void removePoint(Point point);
	
	/**
	 * Removes the last point from the polygon.
	 * @throws IllegalStateException is thrown if there
	 * are less than 3 points in the polygon (there must
	 * be at least three points in order to make a polygon)
	 */
	public void removeLastPoint();
	
	/**
	 * Removes the first point from the polygon.
	 * @throws IllegalStateException is thrown if there
	 * are less than 3 points in the polygon (there must
	 * be at least three points in order to make a polygon)
	 */
	public void removeFirstPoint();
	
}
