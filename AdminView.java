
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.io.FileNotFoundException;

public class AdminView {

	private JFrame frmAdminView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
					window.frmAdminView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminView = new JFrame();
		frmAdminView.setTitle("Admin View");
		frmAdminView.setBounds(100, 100, 804, 515);
		frmAdminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminView.getContentPane().setLayout(null);

		JTextArea textAreaCustomer = new JTextArea();
		textAreaCustomer.setBounds(202, 10, 578, 81);
		frmAdminView.getContentPane().add(textAreaCustomer);

		JTextArea textAreaOrder = new JTextArea();
		textAreaOrder.setText(null);
		textAreaOrder.setBounds(202, 101, 578, 367);
		frmAdminView.getContentPane().add(textAreaOrder);

		JButton btnNewButton = new JButton("New Order\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			// Read the file to show the customer details
			public void actionPerformed(ActionEvent e) {
				try {
					File myObj = new File("CustomerDetails.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						String data = myReader.nextLine();

						textAreaCustomer.append(data + "\n");
						System.out.println(data);
					}
					myReader.close();
				} catch (FileNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "An error occurred.");
					System.out.println("An error occurred.");
					ex.printStackTrace();
				}

				;
			}
		});
		btnNewButton.setBounds(10, 115, 182, 93);
		frmAdminView.getContentPane().add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(null);
				frmAdminView.dispose();
			}
		});
		btnNewButton_2.setBounds(10, 339, 85, 21);
		frmAdminView.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Delevery Done");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File obj = new File("CreateOrder.txt");
				if (obj.delete()) {
					JOptionPane.showMessageDialog(null, "Order Deliver Successfully .");
				}

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(10, 218, 182, 93);
		frmAdminView.getContentPane().add(btnNewButton_1);
	}
}
