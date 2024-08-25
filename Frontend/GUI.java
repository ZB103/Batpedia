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
	protected Family emballonuridae = new Family("Emballonuridae", "Sac-Winged & Sheath-Tailed Bats", ya);
	protected Family furipteridae = new Family("Furipteridae", "Smoky Bat & Thumbless Bat", ya);
	protected Family miniopteridae = new Family("Miniopteridae", "Bent/Long-Winged Bats", ya);
	protected Family molossidae = new Family("Molossidae", "Free-Tailed Bats", ya);
	protected Family mormoopidae = new Family("Mormoopidae", "Mustached & Ghost-Faced & Naked-Backed Bats", ya);
	protected Family mystacinidae = new Family("Mystacinidae", "New Zealand Short-Tailed Bats", ya);
	protected Family myzopodidae = new Family("Myzopodidae", "Sucker-Footed Bats", ya);
	protected Family natalidae = new Family("Natalidae", "Funnel-Eared Bats", ya);
	protected Family noctilionidae = new Family("Noctilionidae", "Bulldog Bats", ya);
	protected Family phyllostomidae = new Family("Phyllostomidae", "Leaf-Nosed Bats", ya);
	protected Family thyropteridae = new Family("Thyropteridae", "Disk-Winged Bats", ya);
	protected Family vespertillionidae = new Family("Vespertillionidae", "Evening Bats", ya);
	//Yin
	String yi = "Yinpterochiroptera";
	protected Family craseonycteridae = new Family("Craseonycteridae", "Kitti's Hog-Nosed/Bumblebee Bat", yi);
	protected Family hipposideridae = new Family("Hipposideridae", "Old World Leaf-Nosed Bats", yi);
	protected Family megadermatidae = new Family("Megadermatidae", "False Vampire Bats", yi);
	protected Family pteropodidae = new Family("Pteropodidae", "Megabats", yi);
	protected Family rhinolophidae = new Family("Rhinolophidae", "Horseshoe Bats", yi);
	protected Family rhinopomatidae = new Family("Rhinopomatidae", "Mouse-Tailed Bats", yi);
    
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
		//settingsScreen();
		//crScreen();
		orderScreen();
		//Make frame visible
		f.setVisible(true);
    }
	
	//Reset frame
	private void fClear(){
		f.getContentPane().removeAll();
		f.repaint();
		SwingUtilities.updateComponentTreeUI(f);
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
		yaBtn.setLocation(frameW*2/3 - yaBtn.getWidth()/2, frameH*2/12);
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
		//Selecting suborder
		// Suborder suborder;
		// if(suborderString.equalsIgnoreCase("yinpterochiroptera")){suborder = yinpterochiroptera;}
		// else if(suborderString.equalsIgnoreCase("yangochiroptera")){suborder = yangochiroptera;}
		// else{System.out.println("ERR: SELECT SUBORDER");}
		
		//Creating title text
		JLabel title = new JLabel("Suborder " + suborderString);
		title.setFont(title.getFont().deriveFont(35.0F));
		title.setSize(500, 150);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setLocation(frameW/2 - title.getWidth()/2, frameH/12 - title.getHeight()/2);
		f.add(title);
		
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
		
		//Creating family buttons
		//Yin families
		//Page 1
		//Craseonycteridae
		JButton craseoBtn = new JButton("Craseonycteridae");
		craseoBtn.setSize(btnW*2/3, btnH);
		craseoBtn.setLocation(frameW/2 - craseoBtn.getWidth()*3/2, frameH/3);
		craseoBtn.setFont(craseoBtn.getFont().deriveFont(20.0F));
		craseoBtn.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e){try{infoBox.setText(chiroptera.getData("order"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){try{infoBox.setText(chiroptera.getData("order"));}catch(IOException f){}}
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
			public void mouseReleased(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
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
			public void mouseReleased(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
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
			public void mouseReleased(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
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
			public void mouseReleased(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
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
			public void mouseReleased(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
			public void mouseClicked(MouseEvent e){try{infoBox.setText(chiroptera.getData("frequency"));}catch(IOException f){}}
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		rhinopoBtn.setVisible(false);
		f.add(rhinopoBtn);
		
		//Using helper functions to make certain family buttons visible
		//Batch 1 default when screen opened
		// if(suborderString.equalsIgnoreCase("yinpterochiroptera")){yinFamilies1();}
		// else{yangoFamilies1();}
		
		//Creating horizontal line
		JSeparator line = new JSeparator(SwingConstants.HORIZONTAL);
		line.setSize(frameW*7/8, 50);
		line.setLocation(frameW/2 - line.getWidth()/2,frameH*4/12 - line.getHeight()/2);
		f.add(line);
		
		//Creating forward and back arrows - top row
		//right arrow - seek
		JButton rArrow = new JButton(">");
			//left arrow - back
			JButton lArrow = new JButton("<");
		rArrow.setSize(lArrow.getWidth(), lArrow.getHeight());
		rArrow.setLocation(megaBtn.getX() + rArrow.getWidth(), megaBtn.getY());
		rArrow.setFont(lArrow.getFont());
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
			
			public void mouseClicked(MouseEvent e){}		//Change so also works for Yango
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		rArrow.setVisible(true);
		f.add(rArrow);
		
		//left arrow - back
		//JButton lArrow = new JButton("<");
		lArrow.setSize(craseoBtn.getWidth()/3, craseoBtn.getHeight());
		lArrow.setLocation(craseoBtn.getX() - lArrow.getWidth(), craseoBtn.getY());
		lArrow.setFont(lArrow.getFont().deriveFont(10.0F));
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
			
			public void mouseClicked(MouseEvent e){}		//Change so also works for Yango
			public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		lArrow.setVisible(true);
		f.add(lArrow);
		
		//Creating info buttons
		//Future optimization: button creation loop
		// String currentLabel = Chiroptera.getData("order");
		// int btnX = 50;
		// while(currentLabel != "*ENDDOC"){
			// JButton button = new JButton();
		// }
		
		//Order button: sets text box alignment to left
		//and displays order data from file Chiroptera
		// JButton btn1 = new JButton("Order");
		// btn1.setSize(yiBtn.getWidth()*3/4, yiBtn.getHeight()*3/4);
		// btn1.setLocation(frameW/2 - btn1.getWidth()*3/2, frameH/3);
		// btn1.setFont(btn1.getFont().deriveFont(20.0F));
		// btn1.addMouseListener(new MouseListener(){
			// public void mouseReleased(MouseEvent e){try{infoBox.setText(Chiroptera.getData("order"));}catch(IOException f){}}
			// public void mouseClicked(MouseEvent e){try{infoBox.setText(Chiroptera.getData("order"));}catch(IOException f){}}
			// public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			// public void mouseExited(MouseEvent e){}
			// public void mousePressed(MouseEvent e){}
		// });
		// f.add(btn1);
		
		// //Frequency button: sets text box alignment to center
		// //and displays frequency data from file Chiroptera
		// JButton btn2 = new JButton("Frequency");
		// btn2.setSize(btn1.getWidth(), btn1.getHeight());
		// btn2.setLocation(btn1.getX() + btn1.getWidth(), btn1.getY());
		// btn2.setFont(btn2.getFont().deriveFont(20.0F));
		// btn2.addMouseListener(new MouseListener(){
			// public void mouseReleased(MouseEvent e){try{infoBox.setText(Chiroptera.getData("frequency"));}catch(IOException f){}}
			// public void mouseClicked(MouseEvent e){try{infoBox.setText(Chiroptera.getData("frequency"));}catch(IOException f){}}
			// public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			// public void mouseExited(MouseEvent e){}
			// public void mousePressed(MouseEvent e){}
		// });
		// f.add(btn2);
		
		// //Diversity button: sets text box alignment to right
		// //and displays diversity data from file Chiroptera
		// JButton btn3 = new JButton("Diversity");
		// btn3.setSize(btn1.getWidth(), btn1.getHeight());
		// btn3.setLocation(btn2.getX() + btn2.getWidth(), btn1.getY());
		// btn3.setFont(btn3.getFont().deriveFont(20.0F));
		// btn3.addMouseListener(new MouseListener(){
			// public void mouseReleased(MouseEvent e){
				// try{infoBox.setText(Chiroptera.getData("diversity"));}catch(IOException f){}
				// infoBox.setAlignmentY(SwingConstants.RIGHT);
				// }
			// public void mouseClicked(MouseEvent e){
				// try{infoBox.setText(Chiroptera.getData("diversity"));}catch(IOException f){}
				// infoBox.setAlignmentY(SwingConstants.RIGHT);
				// }
			// public void mouseEntered(MouseEvent e){/*Cursor.setCursor(Cursor.HAND_CURSOR);*/}
			// public void mouseExited(MouseEvent e){}
			// public void mousePressed(MouseEvent e){}
		// });
		// f.add(btn3);
		
		//Add home and back buttons
		addBackButtons("suborder");
	}

	//Helper function that creates buttons in 1st row
	//on suborder screen for yin (group 1)
	// private void yinFamilies1(){
		// //Making arrow button visible - right goes to second screen
		// rArrow.setVisible(true);
		// lArrow.setVisible(false);
		// //Making options buttons visible
		// craseoBtn.setVisible(true);
		// hippoBtn.setVisible(true);
		// megaBtn.setVisible(true);
		// //Making other buttons invisible
		// pteroBtn.setVisible(false);
		// rhinoloBtn.setVisible(false);
		// rhinopoBtn.setVisible(false);
	// }
	
	//Helper function that creates buttons in 1st row
	//on suborder screen for yin (group 2)
	// private void yinFamilies2(){
		// //Making arrow button visible - right goes to second screen
		// rArrow.setVisible(false);
		// lArrow.setVisible(true);
		// //Making other buttons visible
		// pteroBtn.setVisible(true);
		// rhinoloBtn.setVisible(true);
		// rhinopoBtn.setVisible(true);
		// //Making options buttons invisible
		// craseoBtn.setVisible(false);
		// hippoBtn.setVisible(false);
		// megaBtn.setVisible(false);
	// }
	
	//Helper function that creates buttons in 1st row
	//on suborder screen for yango (group 1)
	// private void yangoFamilies1(){
		
	// }
}