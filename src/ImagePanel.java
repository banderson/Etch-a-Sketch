import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ImagePanel extends JComponent {
    private Image image;
    private Color color;
    private int x, y, width, height;
    
    public ImagePanel(String image, int x, int y) {
    	ImageIcon img = new ImageIcon(image);
    	this.image = img.getImage();
    	this.x = x;
    	this.y = y;
    }
    
    public ImagePanel(Color color, int x, int y, int width, int height) {
    	this.color = color;
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    }
    
    public ImagePanel(int width, int height) {
    	this.width = width;
    	this.height = height;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if (image != null)
        	g.drawImage(image, 0, 0, null);
        else {
        	g.setColor(Color.RED);
        	this.setSize(this.width, this.height);
        	g.fillRect(this.x, this.y, this.width, this.height);
        }
    }
}
