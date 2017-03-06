import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class MovingObjectsPanel extends JPanel {

	final Dimension defaultDim;// = new Dimension(800,600);
	shapeDashMap gm;
	private Timer t;

	public MovingObjectsPanel() {
		this( new Dimension(800,600));
	}
	public MovingObjectsPanel(Dimension dim) {
		defaultDim = dim;
		this.setPreferredSize(defaultDim);
		makeGameMap();
		t.start();// start the timer which starts the "ticking"
	}
	private void makeGameMap() {
		gm = new shapeDashMap(this.defaultDim);// let the map know what dim is

		setUpKeyMappings();

		t = new Timer(100, new ActionListener() {// fires off every 10 ms
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					gm.tick();// I tell the GameMap to tick... do what
					// you do every time the clock goes off.
					//animation 
					repaint();// naturally, we want to see the new view
			}
		}

				);// this semicolon is here because it is the end of the new Timer construction...
	}

	private void setUpKeyMappings() {
		// maps keys with actions...
		//  The code below maps a KeyStroke to an action to be performed
		// In this case I mapped the space bar key to the action named "shoot"
		// Whenever someone hits the Space Bar the action shoot is sent out

		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"shoot");
		this.getInputMap().put(KeyStroke.getKeyStroke("W"), "moveUp");
		this.getInputMap().put(KeyStroke.getKeyStroke("S"), "moveDown");
		this.getInputMap().put(KeyStroke.getKeyStroke("D"), "moveRight");
		this.getInputMap().put(KeyStroke.getKeyStroke("A"), "moveLeft");
		this.getInputMap().put(KeyStroke.getKeyStroke("released W"), "stop");
		this.getInputMap().put(KeyStroke.getKeyStroke("released S"), "stop");
		this.getInputMap().put(KeyStroke.getKeyStroke("released D"), "stop");
		this.getInputMap().put(KeyStroke.getKeyStroke("released A"), "stop");

		//  This associates the command shoot with some action.  In this 
		// case, the action triggers a shoot command invoked on my GameMap.  In general, whatever 
		// goes in the actionPerformed method will be executed when a shoot command
		// is sent...

		this.getActionMap().put("shoot",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {

				gm.shoot();
			}
		});
//		this.getActionMap().put("stop",new AbstractAction(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				gm.stopTank();
//			}
//		});

		this.getActionMap().put("moveUp", new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e){
				gm.moveUp();
			}
		});

		this.getActionMap().put("moveDown", new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e){
				gm.moveDown();
			}
		});

		this.getActionMap().put("moveRight", new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e){
				gm.moveRight();
			}
		});

		this.getActionMap().put("moveLeft", new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e){
				gm.moveLeft();
			}
		});

		this.requestFocusInWindow();		
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gm.draw(g);
	}

}
