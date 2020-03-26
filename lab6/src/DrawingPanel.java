import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class DrawingPanel extends JPanel {
 final MainFrame frame;
 final static int W = 1800, H = 850;
 BufferedImage image; //the offscreen image
 static Graphics2D graphics; //the "tools" needed to draw in the image
 public DrawingPanel(MainFrame frame) {
 this.frame = frame; createOffscreenImage(); init();
 }
 private void createOffscreenImage() {
 image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
 graphics = image.createGraphics();
 graphics.setColor(Color.WHITE); //fill the image with white
 graphics.fillRect(0, 0, W, H);
 }
 private void init() {
	 setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
	 setBorder(BorderFactory.createEtchedBorder()); //for fun
	 this.addMouseListener(new MouseAdapter() {
	 @Override
	 public void mousePressed(MouseEvent e) {
	 drawShape(e.getX(), e.getY()); repaint();
	 } //Can’t use lambdas, JavaFX does a better job in these cases
	 });
	 }
	 private void drawShape(int x, int y) {
	 int radius = (int)(Math.random()*300); //generate a random number
	 int sides = (Integer) ConfigPanel.sidesField.getValue(); //get the value from UI (in ConfigPanel)
	 String str = ConfigPanel.colorCombo.getSelectedItem().toString();
	 Color color;
	 if(str.equals("Black")) 
	color = new Color(0,0,0);
	 else
	color = new Color ( (float) (Math.random()%1),(float) (Math.random()%1),(float) (Math.random()%1),0.5f);//create a transparent random Color.
	 graphics.setColor(color);
	 graphics.fill(new RegularPolygon(x, y, radius, sides));
	 }
	 @Override
	 public void update(Graphics g) { } //Why did I do that?

	 @Override
	 protected void paintComponent(Graphics g) {
	 g.drawImage(image, 0, 0, this);repaint();
	 }
	 public static void load() {
		 try {
			BufferedImage img = ImageIO.read(new File("2.png"));
			graphics.drawImage(img, 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public static void reset() {
		 graphics.setColor(Color.WHITE);
		 graphics.fillRect(0, 0, W, H);
	 }
}
