import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Example {
    private JFrame frame;
    private JPanel panel;
    private JButton button;
	private String path;

    public Example() {
        frame = new JFrame("Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 500, 500);
        frame.add(panel);

		

        button = new JButton("Upload Image");
        button.setBounds(100, 100, 200, 50);
		
		
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif"));
                int result = fileChooser.showOpenDialog(panel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
					path = selectedFile.getAbsolutePath();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    // Do something with the selected file
                }
            }
        });
		
		ImageIcon bgImg = new ImageIcon("image/bg-01.jpg");
        Image img = bgImg.getImage();
        img = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        bgImg = new ImageIcon(img);
        JLabel bg = new JLabel(bgImg);
        bg.setBounds(150, 150, 200, 200);
        panel.add(bg);
		
        panel.add(button);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Example();
    }
}
