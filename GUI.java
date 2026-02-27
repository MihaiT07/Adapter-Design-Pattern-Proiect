package A2026_J15;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JFormattedTextField;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	private JTextField input;
	private JTextField rez;
	private JTextField textField_2;
	private JButton btn;
	private JComboBox<String> selec1;
	private JComboBox<String> selec2;
	private JMenuItem mnitm1;
	private JMenuItem mnitm2;
	private JMenuItem mnitm3;
	private JFormattedTextField input;
//	private JFormattedTextField rez;  

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menu = new JMenuBar();
		menu.setBounds(0, 0, 560, 30);
		contentPane.add(menu);
		
		JMenu mn = new JMenu("Tip Conversie");
		mn.setHorizontalTextPosition(SwingConstants.LEFT);
		mn.setHorizontalAlignment(SwingConstants.LEFT);
		mn.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menu.add(mn);
		
		mnitm1 = new JMenuItem("Capacitate memorie");
		mnitm1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mnitm1.setHorizontalAlignment(SwingConstants.LEFT);
		mnitm1.setHorizontalTextPosition(SwingConstants.LEFT);
		mn.add(mnitm1);
		
		mnitm2 = new JMenuItem("Baze de numeratie");
		mnitm2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mnitm2.setHorizontalTextPosition(SwingConstants.LEFT);
		mnitm2.setHorizontalAlignment(SwingConstants.LEFT);
		mn.add(mnitm2);
		
		mnitm3 = new JMenuItem("Schimb valutar");
		mnitm3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mnitm3.setHorizontalTextPosition(SwingConstants.LEFT);
		mnitm3.setHorizontalAlignment(SwingConstants.LEFT);
		mn.add(mnitm3);
		
		selec2 = new JComboBox<String>();
		selec2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		selec2.setBounds(332, 173, 150, 22);
		contentPane.add(selec2);
		
		btn = new JButton("Start conversie");
		btn.setBounds(197, 173, 125, 23);
		contentPane.add(btn);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setDisabledTextColor(SystemColor.desktop);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_2.setText("-->");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(197, 101, 125, 42);
		contentPane.add(textField_2);
		
		selec1 = new JComboBox<String>()  ;
		selec1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		selec1.setBounds(37, 173, 150, 22);
		contentPane.add(selec1);
		
		input = new JFormattedTextField();
		
		input.setHorizontalAlignment(SwingConstants.CENTER);
		input.setBounds(37, 104, 150, 42);
		contentPane.add(input);
		
		rez = new JTextField();
		rez.setHorizontalAlignment(SwingConstants.CENTER);
		rez.setEnabled(false);
		rez.setEditable(false);
		rez.setDisabledTextColor(Color.BLACK);
		rez.setBounds(332, 101, 150, 42);
		contentPane.add(rez);

	}
	
	JFormattedTextField getInput() {
		return input;
	}
	
//	JFormattedTextField getRez() {
//		return rez;
//	}
	
	JTextField getRez() {
		return rez;
	}
	
	JButton getBtn() {
		return btn;
	}
	
	JComboBox<String> getselec1() {
		return selec1;
	}
	
	JComboBox<String> getselec2() {
		return selec2;
	}
	
	JMenuItem getmnitm1() {
		return mnitm1;
	}
	
	JMenuItem getmnitm2() {
		return mnitm2;
	}
	
	JMenuItem getmnitm3() {
		return mnitm3;
	}
}

	

