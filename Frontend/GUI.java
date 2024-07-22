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
			new Color(108,190,180), new Color(163,96,94)};	//Fishing Bat (Default)
	protected Color[] eveningBatColor = {new Color(73,63,81), new Color(155,38,38),
			new Color(195,135,73), new Color(209,202,128)};	//Evening Bat
	protected Color[] spottedBatColor = {new Color(53,51,48), new Color(224,209,193),
			new Color(200,170,192), new Color(200,170,192)};	//Spotted Bat
	protected Color[] falseVampBatColor = {new Color(30,8,61), new Color(144,97,164),
			new Color(204,197,215), new Color(204,197,215)};	//False Vampire Bat
	protected Color[] grayscaleColor = {new Color(73,73,73), new Color(132,132,132),
			new Color(182,182,182), new Color(243,243,243)};	//Grayscale
	protected Color[][] colorSchemes = {fishingBatColor, eveningBatColor,
			spottedBatColor, falseVampBatColor, grayscaleColor};	//List of color lists
    
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