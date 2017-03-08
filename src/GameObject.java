import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;


public abstract class GameObject implements MovingObject {

	private double speed = 0;// 0 - 10
	private double  // degrees or radians
			x= 0, y= 0, // >= 0

	size = 10; // 10 might be a good size
	private int level = 1;//
	protected Color color;
	private Rectangle rect;
	private double movingDirection;
	private boolean inAir = false;

	public GameObject(Color color, double x, double y, double size) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.size = size;
		rect = new Rectangle();
		// assign damage
	}
	public double getMovingDirection(){
		return this.movingDirection;
	}


	public double getX(){
		return x;
	}

	public void setX(int i){
		x = i;
	}

	public double getY(){
		return y;
	}

	public void setY(int i){
		y = i;
	}

	public double getSize(){
		return size;
	}


	@Override
	public void move() {
		x += getSpeed();
//		y+= getSpeed();
		checkOffScreen();

		// maybe "push" back onto the screen change direction if
		// this object goes off the screen
	}

	public abstract void checkOffScreen();

	public abstract void draw(Graphics g);





	@Override
	public Rectangle getBoundingRect() {

		return this.rect;
	}

	public void setBoundingRect(int x, int y, int width, int height){
		rect.setBounds(x, y, width, height);
	}

	public void setMovingDirection(double movingDirection){
		this.movingDirection = movingDirection;
	}


	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
//	public String toString(){
//		String s = "";
//		s+=this.getClass();
//		s+=this.getX()+" , "+this.getY()+" speed: "+this.getSpeed()+" dir: "+this.getDirection();
//		return s;
//	}
}
