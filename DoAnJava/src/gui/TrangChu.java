package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import java.awt.Window.Type;

public class TrangChu extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;
	private JButton btnQuanLiNV,btnQuanLiKH,btnQuanLiTouDL,btnQuanDonTour,btnQuanLiHOaDOn,btnDangXuat;

	public TrangChu() {
		setResizable(false);
		setTitle("Trang Chủ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1400,800);
		setLocationRelativeTo(null);
		gui();
	}
	public void gui() {
		setBounds(100, 100, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(38, 154, 217));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(43, 11, 1276, 62);
		toolBar.setBackground(new Color(255, 255, 255));
		toolBar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		contentPane.add(toolBar);
		
		JButton btnNewButton = new JButton("Đăng nhập   ");
		btnNewButton.setBackground(new Color(255, 179, 102));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/Log-Out-icon.png")));
		//btnNewButton.setIcon(new ImageIcon("C:\\Users\\thien\\OneDrive\\Máy tính\\LAP TRINH HUONG SU KIEN\\BAITAPLON_JAVA\\GiaoDienBaiTapLon\\src\\GUI\\Log-Out-icon.png"));
		toolBar.add(btnNewButton);
		
		btnQuanLiKH = new JButton("Quản lý khách hàng ");
		btnQuanLiKH.setBackground(new Color(255, 179, 102));
		btnQuanLiKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnQuanLiKH.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/home.png")));
		toolBar.add(btnQuanLiKH);
		
		btnQuanLiNV = new JButton("Quản lý nhân viên     ");
		btnQuanLiNV.setBackground(new Color(255, 179, 102));
		btnQuanLiNV.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnQuanLiNV.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/em.png")));
		toolBar.add(btnQuanLiNV);
		
		btnQuanLiTouDL = new JButton("Quản lý tour du lịch     ");
		btnQuanLiTouDL.setBackground(new Color(255, 179, 102));
		btnQuanLiTouDL.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnQuanLiTouDL.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/tour.png")));
		toolBar.add(btnQuanLiTouDL);
		
		btnQuanDonTour = new JButton("Tạo đơn tour     ");
		btnQuanDonTour.setBackground(new Color(255, 179, 102));
		btnQuanDonTour.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnQuanDonTour.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/order.png")));
		toolBar.add(btnQuanDonTour);
		
		btnQuanLiHOaDOn = new JButton("Thống kê đơn tour ");
		btnQuanLiHOaDOn.setBackground(new Color(255, 179, 102));
		btnQuanLiHOaDOn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnQuanLiHOaDOn.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/note.png")));
		toolBar.add(btnQuanLiHOaDOn);
		
		btnDangXuat = new JButton("Đăng xuất     ");
		btnDangXuat.setBackground(new Color(255, 179, 102));
		btnDangXuat.setForeground(new Color(0, 0, 0));
		btnDangXuat.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnDangXuat.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/logout.png")));
		toolBar.add(btnDangXuat);
		
		table = new JTable();
		table.setBounds(5, 62, 0, 633);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 695, 1171, 0);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(53, 83, 400, 616);
		lblNewLabel_1.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/tral6.jpg")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(504, 83, 400, 616);
		lblNewLabel_2.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/travel5.jpg")));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(948, 83, 400, 616);
		lblNewLabel_3.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/travel9.jpg")));
		contentPane.add(lblNewLabel_3);
		
		btnQuanLiKH.addActionListener(this);
		btnQuanLiHOaDOn.addActionListener(this);
		btnQuanLiNV.addActionListener(this);
		btnQuanLiTouDL.addActionListener(this);
		btnQuanDonTour.addActionListener(this);
		btnDangXuat.addActionListener(this);
		
	
	}
	public static void main(String[] args) {
		new TrangChu().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnQuanLiTouDL)) {
			FormTourDL tour = new FormTourDL();
			tour.setVisible(true);
			this.setVisible(false);
		}else if(o.equals(btnQuanLiNV)){
			FormQLNV qlNV = new FormQLNV();
			qlNV.setVisible(true);
			this.setVisible(false);
		}else if(o.equals(btnQuanDonTour)){
			FormDonTour donTour = new FormDonTour();
			donTour.setVisible(true);
			this.setVisible(false);
		}else if(o.equals(btnQuanLiKH)){
			FormQLKH qlKH = new FormQLKH();
			qlKH.setVisible(true);
			this.setVisible(false);
		}else if(o.equals(btnQuanLiHOaDOn)){
			FormHoaDonCT hoaDOn=new FormHoaDonCT();
			hoaDOn.setVisible(true);
			this.setVisible(false);
		}else if(o.equals(btnDangXuat)){
			login lg = new login();
			lg.setVisible(true);
			JOptionPane.showMessageDialog(null, "Bạn đã đăng xuất thành công");
			this.setVisible(false);
		}
	}
}


