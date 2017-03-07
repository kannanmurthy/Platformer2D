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
	Barrier b1 = new Barrier(Color.DARK_GRAY, 200 , 558, 100);
	Barrier b2 = new Barrier(Color.DARK_GRAY, 600, 558, 100);
	Barrier b3 = new Barrier(Color.DARK_GRAY, 1000, 558, 100);
	Portal p = new Portal(Color.MAGENTA, 1300, 358, 100);
	Shape s = new Shape(Color.DARK_GRAY, 10, 628, 30);
	Image background;
	//Rectangle rect = new Rectangle((int)t.getX()+130, (int)t.getY()-33, 100, 65);
	boolean gameOver;

	public shapeDashMap(Dimension d) {
		addShape();
	}


	public void tick(){
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
		s.setY((int)s.getY()+135);
		s.setMovingDirection(0);
		s.setSpeed(15);
	}

	public void moveUp(){
		//t.setY((int)(t.getY()+10));
		s.setMovingDirection(0);
		s.setY((int)s.getY()-135);
		s.setSpeed(8);
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
