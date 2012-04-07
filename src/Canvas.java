import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	private Rectangle cursor;
	private ArrayList<Rectangle> points;
	private int start_x, start_y, cursor_size;
	
	Canvas() {
		cursor_size = 10;
		start_x = start_y = 100;
		
		cursor = new Rectangle(start_x, start_y, cursor_size, cursor_size);
		points = new ArrayList<Rectangle>();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		for (Rectangle point : points) {
			g2.fill(point);
		}
	}
	
	public void moveBy(int dx, int dy) {
		cursor.translate(dx*cursor_size, dy*cursor_size);
		
		// keep track of all plotted points
		points.add(new Rectangle(cursor.x, cursor.y, cursor_size, cursor_size));
		
		repaint();
		
	}
	
	public void moveTo(int x, int y) {
		cursor.setLocation(x, y);
		
		// keep track of all plotted points
		points.add(new Rectangle(cursor.x, cursor.y, cursor_size, cursor_size));
		
		repaint();
	}
	
	public void shake() {
		points.clear();
		
		repaint();
	}
}
