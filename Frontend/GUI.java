package Frontend;
import Classification.*;
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
			
	//Order
	protected Chiroptera chiroptera = new Chiroptera();
	protected Suborder yinpterochiroptera = new Suborder("Yinpterochiroptera");
	protected Suborder yangochiroptera = new Suborder("Yangochiroptera");
	//Yango
	String ya = "Yangochiroptera";
	protected Family cistugidae = new Family("Cistugidae", "Wing-Gland Bats", ya);
	protected Family emballonuridae = new Family("Emballonuridae", "Sac-Winged & Sheath-Tailed Bats", ya);
	protected Family furipteridae = new Family("Furipteridae", "Smoky Bat & Thumbless Bat", ya);
	protected Family miniopteridae = new Family("Miniopteridae", "Bent/Long-Winged Bats", ya);
	protected Family molossidae = new Family("Molossidae", "Free-Tailed Bats", ya);
	protected Family mormoopidae = new Family("Mormoopidae", "Mustached & Ghost-Faced & Naked-Backed Bats", ya);
	protected Family mystacinidae = new Family("Mystacinidae", "New Zealand Short-Tailed Bats", ya);
	protected Family myzopodidae = new Family("Myzopodidae", "Sucker-Footed Bats", ya);
	protected Family natalidae = new Family("Natalidae", "Funnel-Eared Bats", ya);
	protected Family noctilionidae = new Family("Noctilionidae", "Bulldog Bats", ya);
	protected Family nycteridae = new Family("Nycteridae", "Hollow-Faced Bats", ya);
	protected Family phyllostomidae = new Family("Phyllostomidae", "Leaf-Nosed Bats", ya);
	protected Family thyropteridae = new Family("Thyropteridae", "Disk-Winged Bats", ya);
	protected Family vespertilionidae = new Family("Vespertillionidae", "Evening Bats", ya);
	//Yin
	String yi = "Yinpterochiroptera";
	protected Family craseonycteridae = new Family("Craseonycteridae", "Kitti's Hog-Nosed/Bumblebee Bat", yi);
	protected Family hipposideridae = new Family("Hipposideridae", "Old World Leaf-Nosed Bats", yi);
	protected Family megadermatidae = new Family("Megadermatidae", "False Vampire Bats", yi);
	protected Family pteropodidae = new Family("Pteropodidae", "Megabats", yi);
	protected Family rhinolophidae = new Family("Rhinolophidae", "Horseshoe Bats", yi);
	protected Family rhinopomatidae = new Family("Rhinopomatidae", "Mouse-Tailed Bats", yi);
    
	//Keep track of what page is current while on Yango family (yangoButtons); default page 1
	//Optimize change this
	protected static int curPage = 1;
	protected static int curPageLower = 1;
	
	//Keep track of selected family on suborder pages
	//Optimize change this
	protected static Family currentFamily = null;
	
	//image panel
	protected static JPanel panel = new JPanel();
	
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
	
	//currentFamily variable setter (helper function)
	private void setCurrentFamily(Family f, JTextArea infoBox){
			currentFamily = f;
			addFamilyPhoto(infoBox);
		}
	
	//Reset frame
	private void fClear(){
		f.getContentPane().removeAll();
		f.repaint();
		SwingUtilities.updateComponentTreeUI(f);
		curPage = 1;
		curPageLower = 1;
		currentFamily = null;
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
			public void mouseReleased(MouseEvent e){orderScreen();}
			public void mouseClicked(MouseEvent e){orderScreen();}
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
				public void mouseReleased(MouseEvent e){settingsScreen();}
				public void mouseClicked(MouseEvent e){settingsScreen();}
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
			public void mouseReleased(MouseEvent e){crScreen();}
			public void mouseClicked(MouseEvent e){crScreen();}
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
		String[] themeStrings = {"Fishing Bat", "Evening Bat", "Spotted Bat", "False Vampire Bat"};
		JComboBox<String> themeList = new JComboBox<>(themeStrings);
		themeList.setSelectedIndex(0);
		themeList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				themeText.setText(themeStrings[themeList.getSelectedIndex()]);
			}
		});
		JPanel themeMenu = new JPanel();
		themeMenu.add(themeList);
		themeMenu.setBounds(themeText.getX()*3, themeText.getY() + btnH/4, btnW, btnH);
		f.add(themeMenu);
		
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
		String[] filStrings = {"None", "Monochrome", "Tritanopia", "Deuteranopia", "Protanopia"};
		JComboBox<String> filList = new JComboBox<>(filStrings);
		filList.setSelectedIndex(0);
		filList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				filText.setText(filStrings[filList.getSelectedIndex()]);
			}
		});
		
		JPanel filMenu = new JPanel();
		filMenu.add(filList);
		filMenu.setBounds(filText.getX()*3, filText.getY() + btnH/4, btnW, btnH);
		f.add(filMenu);
		
		//Display 3x1 - Text Size
		JLabel sizeText = new JLabel("Text Size");
		sizeText.setFont(font);
		sizeText.setBounds(textX, frameH*3/6 + btnH/2, btnW, btnH);
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
		String[] sizeStrings = {"50%", "75%", "100%", "125%", "150%"};
		JComboBox<String> sizeList = new JComboBox<>(sizeStrings);
		sizeList.setSelectedIndex(2);
		sizeList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sizeText.setText(sizeStrings[sizeList.getSelectedIndex()]);
			}
		});
		
		JPanel sizeMenu = new JPanel();
		sizeMenu.add(sizeList);
		sizeMenu.setBounds(sizeText.getX()*3, sizeText.getY() + btnH/4, btnW, btnH);
		f.add(sizeMenu);
		
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
		String[] narrStrings = {"Off", "On Click", "On Hover"};
		JComboBox<String> narrList = new JComboBox<>(narrStrings);
		narrList.setSelectedIndex(0);
		narrList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				narrText.setText(narrStrings[narrList.getSelectedIndex()]);
			}
		});
		
		JPanel narrMenu = new JPanel();
		narrMenu.add(narrList);
		narrMenu.setBounds(narrText.getX()*3, narrText.getY() + btnH/4, btnW, btnH);
		f.add(narrMenu);
		
		//Create back button/s
		addBackButtons("settings");
	}
	
	//Add back buttons to frame
	private void addBackButtons(String curScreen){
		try{
			//home
			BufferedImage homeImage = ImageIO.read(new File("Frontend\\Images\\Home.png"));
			JLabel homeBtn = new JLabel(new ImageIcon(homeImage));
			JPanel hPanel = new JPanel();
			hPanel.setSize(30,30);
			hPanel.setLocation(0,0);
			hPanel.add(homeBtn);
			hPanel.addMouseListener(new MouseListener(){
				public void mouseReleased(MouseEvent e){homeScreen();}
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
				public void mouseReleased(MouseEvent e){
					if(curScreen.equals("suborder")){orderScreen();}
					else{homeScreen();}
				}
				public void mouseClicked(MouseEvent e){}
				public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
				public void mouseExited(MouseEvent e){}
				public void mousePressed(MouseEvent e){}
			});
			f.add(bPanel);
		}catch(IOException e){}
	}

	//Display copyright disclaimer screen
	private void crScreen(){
		//Clear frame
		fClear();
		
		//Creating title
		JLabel title = new JLabel("Copyright disclaimer:");
		title.setFont(title.getFont().deriveFont(40.0F));
		title.setSize(500,50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setLocation(frameW/2 - title.getWidth()/2, frameH/12 - title.getHeight()/2);
		f.add(title);
		
		try{
			//Creating cr disclaimer box
			//Getting data from file
			File file = new File("Classification\\Data\\cr.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String crText = br.readLine();
			//Creating box
			JTextArea crBox = new JTextArea(crText);	//add border	//add center alignment
			crBox.setSize(600,350);
			crBox.setLocation(frameW/2 - crBox.getWidth()/2, frameH/3 - crBox.getHeight()/2 + 20);
			crBox.setLineWrap(true);
			crBox.setWrapStyleWord(true);
			crBox.setEditable(false);
			crBox.setFont(crBox.getFont().deriveFont(20.0F));
			f.add(crBox);
			
			br.close();
			fr.close();
			
			//Creating logo image
			BufferedImage logoImage = ImageIO.read(new File("Frontend\\Images\\LogoCR.png"));
			JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
			int logoW = logoImage.getWidth();
			JPanel panel = new JPanel();
			panel.setBounds(frameW/2 - logoImage.getWidth()/2,frameH*3/4 - logoImage.getHeight()/2,logoImage.getWidth(),logoImage.getHeight());
			panel.add(logoLabel);
			f.add(panel);
		}catch(IOException e){}
		
		//add buttons
		addBackButtons("copyright");
	}

	//Display order screen (Chiroptera)
	private void orderScreen(){
		//Clear frame
		fClear();
		
		//Creating title text
		JLabel title = new JLabel("Bats - Order Chiroptera");
		title.setFont(title.getFont().deriveFont(40.0F));
		title.setSize(500, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setLocation(frameW/2 - title.getWidth()/2, frameH/12 - title.getHeight()/2);
		f.add(title);
		
		//Creating Yin button
		JButton yiBtn = new JButton("Yinpterochiroptera");
		yiBtn.setSize(btnW*2/3, btnH);
		yiBtn.setLocation(frameW*1/3 - yiBtn.getWidth()/2, frameH*2/12);
		yiBtn.setFont(yiBtn.getFont().deriveFont(18.0F));
		yiBtn.setHorizontalAlignment(SwingConstants.CENTER);
		yiBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){suborderScreen("Yinpterochiroptera");}
			public void mouseClicked(MouseEvent e){suborderScreen("Yinpterochiroptera");}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		f.add(yiBtn);
		
		//Creating Yango button
		JButton yaBtn = new JButton("Yangochiroptera");
		yaBtn.setSize(btnW*2/3, btnH);
		yaBtn.setLocation(frameW*2/3 - yaBtn.getWidth()/2, frameH/6);
		yaBtn.setFont(yaBtn.getFont().deriveFont(18.0F));
		yaBtn.setHorizontalAlignment(SwingConstants.CENTER);
		yaBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){suborderScreen("Yangochiroptera");}
			public void mouseClicked(MouseEvent e){suborderScreen("Yangochiroptera");}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		f.add(yaBtn);
		
		//Creating horizontal line
		JSeparator line = new JSeparator(SwingConstants.HORIZONTAL);
		line.setSize(frameW*7/8, 50);
		line.setLocation(frameW/2 - line.getWidth()/2,frameH*4/12 - line.getHeight()/2);
		f.add(line);
		
		//Creating information text box
		JTextArea infoBox = new JTextArea();
		infoBox.setSize(600,350);
		infoBox.setLocation(frameW/2 - infoBox.getWidth()/2, frameH*8/12 - infoBox.getHeight()/2);
		infoBox.setLineWrap(true);
		infoBox.setWrapStyleWord(true);
		infoBox.setEditable(false);
		infoBox.setFont(infoBox.getFont().deriveFont(20.0F));
		// infoBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		// infoBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		f.add(infoBox);
		
		//Creating info buttons
		//Future optimization: button creation loop
		// String currentLabel = Chiroptera.getData("order");
		// int btnX = 50;
		// while(currentLabel != "*ENDDOC"){
			// JButton button = new JButton();
		// }
		
		//Order button: displays order data from file Chiroptera in text box
		JButton btn1 = new JButton("Order");
		btn1.setSize(yiBtn.getWidth()*3/4, yiBtn.getHeight()*3/4);
		btn1.setLocation(frameW/2 - btn1.getWidth()*3/2, frameH/3);
		btn1.setFont(btn1.getFont().deriveFont(20.0F));
		btn1.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(chiroptera.getData("order"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){try{infoBox.setText(chiroptera.getData("order"));}catch(IOException f){}}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		f.add(btn1);
		
		//Frequency button: displays frequency data from file Chiroptera in text box
		JButton btn2 = new JButton("Frequency");
		btn2.setSize(btn1.getWidth(), btn1.getHeight());
		btn2.setLocation(btn1.getX() + btn1.getWidth(), btn1.getY());
		btn2.setFont(btn2.getFont().deriveFont(20.0F));
		btn2.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		f.add(btn2);
		
		//Diversity button: displays diversity data from file Chiroptera in text box
		JButton btn3 = new JButton("Diversity");
		btn3.setSize(btn1.getWidth(), btn1.getHeight());
		btn3.setLocation(btn2.getX() + btn2.getWidth(), btn1.getY());
		btn3.setFont(btn3.getFont().deriveFont(20.0F));
		btn3.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){
				try{infoBox.setText(chiroptera.getData("diversity"));}catch(IOException f){}
				infoBox.setAlignmentY(SwingConstants.RIGHT);
				}
			public void mouseClicked(MouseEvent e){
				try{infoBox.setText(chiroptera.getData("diversity"));}catch(IOException f){}
				infoBox.setAlignmentY(SwingConstants.RIGHT);
				}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		f.add(btn3);
		
		//Add home and back buttons
		addBackButtons("order");
	}
	
	//Display suborder screen (Yin/Yango)
	private void suborderScreen(String suborderString){
		//Clear frame
		fClear();
		
		//Creating title text
		JLabel title = new JLabel("Suborder " + suborderString);
		title.setFont(title.getFont().deriveFont(35.0F));
		title.setSize(500, 150);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setLocation(frameW/2 - title.getWidth()/2, frameH/12 - title.getHeight()/2);
		f.add(title);
		
		//Creating information text box
		JTextArea infoBox = new JTextArea();
		infoBox.setSize(400,350);
		infoBox.setLocation(frameW*17/24 - infoBox.getWidth()/2, frameH*8/12 - infoBox.getHeight()/2);
		infoBox.setLineWrap(true);
		infoBox.setWrapStyleWord(true);
		infoBox.setEditable(false);
		infoBox.setFont(infoBox.getFont().deriveFont(20.0F));
		// infoBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		// infoBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		f.add(infoBox);
		
		//Calling helper function for buttons
		if(suborderString.equalsIgnoreCase("yinpterochiroptera")){
			yinButtons(infoBox);
		}else if(suborderString.equalsIgnoreCase("yangochiroptera")){
			yangoButtons(infoBox);
		}else{
			System.out.println("ERR: Selecting Suborder");
		}
				
		//Creating horizontal line
		JSeparator line = new JSeparator(SwingConstants.HORIZONTAL);
		line.setSize(frameW*7/8, 50);
		line.setLocation(frameW/2 - line.getWidth()/2,frameH*4/12 - line.getHeight()/2);
		f.add(line);
		
		//Add photo
		addFamilyPhoto(infoBox);
		//Add home and back buttons
		addBackButtons("suborder");
	}
	
	//Displaying picture of selected bat family
	private void addFamilyPhoto(JTextArea infoBox){
		//Creating picture box
		try{
			panel.removeAll();	//clear panel
			panel.revalidate();	//remove old image components
			panel.repaint();	//refresh layout
			BufferedImage batImage = ImageIO.read(currentFamily.getImage());
			JLabel batLabel = new JLabel(new ImageIcon(batImage));
			panel.setSize(batImage.getWidth(), batImage.getHeight());
			panel.setLocation(frameW*5/24 - batImage.getWidth()/2, frameH*8/12 - batImage.getHeight()/2);
			panel.add(batLabel);
			f.add(panel);
		}catch(IOException e){
			System.out.println("Error loading image: " + e.getMessage());
		}
	}

	//Sets up the displayed buttons when Yin is pressed on Suborder screen
	private void yinButtons(JTextArea infoBox){
		currentFamily = craseonycteridae;	//default
		//Creating info buttons for yin
		//Future optimization: button creation loop
		
		//Creating family buttons
		//Yin families
		//Page 1
		//Craseonycteridae
		JButton craseoBtn = new JButton("Craseonycteridae");
		craseoBtn.setSize(btnW*2/3, btnH);
		craseoBtn.setLocation(frameW/2 - craseoBtn.getWidth()*3/2, frameH/6);
		craseoBtn.setFont(craseoBtn.getFont().deriveFont(20.0F));
		craseoBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(craseonycteridae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		craseoBtn.setVisible(true);
		f.add(craseoBtn);
		
		//Hipposideridae
		JButton hippoBtn = new JButton("Hipposideridae");
		hippoBtn.setSize(craseoBtn.getWidth(), craseoBtn.getHeight());
		hippoBtn.setLocation(craseoBtn.getX() + craseoBtn.getWidth(), craseoBtn.getY());
		hippoBtn.setFont(hippoBtn.getFont().deriveFont(20.0F));
		hippoBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(hipposideridae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		hippoBtn.setVisible(true);
		f.add(hippoBtn);
		
		//Megadermatidae
		JButton megaBtn = new JButton("Megadermatidae");
		megaBtn.setSize(craseoBtn.getWidth(), craseoBtn.getHeight());
		megaBtn.setLocation(hippoBtn.getX() + hippoBtn.getWidth(), hippoBtn.getY());
		megaBtn.setFont(megaBtn.getFont().deriveFont(20.0F));
		megaBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(megadermatidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		megaBtn.setVisible(true);
		f.add(megaBtn);
		
		//Page 2
		//Pteropodidae
		JButton pteroBtn = new JButton("Pteropodidae");
		pteroBtn.setSize(craseoBtn.getWidth(), craseoBtn.getHeight());
		pteroBtn.setLocation(craseoBtn.getX(), craseoBtn.getY());
		pteroBtn.setFont(pteroBtn.getFont().deriveFont(20.0F));
		pteroBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(pteropodidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		pteroBtn.setVisible(false);
		f.add(pteroBtn);
		
		//Rhinolophidae
		JButton rhinoloBtn = new JButton("Rhinolophidae");
		rhinoloBtn.setSize(craseoBtn.getWidth(), craseoBtn.getHeight());
		rhinoloBtn.setLocation(hippoBtn.getX(), hippoBtn.getY());
		rhinoloBtn.setFont(rhinoloBtn.getFont().deriveFont(20.0F));
		rhinoloBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(rhinolophidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		rhinoloBtn.setVisible(false);
		f.add(rhinoloBtn);
		
		//Rhinopomatidae
		JButton rhinopoBtn = new JButton("Rhinopomatidae");
		rhinopoBtn.setSize(craseoBtn.getWidth(), craseoBtn.getHeight());
		rhinopoBtn.setLocation(megaBtn.getX(), megaBtn.getY());
		rhinopoBtn.setFont(rhinopoBtn.getFont().deriveFont(20.0F));
		rhinopoBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(rhinopomatidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		rhinopoBtn.setVisible(false);
		f.add(rhinopoBtn);
		
		//Creating forward and back arrows - top row

		//right arrow - seek
		JButton rArrow = new JButton(">");
		//left arrow - back
		JButton lArrow = new JButton("<");
		
		rArrow.setSize(craseoBtn.getWidth()/3, craseoBtn.getHeight());
		rArrow.setLocation(megaBtn.getX() + megaBtn.getWidth(), megaBtn.getY());
		rArrow.setFont(rArrow.getFont().deriveFont(10.0F));
		rArrow.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){
				//yinFamilies2();
				//Making arrow button visible - right goes to second screen
				rArrow.setVisible(false);
				lArrow.setVisible(true);
				//Making other buttons visible
				pteroBtn.setVisible(true);
				rhinoloBtn.setVisible(true);
				rhinopoBtn.setVisible(true);
				//Making options buttons invisible
				craseoBtn.setVisible(false);
				hippoBtn.setVisible(false);
				megaBtn.setVisible(false);
			}	//Change so also works for Yango
			
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		rArrow.setVisible(true);
		f.add(rArrow);
		
		//left arrow - back
		//JButton lArrow = new JButton("<");
		lArrow.setSize(rArrow.getWidth(), rArrow.getHeight());
		lArrow.setLocation(craseoBtn.getX() - lArrow.getWidth(), craseoBtn.getY());
		lArrow.setFont(rArrow.getFont());
		lArrow.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){
				//yinFamilies1
				//Making arrow button visible - right goes to second screen
				rArrow.setVisible(true);
				lArrow.setVisible(false);
				//Making options buttons visible
				craseoBtn.setVisible(true);
				hippoBtn.setVisible(true);
				megaBtn.setVisible(true);
				//Making other buttons invisible
				pteroBtn.setVisible(false);
				rhinoloBtn.setVisible(false);
				rhinopoBtn.setVisible(false);
			}	//Change so also works for Yango
			
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		lArrow.setVisible(false);
		f.add(lArrow);
		
		//Add second row of buttons
		infoButtons(infoBox);
	}
	
	//Sets up the displayed buttons when Yango is pressed on Suborder screen
	private void yangoButtons(JTextArea infoBox){
		currentFamily = cistugidae;	//default 
		//Creating info buttons for yango
		//Future optimization: button creation loop
		
		
		
		//Creating family buttons
		//Yango families
		//Page 1
		//Cistugidae
		JButton cistBtn = new JButton("Cistugidae");
		cistBtn.setSize(btnW*2/3, btnH);
		cistBtn.setLocation(frameW/2 - cistBtn.getWidth()*3/2, frameH/6);
		cistBtn.setFont(cistBtn.getFont().deriveFont(20.0F));
		cistBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(cistugidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		cistBtn.setVisible(true);
		f.add(cistBtn);
		
		//Emballonuridae
		JButton embalBtn = new JButton("Emballonuridae");
		embalBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		embalBtn.setLocation(cistBtn.getX() + cistBtn.getWidth(), cistBtn.getY());
		embalBtn.setFont(embalBtn.getFont().deriveFont(20.0F));
		embalBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(emballonuridae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		embalBtn.setVisible(true);
		f.add(embalBtn);
		
		//Furipteridae
		JButton furiBtn = new JButton("Furipteridae");
		furiBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		furiBtn.setLocation(embalBtn.getX() + embalBtn.getWidth(), embalBtn.getY());
		furiBtn.setFont(furiBtn.getFont().deriveFont(20.0F));
		furiBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(furipteridae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		furiBtn.setVisible(true);
		f.add(furiBtn);
		
		//Page 2
		//Miniopteridae
		JButton miniBtn = new JButton("Miniopteridae");
		miniBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		miniBtn.setLocation(cistBtn.getX(), cistBtn.getY());
		miniBtn.setFont(miniBtn.getFont().deriveFont(20.0F));
		miniBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(miniopteridae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		miniBtn.setVisible(false);
		f.add(miniBtn);
		
		//Molossidae
		JButton moloBtn = new JButton("Molossidae");
		moloBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		moloBtn.setLocation(embalBtn.getX(), embalBtn.getY());
		moloBtn.setFont(moloBtn.getFont().deriveFont(20.0F));
		moloBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(molossidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		moloBtn.setVisible(false);
		f.add(moloBtn);
		
		//Mormoopidae
		JButton morBtn = new JButton("Mormoopidae");
		morBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		morBtn.setLocation(furiBtn.getX(), furiBtn.getY());
		morBtn.setFont(morBtn.getFont().deriveFont(20.0F));
		morBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(mormoopidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		morBtn.setVisible(false);
		f.add(morBtn);
		
		//Page 3
		//Mystacinidae
		JButton mystaBtn = new JButton("Mystacinidae");
		mystaBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		mystaBtn.setLocation(cistBtn.getX(), cistBtn.getY());
		mystaBtn.setFont(mystaBtn.getFont().deriveFont(20.0F));
		mystaBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(mystacinidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		mystaBtn.setVisible(false);
		f.add(mystaBtn);
		
		//Myzopodidae
		JButton myzoBtn = new JButton("Myzopodidae");
		myzoBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		myzoBtn.setLocation(embalBtn.getX(), embalBtn.getY());
		myzoBtn.setFont(myzoBtn.getFont().deriveFont(20.0F));
		myzoBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(myzopodidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		myzoBtn.setVisible(false);
		f.add(myzoBtn);
		
		//Natalidae
		JButton natBtn = new JButton("Natalidae");
		natBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		natBtn.setLocation(furiBtn.getX(), furiBtn.getY());
		natBtn.setFont(natBtn.getFont().deriveFont(20.0F));
		natBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(natalidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		natBtn.setVisible(false);
		f.add(natBtn);
		
		//Page 4
		//Noctilionidae
		JButton noctBtn = new JButton("Noctilionidae");
		noctBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		noctBtn.setLocation(cistBtn.getX(), cistBtn.getY());
		noctBtn.setFont(noctBtn.getFont().deriveFont(20.0F));
		noctBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(noctilionidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		noctBtn.setVisible(false);
		f.add(noctBtn);
		
		//Nycteridae
		JButton nyctBtn = new JButton("Nycteridae");
		nyctBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		nyctBtn.setLocation(embalBtn.getX(), embalBtn.getY());
		nyctBtn.setFont(nyctBtn.getFont().deriveFont(20.0F));
		nyctBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(nycteridae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		nyctBtn.setVisible(false);
		f.add(nyctBtn);
		
		//Phyllostomidae
		JButton phyBtn = new JButton("Phyllostomidae");
		phyBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		phyBtn.setLocation(furiBtn.getX(), furiBtn.getY());
		phyBtn.setFont(phyBtn.getFont().deriveFont(20.0F));
		phyBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(phyllostomidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		phyBtn.setVisible(false);
		f.add(phyBtn);
		
		//Page 5
		//Thyropteridae
		JButton thyroBtn = new JButton("Thyropteridae");
		thyroBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		thyroBtn.setLocation(cistBtn.getX(), cistBtn.getY());
		thyroBtn.setFont(thyroBtn.getFont().deriveFont(20.0F));
		thyroBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(thyropteridae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		thyroBtn.setVisible(false);
		f.add(thyroBtn);
		
		//Vespertilionidae
		JButton vesBtn = new JButton("Vespertilionidae");
		vesBtn.setSize(cistBtn.getWidth(), cistBtn.getHeight());
		vesBtn.setLocation(embalBtn.getX(), embalBtn.getY());
		vesBtn.setFont(vesBtn.getFont().deriveFont(20.0F));
		vesBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){setCurrentFamily(vespertilionidae, infoBox);}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		vesBtn.setVisible(false);
		f.add(vesBtn);
		
		//Creating forward and back arrows - top row
		//right arrow - seek
		JButton rArrow = new JButton(">");
		//left arrow - back
		JButton lArrow = new JButton("<");
		
		rArrow.setSize(cistBtn.getWidth()/3, cistBtn.getHeight());
		rArrow.setLocation(furiBtn.getX() + furiBtn.getWidth(), furiBtn.getY());
		rArrow.setFont(rArrow.getFont().deriveFont(10.0F));
		rArrow.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){
				//Increment page number
				curPage++;
				//Show/hide arrows based on page number
				if(curPage == 5){
					rArrow.setVisible(false);
					lArrow.setVisible(true);
				}else if(curPage > 1 && curPage < 5){
					rArrow.setVisible(true);
					lArrow.setVisible(true);
				}else if(curPage == 1){
					rArrow.setVisible(false);
					lArrow.setVisible(true);
				}else{
					System.out.println("ERR: current page index: arrows");
				}
				
				//Show/hide buttons based on page number
				if(curPage == 1){
					//Show
					cistBtn.setVisible(true);
					embalBtn.setVisible(true);
					furiBtn.setVisible(true);
					//Hide pg 2
					miniBtn.setVisible(false);
					moloBtn.setVisible(false);
					morBtn.setVisible(false);
				}else if(curPage == 2){
					//Show
					miniBtn.setVisible(true);
					moloBtn.setVisible(true);
					morBtn.setVisible(true);
					//Hide pg 1 & 3
					cistBtn.setVisible(false);
					embalBtn.setVisible(false);
					furiBtn.setVisible(false);
					mystaBtn.setVisible(false);
					myzoBtn.setVisible(false);
					natBtn.setVisible(false);
				}else if(curPage == 3){
					//Show
					mystaBtn.setVisible(true);
					myzoBtn.setVisible(true);
					natBtn.setVisible(true);
					//Hide pg 2 & 4
					miniBtn.setVisible(false);
					moloBtn.setVisible(false);
					morBtn.setVisible(false);
					noctBtn.setVisible(false);
					nyctBtn.setVisible(false);
					phyBtn.setVisible(false);
				}else if(curPage == 4){
					//Show
					noctBtn.setVisible(true);
					nyctBtn.setVisible(true);
					phyBtn.setVisible(true);
					//Hide pg 3 & 5
					mystaBtn.setVisible(false);
					myzoBtn.setVisible(false);
					natBtn.setVisible(false);
					thyroBtn.setVisible(false);
					vesBtn.setVisible(false);
				}else if(curPage == 5){
					//Show
					thyroBtn.setVisible(true);
					vesBtn.setVisible(true);
					//Hide pg 4
					noctBtn.setVisible(false);
					nyctBtn.setVisible(false);
					phyBtn.setVisible(false);
				}else{
					System.out.println("ERR: current page index: buttons");
				}
			}
			
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		rArrow.setVisible(true);
		f.add(rArrow);
		
		//left arrow - back
		//JButton lArrow = new JButton("<");
		lArrow.setSize(rArrow.getWidth(), rArrow.getHeight());
		lArrow.setLocation(cistBtn.getX() - lArrow.getWidth(), cistBtn.getY());
		lArrow.setFont(rArrow.getFont());
		lArrow.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){
				//Decrement page number
				curPage--;
				//Show/hide arrows based on page number
				if(curPage == 5){
					rArrow.setVisible(false);
					lArrow.setVisible(true);
				}else if(curPage > 1 && curPage < 5){
					rArrow.setVisible(true);
					lArrow.setVisible(true);
				}else if(curPage == 1){
					rArrow.setVisible(true);
					lArrow.setVisible(false);
				}else{
					System.out.println("ERR: current page index: arrows");
				}
				
				//Show/hide buttons based on page number
				if(curPage == 1){
					//Show
					cistBtn.setVisible(true);
					embalBtn.setVisible(true);
					furiBtn.setVisible(true);
					//Hide pg 2
					miniBtn.setVisible(false);
					moloBtn.setVisible(false);
					morBtn.setVisible(false);
				}else if(curPage == 2){
					//Show
					miniBtn.setVisible(true);
					moloBtn.setVisible(true);
					morBtn.setVisible(true);
					//Hide pg 1 & 3
					cistBtn.setVisible(false);
					embalBtn.setVisible(false);
					furiBtn.setVisible(false);
					mystaBtn.setVisible(false);
					myzoBtn.setVisible(false);
					natBtn.setVisible(false);
				}else if(curPage == 3){
					//Show
					mystaBtn.setVisible(true);
					myzoBtn.setVisible(true);
					natBtn.setVisible(true);
					//Hide pg 2 & 4
					miniBtn.setVisible(false);
					moloBtn.setVisible(false);
					morBtn.setVisible(false);
					noctBtn.setVisible(false);
					nyctBtn.setVisible(false);
					phyBtn.setVisible(false);
				}else if(curPage == 4){
					//Show
					noctBtn.setVisible(true);
					nyctBtn.setVisible(true);
					phyBtn.setVisible(true);
					//Hide pg 3 & 5
					mystaBtn.setVisible(false);
					myzoBtn.setVisible(false);
					natBtn.setVisible(false);
					thyroBtn.setVisible(false);
					vesBtn.setVisible(false);
				}else if(curPage == 5){
					//Show
					thyroBtn.setVisible(true);
					vesBtn.setVisible(true);
					//Hide pg 4
					noctBtn.setVisible(false);
					nyctBtn.setVisible(false);
					phyBtn.setVisible(false);
				}else{
					System.out.println("ERR: current page index: buttons");
				}
			}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		lArrow.setVisible(false);
		f.add(lArrow);
		
		//Add second row of buttons
		infoButtons(infoBox);
	}

	//Sets up displayed info buttons on Suborder screen
	//Optimization: When different family is clicked, automatically
	//shows last selection of information for newly selected family,
	//rather than needing to be hit twice
	private void infoButtons(JTextArea infoBox){
		//Second row of buttons
		//Page 1
		//Location button: displays location data from selected file in text box
		JButton loBtn = new JButton("Location");
		loBtn.setSize(btnW/2, btnH*3/4);
		loBtn.setLocation(frameW/2 - loBtn.getWidth()*2, frameH/3);
		loBtn.setFont(loBtn.getFont().deriveFont(20.0F));
		loBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("location"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		loBtn.setVisible(true);
		f.add(loBtn);
		
		//Habitat button: displays habitat data from selected file in text box
		JButton haBtn = new JButton("Habitat");
		haBtn.setSize(loBtn.getWidth(), loBtn.getHeight());
		haBtn.setLocation(loBtn.getX() + loBtn.getWidth(), loBtn.getY());
		haBtn.setFont(haBtn.getFont().deriveFont(20.0F));
		haBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("habitat"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		haBtn.setVisible(true);
		f.add(haBtn);
		
		//Diet button: displays diet data from selected file in text box
		JButton diBtn = new JButton("Diet");
		diBtn.setSize(loBtn.getWidth(), loBtn.getHeight());
		diBtn.setLocation(haBtn.getX() + haBtn.getWidth(), loBtn.getY());
		diBtn.setFont(diBtn.getFont().deriveFont(20.0F));
		diBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("diet"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		diBtn.setVisible(true);
		f.add(diBtn);
		
		//Social Structure button: displays social structure data from selected file in text box
		JButton ssBtn = new JButton("Social Structure");	//Fix text size
		ssBtn.setSize(loBtn.getWidth(), loBtn.getHeight());
		ssBtn.setLocation(diBtn.getX() + diBtn.getWidth(), loBtn.getY());
		ssBtn.setFont(ssBtn.getFont().deriveFont(20.0F));
		ssBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("social"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		ssBtn.setVisible(true);
		f.add(ssBtn);
		
		//Page 2
		//Reproduction button: displays reproduction data from selected file in text box
		JButton reBtn = new JButton("Reproduction");
		reBtn.setSize(loBtn.getWidth(), loBtn.getHeight());
		reBtn.setLocation(loBtn.getX(), loBtn.getY());
		reBtn.setFont(loBtn.getFont());
		reBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("reproduction"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		reBtn.setVisible(false);
		f.add(reBtn);
		
		//Seasonal Behavior button: displays seasonal behavior data from selected file in text box
		JButton sbBtn = new JButton("Seasonal Behavior");	//Fix text size
		sbBtn.setSize(haBtn.getWidth(), haBtn.getHeight());
		sbBtn.setLocation(haBtn.getX(), haBtn.getY());
		sbBtn.setFont(haBtn.getFont());
		sbBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("seasonal"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		sbBtn.setVisible(false);
		f.add(sbBtn);
		
		//Lifespan button: displays lifespan data from selected file in text box
		JButton lsBtn = new JButton("Lifespan");
		lsBtn.setSize(diBtn.getWidth(), diBtn.getHeight());
		lsBtn.setLocation(diBtn.getX(), diBtn.getY());
		lsBtn.setFont(diBtn.getFont());
		lsBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("lifespan"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		lsBtn.setVisible(false);
		f.add(lsBtn);
		
		//Predators button: displays predators data from selected file in text box
		JButton prBtn = new JButton("Predators");
		prBtn.setSize(ssBtn.getWidth(), ssBtn.getHeight());
		prBtn.setLocation(ssBtn.getX(), ssBtn.getY());
		prBtn.setFont(ssBtn.getFont());
		prBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("predators"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		prBtn.setVisible(false);
		f.add(prBtn);
		
		//Page 3
		//Threats button: displays threats data from selected file in text box
		JButton thBtn = new JButton("Threats");
		thBtn.setSize(loBtn.getWidth(), loBtn.getHeight());
		thBtn.setLocation(loBtn.getX(), loBtn.getY());
		thBtn.setFont(loBtn.getFont());
		thBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("threats"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		thBtn.setVisible(false);
		f.add(thBtn);
		
		//Status button: displays status data from selected file in text box
		JButton stBtn = new JButton("Status");	//Fix text size
		stBtn.setSize(haBtn.getWidth(), haBtn.getHeight());
		stBtn.setLocation(haBtn.getX(), haBtn.getY());
		stBtn.setFont(haBtn.getFont());
		stBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("status"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		stBtn.setVisible(false);
		f.add(stBtn);
		
		//Genera button: displays genera data from selected file in text box
		JButton geBtn = new JButton("Genera");
		geBtn.setSize(diBtn.getWidth(), diBtn.getHeight());
		geBtn.setLocation(diBtn.getX(), diBtn.getY());
		geBtn.setFont(diBtn.getFont());
		geBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("genera"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		geBtn.setVisible(false);
		f.add(geBtn);
		
		//Appearance button: displays appearance data from selected file in text box
		JButton apBtn = new JButton("Appearance");
		apBtn.setSize(ssBtn.getWidth(), ssBtn.getHeight());
		apBtn.setLocation(ssBtn.getX(), ssBtn.getY());
		apBtn.setFont(ssBtn.getFont());
		apBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("appearance"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		apBtn.setVisible(false);
		f.add(apBtn);
		
		//Page 4
		//Size button: displays size data from selected file in text box
		JButton siBtn = new JButton("Size");
		siBtn.setSize(loBtn.getWidth(), loBtn.getHeight());
		siBtn.setLocation(loBtn.getX(), loBtn.getY());
		siBtn.setFont(loBtn.getFont());
		siBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("size"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		siBtn.setVisible(false);
		f.add(siBtn);
		
		//Echolocation button: displays echolocation data from selected file in text box
		JButton elBtn = new JButton("Echolocation");
		elBtn.setSize(haBtn.getWidth(), haBtn.getHeight());
		elBtn.setLocation(haBtn.getX(), haBtn.getY());
		elBtn.setFont(haBtn.getFont());
		elBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(
				currentFamily.getFamily() + " (" + currentFamily.getCommonName() + ")\n\n" + currentFamily.getData("echo"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		elBtn.setVisible(false);
		f.add(elBtn);
		
		
		//Creating forward and back arrows - bottom row
		//right arrow - seek
		JButton rArrowLower = new JButton(">");
		//left arrow - back
		JButton lArrowLower = new JButton("<");
		
		rArrowLower.setSize(loBtn.getWidth()/3, loBtn.getHeight());
		rArrowLower.setLocation(ssBtn.getX() + ssBtn.getWidth(), ssBtn.getY());
		rArrowLower.setFont(rArrowLower.getFont().deriveFont(10.0F));
		rArrowLower.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){
				//Increment page number
				curPageLower++;
				//Show/hide arrows based on page number
				if(curPageLower == 4){
					rArrowLower.setVisible(false);
					lArrowLower.setVisible(true);
				}else if(curPageLower > 1 && curPageLower < 4){
					rArrowLower.setVisible(true);
					lArrowLower.setVisible(true);
				}else if(curPageLower == 1){
					rArrowLower.setVisible(false);
					lArrowLower.setVisible(true);
				}else{
					System.out.println("ERR: current page index: arrows");
				}
				
				//Show/hide buttons based on page number
				if(curPageLower == 1){
					//Show
					loBtn.setVisible(true);
					haBtn.setVisible(true);
					diBtn.setVisible(true);
					ssBtn.setVisible(true);
					//Hide pg 2
					reBtn.setVisible(false);
					sbBtn.setVisible(false);
					lsBtn.setVisible(false);
					prBtn.setVisible(false);
				}else if(curPageLower == 2){
					//Show
					reBtn.setVisible(true);
					sbBtn.setVisible(true);
					lsBtn.setVisible(true);
					prBtn.setVisible(true);
					//Hide pg 1 & 3
					loBtn.setVisible(false);
					haBtn.setVisible(false);
					diBtn.setVisible(false);
					ssBtn.setVisible(false);
					thBtn.setVisible(false);
					stBtn.setVisible(false);
					geBtn.setVisible(false);
					apBtn.setVisible(false);
				}else if(curPageLower == 3){
					//Show
					thBtn.setVisible(true);
					stBtn.setVisible(true);
					geBtn.setVisible(true);
					apBtn.setVisible(true);
					//Hide pg 2 & 4
					reBtn.setVisible(false);
					sbBtn.setVisible(false);
					lsBtn.setVisible(false);
					prBtn.setVisible(false);
					siBtn.setVisible(false);
					elBtn.setVisible(false);
				}else if(curPageLower == 4){
					//Show
					siBtn.setVisible(true);
					elBtn.setVisible(true);
					//Hide pg 3
					thBtn.setVisible(false);
					stBtn.setVisible(false);
					geBtn.setVisible(false);
					apBtn.setVisible(false);
				}else{
					System.out.println("ERR: current page index: buttons");
				}
			}
			
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		rArrowLower.setVisible(true);
		f.add(rArrowLower);
		
		//left arrow - back
		//JButton lArrowLower = new JButton("<");
		lArrowLower.setSize(rArrowLower.getWidth(), rArrowLower.getHeight());
		lArrowLower.setLocation(loBtn.getX() - lArrowLower.getWidth(), loBtn.getY());
		lArrowLower.setFont(rArrowLower.getFont());
		lArrowLower.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){
				//Increment page number
				curPageLower--;
				
				//Show/hide arrows based on page number
				if(curPageLower == 4){
					rArrowLower.setVisible(false);
					lArrowLower.setVisible(true);
				}else if(curPageLower > 1 && curPageLower < 4){
					rArrowLower.setVisible(true);
					lArrowLower.setVisible(true);
				}else if(curPageLower == 1){
					rArrowLower.setVisible(true);
					lArrowLower.setVisible(false);
				}else{
					System.out.println("ERR: current page index: arrows");
				}
				
				//Show/hide buttons based on page number
				if(curPageLower == 1){
					//Show
					loBtn.setVisible(true);
					haBtn.setVisible(true);
					diBtn.setVisible(true);
					ssBtn.setVisible(true);
					//Hide pg 2
					reBtn.setVisible(false);
					sbBtn.setVisible(false);
					lsBtn.setVisible(false);
					prBtn.setVisible(false);
				}else if(curPageLower == 2){
					//Show
					reBtn.setVisible(true);
					sbBtn.setVisible(true);
					lsBtn.setVisible(true);
					prBtn.setVisible(true);
					//Hide pg 1 & 3
					loBtn.setVisible(false);
					haBtn.setVisible(false);
					diBtn.setVisible(false);
					ssBtn.setVisible(false);
					thBtn.setVisible(false);
					stBtn.setVisible(false);
					geBtn.setVisible(false);
					apBtn.setVisible(false);
				}else if(curPageLower == 3){
					//Show
					thBtn.setVisible(true);
					stBtn.setVisible(true);
					geBtn.setVisible(true);
					apBtn.setVisible(true);
					//Hide pg 2 & 4
					reBtn.setVisible(false);
					sbBtn.setVisible(false);
					lsBtn.setVisible(false);
					prBtn.setVisible(false);
					siBtn.setVisible(false);
					elBtn.setVisible(false);
				}else if(curPageLower == 4){
					//Show
					siBtn.setVisible(true);
					elBtn.setVisible(true);
					//Hide pg 3
					thBtn.setVisible(false);
					stBtn.setVisible(false);
					geBtn.setVisible(false);
					apBtn.setVisible(false);
				}else{
					System.out.println("ERR: current page index: buttons");
				}
			}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		lArrowLower.setVisible(false);
		f.add(lArrowLower);
		
	}

}