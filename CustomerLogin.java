
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Color;

public class CustomerLogin {

    private JFrame frame;
    private JTextField txtCustomerUsername;
    private JPasswordField txtCustomerPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerLogin window = new CustomerLogin();
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
    public CustomerLogin() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 255, 128));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lbCustomerLogin = new JLabel("Customer LOGIN");
        lbCustomerLogin.setFont(new Font("Stencil", Font.BOLD, 18));
        lbCustomerLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lbCustomerLogin.setHorizontalTextPosition(SwingConstants.CENTER);
        lbCustomerLogin.setBounds(91, 11, 218, 38);
        frame.getContentPane().add(lbCustomerLogin);

        JLabel lblNewLabel_1 = new JLabel("Username :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(54, 97, 83, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password :");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(54, 133, 83, 14);
        frame.getContentPane().add(lblNewLabel_2);

        txtCustomerUsername = new JTextField();
        txtCustomerUsername.setBounds(147, 94, 214, 20);
        frame.getContentPane().add(txtCustomerUsername);
        txtCustomerUsername.setColumns(10);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtCustomerUsername.getText();
                String password = txtCustomerPassword.getText();

                if (username.contains("customer") && password.contains("customer")) {
                    txtCustomerUsername.setText(null);
                    txtCustomerPassword.setText(null);
                    AdminView.main(null);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                frame.dispose();
            }
        });
        btnNewButton.setBounds(41, 198, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Reset");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtCustomerUsername.setText(null);
                txtCustomerPassword.setText(null);
            }
        });
        btnNewButton_1.setBounds(182, 198, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Back");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelectUser.main(null);
                frame.dispose();
            }
        });
        btnNewButton_2.setBounds(313, 198, 89, 23);
        frame.getContentPane().add(btnNewButton_2);

        txtCustomerPassword = new JPasswordField();
        txtCustomerPassword.setBounds(147, 130, 214, 20);
        frame.getContentPane().add(txtCustomerPassword);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 166, 414, 2);
        frame.getContentPane().add(separator_1);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 70, 414, 2);
        frame.getContentPane().add(separator);
    }
}
