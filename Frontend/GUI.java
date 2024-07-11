package Frontend;
import java.io.*;
import javax.swing.*;

// Main class
public class GUI {
	protected int frameH = 800;	//Width of the frame
	protected int frameW = 800;	//Height of the frame
	protected int btnW = 200;	//Width of buttons
	protected int btnH = 50;	//Height of buttons
    public GUI(){
		//Creating frame
        JFrame f = new JFrame();
		// ImageIcon icon = new Image("Frontend\\Images\\Asellia patrizii.jpg");
		// frame1.setIconImage(icon);
		f.setSize(frameW, frameH);
		f.setLayout(null);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//Creating default screen button
		JButton chiropteraButton = new JButton("About Chiroptera");
		chiropteraButton.setBounds(frameW/2 - btnW/2,frameH/4 - btnH/2,btnW, btnH);
		chiropteraButton.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(chiropteraButton);
		
		
		//Make frame visible
		f.setVisible(true);
    }
}