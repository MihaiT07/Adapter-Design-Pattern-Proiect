package A2026_J15;

import java.awt.EventQueue;

public class Proiect {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GUI frame = new GUI();
					frame.setVisible(true);
					Control ctr = new Control(frame);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
			}
			
		});
		
	}

}
