import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;


public class Login extends JFrame implements ActionListener{
    private Initial initial; // declare an instance of classes
	private String user;
	private boolean flag;
    
    public Login(Initial initial) {
        this.initial = initial;
		
		ImageIcon icon = new ImageIcon("image/icon-01.png");
		setIconImage(icon.getImage());
		
        setSize(1080,650);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		// Calculate top-left corner of the frame
		int x = (screenWidth - 1080) / 2;
		int y = (screenHeight - 650) / 2;
		
		setLocation(x,y);
		
		setTitle("Login Your Account");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        CardLayout loginLayout = new CardLayout();
		
        JPanel panel = new JPanel(loginLayout);
        panel.setLayout(null);
        
		//set background
		
		ImageIcon loginbgImg = new ImageIcon("image/loginbg-01.jpg");
        Image img = loginbgImg.getImage();
        img = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        loginbgImg = new ImageIcon(img);

        JLabel loginbg = new JLabel(loginbgImg);
        loginbg.setBounds(0, 0, getWidth(), getHeight());
        add(loginbg);
		
		//creating button for back
		
		JButton home = new JButton();
		home.setBounds(40,25,120,32);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.setFocusable(false);
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
	
		//creating the sign in part
		
		Font infoFont = new Font("Helvetica", Font.PLAIN, 15);
		
		JTextField userTf = new JTextField("Your user name or e-mail");
		userTf.setBounds(699,215,288,40);
		userTf.setForeground(Color.decode("#898c90"));
		userTf.setOpaque(false);
		userTf.setBorder(BorderFactory.createEmptyBorder());
		userTf.setFont(infoFont);
		loginbg.add(userTf);
		
		userTf.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				if(userTf.getText().equals("Your user name or e-mail")){
					userTf.setText("");
					userTf.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e){
				if(userTf.getText().isEmpty()){
					userTf.setText("Your user name or e-mail");
					userTf.setForeground(Color.decode("#898c90"));
				}
			}
		});
			
		
		JPasswordField passTf = new JPasswordField("Your password");
		passTf.setBounds(699,299,253,40);
		passTf.setForeground(Color.decode("#898c90"));
		passTf.setOpaque(false);
		passTf.setBorder(BorderFactory.createEmptyBorder());
		passTf.setFont(infoFont);
		passTf.setEchoChar((char)0);
		loginbg.add(passTf);
		
		passTf.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				if(passTf.getText().equals("Your password")){
					passTf.setText("");
					passTf.setForeground(Color.BLACK);
					passTf.setEchoChar('\u2022');
				}
			}
			@Override
			public void focusLost(FocusEvent e){
				if(passTf.getText().equals("")){
					passTf.setText("Your password");
					passTf.setForeground(Color.decode("#898c90"));
					passTf.setEchoChar((char)0);
				}
			}
		});
		
		
		final ImageIcon show = new ImageIcon("image/show-01.png");
		final ImageIcon scaledShow = new ImageIcon(show.getImage().getScaledInstance(28, 15, Image.SCALE_SMOOTH));

		final ImageIcon hide = new ImageIcon("image/hide-01.png");
		final ImageIcon scaledHide = new ImageIcon(hide.getImage().getScaledInstance(28, 20, Image.SCALE_SMOOTH));

		JToggleButton passToggle = new JToggleButton();
		passToggle.setBounds(952,306,35,25);
		passToggle.setOpaque(false);
		passToggle.setContentAreaFilled(false);
		passToggle.setBorderPainted(false);
		passToggle.setFocusable(false);
		passToggle.setIcon(scaledHide);
		passToggle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginbg.add(passToggle);

		passToggle.addItemListener(new ItemListener() {
		  @Override
		  public void itemStateChanged(ItemEvent itemEvent) {
			int state = itemEvent.getStateChange();
			if (state == ItemEvent.SELECTED) {
			  passToggle.setIcon(scaledShow);
			  passTf.setEchoChar((char)0);
			} else {
			  passToggle.setIcon(scaledHide);
			  passTf.setEchoChar('\u2022');
			}
		  }
		});
		
		
		flag = false;
		
		JCheckBox rem = new JCheckBox("Remember me");
		rem.setBounds(690,350,288,20);
		rem.setForeground(Color.decode("#b7b7b7"));
		rem.setBackground(Color.WHITE);
		rem.setOpaque(false);
		rem.setFocusable(false);
		rem.setContentAreaFilled(false);
		rem.setFont(new Font("Helvetica",Font.PLAIN,12));
		loginbg.add(rem);
		
		rem.addItemListener(new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			// check if the rem is checked
				if (e.getStateChange() == ItemEvent.SELECTED) {
					rem.setForeground(Color.WHITE);
					flag = true;
				} else {
					rem.setForeground(Color.decode("#b7b7b7"));
					flag = false;
				}
			}
		});

			//sign in button
		
			
			JButton signin = new JButton("Sign In");
			signin.setBounds(693,398,297,47);
			signin.setFont(new Font("Helvetica",Font.BOLD, 22));
			signin.setOpaque(false);
			signin.setForeground(Color.WHITE);
			signin.setContentAreaFilled(false);
			signin.setFocusable(false);
			signin.setBorderPainted(false);
			signin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			loginbg.add(signin);
		
		
		// go to register account
		
		
		JLabel bottomTxt = new JLabel("New to Netflix?");
		bottomTxt.setBounds(765,460,95,15);
		bottomTxt.setForeground(Color.decode("#b7b7b7"));
		bottomTxt.setFont(new Font("Helvetica",Font.PLAIN, 12));
		loginbg.add(bottomTxt);
		
		JButton bottomBtn = new JButton("Sign Up Now.");
		bottomBtn.setBounds(833,460,110,15);
		bottomBtn.setOpaque(false);
		bottomBtn.setFocusable(false);
		bottomBtn.setContentAreaFilled(false);
		bottomBtn.setBorderPainted(false);
		bottomBtn.setForeground(Color.WHITE);
		bottomBtn.setFont(new Font("Helvetica", Font.BOLD, 12));
		bottomBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginbg.add(bottomBtn);
		
		//adding contents
		loginbg.add(home);
		this.add(panel);
		
		
		//--------button backend process start-------------
		
		// clicking on logo working process
			
			initial.getBtn().addActionListener(this);
			home.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Initial frame = new Initial(); // create a new instance of Initial class
					frame.setVisible(true); // show the new Initial frame
					dispose(); // close the current Login frame
				}
			});
			
		//------sign in process------
		
		
		userTf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = userTf.getText();
				
				try (BufferedReader br1 = new BufferedReader(new FileReader("Profile/" + username + ".csv"))) {
					String line;
					while ((line = br1.readLine()) != null) {
						String[] userData = line.split(",");
						String temp = "Saved";
						
						if(userData[0].equals(username) && userData[4].equals(temp)){
							String savedPass = userData[3];
							passTf.setText(savedPass);
							passTf.setEchoChar('\u2022');
							passTf.setForeground(Color.BLACK);
						}else{
							passTf.requestFocus();
						}
					}
					br1.close();
				}
				catch (IOException e1) {
				  e1.printStackTrace();
				  JOptionPane.showMessageDialog(null,"Username does not exist.");
				  userTf.setText("");
				}
				
				if(userTf.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please enter your Username.");
					userTf.requestFocus();
				}else{
					passTf.requestFocus();
				}
			}
		});
		
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				String username = userTf.getText();
				String password = new String(passTf.getPassword());
				
				user = username;
				
				boolean isLoggedIn = false;

				try (BufferedReader br = new BufferedReader(new FileReader("Profile/" + username + ".csv"))) {
				  String line;
				  
				  while ((line = br.readLine()) != null) {
					String[] userData = line.split(",");
					
					if (userData[3].equals(password)) {
						
						isLoggedIn = true;
						
						String name1,email1,gender1,pass1,saved,balance,dpPath;
						
						name1 = userData[0];
						email1 = userData[1];
						gender1 = userData[2];
						pass1 = userData[3];
						balance = userData[5];
						dpPath = userData[6];
						
						if(flag){
							
							String temp = "Saved";
							
							FileWriter writer = new FileWriter("Profile/" + username + ".csv", false);
							writer.write(name1 + "," + email1 + "," + gender1 + "," + pass1 + "," + temp + "," + balance + "," + dpPath + "\n");
							writer.close();
						}
					}
				  }
				} catch (IOException e) {
				  //do nothing
				}

				if (isLoggedIn) {
				  Home h1 = new Home(initial,user);
				  h1.setVisible(true);
				  dispose();
				} else {
				  JOptionPane.showMessageDialog(null,"Invalid username or password.");
				}
			}
		});
		
		
		
		
		//clicking on signup working process
		
			
			bottomBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Registration reg = new Registration(initial); // pass the instance of Initial to Login constructor
					reg.setVisible(true);
					dispose(); // close the current frame
				}
			});
		
	}
	
	// for initial button
	/*public void setUserName(String setName){
		Home h2 = new Home(initial);
		h2.getUserName(setName);
	}*/
	
	
    public void actionPerformed(ActionEvent e1) {
        if (e1.getSource() == initial.getBtn()) { 
            ((CardLayout) initial.getParent().getLayout()).show(initial.getParent(), "card name"); 
        }
		else if (e1.getActionCommand().equals("Back")) { 
            ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "card name"); 
        }
    }
	
	
	
	
}