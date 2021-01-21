
public class AttendanceFrame extends JFrame {

	public AttendanceFrame() {
		// Set the applicable sizes
		setMinimumSize(new Dimension(800, 550));
		setPreferredSize(new Dimension(800, 550));
		
		// Set main background to white
		setBackground(Color.WHITE);
		
		// Set title
		setTitle("PUP-SIMS");
		
		// When this frame is closed, the JFrame gets dumped
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set location to middle of screen
		setLocationRelativeTo(null);
	}

}