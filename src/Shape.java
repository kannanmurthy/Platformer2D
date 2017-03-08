import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Shape extends GameObject{

	public Shape(Color color, double x, double y, double size) {
		super(color, x, y, size);
		
	}
	public Rectangle getBounds() {
		return new Rectangle((int)getX(),(int)getY(),(int)this.getSize(),(int)this.getSize());
	}


	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillRect((int)getX(), (int)getY(), (int)getSize(), (int)getSize());
		//System.out.println("X coord is: " + getX() + " and Y coord is: " + getY());
		
	}
	
}
