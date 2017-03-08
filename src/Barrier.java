import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Barrier extends GameObject{
	
	public Barrier(Color color, double x, double y, double size) {
		super(color, x, y, size);

		
	}
	
	@Override
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect((int)getX(), (int)getY(), (int)getSize(), (int)getSize());

	}
	public Rectangle getBounds() {
		return new Rectangle((int)this.getX(),(int) this.getY(),(int) this.getSize(),(int)this.getSize());
	}

	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		
	}

}
