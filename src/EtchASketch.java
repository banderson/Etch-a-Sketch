import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EtchASketch {

	final JFrame frame;
	Canvas screen;
	
	// since there are two sets of controls (left and right), create two sets
	JButton right, left, up, down, reset;
	JButton right2, left2, up2, down2;
	
	EtchASketch() {
		frame = new JFrame();
		screen = new Canvas();
	}
	
	public static void main(String[] args) {
		new EtchASketch().launch();
	}
	
	public void launch() {
		 
		 frame.setSize(1000, 600);
		 frame.setTitle("Etch-A-Sketch");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 // first set of buttons (on left)
		 right = new JButton(">");
		 right.addActionListener(new moveCursor());
		 left = new JButton("<");
		 left.addActionListener(new moveCursor());
		 up = new JButton("^");
		 up.addActionListener(new moveCursor());
		 down = new JButton("v");
		 down.addActionListener(new moveCursor());
		 
		 // second set of buttons (on right)
		 right2 = new JButton(">");
		 right2.addActionListener(new moveCursor());
		 left2 = new JButton("<");
		 left2.addActionListener(new moveCursor());
		 up2 = new JButton("^");
		 up2.addActionListener(new moveCursor());
		 down2 = new JButton("v");
		 down2.addActionListener(new moveCursor());
		 reset = new JButton("SHAKE!");
		 reset.addActionListener(new ShakeIt());
		 
//		 frame.getContentPane().add(BorderLayout.WEST, new ImagePanel("src/assets/border-left.png", 100, 400));
		 frame.getContentPane().setBackground(Color.RED);
//		 frame.getContentPane().add(BorderLayout.NORTH, new ImagePanel(500, 100));
//		 frame.getContentPane().add(BorderLayout.EAST, new ImagePanel(100, 400));
//		 frame.getContentPane().add(BorderLayout.WEST, new ImagePanel(100, 400));
//		 frame.getContentPane().add(BorderLayout.SOUTH, new ImagePanel(500, 100));
		 
		 JPanel buttonsLeft = new JPanel();
		 JButton[] set1 = {up, left, right, down};
		 setupButtons(buttonsLeft, set1);
		 
		 JPanel buttonsRight = new JPanel();
		 JButton[] set2 = {up2, left2, right2, down2};
		 setupButtons(buttonsRight, set2);
		 
		 JPanel controlBar = new JPanel();
		 controlBar.setBackground(Color.RED);
		 controlBar.add(BorderLayout.WEST, buttonsLeft);
		 controlBar.add(BorderLayout.CENTER, reset);
		 controlBar.add(BorderLayout.EAST, buttonsRight);
		 
		 
		 frame.getContentPane().add(BorderLayout.CENTER, screen);
		 frame.getContentPane().add(BorderLayout.SOUTH, controlBar);
		 frame.setVisible(true);
	}
	
	private void setupButtons(JPanel panel, JButton[] buttons) {
		panel.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    JButton button;
	    
	    c.gridx = 0;
	    c.gridy = 0;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    
	    button = new JButton("-");
//	    buttons.add(button, c);
	    c.gridx = 1;
	    panel.add(buttons[0], c);
	    button = new JButton("-");
	    c.gridx = 2;
//	    buttons.add(button, c);
	    
	    c.gridy = 1;
	    c.gridx = 0;
	    panel.add(buttons[1], c);
	    c.gridx = 2;
	    panel.add(buttons[2], c);
	    
	    c.gridy = 2;
	    c.gridx = 0;
	    button = new JButton("-");
//	    buttons.add(button, c);
	    c.gridx = 1;
	    panel.add(buttons[3], c);
	    button = new JButton("-");
	    c.gridx = 2;
//	    buttons.add(button, c);
	}
	
	class moveCursor implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			int x = 0, y = 0;
			
			if (event.getSource() == right || event.getSource() == right2) 
				x = 1;
			if (event.getSource() == left || event.getSource() == left2) 
				x = -1;
			if (event.getSource() == down || event.getSource() == down2) 
				y = 1;
			if (event.getSource() == up || event.getSource() == up2) 
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
