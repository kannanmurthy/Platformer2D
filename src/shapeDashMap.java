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
//	Tank t = new Tank(Color.BLACK, a.width/2 , a.height/2, 200);
	Image background;
	//Rectangle rect = new Rectangle((int)t.getX()+130, (int)t.getY()-33, 100, 65);
	int shouldShoot = 0;
	boolean gameOver;

	public shapeDashMap(Dimension d) {



	}

//	public void tick(){
//		//system.out.println("BOT 1 health = " + TankBot.getHealth());
//		//System.out.println("BOT 2 health = " + TankBot2.getHealth());
//		super.tick();
//		double angle = calculateAngle();
//
//		shouldShoot++;
//
//		for (int i =0; i<movers.size(); i++){
//
//			((GameObject)movers.get(i)).setBoundingRect((int)((GameObject)movers.get(i)).getX(), (int)((GameObject)movers.get(i)).getY(), 20, 20);
//			if (movers.get(i) instanceof Tank){
//				t.setDir(angle);
//				t.setBoundingRect((int)t.getX()+130, (int)t.getY()-33, 100, 65);
//				if (t.getHealth() ==0 ){
//					gameOver = true;
//					//JOptionPane.showMessageDialog(null, "Game Over");
//				}
//			}
//
//
//
//
//			if (movers.get(i).equals(TankBot)){
//				System.out.println("tank bot");
//				TankBot.setSpeed(3);
//				TankBot.setMovingDirection(botAngle());
//				TankBot.setDirection(botAngle());
//				TankBot.move();
//				TankBot.setBoundingRect((int)TankBot.getX()+130, (int)TankBot.getY()-33, 100, 65);
//				if (TankBot.getHealth() <=0){
//					movers.remove(i);
//					isBotDead = true;
//
//				}
//			}
//			if (movers.get(i).equals(TankBot2)){
//				System.out.println("tankbot2");
//				TankBot2.setSpeed(3);
//				TankBot2.setMovingDirection(botAngle2());
//				TankBot2.setDirection(botAngle2());
//				TankBot2.move();
//				TankBot2.setBoundingRect((int)TankBot2.getX()+130, (int)TankBot2.getY()-33, 100, 65);
//				if (TankBot2.getHealth() <=0){
//					movers.remove(i);
//					isBotDead2 = true;
//				}
//			}
//
//			if (TankBot.getHealth() <=0 && TankBot2.getHealth() <= 0){
//				//JOptionPane.showMessageDialog(null, "You Win");
//			}
//
//		}
//
//
//
//		//		System.out.println("bot angle= " + Math.toDegrees(botAngle()));
//
//
//		//		for (int i =0; i<movers.size(); i++){
//		//			System.out.println("index = " + i + "  " + ((GameObject) movers.get(i)).getBoundingRect());
//		//			
//		//		}
//
//
//
//		for (int i = 0; i < movers.size(); i++) {
//			for (int j = i+1; j < movers.size(); j++) {
//				// compare list.get(i) and list.get(j)
//				//System.out.println("inner loop");
//
//
//				if (movers.get(i).getBoundingRect().intersects(movers.get(j).getBoundingRect()) && 
//						!((GameObject) movers.get(i)).getName().equals(((GameObject)movers.get(j)).getName())){
//					System.out.println("collision between " + movers.get(i) + "and " + movers.get(j));
//
//					((GameObject) movers.get(i)).takeDamage((GameObject) movers.get(j));
//					((GameObject) movers.get(j)).takeDamage((GameObject) movers.get(i));
//					try {
//						if (movers.get(i) instanceof Bullet){
//							movers.remove(i);
//						}
//					}
//					catch (Exception e){
//						System.out.println("error removing bullet");
//					}
//					try {
//						if (movers.get(j) instanceof Bullet){
//							movers.remove(j);
//						}
//					}
//					catch (Exception e){
//						System.out.println("error removing bullet");
//					}
//				}
//			}
//		}
//
//
//
//	}


	public void draw(Graphics g){
		//		Tank t = new Tank(Color.BLACK, 1 , 1);

		g.drawImage(background, 0, 0, a.width, a.height, null);
		
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
//	public void moveDown(){
//		//t.setY((int)(t.getY()-10));
//		t.setMovingDirection((Math.PI/2));
//		t.setSpeed(15);
//	}
//
//	public void moveUp(){
//		//t.setY((int)(t.getY()+10));
//		t.setMovingDirection((3*Math.PI/2));
//		t.setSpeed(15);
//	}
//
//	public void moveRight(){
//		//t.setX((int)(t.getX()+10));
//		t.setMovingDirection(0);
//		t.setSpeed(15);
//	}
//
//	public void moveLeft(){
//		//t.setX((int)(t.getX()-10));
//		t.setMovingDirection(Math.PI);
//		t.setSpeed(15);
//	}

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
