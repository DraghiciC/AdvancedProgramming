import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
 ConfigPanel configPanel;
 ControlPanel controlPanel;
 DrawingPanel canvas;

 public MainFrame() {
 super("My Drawing Application");
 init();
 setSize(1800,1000);
 }

 private void init() {
 setDefaultCloseOperation(EXIT_ON_CLOSE);

 //create the components
 configPanel= new ConfigPanel(this);
 canvas = new DrawingPanel(this);
 controlPanel= new ControlPanel(this);
 //...TODO

 //arrange the components in the container (frame)
 add(configPanel, BorderLayout.PAGE_START);
 add(controlPanel, BorderLayout.PAGE_END);
 //JFrame uses a BorderLayout by default
 add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
 //...TODO

 //invoke the layout manager
 pack();
 }
}
