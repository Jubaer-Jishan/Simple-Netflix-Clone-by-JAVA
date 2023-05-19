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

public class Registration extends JFrame implements ActionListener{
	
	//private Login login;
	private Initial initial;
	private EmailValidator emailValidator = new EmailValidator();

	
	public Registration(Initial initial){
		
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
		
		setTitle("Sign Up Your Account");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set background
		
		ImageIcon regbgImg = new ImageIcon("image/regbg-01.jpg");
        Image img = regbgImg.getImage();
        img = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        regbgImg = new ImageIcon(img);

        JLabel regbg = new JLabel(regbgImg);
        regbg.setBounds(0, 0, getWidth(), getHeight());
        add(regbg);
		
		
		//creating button for back
		
		JButton home = new JButton();
		home.setBounds(30,13,120,32);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.setFocusable(false);
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		regbg.add(home);
		
		// clicking on logo working process
		
		initial.getBtn().addActionListener(this);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Initial frame = new Initial(); // create a new instance of Initial class
				frame.setVisible(true); // show the new Initial frame
				dispose(); // close the current Login frame
			}
		});
		
		
		
		
		// ---------creating the info part----------
		
		Font infoFont = new Font("Helvetica", Font.PLAIN, 15);
		
		//user name
		
		JTextField userName = new JTextField("Enter your username...");
		userName.setBounds(390,165,288,30);
		userName.setOpaque(false);
		userName.setFont(infoFont);
		userName.setBorder(BorderFactory.createEmptyBorder());
		userName.setForeground(Color.decode("#5a5a5a"));
		regbg.add(userName);
		
		userName.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (userName.getText().equals("Enter your username...")) {
					userName.setText("");
					userName.setForeground(Color.WHITE);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if (userName.getText().equals("")) {
					userName.setText("Enter your username...");
					userName.setForeground(Color.decode("#5a5a5a"));
				}
			}
		});
				
		//email
		
		JTextField email = new JTextField("Enter a valid email...");
		email.setBounds(390,232,288,30);
		email.setOpaque(false);
		email.setFont(infoFont);
		email.setBorder(BorderFactory.createEmptyBorder());
		email.setForeground(Color.decode("#5a5a5a"));
		regbg.add(email);
		
		userName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if(userName.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please enter a User Name.");
					userName.requestFocus();
				}else{
					email.requestFocus();
				}
			}
		});
		email.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (email.getText().equals("Enter a valid email...")) {
					email.setText("");
					email.setForeground(Color.WHITE);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if (email.getText().equals("")) {
					email.setText("Enter a valid email...");
					email.setForeground(Color.decode("#5a5a5a"));
				}
			}
		});
		//gender section
		
		JRadioButton r1 = new JRadioButton("Male");
		r1.setBounds(390,305,100,30);
		r1.setOpaque(false);
		r1.setFocusable(false);
		r1.setForeground(Color.WHITE);
		r1.setFont(infoFont);
		r1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		regbg.add(r1);
		
		JRadioButton r2 = new JRadioButton("Female");
		r2.setBounds(490,305,100,30);
		r2.setOpaque(false);
		r2.setFocusable(false);
		r2.setForeground(Color.WHITE);
		r2.setFont(infoFont);
		r2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		regbg.add(r2);
		
		JRadioButton r3 = new JRadioButton("Others");
		r3.setBounds(590,305,100,30);
		r3.setOpaque(false);
		r3.setFocusable(false);
		r3.setForeground(Color.WHITE);
		r3.setFont(infoFont);
		r3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		regbg.add(r3);
		
		//button grouping
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(r1);
		bGroup.add(r2);
		bGroup.add(r3);
		
		// password section
		
		JPasswordField pass = new JPasswordField("Enter your password...");
		pass.setBounds(390,362,253,30);
		pass.setOpaque(false);
		pass.setFont(infoFont);
		pass.setEchoChar((char)0);
		pass.setBorder(BorderFactory.createEmptyBorder());
		pass.setForeground(Color.decode("#5a5a5a"));
		regbg.add(pass);
		
		pass.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pass.getText().equals("Enter your password...")) {
					pass.setText("");
					pass.setEchoChar('\u2022');
					pass.setForeground(Color.WHITE);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if (pass.getText().equals("")) {
					pass.setText("Enter your password...");
					pass.setForeground(Color.decode("#5a5a5a"));
					pass.setEchoChar((char)0);
				}
			}
		});
		
		
		final ImageIcon show = new ImageIcon("image/showWhite-01.png");
		final ImageIcon scaledShow = new ImageIcon(show.getImage().getScaledInstance(28, 15, Image.SCALE_SMOOTH));

		final ImageIcon hide = new ImageIcon("image/hideWhite-01.png");
		final ImageIcon scaledHide = new ImageIcon(hide.getImage().getScaledInstance(28, 20, Image.SCALE_SMOOTH));

		JToggleButton passToggle = new JToggleButton();
		passToggle.setBounds(645,362,35,25);
		passToggle.setOpaque(false);
		passToggle.setContentAreaFilled(false);
		passToggle.setBorderPainted(false);
		passToggle.setFocusable(false);
		passToggle.setIcon(scaledHide);
		passToggle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		regbg.add(passToggle);

		passToggle.addItemListener(new ItemListener() {
		  @Override
		  public void itemStateChanged(ItemEvent itemEvent) {
			int state = itemEvent.getStateChange();
			if (state == ItemEvent.SELECTED) {
			  passToggle.setIcon(scaledShow);
			  pass.setEchoChar((char)0);
			} else {
			  passToggle.setIcon(scaledHide);
			  pass.setEchoChar('\u2022');
			}
		  }
		});


		
				
		email.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if(email.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please enter your E-mail.");
					email.requestFocus();
				}else{
					bGroup.setSelected(r1.getModel(), true);
					pass.requestFocus();
				}
			}
		});
		
		//checkbox
		
		JCheckBox policy = new JCheckBox("I accept all the Terms & Conditions.");
		policy.setBounds(387,402,288,20);
		policy.setForeground(Color.decode("#b7b7b7"));
		policy.setBackground(Color.WHITE);
		policy.setOpaque(false);
		policy.setFocusable(false);
		policy.setContentAreaFilled(false);
		policy.setFont(new Font("Helvetica",Font.PLAIN,12));
		policy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		regbg.add(policy);
		
		policy.addItemListener(new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			// check if the policy is checked
				if (e.getStateChange() == ItemEvent.SELECTED) {
					policy.setForeground(Color.WHITE);
				} else {
					policy.setForeground(Color.decode("#b7b7b7"));
				}
			}
		});
		
		// sign up button creation
		
		JButton signUp = new JButton("Sign Up");
		signUp.setBounds(387,443,290,42);
		signUp.setFont(new Font("Helvetica",Font.BOLD, 20));
		signUp.setOpaque(false);
		signUp.setForeground(Color.WHITE);
		signUp.setContentAreaFilled(false);
		signUp.setFocusable(false);
		signUp.setBorderPainted(false);
		signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		regbg.add(signUp);
		
		pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if(String.valueOf(pass.getPassword()).isEmpty()){
					JOptionPane.showMessageDialog(null,"You must have to enter a password.");
					pass.requestFocus();
				}else{
					signUp.requestFocusInWindow();
				}
			}
		});
		
		
		JButton bottomBtn = new JButton("Sign In.");
		bottomBtn.setBounds(560,493,80,30);
		bottomBtn.setOpaque(false);
		bottomBtn.setFocusable(false);
		bottomBtn.setContentAreaFilled(false);
		bottomBtn.setBorderPainted(false);
		bottomBtn.setForeground(Color.WHITE);
		bottomBtn.setFont(new Font("Helvetica", Font.BOLD, 12));
		bottomBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		regbg.add(bottomBtn);
		
		bottomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                bottomBtn.setBackground(Color.RED);
                Login login = new Login(initial); // pass the instance of Initial to Login constructor
                login.setVisible(true);
                dispose(); // close the current frame
            }
		});
		
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = userName.getText();
				
				if (name.contains(" ") || name.contains(",") || name.contains("(") || name.contains(")") ||
					name.contains("{") || name.contains("}") || name.contains("[") || name.contains("]"))
				{
					JOptionPane.showMessageDialog(null, "Username can only contain Characters, Special Characters & Numbers");
					userName.setText("Enter your username...");
					return;
				}else if(name.isEmpty()){
					JOptionPane.showMessageDialog(null,"Username can not be empty!");
					return;
				}
				String mail = email.getText();
				
				 if(mail.isEmpty()){
					JOptionPane.showMessageDialog(null,"E-mail can not be empty!");
					return;
				}else if (!emailValidator.validate(mail)) {
					JOptionPane.showMessageDialog(null,"Invalid email address!");
					email.setText("Enter a valid email...");
					return;
				}	
					
		
				String gender = "";
				if (r1.isSelected()) {
					gender = "Male";
				} else if (r2.isSelected()) {
					gender = "Female";
				} else if (r3.isSelected()) {
					gender = "Others";
				}
				
				String password = new String(pass.getPassword());
				
				
		//---------An username or email can be used only once----------
				
				try (BufferedReader br = new BufferedReader(new FileReader("Profile/" + name + ".csv"))) {
					  
					  JOptionPane.showMessageDialog(null,"Username already exist");
					  userName.setText("");
					  
				} catch (IOException ev) {
				  //username is available
				}
				
		
		//-------------------********-------------------

				if(userName.getText().isEmpty() || email.getText().isEmpty() ||
					String.valueOf(pass.getPassword()).isEmpty() || gender.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please fill out all the information");
				}else{
					
					if (password.length()<6 || password.length()>18) {
					JOptionPane.showMessageDialog(null,"Password must be within 6 - 18 digit");
					pass.setText("");
					return;
					}
					
					if(!policy.isSelected()){
						
						JOptionPane.showMessageDialog(null,"Please agree to the terms and conditions.");
						
					}else{
					
						saveUserData(name, mail, gender, password);
						
						// going to login page---
						
						Login login = new Login(initial);
						login.setVisible(true);
						dispose();
					}
				}
				
			}
		});


	}
	
	
	private void saveUserData(String userName, String email, String gender, String password) {
		try {
			FileWriter writer = new FileWriter("Profile/" + userName + ".csv",true);
			writer.write(userName + "," + email + "," + gender + "," + password + ",notSaved,20,image/dp-01.png\n");
			writer.close();
			
			FileWriter writer2 = new FileWriter("Profile/" + userName +"_fav.csv",true);
			writer2.close();
			
			FileWriter writer3 = new FileWriter("Profile/" + userName +"_buy.csv",true);
			writer3.close();
			
			JOptionPane.showMessageDialog(null, "User registered successfully.");
			JOptionPane.showMessageDialog(null, "Congratulations! You recieved 20 FlixCoins!!!");
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error while saving user data!");
			e.printStackTrace();
		}
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    // Handle button clicks or other events here
	}
}