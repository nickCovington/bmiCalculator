import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class BmiCalc extends JFrame {

	private JPanel contentPane;
	private JTextField txtHeight;
	private JTextField txtWeight;
	
	double height;
	double weight;
	double result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BmiCalc frame = new BmiCalc();
					frame.setVisible(true);
					frame.setTitle("B.M.I. Calculator");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BmiCalc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterHeight = new JLabel("Enter height (in.):");
		lblEnterHeight.setBounds(16, 44, 113, 13);
		contentPane.add(lblEnterHeight);
		
		txtHeight = new JTextField();
		txtHeight.setBounds(139, 41, 292, 19);
		contentPane.add(txtHeight);
		txtHeight.setColumns(10);
		
		JLabel lblEnterWeight = new JLabel("Enter Weight (lbs):");
		lblEnterWeight.setBounds(11, 99, 118, 13);
		contentPane.add(lblEnterWeight);
		
		txtWeight = new JTextField();
		txtWeight.setBounds(139, 96, 292, 19);
		contentPane.add(txtWeight);
		txtWeight.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(139, 121, 292, 21);
		contentPane.add(btnCalculate);
		
		JLabel lblBMI = new JLabel("Your B.M.I. :");
		lblBMI.setBounds(11, 178, 87, 13);
		contentPane.add(lblBMI);
		
		JLabel lblResult = new JLabel("- - -");
		lblResult.setBounds(104, 178, 327, 13);
		contentPane.add(lblResult);
		
		JLabel lblHealthy = new JLabel("A healthy BMI is b/w 19 <--> 25");
		lblHealthy.setHorizontalAlignment(SwingConstants.LEFT);
		lblHealthy.setBounds(184, 240, 247, 13);
		contentPane.add(lblHealthy);
		
		JLabel lblAdvice = new JLabel("");
		lblAdvice.setForeground(Color.BLUE);
		lblAdvice.setBounds(184, 217, 247, 13);
		contentPane.add(lblAdvice);
	
	
	
	
	
		btnCalculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				height = Integer.parseInt(txtHeight.getText());
				weight = Integer.parseInt(txtWeight.getText());
				result = weight / (height * height) * 703;
				
				lblResult.setText(String.format("%.2f", result));
				
				if (result < 19.0) {
					lblAdvice.setText("Try eating some peanut butter.");
				} else if (result > 25.0) {
					lblAdvice.setText("Try drinking some green tea.");
				} else {
					lblAdvice.setText("Wow, that's a healthy BMI. Good work.");
				}
				
			}
			
		});
	
	
	
	}
}
