import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;


public class Admin extends JFrame implements ActionListener{
	
	private JComboBox genre;
	private String thumbPath;
	
	public Admin(){		

		int frameWidth = 720;
		int frameHeight = 405;
		setSize(frameWidth, frameHeight);

		// Get screen dimensions
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		// Calculate top-left corner of the frame
		int x = (screenWidth - frameWidth) / 2;
		int y = (screenHeight - frameHeight) / 2;

		

		//frame.setVisible(true);
		
		
		ImageIcon icon = new ImageIcon("image/icon-01.png");
		setIconImage(icon.getImage());
		
		JPasswordField passwordField = new JPasswordField();
		Window window = SwingUtilities.getWindowAncestor(passwordField);
		passwordField.setFont(new Font("Helvetica",Font.BOLD,17));
		boolean retry = false;
		int option;
		
		do {
			option = JOptionPane.showConfirmDialog(null, passwordField, "Enter password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (option == JOptionPane.OK_OPTION) {
				String password = new String(passwordField.getPassword());
				System.out.println(password);
				
				if(password.equals("888")){
					
					retry = false;
					
					// Set frame location
					setLocation(x, y);
					setTitle("Netflix- Admin Panel");
					setResizable(false);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					JPanel container = new JPanel();
					container.setLayout(null);
					
					JLabel heading = new JLabel("Add Content From Here");
					heading.setBounds(90,30,540,50);
					heading.setFont(new Font("Helvetica", Font.BOLD, 45));
					heading.setForeground(Color.decode("#060d3a"));
					container.add(heading);
					
					JLabel nameLabel = new JLabel("Content Name: ");
					nameLabel.setBounds(180,130,120,30);
					nameLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
					container.add(nameLabel);
					
					JTextField name = new JTextField();
					name.setBounds(300,130,250,30);
					container.add(name);
					
					JLabel genreLabel = new JLabel("Content Genre: ");
					genreLabel.setBounds(180,165,120,30);
					genreLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
					container.add(genreLabel);
					
					String[] items = {"--- Select here ---","Movie","Webseries"};
					genre = new JComboBox(items);
					genre.setBounds(300,165,250,30);
					genre.setOpaque(true);
					genre.setBackground(Color.WHITE);
					container.add(genre);

					JLabel priceLabel = new JLabel("Content Price: ");
					priceLabel.setBounds(180,200,120,30);
					priceLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
					container.add(priceLabel);
					
					JTextField price = new JTextField();
					price.setBounds(300,200,125,30);
					container.add(price);
					
					price.addKeyListener(new KeyAdapter() {
					 public void keyPressed(KeyEvent ke) {
						String value = price.getText();
						int l = value.length();
						if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
						   //nothing
						} else {
						   JOptionPane.showMessageDialog(null,"Only numerical value");
						   price.setText("");
						}
					 }
				  });
					
					JButton upThumbnail = new JButton("Thumbnail");
					upThumbnail.setBounds(435,200,115,30);
					upThumbnail.setFont(new Font("Helvetica", Font.BOLD, 12));
					upThumbnail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					container.add(upThumbnail);
					
					JButton submit = new JButton("Submit");
					submit.setBounds(180,240,370,30);
					submit.setOpaque(true);
					submit.setBackground(Color.decode("#060d3a"));
					submit.setForeground(Color.WHITE);
					submit.setBorderPainted(false);
					submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					container.add(submit);
					
					add(container);
							
					upThumbnail.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							JFileChooser thumbChoose = new JFileChooser();
							thumbChoose.setFileFilter(new FileNameExtensionFilter("Images","jpg","jpeg","png"));
							int res = thumbChoose.showOpenDialog(Admin.this);
							if(res == JFileChooser.APPROVE_OPTION){
								File selectedFile = thumbChoose.getSelectedFile();
								
								try{
									Image selectedImage = ImageIO.read(selectedFile);
									thumbPath = selectedFile.getAbsolutePath();
									
									if(thumbPath != null){
										upThumbnail.setText(thumbPath);
									}else{
										upThumbnail.setText("Thumbnail");
									}
									
								}catch(IOException ex){
									JOptionPane.showMessageDialog(null,"This file can not be added","Error",JOptionPane.WARNING_MESSAGE);
								}
							}
						}
					});
					
					submit.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							
							String contentName = name.getText();
							String contentGen = (String)genre.getSelectedItem();
							String contentPrice = price.getText();
							String contentPath = thumbPath;
							
							if(!contentName.isEmpty() && !contentPath.isEmpty() &&
								!contentPrice.isEmpty() && contentGen != "--- Select here ---"){
			
								saveData(contentName,contentGen,contentPrice,contentPath);
								JOptionPane.showMessageDialog(null,"Content added successfully.");
			
								name.setText("");
								genre.setSelectedItem("--- Select here ---");
								price.setText("");
								upThumbnail.setText("Thumbnail");
							}else{
								JOptionPane.showMessageDialog(null,"Please fill up all the information");
							}
						}
					});
					
				}else{
					JOptionPane.showMessageDialog(null,"Wrong Password","User Restricted",JOptionPane.WARNING_MESSAGE);
					passwordField.setText("");
					retry = true;
				}
				
			}else if(option == JOptionPane.CANCEL_OPTION){
				
				System.exit(0);
			}
		} while (retry==true);
		
	}
	
	
	
	public void saveData(String name, String genre, String price, String path){
		try{
			FileWriter writer = new FileWriter("contents/data/all_content.csv",true);
			writer.write(name + "," + genre + "," + price + ","+ path + "\n");
			writer.close();
			
			if(genre.equals("Movie")){
				FileWriter writer1 = new FileWriter("contents/data/movie.csv",true);
				writer1.write(name + "," + genre + "," + price + ","+ path + "\n");
				writer1.close();
			}else if(genre.equals("Webseries")){
				FileWriter writer2 = new FileWriter("contents/data/webseries.csv",true);
				writer2.write(name + "," + genre + "," + price + ","+ path + "\n");
				writer2.close();
			}
		}catch(IOException e1){
			e1.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e){
		//nothing
	}
	
	public static void main(String[]args){
		
		Admin admin = new Admin();
		admin.setVisible(true);
	}
}