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
	Barrier b1 = new Barrier(Color.BLACK, 200 , 558, 100);
	Barrier b2 = new Barrier(Color.BLACK, 600, 558, 100);
	Barrier b3 = new Barrier(Color.BLACK, 1000, 558, 100);
	Portal p = new Portal(Color.BLACK, 1300, 358, 100);
	Shape s = new Shape(Color.cyan, 10, 628, 30);
	Image background;
	//Rectangle rect = new Rectangle((int)t.getX()+130, (int)t.getY()-33, 100, 65);
	int shouldShoot = 0;
	boolean gameOver;

	public shapeDashMap(Dimension d) {


	}

	public void tick(){
		//system.out.println("BOT 1 health = " + TankBot.getHealth());
		//System.out.println("BOT 2 health = " + TankBot2.getHealth());
		super.tick();

		shouldShoot++;

		for (int i =0; i<movers.size(); i++){

			((GameObject)movers.get(i)).setBoundingRect((int)((GameObject)movers.get(i)).getX(), (int)((GameObject)movers.get(i)).getY(), 20, 20);
			if (movers.get(i) instanceof Tank){
				s.setDir(angle);
				t.setBoundingRect((int)t.getX()+130, (int)t.getY()-33, 100, 65);
			}
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
//	private void addTank() {
//		this.addGameObject(t);
//		this.addGameObject(TankBot);
//		this.addGameObject(TankBot2);
//	}
//
//	public void shoot(){
//		this.addGameObject(t.shoot());
//	}
//
//	public void botShoot(){
//		this.addGameObject(TankBot.shoot(getBotAngle()));
//	}
//
//	public void botShoot2(){
//		this.addGameObject(TankBot2.shoot(botAngle2()));
//	}
//
	public void moveDown(){
		//t.setY((int)(t.getY()-10));
		s.setMovingDirection((Math.PI/2));
		s.setSpeed(15);
	}

	public void moveUp(){
		//t.setY((int)(t.getY()+10));
		s.setMovingDirection((3*Math.PI/2));
		s.setSpeed(15);
	}

	public void moveRight(){
		//t.setX((int)(t.getX()+10));
		s.setMovingDirection(0);
		s.setSpeed(15);
	}

	public void moveLeft(){
		//t.setX((int)(t.getX()-10));
		s.setMovingDirection(0);
		s.setSpeed(15);
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
	

//	private double calculateAngle(){
//		Point imageCenter = new Point((int)t.getX() + 89, (int)t.getY() -50);
//		double adjacentSide = mouseX() - imageCenter.x;
//		double oppositeSide = mouseY() - imageCenter.y;
//		double angle = Math.atan2(oppositeSide,adjacentSide);
//		System.out.println(t.getX() + ", " +t.getY());
//		//System.out.println("Height equals " + tank.getHeight(null) + "Width equals " + tank.getWidth(null));
//		return  angle;
//	}
//
//	private double botAngle(){
//		double adjacentSide = t.getX() - TankBot.getX();
//		double oppositeSide = t.getY() - TankBot.getY();
//		double angle = Math.atan2(oppositeSide,  adjacentSide);
//		return angle;
//	}
//
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
