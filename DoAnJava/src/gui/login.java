package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldtk;
	private JPasswordField passwordField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new login().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setResizable(false);
		setTitle("Trang Chủ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1400,800);
		setLocationRelativeTo(null);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1426, 797);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 225, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(369, 204, 416, 113);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TRAVEL INC");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel_1.setBounds(763, 217, 395, 87);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên tài khoản:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(183, 328, 187, 52);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mật khẩu:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(183, 431, 150, 58);
		contentPane.add(lblNewLabel_3);
		
		textFieldtk = new JTextField();
		textFieldtk.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		textFieldtk.setBounds(368, 328, 762, 58);
		contentPane.add(textFieldtk);
		textFieldtk.setColumns(10);
		
		 btnNewButton = new JButton("Đăng nhập ");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(602, 550, 281, 58);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(368, 435, 762, 58);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FormQLKH.class.getResource("/img/fly.png")));
		label.setBounds(10, 11, 612, 259);
		contentPane.add(label);
		btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnNewButton)){
			if(textFieldtk.getText().equalsIgnoreCase("duanjava")&&passwordField.getText().equalsIgnoreCase("123")) {
				JOptionPane.showMessageDialog(null, "danh nhap thanh conmg");
				TrangChu tr = new TrangChu();
				tr.setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "dang nhap khong thanh cong");
			}
		
		}
	}
}
