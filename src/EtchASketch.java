import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EtchASketch {

	final JFrame frame;
	Canvas screen;
	JButton right, left, up, down, reset;
	
	EtchASketch() {
		frame = new JFrame();
		screen = new Canvas();
	}
	
	public static void main(String[] args) {
		new EtchASketch().launch();
	}
	
	public void launch() {
		 
		 frame.setSize(800, 600);
		 frame.setTitle("Etch-A-Sketch");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 // first set of buttons (on left)
		 right = buttonBuilder(">", 50, 100);
		 left = buttonBuilder("<", 50, 100);
		 up = buttonBuilder("^", 100, 50);
		 down = buttonBuilder("v", 100, 50);
		 
		 reset = new JButton("SHAKE!");
		 reset.addActionListener(new ShakeIt());
		 
		 frame.getContentPane().setBackground(Color.RED);
		 frame.getContentPane().add(BorderLayout.NORTH, getBorderPanel(800, 50));
		 frame.getContentPane().add(BorderLayout.EAST, getBorderPanel(100, 400));
		 frame.getContentPane().add(BorderLayout.WEST, getBorderPanel(100, 400));
		 
		 JPanel buttonsLeft = new JPanel();
		 buttonsLeft.add(left);
		 buttonsLeft.add(right);
		 
		 JPanel buttonsRight = new JPanel();
		 buttonsRight.add(BorderLayout.NORTH, up);
		 buttonsRight.add(BorderLayout.CENTER, down);
		
		 JPanel controlBar = new JPanel();
		 controlBar.setBackground(Color.RED);
		 controlBar.add(BorderLayout.WEST, buttonsLeft);
		 controlBar.add(BorderLayout.CENTER, reset);
		 controlBar.add(BorderLayout.EAST, buttonsRight);
		 
		 
		 frame.getContentPane().add(BorderLayout.CENTER, screen);
		 frame.getContentPane().add(BorderLayout.SOUTH, controlBar);
		 frame.setVisible(true);
	}
	
	private JButton buttonBuilder(String text, int width, int height) {
		JButton btn = new JButton(text);
		btn.addActionListener(new moveCursor());
		// removed the sizing, because my layout didn't honor it for both sets...
		// btn.setPreferredSize(new Dimension(width, height));
		 
	 	return btn;
	}
	
	private JPanel getBorderPanel(int width, int height) {
		JPanel result = new JPanel();
		result.setSize(100, 400);
		result.setBackground(Color.RED);
		
		return result;
	}
	
	class moveCursor implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			int x = 0, y = 0;
			
			if (event.getSource() == right) 
				x = 1;
			if (event.getSource() == left) 
				x = -1;
			if (event.getSource() == down) 
				y = 1;
			if (event.getSource() == up) 
				y = -1;
			
			screen.moveBy(x, y);
		}
	}
	
	class ShakeIt implements ActionListener	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			screen.shake();
		}
	}
}
