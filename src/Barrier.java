import java.awt.Color;
import java.awt.Graphics;

public class Barrier extends GameObject{
	
	public Barrier(Color color, double x, double y, double size) {
		super(color, x, y, size);

		
	}
	
	@Override
	public void draw(Graphics g){
		g.fillRect((int)getX(), (int)getY(), (int)getSize(), (int)getSize());

	}

	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		
	}

}
