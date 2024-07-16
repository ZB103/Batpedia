package Frontend;
import java.io.*;
import javax.swing.*;
import java.awt.*;

// Main class
public class GUI {
	//Dimensions
	protected int frameH = 800;	//Width of the frame
	protected int frameW = 800;	//Height of the frame
	protected int btnW = 200;	//Width of buttons
	protected int btnH = 50;	//Height of buttons
	protected static JFrame f;	//Frame
	
	//Color schemes
	protected Color[] fishingBatColor = {new Color(73,63,81), new Color(96,97,101), 
			new Color(108,190,180), new Color(163,96,94)};	//FIshing Bat (Default)
	protected Color[][] colorSchemes = {fishingBatColor};	//List of color lists
    
	//Base frame creation
	public GUI(){
		//Creating frame
        f = new JFrame();
		// ImageIcon icon = new Image("Frontend\\Images\\Asellia patrizii.jpg");
		// frame1.setIconImage(icon);
		f.setSize(frameW, frameH);
		f.setLayout(null);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setName("Batpedia");
		
		//Default to home screen when application is started
		homeScreen();
		//Make frame visible
		f.setVisible(true);
    }
	
	//Reset frame
	private void fClear(){
		f.getContentPane().removeAll();
		f.repaint();
	}
	
	//Display home screen
	private void homeScreen(){
		//Clear frame
		fClear();
		//Creating default screen button
		JButton chiropteraButton = new JButton("About Chiroptera");
		chiropteraButton.setBounds(frameW/2 - btnW/2,frameH/4 - btnH/2,btnW, btnH);
		chiropteraButton.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(chiropteraButton);
	}
}