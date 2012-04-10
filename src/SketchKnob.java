import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

// NOTE: this is my initial attempt to make a knob for the etch-a-sketch,
//	but I bailed on the idea because it seemed like a rabbit-hole
public class SketchKnob extends JPanel implements MouseListener {
	private Ellipse2D.Double circle;
	
	SketchKnob() {
		super(new GridLayout(0,1));
		circle = new Ellipse2D.Double(0, 0, 50, 50);
//		this.setSize(200, 200);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.BLUE);
//		g.fillOval(0, 0, 50, 50);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLUE);
		g2.fill(circle);
		this.setSize(100, 100);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
