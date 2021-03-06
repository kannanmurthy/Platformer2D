import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import java.net.URL;

import javax.imageio.ImageIO;

public class shapeDashMap extends GameMap {
	Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
	static Barrier b1 = new Barrier(Color.DARK_GRAY, 400 , 598, 60);
	static Barrier b2 = new Barrier(Color.DARK_GRAY, 650, 598, 60);
	static Barrier b3 = new Barrier(Color.DARK_GRAY, 1000, 598, 60);
	Portal p = new Portal(Color.MAGENTA, 1300, 358, 100);
	static Shape s = new Shape(Color.GREEN, 10, 628, 30);
	Image background;
	public static double seconds = 0;
	//Rectangle rect = new Rectangle((int)t.getX()+130, (int)t.getY()-33, 100, 65);
	boolean gameOver;
	static boolean collision = false;
	public boolean isJumping = false;


	public shapeDashMap(Dimension d) {
		addShape();
	}


	public void tick(){
		if (isJumping) {
			seconds++;
			if (seconds <21) {
				s.setY(627-((Math.sin(Math.toRadians(seconds*9))*200)));
				System.out.println(s.getY()); 
			}
			else {
				isJumping = false;
				seconds = 0;
			}
		}
		//system.out.println("BOT 1 health = " + TankBot.getHealth());
		//System.out.println("BOT 2 health = " + TankBot2.getHealth());
		super.tick();

		for (int i =0; i<movers.size(); i++){

			((GameObject)movers.get(i)).setBoundingRect((int)((GameObject)movers.get(i)).getX(), (int)((GameObject)movers.get(i)).getY(), 20, 20);

		}

		//		System.out.println("bot angle= " + Math.toDegrees(botAngle()));

		//		for (int i =0; i<movers.size(); i++){
		//			System.out.println("index = " + i + "  " + ((GameObject) movers.get(i)).getBoundingRect());
		//			
		//		}


	}


	public void draw(Graphics g){
		//		Tank t = new Tank(Color.BLACK, 1 , 1);

		g.drawImage(background, 0, 0, a.width, a.height, null);
		b1.draw(g);
		b2.draw(g);
		b3.draw(g);
		p.draw(g);
		s.draw(g);


		//		t.draw(g);
		//		TankBot.draw(g);
		//		for (int i =0; i<movers.size(); i++){
		//			movers.get(i).draw(g);
		//		}
		//		if (TankBot.getHealth()<=0 && TankBot2.getHealth()<=0){
		//			g.setFont(new Font("TimesRoman", Font.PLAIN, 300)); 
		//			FontMetrics metrics = g.getFontMetrics();
		//			// Determine the X coordinate for the text
		//			int x = (3840 - metrics.stringWidth("You Win")) / 2;
		//			// Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
		//			int y = ((2160 - metrics.getHeight()) / 2) + metrics.getAscent();
		//
		//			g.drawString("You Win", x, y);
		//		}
		//
		//		if (gameOver){
		//			g.setFont(new Font("TimesRoman", Font.PLAIN, 300)); 
		//			FontMetrics metrics = g.getFontMetrics();
		//			// Determine the X coordinate for the text
		//			int x = (3840 - metrics.stringWidth("You Lose")) / 2;
		//			// Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
		//			int y = ((2160 - metrics.getHeight()) / 2) + metrics.getAscent();
		//
		//			g.drawString("You Lose", x, y);
		//		}

	}

	//	public double getBotAngle(){
	//		return this.botAngle();
	//	}
	//
	private void addShape() {
		this.addGameObject(s);
	}

	public void moveDown(){
		//t.setY((int)(t.getY()-10));
		//		if(s.getY()<628)
		//		s.setY((int) s.getY() + 135);
		//		s.setMovingDirection(0);
		//		s.setSpeed(15);

	}

	public void moveUp(){
		//t.setY((int)(t.getY()+10));
		//		s.setMovingDirection(0);
		//		s.setY((int)s.getY()-135);
		//		int temp = (int)s.getY()-135;
		//		s.setSpeed(10);
	}

	public void moveRight(){
		//t.setX((int)(t.getX()+10));
		s.setMovingDirection(0);
		s.setSpeed(8);
	}

	public void moveLeft(){
		//t.setX((int)(t.getX()-10));
		s.setMovingDirection(0);
		s.setSpeed(8);
	}

	public void jump(){
		isJumping = true;
		s.setMovingDirection(0);
		s.setSpeed(8);
		//		for (int i = 0; i<181; i++){
		//			s.setY(500-((Math.sin(Math.toRadians(i))*200)));
		//			System.out.println(s.getY());
		//		}
		//s.setY(400-Math.sin(0));
		//		s.setY(700-((Math.sin((Math.PI)/2)))*200);
		//		//s.setY(400-Math.sin(Math.PI));
		//		System.out.println(400-Math.sin(0));
		//		System.out.println(400-((Math.sin((Math.PI)/2)))*200);
		//		System.out.println(400-Math.sin(Math.PI));
	}

	@Override
	public void openBackgroundImage() {
		// TODO Auto-generated method stub
		try {
			URL url = getClass().getResource("images/Background_001.png");
			background = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("problem opening the background");
			e.printStackTrace();
		}

	}
	public static boolean ifCollide() {
		if(s.getBounds().intersects(b1.getBounds()) || s.getBounds().intersects(b2.getBounds()) || s.getBounds().intersects(b3.getBounds())) {
			collision = true;
		} else collision = false;
		return collision;
	}
	private void secondCounter() {
		seconds += .1;
	}

	private int mouseX(){
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		return x;
	}

	private int mouseY(){
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int y = (int) b.getY();
		return y;
	}

	//	private double botAngle2(){
	//		double adjacentSide = t.getX() - TankBot2.getX();
	//		double oppositeSide = t.getY() - TankBot2.getY();
	//		double angle = Math.atan2(oppositeSide,  adjacentSide);
	//		return angle;
	//	}
	//
	//	public void stopTank() {
	//		// TODO Auto-generated method stub
	//		t.setSpeed(0);
	//	}

}
