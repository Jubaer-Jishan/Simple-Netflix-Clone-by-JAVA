import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Initial extends JFrame implements ActionListener{
	
	public JButton getBtn() {
    JButton btn = new JButton("Click me!");
    return btn;
	}

	public Initial(){
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        setSize(1080,650);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		// Calculate top-left corner of the frame
		int x = (screenWidth - 1080) / 2;
		int y = (screenHeight - 650) / 2;
		
		setLocation(x,y);
		
		setTitle("Netflix- Unlimited Streaming Platform");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon("image/icon-01.png");
		setIconImage(icon.getImage());
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		ImageIcon bgImg = new ImageIcon("image/bg-01.jpg");
        Image img = bgImg.getImage();
        img = img.getScaledInstance(1080, 650, Image.SCALE_SMOOTH);
        bgImg = new ImageIcon(img);
        JLabel bg = new JLabel(bgImg);
        bg.setBounds(0, 0, getWidth(), getHeight());
        panel.add(bg);
		
		ImageIcon bgImg2 = new ImageIcon("image/bg-02.jpg");
        Image img2 = bgImg2.getImage();
        img2 = img2.getScaledInstance(1080, 600, Image.SCALE_SMOOTH);
        bgImg2 = new ImageIcon(img2);
        JLabel bg2 = new JLabel(bgImg2);
        bg2.setBounds(0, 0, getWidth(), getHeight());
        panel.add(bg2);
		
		ImageIcon bgImg3 = new ImageIcon("image/bg-03.jpg");
        Image img3 = bgImg3.getImage();
        img3 = img3.getScaledInstance(1080, 600, Image.SCALE_SMOOTH);
        bgImg3 = new ImageIcon(img3);
        JLabel bg3 = new JLabel(bgImg3);
        bg3.setBounds(0, 0, getWidth(), getHeight());
        panel.add(bg3);
		
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(0, 0, 1080, 650);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(25);
		scrollPane.getVerticalScrollBar().setOpaque(false);
		add(scrollPane);
		
		
		JButton btn = new JButton("G E T   S T A R T E D");
		btn.setOpaque(true);
		btn.setBounds(450,450,180,47);
		btn.setBackground(Color.RED);
		btn.setForeground(Color.WHITE);
		btn.setBorderPainted(false);
		btn.setFocusable(false);
		btn.setFont(new Font("Helvetica", Font.PLAIN, 14));
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bg.add(btn);
		
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				Registration reg = new Registration(Initial.this);
				reg.setVisible(true);
				dispose();
				
			}
		});
		
		JButton signIn = new JButton("Sign In");
		signIn.setOpaque(false);
		signIn.setBounds(880,50,100,30);
		signIn.setContentAreaFilled(false);
		signIn.setForeground(Color.WHITE);
		signIn.setBorder(new LineBorder(Color.RED, 2));
		signIn.setFocusable(false);
		signIn.setFont(new Font("Helvetica", Font.BOLD, 15));
		signIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bg.add(signIn);
		
		signIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				Login login = new Login(Initial.this);
				login.setVisible(true);
				dispose();
				
			}
		});
		
	}
	

	public void actionPerformed(ActionEvent e) {
	    
	}
}
