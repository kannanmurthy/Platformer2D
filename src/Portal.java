import java.awt.Color;
import java.awt.Graphics;

public class Portal extends GameObject{

	public Portal(Color color, double x, double y, double size) {
		super(color, x, y, size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval((int)getX(), (int)getY(), (int)getSize(), (int)getSize()*3);
	}

}
