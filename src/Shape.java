import java.awt.Color;
import java.awt.Graphics;

public class Shape extends GameObject{

	public Shape(Color color, double x, double y, double size) {
		super(color, x, y, size);
		
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
		
	}
	
}
