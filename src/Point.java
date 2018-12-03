package application;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
	
	public int[] getPoint() {
		int[] res = new int[2];
		res[0] = x;
		res[1] = y;
		return res;
	}
	
	public void setPoint(int newX, int newY) {
		this.x = newX;
		this.y = newY;
	}
}
