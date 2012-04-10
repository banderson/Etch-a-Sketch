import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * @author Ben Anderson
 * @description Canvas represents the drawing surface for the Etch-a-Sketch game
 */
public class Canvas extends JComponent {
	
	// the graphics item representing the moving cursor
	private Rectangle cursor;
	
	// maintain a list of places the cursor has been so we can 
	//	repaint anytime without losing any part of the drawing
	private ArrayList<Rectangle> points;
	
	// see constructor for details on these instance variables
	private int start_x, start_y, cursor_size;
	
	// default constructor: initialize the state of the drawing surface
	Canvas() {
		// this determines the size of the "pen" on the screen
		cursor_size = 10;
		// the arbitrary starting points of the cursor on the screen
		start_x = start_y = 100;
		
		cursor = new Rectangle(start_x, start_y, cursor_size, cursor_size);
		points = new ArrayList<Rectangle>();
	}
	
	// this renders the canvas
	public void paintComponent(Graphics g) {
		// implement the default JComponent rendering first
		super.paintComponents(g);
		
		// paint the background light_gray (there is no silver)
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// draw a rectangle for every point over which the cursor has traveled
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		for (Rectangle point : points) {
			g2.fill(point);
		}
	}
	
	// move the cursor position on the canvas...
	public void moveBy(int dx, int dy) {
		if (isMoveInBounds(dx, dy)) {
			cursor.translate(dx*cursor_size, dy*cursor_size);
			
			// keep track of all plotted points
			points.add(new Rectangle(cursor.x, cursor.y, cursor_size, cursor_size));
			
			repaint();
		}
	}
	
	// this ensures that the cursor stays within the bounds of the canvas
	private boolean isMoveInBounds(int dx, int dy) {
		int move_x = dx*cursor_size, move_y = dy*cursor_size;

		return (cursor.x + move_x >= 0 & cursor.y + move_y >= 0
				&& cursor.x + move_x <= this.getWidth() & cursor.y + move_y <= this.getHeight());
	}
	
	// if needed, you can move the cursor to any point on the screen
	// NOTE: this is not implemented in the UI functionality
	public void moveTo(int x, int y) {
		cursor.setLocation(x, y);
		
		// keep track of all plotted points
		points.add(new Rectangle(cursor.x, cursor.y, cursor_size, cursor_size));
		
		repaint();
	}
	
	// "shake" the game to start over...
	public void shake() {
		points.clear();
		
		repaint();
	}
}