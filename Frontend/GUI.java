package Frontend;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.imageio.ImageIO;

// Main class
public class GUI {
	//Dimensions
	protected int frameH = 800;	//Width of the frame
	protected int frameW = 800;	//Height of the frame
	protected int btnW = 300;	//Width of buttons
	protected int btnH = 75;	//Height of buttons
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
        f = new JFrame("Batpedia");
		ImageIcon icon = new ImageIcon("Frontend\\Images\\Logo.png");
		f.setIconImage(icon.getImage());
		f.setSize(frameW, frameH);
		f.setLayout(null);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
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
		
		//Creating title text
		JLabel title = new JLabel("Welcome to Batpedia!");
		title.setFont(title.getFont().deriveFont(40.0F));
		title.setSize(500,50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setLocation(frameW/2 - title.getWidth()/2, frameH/6 - title.getHeight()/2);
		f.add(title);
		
		//Creating subtitle text
		JLabel subtitle = new JLabel("Designed and Programmed by ZB103");
		subtitle.setFont(subtitle.getFont().deriveFont(15.0F));
		subtitle.setSize(500,25);
		subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		subtitle.setLocation(frameW/2 - subtitle.getWidth()/2, title.getY() + title.getHeight());
		f.add(subtitle);
		
		//Creating proceed button
		JButton btn = new JButton("Click here to learn about bats");
		btn.setBounds(frameW/2 - btnW/2,frameH*6/16 - btnH/2,btnW, btnH);
		btn.setHorizontalAlignment(SwingConstants.CENTER);
		btn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){title.setText("button");}	//change to crScreen()
			public void mouseClicked(MouseEvent e){title.setText("button");}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		f.add(btn);
		
		try{
			//Creating logo image
			BufferedImage logoImage = ImageIO.read(new File("Frontend\\Images\\Logo.png"));
			JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
			int logoW = logoImage.getWidth();
			JPanel panel = new JPanel();
			panel.setBounds(frameW/2 - logoImage.getWidth()/2,frameH*11/16 - logoImage.getHeight()/2,logoImage.getWidth(),logoImage.getHeight());
			panel.add(logoLabel);
			f.add(panel);
			
			//Creating settings button
			BufferedImage gearImage = ImageIO.read(new File("Frontend\\Images\\Settings.png"));
			JLabel gearLabel = new JLabel(new ImageIcon(gearImage));
			JPanel sPanel = new JPanel();
			sPanel.setSize(30,30);
			sPanel.setLocation(0, frameH - sPanel.getHeight()*2);
			sPanel.add(gearLabel);
			sPanel.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){title.setText("settings");}	//change to crScreen()
			public void mouseClicked(MouseEvent e){title.setText("settings");}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			});
			f.add(sPanel);
		
		}catch(IOException e){}
		
		//Creating copyright button
		JLabel cr = new JLabel("<HTML><u>Copyright</u></HTML>");
		cr.setFont(cr.getFont().deriveFont(10.0F));
		cr.setSize(50,20);
		cr.setHorizontalAlignment(SwingConstants.CENTER);
		cr.setLocation(frameW - cr.getWidth()*4/3, frameH - 55);
		cr.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){title.setText("pressed");}	//change to crScreen()
			public void mouseClicked(MouseEvent e){title.setText("pressed");}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		f.add(cr);
	}
}