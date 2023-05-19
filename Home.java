import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import java.awt.EventQueue;
import java.awt.Image;

public class Home extends JFrame implements ActionListener{
	
	private Initial initial;
	private JPanel coinPanel, profilePanel;
	private static String user;
	private int balance, totalBalance;
	private String email,gender,pass,saved,dpPath,tempBalance;
	private JLabel dp;
	
	private EmailValidator emailValidator = new EmailValidator();
	
	public Home(Initial initial, String user) {

		
		this.initial = initial;
		this.user = user;
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ToolTipManager.sharedInstance().setInitialDelay(1000);
        ToolTipManager.sharedInstance().setDismissDelay(2000);
		
		
		//------ bg creation for the home page after login -------
		
		ImageIcon icon = new ImageIcon("image/icon-01.png");
		setIconImage(icon.getImage());
		
		setSize(1280,720);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		// Calculate top-left corner of the frame
		int x = (screenWidth - 1280) / 2;
		int y = (screenHeight - 720) / 2;
		
		setLocation(x,y);
		
		setTitle("Hey, " + user + ". Welcome home!");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		ImageIcon bgImg = new ImageIcon("image/home-01.jpg");
		Image img = bgImg.getImage();
		img = img.getScaledInstance(1280,720, Image.SCALE_SMOOTH);
		bgImg = new ImageIcon(img);
		JLabel homeBg = new JLabel(bgImg);
		homeBg.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(homeBg);
		homeBg.setVisible(true);

		//--------- gif setting --------
		

		JPanel tvPanel = new JPanel();
		tvPanel.setBounds(730,195,450,335);
		tvPanel.setOpaque(false);
		tvPanel.setLayout(new OverlayLayout(tvPanel));
		
		JLabel gifLabel = new JLabel();
        Icon gifIcon = new ImageIcon("image/bg.gif");
		gifLabel.setIcon(gifIcon);
		gifLabel.setBounds(790,255,328,184);
		gifLabel.setPreferredSize(new Dimension(328,184));
		tvPanel.add(gifLabel);

		ImageIcon tvIcon = new ImageIcon("image/tv.png");
		Image tvImg = tvIcon.getImage();
		tvImg = tvImg.getScaledInstance(450,335, Image.SCALE_SMOOTH);
		tvIcon = new ImageIcon(tvImg);
		JLabel tvBg = new JLabel(tvIcon);
		tvBg.setBounds(0,0,450,335);
		tvPanel.add(tvBg);
		
		tvPanel.setComponentZOrder(gifLabel, 1);
        tvPanel.setComponentZOrder(tvBg, 0);
		
		homeBg.add(tvPanel);


		// ----------bg image 2 setup------

		ImageIcon bg2Img = new ImageIcon("image/content-01.jpg");
		Image bg2 = bg2Img.getImage();
		bg2 = bg2.getScaledInstance(1280,1440, Image.SCALE_SMOOTH);
		bg2Img = new ImageIcon(bg2);
		JLabel homeBg2 = new JLabel(bg2Img);
		homeBg2.setAlignmentX(Component.CENTER_ALIGNMENT);

		// create the JScrollPane and set its viewport view to the panel
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(0, 0, 1280,720);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.getVerticalScrollBar().setOpaque(false);
		add(scrollPane);
		
		
		//------ bg creation for the movies page after login -------
		
		JPanel moviePanel = new JPanel();
		moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));
		ImageIcon movieImg = new ImageIcon("image/content-02.jpg");
		Image movieBg = movieImg.getImage();
		movieBg = movieBg.getScaledInstance(1280,1440, Image.SCALE_SMOOTH);
		movieImg = new ImageIcon(movieBg);
		JLabel homeMovieBg = new JLabel(movieImg);
		homeMovieBg.setAlignmentX(Component.CENTER_ALIGNMENT);
		moviePanel.setVisible(false);

		JScrollPane scrollPane2 = new JScrollPane(moviePanel);
		scrollPane2.setBounds(0, 0, 1280,720);
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane2.getVerticalScrollBar().setOpaque(false);
		add(scrollPane2);
		scrollPane2.setVisible(false);
		
		//------ bg creation for the web series page after login -------
		
		JPanel webPanel = new JPanel();
		webPanel.setLayout(new BoxLayout(webPanel, BoxLayout.Y_AXIS));
		ImageIcon webImg = new ImageIcon("image/content-03.jpg");
		Image webBg = webImg.getImage();
		webBg = webBg.getScaledInstance(1280,1440, Image.SCALE_SMOOTH);
		webImg = new ImageIcon(webBg);
		JLabel homeWebBg = new JLabel(webImg);
		homeWebBg.setAlignmentX(Component.CENTER_ALIGNMENT);
		webPanel.setVisible(false);

		JScrollPane scrollPane3 = new JScrollPane(webPanel);
		scrollPane3.setBounds(0, 0, 1280,720);
		scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane3.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane3.getVerticalScrollBar().setOpaque(false);
		add(scrollPane3);
		scrollPane3.setVisible(false);
		
		//------ bg creation for the my favourite page after login -------
		
		JPanel myFavPanel = new JPanel();
		myFavPanel.setLayout(new BoxLayout(myFavPanel, BoxLayout.Y_AXIS));
		ImageIcon myFavImg = new ImageIcon("image/content-04.jpg");
		Image myFavBg = myFavImg.getImage();
		myFavBg = myFavBg.getScaledInstance(1280,1440, Image.SCALE_SMOOTH);
		myFavImg = new ImageIcon(myFavBg);
		JLabel homeMyFavBg = new JLabel(myFavImg);
		homeMyFavBg.setAlignmentX(Component.CENTER_ALIGNMENT);
		myFavPanel.setVisible(false);

		JScrollPane scrollPane4 = new JScrollPane(myFavPanel);
		scrollPane4.setBounds(0, 0, 1280,720);
		scrollPane4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane4.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane4.getVerticalScrollBar().setOpaque(false);
		add(scrollPane4);
		scrollPane4.setVisible(false);
		
		//------ bg creation for the search page after login -------
		
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
		ImageIcon searchImg = new ImageIcon("image/search-01.jpg");
		Image searchBg = searchImg.getImage();
		searchBg = searchBg.getScaledInstance(1280,720, Image.SCALE_SMOOTH);
		searchImg = new ImageIcon(searchBg);
		JLabel homeSearchBg = new JLabel(searchImg);
		homeSearchBg.setAlignmentX(Component.CENTER_ALIGNMENT);
		searchPanel.setVisible(false);
		
		JScrollPane scrollPane5 = new JScrollPane(searchPanel);
		scrollPane5.setBounds(0, 0, 1280,720);
		scrollPane5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane5.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane5.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane5.getVerticalScrollBar().setOpaque(false);
		add(scrollPane5);
		scrollPane5.setVisible(false);
		
		// -----balance calculation------
		
		balance=0;
		
		if(user != null){
			try(BufferedReader br = new BufferedReader(new FileReader("Profile/" + user + ".csv"))){
				
				String line;
				
				while((line = br.readLine()) != null){
					String[]userData = line.split(",");
					
					email = userData[1];
					gender = userData[2];
					pass = userData[3];
					saved = userData[4];
					balance = Integer.parseInt(userData[5]);
					dpPath = userData[6];
					totalBalance = balance;
					tempBalance = Integer.toString(totalBalance);
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}		
		
		//----reload button------
		
		JButton reload = new JButton();
		reload.setBounds(40,40,130,40);
		reload.setContentAreaFilled(false);
		reload.setBorderPainted(false);
		reload.setFocusable(false);
		reload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeBg.add(reload);
		
		//-------home button--------
		
		JButton homeBtn = new JButton();
		homeBtn.setBounds(205,50,55,25);
		homeBtn.setContentAreaFilled(false);
		homeBtn.setBorderPainted(false);
		homeBtn.setFocusable(false);
		homeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeBg.add(homeBtn);

		//------- movie button --------
		
		JButton movieBtn = new JButton();
		movieBtn.setBounds(275,50,70,25);
		movieBtn.setContentAreaFilled(false);
		movieBtn.setBorderPainted(false);
		movieBtn.setFocusable(false);
		movieBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeBg.add(movieBtn);

		//------- webseries button --------
		
		JButton webBtn = new JButton();
		webBtn.setBounds(360,50,100,25);
		webBtn.setContentAreaFilled(false);
		webBtn.setBorderPainted(false);
		webBtn.setFocusable(false);
		webBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeBg.add(webBtn);

		//------- my favourite button --------
		
		JButton favBtn = new JButton();
		favBtn.setBounds(473,50,72,25);
		favBtn.setContentAreaFilled(false);
		favBtn.setBorderPainted(false);
		favBtn.setFocusable(false);
		favBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeBg.add(favBtn);

		//------- search bar --------
		
		JTextField dodge = new JTextField();
		dodge.setBounds(0,0,1,1);
		homeBg.add(dodge);

		JTextField searchBar = new JTextField("  s e a r c h   h e r e. . .");
		searchBar.setBounds(620,47,320,33);
		searchBar.setOpaque(false);
		searchBar.setFont(new Font("Helvetica", Font.PLAIN, 15));
		searchBar.setBorder(BorderFactory.createEmptyBorder());
		searchBar.setForeground(Color.decode("#898c90"));
		homeBg.add(searchBar);

		searchBar.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (searchBar.getText().equals("  s e a r c h   h e r e. . .")) {
					searchBar.setText("");
					searchBar.setForeground(Color.BLACK);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if (searchBar.getText().equals("")) {
					searchBar.setText("  s e a r c h   h e r e. . .");
					searchBar.setForeground(Color.decode("#898c90"));
				}
			}
		});
		
		//------- search button --------
		
		JButton searchBtn = new JButton();
		searchBtn.setBounds(940,47,50,33);
		searchBtn.setContentAreaFilled(false);
		searchBtn.setBorderPainted(false);
		searchBtn.setFocusable(false);
		searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeBg.add(searchBtn);

		// ------coin purchasing process start-------
		
		JButton coinBtn = new JButton();
		coinBtn.setBounds(1018,47,30,30);
		coinBtn.setOpaque(false);
		coinBtn.setContentAreaFilled(false);
		coinBtn.setBorderPainted(false);
		coinBtn.setFocusable(false);
		coinBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeBg.add(coinBtn);

		
		ImageIcon coinBg = new ImageIcon("image/coin-01.png");
        Image coinimg = coinBg.getImage();
        coinimg = coinimg.getScaledInstance(680, 420, Image.SCALE_SMOOTH);
        coinBg = new ImageIcon(coinimg);
        JLabel addCoinBg = new JLabel(coinBg);
		addCoinBg.setBounds(300, 150, 680, 420);
        addCoinBg.setBounds(0, 0, getWidth(), getHeight());
        
		homeBg.add(addCoinBg);
		homeBg.setComponentZOrder(addCoinBg,0);
		addCoinBg.setVisible(false);
		
		
		coinPanel = new JPanel();
		coinPanel.setBounds(300, 150, 680, 420);
		coinPanel.setOpaque(false);
		coinPanel.setLayout(null);
		
		JLabel coinText = new JLabel("Welcome To Flix Store");
		coinText.setBounds(170,20,400,50);
		coinText.setForeground(Color.decode("#00003b"));
		coinText.setFont(new Font("Roboto", Font.BOLD, 35));
		coinPanel.add(coinText);
		
		JLabel currentBalance = new JLabel("Current Balance: " + balance);
		currentBalance.setBounds(220,90,280,35);
		currentBalance.setForeground(Color.BLACK);
		currentBalance.setFont(new Font("Roboto", Font.BOLD, 23));
		coinPanel.add(currentBalance);
		
		JLabel addText = new JLabel("Need more coins? Add from here...");
		addText.setBounds(145,130,400,35);
		addText.setForeground(Color.BLACK);
		addText.setFont(new Font("Roboto", Font.BOLD, 23));
		coinPanel.add(addText);

		//-------minus button------
		
		JButton minus = new JButton();
		ImageIcon min = new ImageIcon("image/minus.png");
		Image minIcon = min.getImage();
		minIcon = minIcon.getScaledInstance(20,18,Image.SCALE_SMOOTH);
		min = new ImageIcon(minIcon);
		minus.setIcon(min);
		minus.setBounds(190,200,70,30);
		minus.setFont(new Font("Roboto", Font.BOLD, 30));
		minus.setFocusable(false);
		minus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		coinPanel.add(minus);
		
		//------balance text area------
		
		
		JTextField balanceText = new JTextField("20");
		balanceText.setBounds(265,200,120,30);
		balanceText.setFont(new Font("Roboto", Font.BOLD, 15));
		balanceText.setEditable(false);
		Insets insets = new Insets(7, 7, 7, 7);
        balanceText.setMargin(insets);
		coinPanel.add(balanceText);
		
		//-----plus button-----
		
		JButton plus = new JButton();
		ImageIcon pl = new ImageIcon("image/plus.png");
		Image plIcon = pl.getImage();
		plIcon = plIcon.getScaledInstance(20,18,Image.SCALE_SMOOTH);
		pl = new ImageIcon(plIcon);
		plus.setIcon(pl);
		plus.setBounds(390,200,70,30);
		plus.setFocusable(false);
		plus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		coinPanel.add(plus);
		
		JButton addCoin = new JButton("Add Coin");
		addCoin.setBounds(190, 250, 270, 40);
		addCoin.setFocusable(false);
		addCoin.setFont(new Font("Roboto", Font.BOLD, 17));
		addCoin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		coinPanel.add(addCoin);
		
		addCoinBg.add(coinPanel);

		
		
		// ------profile panel process start-------
		
		JButton profileBtn = new JButton();
		profileBtn.setBounds(1069,47,30,30);
		profileBtn.setOpaque(false);
		profileBtn.setContentAreaFilled(false);
		profileBtn.setBorderPainted(false);
		profileBtn.setFocusable(false);
		profileBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeBg.add(profileBtn);


		ImageIcon profileBg = new ImageIcon("image/profile-01.png");
        Image profileimg = profileBg.getImage();
        profileimg = profileimg.getScaledInstance(680, 420, Image.SCALE_SMOOTH);
        profileBg = new ImageIcon(profileimg);
        JLabel addProfileBg = new JLabel(profileBg);
		addProfileBg.setBounds(300, 150, 680, 420);
        addProfileBg.setBounds(0, 0, getWidth(), getHeight());
        homeBg.add(addProfileBg);
		homeBg.setComponentZOrder(addProfileBg,0);
		addProfileBg.setVisible(false);
				
		profilePanel = new JPanel();
		profilePanel.setBounds(300, 150, 680, 420);
		profilePanel.setLayout(null);
		profilePanel.setOpaque(false);
		
		JButton uploadImg = new JButton();
		uploadImg.setBounds(160,174,130,25);
		uploadImg.setOpaque(false);
		uploadImg.setContentAreaFilled(false);
		uploadImg.setBorderPainted(false);
		uploadImg.setFocusable(false);
		uploadImg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profilePanel.add(uploadImg);
		
		ImageIcon dpPic = new ImageIcon(dpPath);
		Image dpImg = dpPic.getImage();
		dpImg = dpImg.getScaledInstance(120,120,Image.SCALE_SMOOTH);
		dpPic = new ImageIcon(dpImg);
		dp = new JLabel(dpPic);
		dp.setBounds(165,45,120,120);
		dp.setLayout(null);
		profilePanel.add(dp);
		
		
		JLabel accName = new JLabel(user);
		accName.setFont(new Font("Helvetica", Font.BOLD, 40));
		accName.setForeground(Color.WHITE);
		accName.setBounds(330,65,380,60);
		profilePanel.add(accName);
		
		JLabel accEmail = new JLabel(email);
		accEmail.setFont(new Font("Helvetica", Font.BOLD, 18));
		accEmail.setForeground(Color.decode("#4E4F50"));
		accEmail.setBounds(330,115,380,30);
		profilePanel.add(accEmail);
		
		String profileBalance = Integer.toString(totalBalance);
		
		JLabel accBalance = new JLabel(profileBalance);
		accBalance.setFont(new Font("Helvetica", Font.BOLD, 22));
		accBalance.setForeground(Color.BLACK);
		accBalance.setBounds(115,295,60,25);
		profilePanel.add(accBalance);
		
		JButton greenAdd = new JButton();
		greenAdd.setBounds(195,300,40,20);
		greenAdd.setContentAreaFilled(false);
		greenAdd.setBorderPainted(false);
		greenAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profilePanel.add(greenAdd);
		
		JLabel transHistory = new JLabel("no recent transaction");
		transHistory.setFont(new Font("Helvetica", Font.BOLD, 15));
		transHistory.setForeground(Color.decode("#a09f9f"));
		transHistory.setBounds(84,360,180,25);
		profilePanel.add(transHistory);
		
		// ------profile panel process end-------
		
		
		
		//-----profile all settings----
		
		JButton passChange = new JButton();
		passChange.setBounds(431,288,147,26);
		passChange.setContentAreaFilled(false);
		passChange.setBorderPainted(false);
		passChange.setFocusable(false);
		passChange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profilePanel.add(passChange);
		
		JButton mailChange = new JButton();
		mailChange.setBounds(431,328,147,26);
		mailChange.setContentAreaFilled(false);
		mailChange.setBorderPainted(false);
		mailChange.setFocusable(false);
		mailChange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profilePanel.add(mailChange);
		
		JButton deleteAcc = new JButton();
		deleteAcc.setBounds(431,368,147,26);
		deleteAcc.setContentAreaFilled(false);
		deleteAcc.setBorderPainted(false);
		deleteAcc.setFocusable(false);
		deleteAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profilePanel.add(deleteAcc);
		
		addProfileBg.add(profilePanel);
		
		//sign out button
		
		JButton signOut = new JButton("Sign Out");
		signOut.setOpaque(false);
		signOut.setBounds(1119,47,96,30);
		signOut.setContentAreaFilled(false);
		signOut.setForeground(Color.WHITE);
		signOut.setBorderPainted(false);
		signOut.setFocusable(false);
		signOut.setFont(new Font("Netflix sans", Font.BOLD, 15));
		signOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeBg.add(signOut);

		//---------close button--------
		
		JButton close = new JButton();
		
		ImageIcon cross = new ImageIcon("image/cross.png");
		Image crossIcon = cross.getImage();
		crossIcon = crossIcon.getScaledInstance(20,18,Image.SCALE_SMOOTH);
		cross = new ImageIcon(crossIcon);
		close.setIcon(cross);
		
		close.setBounds(640, 20, 20, 18);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.setFocusable(false);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		
		//-----------------*******-------------------
		//------**** BackEnd Code for all Buttons ****---------
		//-----------------*******-------------------
		
		
		//------- home button -------
		
		homeBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.setVisible(true);
				moviePanel.setVisible(false);
				webPanel.setVisible(false);
				myFavPanel.setVisible(false);
				searchPanel.setVisible(false);

				if(addCoinBg.isVisible()){
					addCoinBg.setVisible(false);
				}
				if(addProfileBg.isVisible()){
					addProfileBg.setVisible(false);
				}

				scrollPane.setVisible(true);
				scrollPane2.setVisible(false);
				scrollPane3.setVisible(false);
				scrollPane4.setVisible(false);
				scrollPane5.setVisible(false);
				
				homeBg.add(reload);
				homeBg.add(homeBtn);
				homeBg.add(movieBtn);
				homeBg.add(webBtn);
				homeBg.add(favBtn);
				homeBg.add(dodge);
				homeBg.add(searchBar);
				homeBg.add(searchBtn);
				homeBg.add(coinBtn);
				homeBg.add(addCoinBg);
				homeBg.setComponentZOrder(addCoinBg,0);
				homeBg.add(profileBtn);
				homeBg.add(addProfileBg);
				homeBg.setComponentZOrder(addProfileBg,0);
				homeBg.add(signOut);	
				
				setTitle("Netflix- Home");
			}
		});
		
		//---------movie button--------
		
		movieBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.setVisible(false);
				moviePanel.setVisible(true);
				webPanel.setVisible(false);
				myFavPanel.setVisible(false);
				searchPanel.setVisible(false);
				
				if(addCoinBg.isVisible()){
					addCoinBg.setVisible(false);
				}
				if(addProfileBg.isVisible()){
					addProfileBg.setVisible(false);
				}

				scrollPane.setVisible(false);
				scrollPane2.setVisible(true);
				scrollPane3.setVisible(false);
				scrollPane4.setVisible(false);
				scrollPane5.setVisible(false);
				
				homeMovieBg.add(reload);
				homeMovieBg.add(homeBtn);
				homeMovieBg.add(movieBtn);
				homeMovieBg.add(webBtn);
				homeMovieBg.add(favBtn);
				homeMovieBg.add(dodge);
				homeMovieBg.add(searchBar);
				homeMovieBg.add(searchBtn);
				homeMovieBg.add(coinBtn);
				homeMovieBg.add(addCoinBg);
				homeMovieBg.setComponentZOrder(addCoinBg,0);
				homeMovieBg.add(profileBtn);
				homeMovieBg.add(addProfileBg);
				homeMovieBg.setComponentZOrder(addProfileBg,0);
				homeMovieBg.add(signOut);	

				setTitle("Netflix- Movies");
			}
		});
		
		//-------web series button--------
		
		webBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.setVisible(false);
				moviePanel.setVisible(false);
				webPanel.setVisible(true);
				myFavPanel.setVisible(false);
				searchPanel.setVisible(false);

				if(addCoinBg.isVisible()){
					addCoinBg.setVisible(false);
				}
				if(addProfileBg.isVisible()){
					addProfileBg.setVisible(false);
				}

				scrollPane.setVisible(false);
				scrollPane2.setVisible(false);
				scrollPane3.setVisible(true);
				scrollPane4.setVisible(false);
				scrollPane5.setVisible(false);
				
				homeWebBg.add(reload);
				homeWebBg.add(homeBtn);
				homeWebBg.add(movieBtn);
				homeWebBg.add(webBtn);
				homeWebBg.add(favBtn);
				homeWebBg.add(dodge);
				homeWebBg.add(searchBar);
				homeWebBg.add(searchBtn);
				homeWebBg.add(profileBtn);
				homeWebBg.add(addProfileBg);
				homeWebBg.setComponentZOrder(addProfileBg,0);
				homeWebBg.add(coinBtn);
				homeWebBg.add(addCoinBg);
				homeWebBg.setComponentZOrder(addCoinBg,0);
				homeWebBg.add(signOut);		
				
				setTitle("Netflix- Web Series");
			}
		});
		
		//-------favourite button--------
		
		favBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.setVisible(false);
				moviePanel.setVisible(false);
				webPanel.setVisible(false);
				myFavPanel.setVisible(true);
				searchPanel.setVisible(false);

				if(addCoinBg.isVisible()){
					addCoinBg.setVisible(false);
				}
				if(addProfileBg.isVisible()){
					addProfileBg.setVisible(false);
				}

				scrollPane.setVisible(false);
				scrollPane2.setVisible(false);
				scrollPane3.setVisible(false);
				scrollPane4.setVisible(true);
				scrollPane5.setVisible(false);
				
				homeMyFavBg.add(reload);
				homeMyFavBg.add(homeBtn);
				homeMyFavBg.add(movieBtn);
				homeMyFavBg.add(webBtn);
				homeMyFavBg.add(favBtn);
				homeMyFavBg.add(dodge);
				homeMyFavBg.add(searchBar);
				homeMyFavBg.add(searchBtn);
				homeMyFavBg.add(coinBtn);
				homeMyFavBg.add(addCoinBg);
				homeMyFavBg.setComponentZOrder(addCoinBg,0);
				homeMyFavBg.add(profileBtn);
				homeMyFavBg.add(addProfileBg);
				homeMyFavBg.setComponentZOrder(addProfileBg,0);
				homeMyFavBg.add(signOut);				

				setTitle("Netflix- My Favourite");
			}
		});

		
		//-------reload button on logo-------
		
		reload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Home newHome = new Home(initial,user);
				newHome.setVisible(true);
				dispose();
			}
		});
		
		
		//-----coin adding button-------
		
		coinBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				
				if(addProfileBg.isVisible()){
					JOptionPane.showMessageDialog(null,"Please close the previous panel", "Close", JOptionPane.WARNING_MESSAGE);
				}else{
					addCoinBg.setVisible(true);					
					coinPanel.add(close);				
					
					close.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){	
							addCoinBg.setVisible(false);
						}
					});
				}
			}
		});
		profileBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if(addCoinBg.isVisible()){
					JOptionPane.showMessageDialog(null,"Please close the previous panel", "Close", JOptionPane.WARNING_MESSAGE);
				}else{
					
					addProfileBg.setVisible(true);
					//homeBg.setComponentZOrder(addProfileBg,0);
					setTitle("Netflix- Profile/" + user);
					profilePanel.add(close);
					
					close.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){	
							addProfileBg.setVisible(false);
							setTitle("Netflix- Unlimited Streaming Platform");
						}
					});
				}

			}
			
		});
		
		greenAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addProfileBg.setVisible(false);
				addCoinBg.setVisible(true);
				coinPanel.add(close);
				
				close.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){	
						addCoinBg.setVisible(false);
					}
				});
			}
		});
		
		//------Coin purchasing process start-------
		
		plus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				String presentText = balanceText.getText();  
				balance = Integer.parseInt(presentText);
				
				if(balance<=980){
					plus.setEnabled(true);
					balance += 20;
					String tempBalance = Integer.toString(balance);
					balanceText.setText(tempBalance);
				}
				if(balance>980){
					JOptionPane.showMessageDialog(null,"Buying maximum amount. Are you sure?",
												"Reminder!",
												JOptionPane.WARNING_MESSAGE);
					plus.setEnabled(false);
				}
				if(balance>0){
					minus.setEnabled(true);
				}
			}
		});
		minus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				String presentText = balanceText.getText();  
				balance = Integer.parseInt(presentText);
				
				if(balance>=20){
					minus.setEnabled(true);
					balance -= 20;
					String tempBalance = Integer.toString(balance);
					balanceText.setText(tempBalance);
				}
				if(balance<20){
					minus.setEnabled(false);
				}
				if(balance<1000){
					plus.setEnabled(true);
				}

			}
		});
		
		balance = Integer.parseInt(balanceText.getText());
		
		addCoin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				totalBalance += balance;
				
				if(balance == 0){
					JOptionPane.showMessageDialog(null,"Minimum purchasing limit is 20",
													"Oops! Amount is Invalid",
													JOptionPane.WARNING_MESSAGE);
				}else{
					tempBalance = Integer.toString(totalBalance);
					try{
						
						FileWriter profileWrite = new FileWriter("Profile/" + user + ".csv",false);
						profileWrite.write(user + "," + email + "," + gender + "," + pass + "," + saved + "," + tempBalance + "," + dpPath);
						profileWrite.close();
						
						JOptionPane.showMessageDialog(null,"Successfuly Added");
						currentBalance.setText("Current Balance: " + tempBalance);
						accBalance.setText("" + tempBalance);
						transHistory.setForeground(Color.decode("#33e50b"));
						transHistory.setText("Last, " + balance + " coin added");
						
					}catch(IOException e1){
						e1.printStackTrace();
					}
				}
			}
		});
		
		if(balance<=0 && balance>1000){
			addCoin.setEnabled(false);
		}
		else{
			addCoin.setEnabled(true);
		}
		
		// ------coin purchasing process end-------
		
		
		// ----------dp upload system---------
		
		uploadImg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser dpChoose = new JFileChooser();
				dpChoose.setFileFilter(new FileNameExtensionFilter("Images","jpg","jpeg","png"));
				int res = dpChoose.showOpenDialog(Home.this);
				if(res == JFileChooser.APPROVE_OPTION){
					File selectedFile = dpChoose.getSelectedFile();
					
					try{
						Image selectedImage = ImageIO.read(selectedFile);
						dpPath = selectedFile.getAbsolutePath();

						FileWriter profileWrite = new FileWriter("Profile/" + user + ".csv",false);
						profileWrite.write(user + "," + email + "," + gender + "," + pass + "," + saved + "," + totalBalance + "," + dpPath);
						profileWrite.close();
						
						ImageIcon dpPic = new ImageIcon(dpPath);
						Image dpImg = dpPic.getImage();
						dpImg = dpImg.getScaledInstance(120,120,Image.SCALE_SMOOTH);
						dpPic = new ImageIcon(dpImg);
						dp.setIcon(dpPic);
						
					}catch(IOException ex){
						JOptionPane.showMessageDialog(null,"This file can not be added","Error",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		//-------sign out start--------
		
		signOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int conf = JOptionPane.showConfirmDialog(
							null,
							"Signing out too early!  Are you sure?",
							"Confirm Sign Out?",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE
							);
				
				if(conf == JOptionPane.YES_OPTION){
					Login login = new Login(initial);
					login.setVisible(true);
					dispose();
				}else{
					//do nothing
				}
			}
		});
		
		//----------sign out end----------
		
		//********************************
		
		//----------profile settings start-----------
		
				
		JPanel changes = new JPanel();
		changes.setBounds(440,200,400, 250);
		changes.setOpaque(true);
		changes.setLayout(null);
		changes.setBackground(Color.decode("#d5d8ea"));
		
		JButton chngClose = new JButton();
		ImageIcon c1 = new ImageIcon("image/cross.png");
		Image c1Icon = c1.getImage();
		c1Icon = c1Icon.getScaledInstance(18,15,Image.SCALE_SMOOTH);
		c1 = new ImageIcon(c1Icon);
		chngClose.setIcon(c1);
		chngClose.setBounds(370,10,18,15);
		chngClose.setContentAreaFilled(false);
		chngClose.setBorderPainted(false);
		chngClose.setFocusable(false);
		chngClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changes.add(chngClose);
		
		JLabel chngText = new JLabel("");
		chngText.setBounds(50,25,300,30);
		chngText.setFont(new Font("Helvetica", Font.BOLD, 24));
		chngText.setForeground(Color.BLACK);
		changes.add(chngText);
		
		JLabel firstTitle = new JLabel("");
		firstTitle.setBounds(30,75,110,25);
		firstTitle.setFont(new Font("Helvetica", Font.BOLD, 15));
		firstTitle.setForeground(Color.BLACK);
		changes.add(firstTitle);
		
		JTextField firstFieldMail = new JTextField();
		firstFieldMail.setBounds(145,73,215,30);
		firstFieldMail.setFont(new Font("Helvetica", Font.PLAIN, 16));
		firstFieldMail.setForeground(Color.BLACK);
		firstFieldMail.setVisible(false);
		changes.add(firstFieldMail);
		
		JPasswordField firstFieldPass = new JPasswordField();
		firstFieldPass.setBounds(145,73,215,30);
		firstFieldPass.setFont(new Font("Helvetica", Font.BOLD, 16));
		firstFieldPass.setForeground(Color.BLACK);
		firstFieldPass.setVisible(false);
		changes.add(firstFieldPass);
		
		JLabel secondTitle = new JLabel("");
		secondTitle.setBounds(30,115,110,25);
		secondTitle.setFont(new Font("Helvetica", Font.BOLD, 15));
		secondTitle.setForeground(Color.BLACK);
		changes.add(secondTitle);
		
		JPasswordField secondField = new JPasswordField();
		secondField.setBounds(145,113,215,30);
		secondField.setFont(new Font("Helvetica", Font.BOLD, 16));
		secondField.setForeground(Color.BLACK);
		changes.add(secondField);
						
		JLabel thirdTitle = new JLabel("Confirm Pass: ");
		thirdTitle.setBounds(30,155,110,25);
		thirdTitle.setFont(new Font("Helvetica", Font.BOLD, 15));
		thirdTitle.setForeground(Color.BLACK);
		thirdTitle.setVisible(false);
		changes.add(thirdTitle);
				
		JPasswordField thirdField = new JPasswordField();
		thirdField.setBounds(145,153,215,30);
		thirdField.setFont(new Font("Helvetica", Font.BOLD, 16));
		thirdField.setForeground(Color.BLACK);
		thirdField.setVisible(false);
		changes.add(thirdField);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(140,200,120,28);
		submit.setOpaque(true);
		submit.setBackground(Color.decode("#060d3a"));
		submit.setForeground(Color.WHITE);
		submit.setFocusable(false);
		submit.setBorderPainted(false);
		submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changes.add(submit);
		
		changes.setVisible(false);
		addProfileBg.add(changes);
		addProfileBg.setComponentZOrder(changes,0);

		
		passChange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				//addProfileBg.setVisible(false);
				changes.setVisible(true);
				
				chngText.setText("Change Your Password");
				chngText.setBounds(75,25,300,30);
				
				firstTitle.setText("Current Pass: ");
				firstTitle.setBounds(30,75,110,25);
				
				firstFieldPass.setBounds(145,73,215,30);
				firstFieldPass.setVisible(true);
				
				secondTitle.setText("New Pass: ");
				secondTitle.setBounds(30,115,110,25);
				secondField.setBounds(145,113,215,30);
			
				thirdTitle.setVisible(true);
				thirdField.setVisible(true);
				
				
				submit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e1){
						
						String curPass = new String(firstFieldPass.getPassword());
						String newPass = new String(secondField.getPassword());
						String confPass = new String(thirdField.getPassword());
						
						if(newPass.isEmpty() || confPass.isEmpty()){
							JOptionPane.showMessageDialog(null,"Please fill all fields");
						}else if(!newPass.isEmpty() && !confPass.isEmpty() && !newPass.equals(confPass)){
							JOptionPane.showMessageDialog(null,"Password mismatch!");
							secondField.setText("");
							thirdField.setText("");
						}else if(!newPass.isEmpty() && (newPass.length()<6 || newPass.length()>18)){
							JOptionPane.showMessageDialog(null,"Password must be within 6-18 digits");
							secondField.setText("");
							thirdField.setText("");
						}else if(curPass.equals(pass) && newPass.equals(confPass)){
							int conf = JOptionPane.showConfirmDialog(
										null,
										"Password changed successfully. Do you want to save this new password? ",
										"Remember Password",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.WARNING_MESSAGE
										);
												
							if(conf == JOptionPane.YES_OPTION){
								saved = "Saved";
								saveUserData(user,email,gender,newPass,saved,tempBalance,dpPath);
							}else if(conf == JOptionPane.NO_OPTION){
								saved = "notSaved";
								saveUserData(user,email,gender,newPass,saved,tempBalance,dpPath);
							}
						}				

						changes.setVisible(false);
						chngText.setText("");
						firstTitle.setText("");
						firstFieldPass.setVisible(false);
						firstFieldPass.setText("");
						secondTitle.setText("");
						secondField.setText("");
						thirdTitle.setVisible(false);
						thirdField.setVisible(false);
						addProfileBg.setVisible(true);
					}
				});
				
				
				chngClose.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e2){
						
						changes.setVisible(false);
						chngText.setText("");
						firstTitle.setText("");
						firstFieldPass.setVisible(false);
						secondTitle.setText("");
						secondField.setText("");
						thirdTitle.setVisible(false);
						thirdField.setVisible(false);
						thirdField.setText("");
						addProfileBg.setVisible(true);
					}
				});
				
			}
		});
		
		mailChange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//addProfileBg.setVisible(false);
				changes.setVisible(true);
				
				chngText.setText("Change Your Email");
				chngText.setBounds(85,25,230,30);
						
				firstTitle.setText("New Email: ");
				firstTitle.setBounds(30,90,110,25);
				
				firstFieldMail.setBounds(145,88,215,30);
				firstFieldMail.setVisible(true);
				
				secondTitle.setText("Password: ");
				secondTitle.setBounds(30,140,110,25);
				secondField.setBounds(145,138,215,30);
										
				submit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e1){
						
						String getMail = firstFieldMail.getText();
						String getPass = new String(secondField.getPassword());
						 
						if(getMail.isEmpty()){
							JOptionPane.showMessageDialog(null,"Add a new email address");
						}else if (!emailValidator.validate(getMail)){
							JOptionPane.showMessageDialog(null,"Invalid email address!");
							firstFieldMail.setText("");
						}
						
						if(getPass.isEmpty()){
							JOptionPane.showMessageDialog(null,"Enter your password for proceed");
						}else if(!getPass.equals(pass)){
							JOptionPane.showMessageDialog(null,"Wrong Password");
							secondField.setText("");
						} 
						
						if(emailValidator.validate(getMail) && getPass.equals(pass)){
							
							int conf = JOptionPane.showConfirmDialog(
							null,
							"Are you sure about changing your previous email?",
							"Change Email",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE
							);
				
							if(conf == JOptionPane.YES_OPTION){
								accEmail.setText(getMail);
								saveUserData(user,getMail,gender,pass,saved,tempBalance,dpPath);
								JOptionPane.showMessageDialog(null,"Email Changed Successfuly");
								
								changes.setVisible(false);
								chngText.setText("");
								firstTitle.setText("");
								firstFieldMail.setVisible(false);
								secondTitle.setText("");
								secondField.setText("");
								
								addProfileBg.setVisible(true);
							}
						}
					}
				});
				
				chngClose.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e2){
						
						changes.setVisible(false);
						chngText.setText("");
						firstTitle.setText("");
						firstFieldMail.setVisible(false);
						secondTitle.setText("");
						secondField.setText("");
						
						addProfileBg.setVisible(true);
					}
				});
			}
		});
		
		deleteAcc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int conf = JOptionPane.showConfirmDialog(
				null,
				"Are you sure? This action can not be undone.",
				"Delete Account",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE
				);
				
				if(conf == JOptionPane.YES_OPTION){
					File file = new File("Profile/" + user + ".csv");
					file.delete();
					
					Login login = new Login(initial);
					login.setVisible(true);
					dispose();
				}
			}
		});
		
		
		//-----**** Content for Home Page ****------
		
		int col =40, row = 50, cnt = 0;
		
		
		try(BufferedReader br = new BufferedReader(new FileReader("contents/data/all_content.csv"))){
			String line;
			
			while ((line = br.readLine()) != null) {
				
				String[] userData = line.split(",");
				
				if(userData.length>=4){
					final String name = userData[0];
					final String genre = userData[1];
					final String price = userData[2];
					final String path = userData[3];
					
					ImageIcon thumbnail = new ImageIcon(path);
					Image thumb = thumbnail.getImage();
					thumb = thumb.getScaledInstance(272,153,Image.SCALE_SMOOTH);
					thumbnail = new ImageIcon(thumb);
					JLabel boxThumb = new JLabel(thumbnail);					
					boxThumb.setBounds(col,row,272,153);
					boxThumb.setLayout(null);

					JPanel hoverBox = new JPanel();
					hoverBox.setBounds(0,83,272,70);
					hoverBox.setPreferredSize(new Dimension(272,70));
					hoverBox.setOpaque(true);
					hoverBox.setLayout(null);
					hoverBox.setBackground(new Color(0, 0, 30, 200));
					hoverBox.setVisible(false);
					
					JLabel cntntName = new JLabel(name);
					cntntName.setBounds(0, 3, 272, 20);
					cntntName.setHorizontalAlignment(JLabel.CENTER);
					cntntName.setFont(new Font("Netflix-sans",Font.PLAIN,15));
					cntntName.setForeground(Color.WHITE);
					hoverBox.add(cntntName);
					
					ImageIcon play = new ImageIcon("image/play-01.png");
					Image playImg = play.getImage();
					playImg = playImg.getScaledInstance(24,30,Image.SCALE_SMOOTH);
					play = new ImageIcon(playImg);
					
					JLabel playLabel = new JLabel(play);
					playLabel.setBounds(80,30,25,30);
					playLabel.setHorizontalAlignment(JLabel.CENTER);
					playLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					playLabel.setVisible(false);
					hoverBox.add(playLabel);
					
					
					ImageIcon lock = new ImageIcon("image/lock-01.png");
					Image lockImg = lock.getImage();
					lockImg = lockImg.getScaledInstance(20,30,Image.SCALE_SMOOTH);
					lock = new ImageIcon(lockImg);
					
					JLabel priceLabel = new JLabel(lock);
					priceLabel.setText(" " + price);
					priceLabel.setFont(new Font("Netflix-sans",Font.BOLD,30));
					priceLabel.setForeground(Color.decode("#ffe074"));
					priceLabel.setBounds(44,30,100,30);
					priceLabel.setHorizontalAlignment(JLabel.CENTER);
					priceLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					priceLabel.setVisible(true);
					hoverBox.add(priceLabel);
					
					//------- searching for locked or unlock--------
					boolean found = false;
					
					try (BufferedReader br1 = new BufferedReader(new FileReader("Profile/" + user + "_buy.csv"))) {
						String line1;

						while ((line1 = br1.readLine()) != null) {
							
							String[] values = line1.split(",");
				
							// Iterate through the values and check if the search value exists
							for (String value : values) {
								if (value.equals(name)) {
									found = true;
									break;
								}
							}
						}
					}catch(IOException e1){
						e1.printStackTrace();
					}
					
					if(!found){
					
						priceLabel.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent m){
								int conf = JOptionPane.showConfirmDialog(null,
											"Are your sure to buy "+name+" for "+price+" coins?",
											"Buy "+name+".",
											JOptionPane.YES_NO_OPTION,
											JOptionPane.WARNING_MESSAGE);
											
								if(conf == JOptionPane.YES_OPTION){
									int temp = Integer.parseInt(price);
									
									if(totalBalance>=temp){
										totalBalance -= temp;
										String newBalance = Integer.toString(totalBalance);
										
										saveUserData(user,email,gender,pass,saved,newBalance,dpPath);
										
										try{
											FileWriter buyWriter = new FileWriter("Profile/" + user + "_buy.csv",true);
											buyWriter.write(name + ",");
											buyWriter.close();
										}catch(IOException i){
											i.printStackTrace();
										}
										
										JOptionPane.showMessageDialog(null,"Purchcase Successful");
										
										currentBalance.setText("Current Balance: " + newBalance);
										accBalance.setText("" + newBalance);
										transHistory.setForeground(Color.decode("#f40202"));
										transHistory.setText("Last, " + price + " coin spent");
										priceLabel.setVisible(false);
										playLabel.setVisible(true);
										playLabel.addMouseListener(new MouseAdapter(){
											public void mouseClicked(MouseEvent m){
												JOptionPane.showMessageDialog(null,"Error 503, service is not available.");
											}
										});
										
									}else{
										JOptionPane.showMessageDialog(null,"Insufficiant Balance!","Oops!",JOptionPane.WARNING_MESSAGE);
									}
								}
							}
						});
					}else if(found){
						
						priceLabel.setVisible(false);
						playLabel.setVisible(true);
						playLabel.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent m){
								JOptionPane.showMessageDialog(null,"Error 503, service is not available.");
							}
						});
					}
					
					//----searching for fav or not-------
					
					JLabel favAdd = new JLabel();
		
					ImageIcon favIcon = new ImageIcon("image/fav-01.png");
					ImageIcon redHeart = new ImageIcon(favIcon.getImage().getScaledInstance(32, 27, Image.SCALE_SMOOTH));

					ImageIcon notFavIcon = new ImageIcon("image/notFav-01.png");
					ImageIcon whiteHeart = new ImageIcon(notFavIcon.getImage().getScaledInstance(32, 27, Image.SCALE_SMOOTH));
					favAdd.setIcon(whiteHeart);
					
					boolean foundFav = false;
					
					try (BufferedReader br1 = new BufferedReader(new FileReader("Profile/" + user + "_fav.csv"))) {
						String line1;

						while ((line1 = br1.readLine()) != null) {
							
							String[] values = line1.split(",");
							
							if(values[0].equals(name)){
								foundFav = true;
								break;
							}
							
						}
					}catch(IOException e1){
						e1.printStackTrace();
					}
					
					if(foundFav){
						favAdd.setIcon(redHeart);
					}else if(!foundFav){
						favAdd.setIcon(whiteHeart);
						
						favAdd.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent m){
								favAdd.setIcon(redHeart);
								
								try{
									FileWriter favWriter = new FileWriter("Profile/" + user + "_fav.csv",true);
									favWriter.write(name + "," + genre + "," + price + ","+ path + "\n");
									favWriter.close();
								}catch(IOException ef){
									ef.printStackTrace();
								}
							}
						});
					}
					
					favAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					favAdd.setBounds(180,30,80,30);
					hoverBox.add(favAdd);
					
					
					boxThumb.add(hoverBox);		
					homeBg2.add(boxThumb);

					boxThumb.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							hoverBox.setVisible(true);
							homeBg2.repaint();
						}

						@Override
						public void mouseExited(MouseEvent e) {
							hoverBox.setVisible(false);
							homeBg2.repaint();
						}
					});
					
					col += 300;
					cnt++;
					if(cnt%4==0){
						row += 183;
						col = 40;
					}
				}
			}
			br.close();
		}catch(IOException e1){
			e1.printStackTrace();
		}

		
		//-----**** Content for Movie Page ****------
		
		col =40; row = 150; cnt = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader("contents/data/movie.csv"))){
			String line;
			
			while ((line = br.readLine()) != null) {
				
				String[] userData = line.split(",");
				
				if(userData.length>=4){
					final String name = userData[0];
					final String genre = userData[1];
					final String price = userData[2];
					final String path = userData[3];
					
					ImageIcon thumbnail = new ImageIcon(path);
					Image thumb = thumbnail.getImage();
					thumb = thumb.getScaledInstance(272,153,Image.SCALE_SMOOTH);
					thumbnail = new ImageIcon(thumb);
					JLabel boxThumb = new JLabel(thumbnail);					
					boxThumb.setBounds(col,row,272,153);
					boxThumb.setLayout(null);

					JPanel hoverBox = new JPanel();
					hoverBox.setBounds(0,83,272,70);
					hoverBox.setPreferredSize(new Dimension(272,70));
					hoverBox.setOpaque(true);
					hoverBox.setLayout(null);
					hoverBox.setBackground(new Color(0, 0, 30, 200));
					hoverBox.setVisible(false);
					
					JLabel cntntName = new JLabel(name);
					cntntName.setBounds(0, 3, 272, 20);
					cntntName.setHorizontalAlignment(JLabel.CENTER);
					cntntName.setFont(new Font("Netflix-sans",Font.PLAIN,15));
					cntntName.setForeground(Color.WHITE);
					hoverBox.add(cntntName);
					
					ImageIcon play = new ImageIcon("image/play-01.png");
					Image playImg = play.getImage();
					playImg = playImg.getScaledInstance(24,30,Image.SCALE_SMOOTH);
					play = new ImageIcon(playImg);
					
					JLabel playLabel = new JLabel(play);
					playLabel.setBounds(80,30,25,30);
					playLabel.setHorizontalAlignment(JLabel.CENTER);
					playLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					playLabel.setVisible(false);
					hoverBox.add(playLabel);
					
					
					ImageIcon lock = new ImageIcon("image/lock-01.png");
					Image lockImg = lock.getImage();
					lockImg = lockImg.getScaledInstance(20,30,Image.SCALE_SMOOTH);
					lock = new ImageIcon(lockImg);
					
					JLabel priceLabel = new JLabel(lock);
					priceLabel.setText(" " + price);
					priceLabel.setFont(new Font("Netflix-sans",Font.BOLD,30));
					priceLabel.setForeground(Color.decode("#ffe074"));
					priceLabel.setBounds(44,30,100,30);
					priceLabel.setHorizontalAlignment(JLabel.CENTER);
					priceLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					priceLabel.setVisible(true);
					hoverBox.add(priceLabel);
					
					//------- searching for locked or unlock--------
					boolean found = false;
					
					try (BufferedReader br1 = new BufferedReader(new FileReader("Profile/" + user + "_buy.csv"))) {
						String line1;

						while ((line1 = br1.readLine()) != null) {
							
							String[] values = line1.split(",");
				
							// Iterate through the values and check if the search value exists
							for (String value : values) {
								if (value.equals(name)) {
									found = true;
									break;
								}
							}
						}
					}catch(IOException e1){
						e1.printStackTrace();
					}
					
					if(!found){
					
						priceLabel.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent m){
								int conf = JOptionPane.showConfirmDialog(null,
											"Are your sure to buy "+name+" for "+price+" coins?",
											"Buy "+name+".",
											JOptionPane.YES_NO_OPTION,
											JOptionPane.WARNING_MESSAGE);
											
								if(conf == JOptionPane.YES_OPTION){
									int temp = Integer.parseInt(price);
									
									if(totalBalance>=temp){
										totalBalance -= temp;
										String newBalance = Integer.toString(totalBalance);
										
										saveUserData(user,email,gender,pass,saved,newBalance,dpPath);
										
										try{
											FileWriter buyWriter = new FileWriter("Profile/" + user + "_buy.csv",true);
											buyWriter.write(name + ",");
											buyWriter.close();
										}catch(IOException i){
											i.printStackTrace();
										}
										
										JOptionPane.showMessageDialog(null,"Purchcase Successful");
										
										currentBalance.setText("Current Balance: " + newBalance);
										accBalance.setText("" + newBalance);
										transHistory.setForeground(Color.decode("#f40202"));
										transHistory.setText("Last, " + price + " coin spent");
										priceLabel.setVisible(false);
										playLabel.setVisible(true);
										playLabel.addMouseListener(new MouseAdapter(){
											public void mouseClicked(MouseEvent m){
												JOptionPane.showMessageDialog(null,"Error 503, service is not available.");
											}
										});
										
									}else{
										JOptionPane.showMessageDialog(null,"Insufficiant Balance!","Oops!",JOptionPane.WARNING_MESSAGE);
									}
								}
							}
						});
					}else if(found){
						
						priceLabel.setVisible(false);
						playLabel.setVisible(true);
						playLabel.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent m){
								JOptionPane.showMessageDialog(null,"Error 503, service is not available.");
							}
						});
					}
					
					//----searching for fav or not-------
					
					JLabel favAdd = new JLabel();
		
					ImageIcon favIcon = new ImageIcon("image/fav-01.png");
					ImageIcon redHeart = new ImageIcon(favIcon.getImage().getScaledInstance(32, 27, Image.SCALE_SMOOTH));

					ImageIcon notFavIcon = new ImageIcon("image/notFav-01.png");
					ImageIcon whiteHeart = new ImageIcon(notFavIcon.getImage().getScaledInstance(32, 27, Image.SCALE_SMOOTH));
					favAdd.setIcon(whiteHeart);
					
					boolean foundFav = false;
					
					try (BufferedReader br1 = new BufferedReader(new FileReader("Profile/" + user + "_fav.csv"))) {
						String line1;

						while ((line1 = br1.readLine()) != null) {
							
							String[] values = line1.split(",");
							
							if(values[0].equals(name)){
								foundFav = true;
								break;
							}
							
						}
					}catch(IOException e1){
						e1.printStackTrace();
					}
					
					if(foundFav){
						favAdd.setIcon(redHeart);
					}else if(!foundFav){
						favAdd.setIcon(whiteHeart);
						
						favAdd.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent m){
								favAdd.setIcon(redHeart);
								
								try{
									FileWriter favWriter = new FileWriter("Profile/" + user + "_fav.csv",true);
									favWriter.write(name + "," + genre + "," + price + ","+ path + "\n");
									favWriter.close();
								}catch(IOException ef){
									ef.printStackTrace();
								}
							}
						});
					}
					
					favAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					favAdd.setBounds(180,30,80,30);
					hoverBox.add(favAdd);
					
					
					boxThumb.add(hoverBox);		
					homeMovieBg.add(boxThumb);

					boxThumb.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							hoverBox.setVisible(true);
							homeMovieBg.repaint();
						}

						@Override
						public void mouseExited(MouseEvent e) {
							hoverBox.setVisible(false);
							homeMovieBg.repaint();
						}
					});
					
					col += 300;
					cnt++;
					if(cnt%4==0){
						row += 183;
						col = 40;
					}
				}
			}
			br.close();
		}catch(IOException e1){
			e1.printStackTrace();
		}

		
		//-----**** Content for Webseries Page ****------
		
		col =40; row = 150; cnt = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader("contents/data/webseries.csv"))){
			String line;
			
			while ((line = br.readLine()) != null) {
				
				String[] userData = line.split(",");
				
				if(userData.length>=4){
					final String name = userData[0];
					final String genre = userData[1];
					final String price = userData[2];
					final String path = userData[3];
					
					ImageIcon thumbnail = new ImageIcon(path);
					Image thumb = thumbnail.getImage();
					thumb = thumb.getScaledInstance(272,153,Image.SCALE_SMOOTH);
					thumbnail = new ImageIcon(thumb);
					JLabel boxThumb = new JLabel(thumbnail);					
					boxThumb.setBounds(col,row,272,153);
					boxThumb.setLayout(null);

					JPanel hoverBox = new JPanel();
					hoverBox.setBounds(0,83,272,70);
					hoverBox.setPreferredSize(new Dimension(272,70));
					hoverBox.setOpaque(true);
					hoverBox.setLayout(null);
					hoverBox.setBackground(new Color(0, 0, 30, 200));
					hoverBox.setVisible(false);
					
					JLabel cntntName = new JLabel(name);
					cntntName.setBounds(0, 3, 272, 20);
					cntntName.setHorizontalAlignment(JLabel.CENTER);
					cntntName.setFont(new Font("Netflix-sans",Font.PLAIN,15));
					cntntName.setForeground(Color.WHITE);
					hoverBox.add(cntntName);
					
					ImageIcon play = new ImageIcon("image/play-01.png");
					Image playImg = play.getImage();
					playImg = playImg.getScaledInstance(24,30,Image.SCALE_SMOOTH);
					play = new ImageIcon(playImg);
					
					JLabel playLabel = new JLabel(play);
					playLabel.setBounds(80,30,25,30);
					playLabel.setHorizontalAlignment(JLabel.CENTER);
					playLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					playLabel.setVisible(false);
					hoverBox.add(playLabel);
					
					
					ImageIcon lock = new ImageIcon("image/lock-01.png");
					Image lockImg = lock.getImage();
					lockImg = lockImg.getScaledInstance(20,30,Image.SCALE_SMOOTH);
					lock = new ImageIcon(lockImg);
					
					JLabel priceLabel = new JLabel(lock);
					priceLabel.setText(" " + price);
					priceLabel.setFont(new Font("Netflix-sans",Font.BOLD,30));
					priceLabel.setForeground(Color.decode("#ffe074"));
					priceLabel.setBounds(44,30,100,30);
					priceLabel.setHorizontalAlignment(JLabel.CENTER);
					priceLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					priceLabel.setVisible(true);
					hoverBox.add(priceLabel);
					
					//------- searching for locked or unlock--------
					boolean found = false;
					
					try (BufferedReader br1 = new BufferedReader(new FileReader("Profile/" + user + "_buy.csv"))) {
						String line1;

						while ((line1 = br1.readLine()) != null) {
							
							String[] values = line1.split(",");
				
							// Iterate through the values and check if the search value exists
							for (String value : values) {
								if (value.equals(name)) {
									found = true;
									break;
								}
							}
						}
					}catch(IOException e1){
						e1.printStackTrace();
					}
					
					if(!found){
					
						priceLabel.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent m){
								int conf = JOptionPane.showConfirmDialog(null,
											"Are your sure to buy "+name+" for "+price+" coins?",
											"Buy "+name+".",
											JOptionPane.YES_NO_OPTION,
											JOptionPane.WARNING_MESSAGE);
											
								if(conf == JOptionPane.YES_OPTION){
									int temp = Integer.parseInt(price);
									
									if(totalBalance>=temp){
										totalBalance -= temp;
										String newBalance = Integer.toString(totalBalance);
										
										saveUserData(user,email,gender,pass,saved,newBalance,dpPath);
										
										try{
											FileWriter buyWriter = new FileWriter("Profile/" + user + "_buy.csv",true);
											buyWriter.write(name + ",");
											buyWriter.close();
										}catch(IOException i){
											i.printStackTrace();
										}
										
										JOptionPane.showMessageDialog(null,"Purchcase Successful");
										
										currentBalance.setText("Current Balance: " + newBalance);
										accBalance.setText("" + newBalance);
										transHistory.setForeground(Color.decode("#f40202"));
										transHistory.setText("Last, " + price + " coin spent");
										priceLabel.setVisible(false);
										playLabel.setVisible(true);
										playLabel.addMouseListener(new MouseAdapter(){
											public void mouseClicked(MouseEvent m){
												JOptionPane.showMessageDialog(null,"Error 503, service is not available.");
											}
										});
										
									}else{
										JOptionPane.showMessageDialog(null,"Insufficiant Balance!","Oops!",JOptionPane.WARNING_MESSAGE);
									}
								}
							}
						});
					}else if(found){
						
						priceLabel.setVisible(false);
						playLabel.setVisible(true);
						playLabel.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent m){
								JOptionPane.showMessageDialog(null,"Error 503, service is not available.");
							}
						});
					}
					
					//----searching for fav or not-------
					
					JLabel favAdd = new JLabel();
		
					ImageIcon favIcon = new ImageIcon("image/fav-01.png");
					ImageIcon redHeart = new ImageIcon(favIcon.getImage().getScaledInstance(32, 27, Image.SCALE_SMOOTH));

					ImageIcon notFavIcon = new ImageIcon("image/notFav-01.png");
					ImageIcon whiteHeart = new ImageIcon(notFavIcon.getImage().getScaledInstance(32, 27, Image.SCALE_SMOOTH));
					favAdd.setIcon(whiteHeart);
					
					boolean foundFav = false;
					
					try (BufferedReader br1 = new BufferedReader(new FileReader("Profile/" + user + "_fav.csv"))) {
						String line1;

						while ((line1 = br1.readLine()) != null) {
							
							String[] values = line1.split(",");
							
							if(values[0].equals(name)){
								foundFav = true;
								break;
							}
							
						}
					}catch(IOException e1){
						e1.printStackTrace();
					}
					
					if(foundFav){
						favAdd.setIcon(redHeart);
					}else if(!foundFav){
						favAdd.setIcon(whiteHeart);
						
						favAdd.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent m){
								favAdd.setIcon(redHeart);
								
								try{
									FileWriter favWriter = new FileWriter("Profile/" + user + "_fav.csv",true);
									favWriter.write(name + "," + genre + "," + price + ","+ path + "\n");
									favWriter.close();
								}catch(IOException ef){
									ef.printStackTrace();
								}
							}
						});
					}
					
					favAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					favAdd.setBounds(180,30,80,30);
					hoverBox.add(favAdd);
					
					
					boxThumb.add(hoverBox);		
					homeWebBg.add(boxThumb);

					boxThumb.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							hoverBox.setVisible(true);
							homeWebBg.repaint();
						}

						@Override
						public void mouseExited(MouseEvent e) {
							hoverBox.setVisible(false);
							homeWebBg.repaint();
						}
					});
					
					col += 300;
					cnt++;
					if(cnt%4==0){
						row += 183;
						col = 40;
					}
				}
			}
			br.close();
		}catch(IOException e1){
			e1.printStackTrace();
		}
		

		
		//-----**** Content for My Fav Page ****------
		
		col =40; row = 150; cnt = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader("Profile/" + user + "_fav.csv"))){
			String line;
			
			while ((line = br.readLine()) != null) {
				
				String[] userData = line.split(",");
				
				if(userData.length>=4){
					final String name = userData[0];
					final String genre = userData[1];
					final String price = userData[2];
					final String path = userData[3];
					
					ImageIcon thumbnail = new ImageIcon(path);
					Image thumb = thumbnail.getImage();
					thumb = thumb.getScaledInstance(272,153,Image.SCALE_SMOOTH);
					thumbnail = new ImageIcon(thumb);
					JLabel boxThumb = new JLabel(thumbnail);					
					boxThumb.setBounds(col,row,272,153);
					boxThumb.setLayout(null);

					JPanel hoverBox = new JPanel();
					hoverBox.setBounds(0,83,272,70);
					hoverBox.setPreferredSize(new Dimension(272,70));
					hoverBox.setOpaque(true);
					hoverBox.setLayout(null);
					hoverBox.setBackground(new Color(0, 0, 30, 200));
					hoverBox.setVisible(false);
					
					JLabel cntntName = new JLabel(name);
					cntntName.setBounds(0, 3, 272, 20);
					cntntName.setHorizontalAlignment(JLabel.CENTER);
					cntntName.setFont(new Font("Netflix-sans",Font.PLAIN,15));
					cntntName.setForeground(Color.WHITE);
					hoverBox.add(cntntName);
					
					ImageIcon play = new ImageIcon("image/play-01.png");
					Image playImg = play.getImage();
					playImg = playImg.getScaledInstance(24,30,Image.SCALE_SMOOTH);
					play = new ImageIcon(playImg);
					
					JLabel playLabel = new JLabel(play);
					playLabel.setBounds(80,30,25,30);
					playLabel.setHorizontalAlignment(JLabel.CENTER);
					playLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					playLabel.setVisible(false);
					hoverBox.add(playLabel);
					
					
					ImageIcon lock = new ImageIcon("image/lock-01.png");
					Image lockImg = lock.getImage();
					lockImg = lockImg.getScaledInstance(20,30,Image.SCALE_SMOOTH);
					lock = new ImageIcon(lockImg);
					
					JLabel priceLabel = new JLabel(lock);
					priceLabel.setText(" " + price);
					priceLabel.setFont(new Font("Netflix-sans",Font.BOLD,30));
					priceLabel.setForeground(Color.decode("#ffe074"));
					priceLabel.setBounds(44,30,100,30);
					priceLabel.setHorizontalAlignment(JLabel.CENTER);
					priceLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					priceLabel.setVisible(true);
					hoverBox.add(priceLabel);
					
					//------- searching for locked or unlock--------
					boolean found = false;
					
					try (BufferedReader br1 = new BufferedReader(new FileReader("Profile/" + user + "_buy.csv"))) {
						String line1;

						while ((line1 = br1.readLine()) != null) {
							
							String[] values = line1.split(",");
				
							// Iterate through the values and check if the search value exists
							for (String value : values) {
								if (value.equals(name)) {
									found = true;
									break;
								}
							}
						}
					}catch(IOException e1){
						e1.printStackTrace();
					}
					
					if(!found){
					
						priceLabel.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent m){
								int conf = JOptionPane.showConfirmDialog(null,
											"Are your sure to buy "+name+" for "+price+" coins?",
											"Buy "+name+".",
											JOptionPane.YES_NO_OPTION,
											JOptionPane.WARNING_MESSAGE);
											
								if(conf == JOptionPane.YES_OPTION){
									int temp = Integer.parseInt(price);
									
									if(totalBalance>=temp){
										totalBalance -= temp;
										String newBalance = Integer.toString(totalBalance);
										
										saveUserData(user,email,gender,pass,saved,newBalance,dpPath);
										
										try{
											FileWriter buyWriter = new FileWriter("Profile/" + user + "_buy.csv",true);
											buyWriter.write(name + ",");
											buyWriter.close();
										}catch(IOException i){
											i.printStackTrace();
										}
										
										JOptionPane.showMessageDialog(null,"Purchcase Successful");
										
										currentBalance.setText("Current Balance: " + newBalance);
										accBalance.setText("" + newBalance);
										transHistory.setForeground(Color.decode("#f40202"));
										transHistory.setText("Last, " + price + " coin spent");
										priceLabel.setVisible(false);
										playLabel.setVisible(true);
										playLabel.addMouseListener(new MouseAdapter(){
											public void mouseClicked(MouseEvent m){
												JOptionPane.showMessageDialog(null,"Error 503, service is not available.");
											}
										});
										
									}else{
										JOptionPane.showMessageDialog(null,"Insufficiant Balance!","Oops!",JOptionPane.WARNING_MESSAGE);
									}
								}
							}
						});
					}else if(found){
						
						priceLabel.setVisible(false);
						playLabel.setVisible(true);
						playLabel.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent m){
								JOptionPane.showMessageDialog(null,"Error 503, service is not available.");
							}
						});
					}
					
					//----searching for fav or not-------
					
					JLabel favAdd = new JLabel();
		
					ImageIcon favIcon = new ImageIcon("image/fav-01.png");
					ImageIcon redHeart = new ImageIcon(favIcon.getImage().getScaledInstance(32, 27, Image.SCALE_SMOOTH));
					favAdd.setIcon(redHeart);
					favAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					favAdd.setBounds(180,30,80,30);
					hoverBox.add(favAdd);
					
					
					boxThumb.add(hoverBox);		
					homeMyFavBg.add(boxThumb);

					boxThumb.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							hoverBox.setVisible(true);
							homeMyFavBg.repaint();
						}

						@Override
						public void mouseExited(MouseEvent e) {
							hoverBox.setVisible(false);
							homeMyFavBg.repaint();
						}
					});
					
					col += 300;
					cnt++;
					if(cnt%4==0){
						row += 183;
						col = 40;
					}
				}
			}
			br.close();
		}catch(IOException e1){
			e1.printStackTrace();
		}
		
		
		//------- search bar working process ------
		
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if (homeSearchBg.getComponentCount() > 0) {
                    homeSearchBg.removeAll();
                    homeSearchBg.revalidate();
                    homeSearchBg.repaint();
                }
				
				panel.setVisible(false);
				moviePanel.setVisible(false);
				webPanel.setVisible(false);
				myFavPanel.setVisible(false);
				searchPanel.setVisible(true);

				if(addCoinBg.isVisible()){
					addCoinBg.setVisible(false);
				}
				if(addProfileBg.isVisible()){
					addProfileBg.setVisible(false);
				}

				scrollPane.setVisible(false);
				scrollPane2.setVisible(false);
				scrollPane3.setVisible(false);
				scrollPane4.setVisible(false);
				scrollPane5.setVisible(true);
				
				homeSearchBg.add(reload);
				homeSearchBg.add(homeBtn);
				homeSearchBg.add(movieBtn);
				homeSearchBg.add(webBtn);
				homeSearchBg.add(favBtn);
				homeSearchBg.add(dodge);
				homeSearchBg.add(searchBar);
				homeSearchBg.add(searchBtn);
				homeSearchBg.add(coinBtn);
				homeSearchBg.add(addCoinBg);
				homeSearchBg.setComponentZOrder(addCoinBg,0);
				homeSearchBg.add(profileBtn);
				homeSearchBg.add(addProfileBg);
				homeSearchBg.setComponentZOrder(addProfileBg,0);
				homeSearchBg.add(signOut);				

				setTitle("Netflix- Unlimited Streaming");
				
				//---- searched content add -------
				
				try(BufferedReader br = new BufferedReader(new FileReader("contents/data/all_content.csv"))){
					String line;
					String text = searchBar.getText();
					boolean flag = false;
					
					while ((line = br.readLine()) != null) {
						
						String[] userData = line.split(",");
						
						if(userData.length>=4){
							final String name = userData[0];
							final String genre = userData[1];
							final String price = userData[2];
							final String path = userData[3];

							if(name.equalsIgnoreCase(text)){
								
								flag = true;

								ImageIcon thumbnail = new ImageIcon(path);
								Image thumb = thumbnail.getImage();
								thumb = thumb.getScaledInstance(272,153,Image.SCALE_SMOOTH);
								thumbnail = new ImageIcon(thumb);
								JLabel boxThumb = new JLabel(thumbnail);					
								boxThumb.setBounds(40,220,272,153);
								boxThumb.setLayout(null);
			
								JPanel hoverBox = new JPanel();
								hoverBox.setBounds(0,83,272,70);
								hoverBox.setPreferredSize(new Dimension(272,70));
								hoverBox.setOpaque(true);
								hoverBox.setLayout(null);
								hoverBox.setBackground(new Color(0, 0, 30, 200));
								hoverBox.setVisible(false);
								
								JLabel cntntName = new JLabel(name);
								cntntName.setBounds(0, 3, 272, 20);
								cntntName.setHorizontalAlignment(JLabel.CENTER);
								cntntName.setFont(new Font("Netflix-sans",Font.PLAIN,15));
								cntntName.setForeground(Color.WHITE);
								hoverBox.add(cntntName);
								
								ImageIcon play = new ImageIcon("image/play-01.png");
								Image playImg = play.getImage();
								playImg = playImg.getScaledInstance(24,30,Image.SCALE_SMOOTH);
								play = new ImageIcon(playImg);
								
								JLabel playLabel = new JLabel(play);
								playLabel.setBounds(80,30,25,30);
								playLabel.setHorizontalAlignment(JLabel.CENTER);
								playLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								playLabel.setVisible(false);
								hoverBox.add(playLabel);
								
								
								ImageIcon lock = new ImageIcon("image/lock-01.png");
								Image lockImg = lock.getImage();
								lockImg = lockImg.getScaledInstance(20,30,Image.SCALE_SMOOTH);
								lock = new ImageIcon(lockImg);
								
								JLabel priceLabel = new JLabel(lock);
								priceLabel.setText(" " + price);
								priceLabel.setFont(new Font("Netflix-sans",Font.BOLD,30));
								priceLabel.setForeground(Color.decode("#ffe074"));
								priceLabel.setBounds(44,30,100,30);
								priceLabel.setHorizontalAlignment(JLabel.CENTER);
								priceLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								priceLabel.setVisible(true);
								hoverBox.add(priceLabel);
								
								//------- searching for locked or unlock--------
								boolean found = false;
								
								try (BufferedReader br1 = new BufferedReader(new FileReader("Profile/" + user + "_buy.csv"))) {
									String line1;
			
									while ((line1 = br1.readLine()) != null) {
										
										String[] values = line1.split(",");
							
										// Iterate through the values and check if the search value exists
										for (String value : values) {
											if (value.equals(name)) {
												found = true;
												break;
											}
										}
									}
								}catch(IOException e1){
									e1.printStackTrace();
								}
								
								if(!found){
								
									priceLabel.addMouseListener(new MouseAdapter(){
										public void mouseClicked(MouseEvent m){
											int conf = JOptionPane.showConfirmDialog(null,
														"Are your sure to buy "+name+" for "+price+" coins?",
														"Buy "+name+".",
														JOptionPane.YES_NO_OPTION,
														JOptionPane.WARNING_MESSAGE);
														
											if(conf == JOptionPane.YES_OPTION){
												int temp = Integer.parseInt(price);
												
												if(totalBalance>=temp){
													totalBalance -= temp;
													String newBalance = Integer.toString(totalBalance);
													
													saveUserData(user,email,gender,pass,saved,newBalance,dpPath);
													
													try{
														FileWriter buyWriter = new FileWriter("Profile/" + user + "_buy.csv",true);
														buyWriter.write(name + ",");
														buyWriter.close();
													}catch(IOException i){
														i.printStackTrace();
													}
													
													JOptionPane.showMessageDialog(null,"Purchcase Successful");
													
													currentBalance.setText("Current Balance: " + newBalance);
													accBalance.setText("" + newBalance);
													transHistory.setForeground(Color.decode("#f40202"));
													transHistory.setText("Last, " + price + " coin spent");
													priceLabel.setVisible(false);
													playLabel.setVisible(true);
													playLabel.addMouseListener(new MouseAdapter(){
														public void mouseClicked(MouseEvent m){
															JOptionPane.showMessageDialog(null,"Error 503, service is not available.");
														}
													});
													
												}else{
													JOptionPane.showMessageDialog(null,"Insufficiant Balance!","Oops!",JOptionPane.WARNING_MESSAGE);
												}
											}
										}
									});
								}else if(found){
									
									priceLabel.setVisible(false);
									playLabel.setVisible(true);
									playLabel.addMouseListener(new MouseAdapter(){
										public void mouseClicked(MouseEvent m){
											JOptionPane.showMessageDialog(null,"Error 503, service is not available.");
										}
									});
								}
								
								//----searching for fav or not-------
								//----searching for fav or not-------
					
								JLabel favAdd = new JLabel();
					
								ImageIcon favIcon = new ImageIcon("image/fav-01.png");
								ImageIcon redHeart = new ImageIcon(favIcon.getImage().getScaledInstance(32, 27, Image.SCALE_SMOOTH));
			
								ImageIcon notFavIcon = new ImageIcon("image/notFav-01.png");
								ImageIcon whiteHeart = new ImageIcon(notFavIcon.getImage().getScaledInstance(32, 27, Image.SCALE_SMOOTH));
								favAdd.setIcon(whiteHeart);
								
								boolean foundFav = false;
								
								try (BufferedReader br1 = new BufferedReader(new FileReader("Profile/" + user + "_fav.csv"))) {
									String line1;
			
									while ((line1 = br1.readLine()) != null) {
										
										String[] values = line1.split(",");
										
										if(values[0].equals(name)){
											foundFav = true;
											break;
										}
										
									}
								}catch(IOException e1){
									e1.printStackTrace();
								}
								
								if(foundFav){
									favAdd.setIcon(redHeart);
								}else if(!foundFav){
									favAdd.setIcon(whiteHeart);
									
									favAdd.addMouseListener(new MouseAdapter(){
										public void mouseClicked(MouseEvent m){
											favAdd.setIcon(redHeart);
											
											try{
												FileWriter favWriter = new FileWriter("Profile/" + user + "_fav.csv",true);
												favWriter.write(name + "," + genre + "," + price + ","+ path + "\n");
												favWriter.close();
											}catch(IOException ef){
												ef.printStackTrace();
											}
										}
									});
								}
								
								favAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								favAdd.setBounds(180,30,80,30);
								hoverBox.add(favAdd);
	
	
								boxThumb.add(hoverBox);		
								homeSearchBg.add(boxThumb);
			
								boxThumb.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseEntered(MouseEvent e) {
										hoverBox.setVisible(true);
										homeMyFavBg.repaint();
									}
			
									@Override
									public void mouseExited(MouseEvent e) {
										hoverBox.setVisible(false);
										homeMyFavBg.repaint();
									}
								});
							}
							
						}
					}
					JLabel headline = new JLabel();
					headline.setBounds(0,120,1280,50);
					headline.setForeground(Color.WHITE);
					headline.setFont(new Font("Helvetica", Font.BOLD, 25));
					headline.setHorizontalAlignment(JLabel.CENTER);
					
					if(flag){
						headline.setText("All results for searching '" + text + "'.");
					}else{
						headline.setText("No result found for searching '" + text + "'.");
					}
					homeSearchBg.add(headline);
					br.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		});

		
		
		searchPanel.add(homeSearchBg);
		myFavPanel.add(homeMyFavBg);
		webPanel.add(homeWebBg);
		moviePanel.add(homeMovieBg);
		panel.add(homeBg2);
		
	}
	
	public void display() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }
	
	public void actionPerformed(ActionEvent e) {
	    
	}

	private void saveUserData(String userName, String email, String gender, String password, String isSaved, String balance, String image) {
		try {
			FileWriter writer = new FileWriter("Profile/" + userName + ".csv",false);
			writer.write(userName + "," + email + "," + gender + "," + password + "," + isSaved + ","+ balance + "," + image + "\n");
			writer.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error while saving user data!");
			e.printStackTrace();
		}
	}
} 