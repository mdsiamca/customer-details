
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends RegistrationDetails {

	private JFrame frame;
	private JTextField txtRContact;
	private JTextField txtRUsername;
	private JPasswordField txtRPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 389, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(27, 131, 72, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(27, 97, 72, 23);
		frame.getContentPane().add(lblNewLabel);

		// add code to for contact number. if the entered phone number exceeds 11 digits
		// it should show error
		JLabel lbContactNum = new JLabel("Contact Number :");
		lbContactNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbContactNum.setBounds(27, 165, 120, 23);
		frame.getContentPane().add(lbContactNum);

		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("CustomerDetails.txt");
				try {
					f.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				RegistrationDetails.username = txtRUsername.getText();
				RegistrationDetails.password = txtRPassword.getText();
				RegistrationDetails.contactNumber = txtRContact.getText();

				try {
					FileWriter ob = new FileWriter("CustomerDetails.txt", true);
					// validation
					if (txtRUsername.getText().isEmpty() || txtRPassword.getText().isEmpty()
							|| txtRContact.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please fill all the fields");
						ob.close();
						return;
					}
					// validation for contact number is 11 digits
					if (txtRContact.getText().length() != 11) {
						JOptionPane.showMessageDialog(null, "Contact number should be 11 digits");
						ob.close();
						return;
					}
					ob.write("Customer Username : " + txtRUsername.getText() + "\n");
					// ob.write("Customer Username : " + txtRUsername.getText());
					ob.write("Customer Password : " + txtRPassword.getText() + "\n");
					ob.write("Customer Contact Number : " + txtRContact.getText() + "\n");

					ob.close();
					JOptionPane.showMessageDialog(null, "Sign Up Successfull !!");
					txtRUsername.setText(null);
					txtRPassword.setText(null);
					txtRContact.setText(null);

				} catch (IOException c) {
				}
			}
		});
		btnNewButton.setBounds(27, 357, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRUsername.setText(null);
				txtRPassword.setText(null);

			}
		});
		btnNewButton_1.setBounds(146, 357, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Login.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(258, 357, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Agree to System's Terms and Conditions.");
		chckbxNewCheckBox.setBounds(27, 265, 277, 49);
		frame.getContentPane().add(chckbxNewCheckBox);

		JLabel lblNewLabel_3 = new JLabel("REGISTRATION");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 11, 353, 49);
		frame.getContentPane().add(lblNewLabel_3);

		txtRUsername = new JTextField();
		txtRUsername.setBounds(116, 99, 188, 20);
		frame.getContentPane().add(txtRUsername);
		txtRUsername.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		comboBox.setBounds(116, 201, 86, 22);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel_4 = new JLabel("Gender :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(27, 201, 72, 23);
		frame.getContentPane().add(lblNewLabel_4);

		txtRPassword = new JPasswordField();
		txtRPassword.setBounds(116, 132, 188, 20);
		frame.getContentPane().add(txtRPassword);

		txtRContact = new JTextField();
		txtRContact.setBounds(157, 167, 147, 20);
		frame.getContentPane().add(txtRContact);
		txtRContact.setColumns(10);

	}
}
