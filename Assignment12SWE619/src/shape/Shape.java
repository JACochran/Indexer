package shape;

public interface Shape
{
	/**
	 * Returns the area of the shape
	 * (i.e. if the Shape is a Square with a side length of 3 the area would be 9)
	 * @return the area of the shape
	 */
	public double getArea();
	/**
	 * Returns the length of the continuous line
	 * forming the boundary of the enclosed geometric figure
	 * @return the perimeter of the shape
	 */
	public double getPerimeter();
}
