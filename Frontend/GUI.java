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
		//homeScreen();
		settingsScreen();
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
		btn.setFont(title.getFont().deriveFont(18.0F));
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

	//Display settings screen
	private void settingsScreen(){
		//Clear frame
		fClear();
		
		//Create back button/s
		addBackButtons();
		
		//Creating title text
		JLabel title = new JLabel("Display Settings");
		title.setFont(title.getFont().deriveFont(40.0F));
		title.setSize(500,50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setLocation(frameW/2 - title.getWidth()/2, frameH/12 - title.getHeight()/2);
		f.add(title);
		
		//Text variables
		Font font = title.getFont().deriveFont(25.0F);
		int textX = frameW/3 - btnW/2;
	
		//Display 1x1 - Color Theme
		JLabel themeText = new JLabel("Color Theme");
		themeText.setFont(font);
		themeText.setBounds(textX, frameH/6 + btnH/2, btnW, btnH);
		themeText.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(themeText);
		
		/*
		Display 1x2 - Color Theme Drop-down Menu
		Options:
		Fishing Bat (Default) - cool
		Evening Bat - warm
		Spotted Bat - muted
		False Vampire Bat - silver
		*/
		
		
		//Display 2x1 - Color Filter
		JLabel filText = new JLabel("Color Filter");
		filText.setFont(font);
		filText.setBounds(textX, frameH/3 + btnH/2, btnW, btnH);
		filText.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(filText);
		
		/*
		Display 2x2 - Color Filter Drop-down Menu
		Options:
		None (Default)
		Monochrome
		Tritanopia
		Deuteranopia
		Protanopia
		*/
		
		
		//Display 3x1 - Text Size
		JLabel sizeText = new JLabel("Text Size");
		sizeText.setFont(font);
		sizeText.setBounds(textX, frameH/2 + btnH/2, btnW, btnH);
		sizeText.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(sizeText);
		
		/*
		Display 3x2 - Text Size Drop-Down Menu
		50%
		75%
		100% (Default)
		125%
		150%
		*/
		
		
		//Display 4x1 - Narration
		JLabel narrText = new JLabel("Narration");
		narrText.setFont(font);
		narrText.setBounds(textX, frameH*2/3 + btnH/2, btnW, btnH);
		narrText.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(narrText);
		
		/*
		Display 4x2 - Narration Drop-Down Menu
		Off (Default)
		On Click
		On Hover
		*/
	}
	
	//Add back buttons to frame
	private void addBackButtons(){
		try{
			//home
			BufferedImage homeImage = ImageIO.read(new File("Frontend\\Images\\Home.png"));
			JLabel homeBtn = new JLabel(new ImageIcon(homeImage));
			JPanel hPanel = new JPanel();
			hPanel.setSize(30,30);
			hPanel.setLocation(0,0);
			hPanel.add(homeBtn);
			hPanel.addMouseListener(new MouseListener(){
				public void mouseReleased(MouseEvent e){homeScreen();}	//change to last screen
				public void mouseClicked(MouseEvent e){}
				public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
				public void mouseExited(MouseEvent e){}
				public void mousePressed(MouseEvent e){}
			});
			f.add(hPanel);
			
			//back
			BufferedImage backArrowImage = ImageIO.read(new File("Frontend\\Images\\Back.png"));
			JLabel backBtn = new JLabel(new ImageIcon(backArrowImage));
			JPanel bPanel = new JPanel();
			bPanel.setSize(30,30);
			bPanel.setLocation(hPanel.getWidth(), 0);
			bPanel.add(backBtn);
			bPanel.addMouseListener(new MouseListener(){
				public void mouseReleased(MouseEvent e){homeScreen();}	//change to home screen
				public void mouseClicked(MouseEvent e){}
				public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
				public void mouseExited(MouseEvent e){}
				public void mousePressed(MouseEvent e){}
			});
			f.add(bPanel);
		}catch(IOException e){}
	}
}