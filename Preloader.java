import javax.swing.*;

public class Preloader extends JDialog {

    private JProgressBar progressBar;
    private JLabel statusLabel;

    public Preloader(JFrame parent) {
        
	
		super(parent, "Loading...", true);
	

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);

        statusLabel = new JLabel("Loading...");

        JPanel panel = new JPanel();
        panel.add(progressBar);
        panel.add(statusLabel);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent);
		
		
	
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    public static void main(String[] args) {
        // Create a new JFrame
        Home home = new Home(initial,user);

        // Show the preloader
        Preloader preloader = new Preloader(home);
        preloader.setVisible(true);

        // Simulate a time-consuming task
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hide the preloader
        preloader.setVisible(false);

        
        home.setVisible(true);
    }
}