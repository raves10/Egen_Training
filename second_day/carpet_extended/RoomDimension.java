package second_day.carpet_extended;

public class RoomDimension {
	
	public double width;
	public double length;
	
	public RoomDimension(double width, double length) {
		
		this.width = width;
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public double getArea()
	{
		return (this.width * this.length);
	}

	@Override
	public String toString() {
		return "RoomDimension [width=" + width + ", length=" + length + "]";
	}
	
	

}
