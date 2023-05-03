package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.HoaDonCT_Dao;
import dao.KhachHang_Dao;
import entity.DonDatTour;
import entity.HoaDonCT;
import entity.KhachHang;
import entity.MycombomaKH;

public class FormHoaDonCT extends JFrame implements ActionListener{
	private JTextField txtmaHD,txtmaTour,txtGiaTien,txtSoLuong,txtdisCount;
	private DefaultTableModel model;
	private JTable table;
	private JComboBox<String> combox1,combox2;
	private HoaDonCT_Dao ds;
	private JButton btnTroVe,btnLuu,btnSua,btnThem,btnXoa;
	public FormHoaDonCT() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		setTitle("QUẢN LÝ KHÁCH HÀNG");
		setSize(1400,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		gui();
	}
	public void gui() {
		getContentPane().setLayout(null);
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(new Color(24, 174, 231));
		pnNorth.setForeground(new Color(255, 255, 0));
		pnNorth.setBounds(0, 0, 1386, 41);
		pnNorth.setLayout(null);
		
		btnTroVe = new JButton("Quay lại ");
		btnTroVe.setBackground(new Color(241, 176, 56));
		btnTroVe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnTroVe.setForeground(new Color(255, 255, 255));
		btnTroVe.setIcon(new ImageIcon(FormQLKH.class.getResource("/img/sd.png")));
		btnTroVe.setBounds(48, 0, 136, 41);
		pnNorth.add(btnTroVe);
		JLabel lblNewLabeltitle = new JLabel("THỐNG KÊ ĐƠN TOUR");
		lblNewLabeltitle.setBounds(608, 5, 310, 31);
		lblNewLabeltitle.setForeground(new Color(255, 255, 255));
		lblNewLabeltitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnNorth.add(lblNewLabeltitle);
		getContentPane().add(pnNorth);
		
		Box BE = Box.createHorizontalBox();
		BE.setBounds(0, 41, 1386, 708);
		
		JPanel paneleft = new JPanel();
		paneleft.setBackground(new Color(24, 174, 231));
		paneleft.setPreferredSize(new Dimension(700,800));
		paneleft.setLayout(null);
	
		Box b = Box.createVerticalBox();
		b.setBounds(56, 5, 450, 300);
		Component verticalStrut_1 = Box.createVerticalStrut(30);
		b.add(verticalStrut_1);
		paneleft.add(b);
		Box b1 = Box.createHorizontalBox();
	
		b.add(b1);
		JLabel lbMahd = new JLabel("Mã Hóa Đơn:");
		lbMahd.setBackground(new Color(255, 179, 102));
		lbMahd.setForeground(new Color(255, 0, 0));
		lbMahd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		b1.add(lbMahd);
		combox1 = new JComboBox();
		b.add(Box.createVerticalStrut(20));
		//b3
		Box b3 = Box.createHorizontalBox();
		b.add(b3);
		JLabel lbMATour = new JLabel("Mã Tour:");
		lbMATour.setForeground(new Color(255, 0, 0));
		lbMATour.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		b3.add(lbMATour);
		combox2 = new JComboBox();
		b.add(Box.createVerticalStrut(20));

		//b4
		Box b4 = Box.createHorizontalBox();
		b.add(b4);
		JLabel lblgiaTien = new JLabel("Giá Tiền : ");
		lblgiaTien.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblgiaTien.setForeground(new Color(255, 0, 0));
		b4.add(lblgiaTien);
		txtGiaTien = new JTextField();
		b4.add(txtGiaTien);
		b.add(Box.createVerticalStrut(20));
		//b5
		Box b5 = Box.createHorizontalBox();
		b.add(b5);
		JLabel lbSL = new JLabel("Số Lượng Người Trong Tour :");
		lbSL.setForeground(new Color(255, 0, 0));
		lbSL.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		b5.add(lbSL);
		txtSoLuong = new JTextField();
		b5.add(txtSoLuong);
		b.add(Box.createVerticalStrut(20));
		//b6
		Box b6 = Box.createHorizontalBox();
		b.add(b6);
		JLabel lbDis = new JLabel("DisCount :");
		lbDis.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbDis.setForeground(new Color(255, 0, 0));
		b6.add(lbDis);
		txtdisCount = new JTextField();
		b6.add(txtdisCount);
		b.add(Box.createVerticalStrut(20));
		
		

		//
		lbMahd.setPreferredSize(lbSL.getPreferredSize());
		lbMATour.setPreferredSize(lbSL.getPreferredSize());
		lblgiaTien.setPreferredSize(lbSL.getPreferredSize());
		lbDis.setPreferredSize(lbSL.getPreferredSize());
		
		//righ
		Box b11 = Box.createVerticalBox();
		model = new DefaultTableModel();
		model.addColumn("Mã Hóa Đơn");
		model.addColumn("Mã Tour");
		model.addColumn("Giá Tiền");
		model.addColumn("Số lượng người trong tour");
		model.addColumn("Discount");
	
	
		 btnThem = new JButton("Thêm Hóa Đơn");
		btnThem.setBackground(new Color(255, 179, 102));
		btnThem.setForeground(new Color(255, 0, 0));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnThem.setBounds(123, 567, 145, 41);
		paneleft.add(btnThem);
		
		 btnXoa = new JButton("Xóa Hóa Đơn");
		btnXoa.setBackground(new Color(255, 179, 102));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnXoa.setForeground(new Color(255, 0, 0));
		btnXoa.setBounds(123, 642, 145, 43);
		paneleft.add(btnXoa);
		
		 btnSua = new JButton("Sửa thông tin");
		btnSua.setBackground(new Color(255, 179, 102));
		btnSua.setForeground(new Color(255, 0, 0));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnSua.setBounds(326, 642, 156, 43);
		paneleft.add(btnSua);
		
		 btnLuu = new JButton("Lưu vào danh sách");
		btnLuu.setBackground(new Color(255, 179, 102));
		btnLuu.setForeground(new Color(255, 0, 0));
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnLuu.setBounds(326, 566, 156, 43);
		paneleft.add(btnLuu);
		
		JLabel lbanh1 = new JLabel("");
		lbanh1.setIcon(new ImageIcon(FormHoaDonCT.class.getResource("/img/s.jpg")));
		lbanh1.setBounds(26, 0, 542, 493);
		paneleft.add(lbanh1);
		
		JLabel lblanh2 = new JLabel("New label");
		lblanh2.setBounds(26, 514, 542, 184);
		paneleft.add(lblanh2);
		lblanh2.setIcon(new ImageIcon(FormHoaDonCT.class.getResource("/img/bg.jpg")));
		
	
		BE.add(b11);
		BE.add(paneleft);
	
		getContentPane().add(BE);
	
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(-89, 5, 1000, 10);
		scrollPane.setBackground(new Color(241, 176, 56));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(1000, 10));
		scrollPane.setBorder(BorderFactory.createTitledBorder("Danh Sách Hóa Đơn:"));
		b11.add(scrollPane);
		table.setRowHeight(25);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 174, 231));
		b11.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 807, 339);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(FormHoaDonCT.class.getResource("/img/Khachquoctethang9-1632898673870.jpg")));
		ds = new HoaDonCT_Dao();
		table.setRowHeight(25);
		
		for (HoaDonCT hd: ds.getAllHoaDonCT()) {
			Object [] rowData= {hd.getMaHd(),hd.getMaTour(),hd.getGiaTien(),hd.getSoLuong(),hd.getDiscount()};
			model.addRow(rowData);
		}
		for (MycombomaKH ma : ds.getmaHD()) {
			String row = ma.getText();
			combox1.addItem(row);
		}
		combox1.setPreferredSize(new Dimension(10,35));
		b1.add(combox1);
		for (MycombomaKH ma : ds.getmaTour()) {
			String row = ma.getText();
			combox2.addItem(row);

		}
		combox2.setPreferredSize(new Dimension(10,35));
		b3.add(combox2);
		btnTroVe.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new FormHoaDonCT().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnTroVe)) {
			TrangChu chinh = new TrangChu();
			chinh.setVisible(true);
			this.setVisible(false);
		}else if(o.equals(btnThem)) {
			if(btnThem.getText().equalsIgnoreCase("thêm hóa đơn")) {
				btnXoa.setEnabled(false);
				btnSua.setEnabled(false);
				btnLuu.setEnabled(true);
				btnThem.setEnabled(true);
				btnThem.setText("huy");
			}else if(btnThem.getText().equalsIgnoreCase("huy")) {
				btnXoa.setEnabled(true	);
				btnSua.setEnabled(true);
				btnLuu.setEnabled(false);
				btnThem.setText("them");
			}
		}else if(o.equals(btnLuu)) {
			String maHD = (String) combox1.getSelectedItem();
			String maTour = (String) combox2.getSelectedItem();
				
			HoaDonCT hoaDonCt = new HoaDonCT(maHD, maTour, Double.parseDouble(txtGiaTien.getText()), Integer.parseInt(txtSoLuong.getText()), Double.parseDouble(txtdisCount.getText()));
			
			JOptionPane.showMessageDialog(null, "them thanh cong");
			String row[]= {maHD, maTour, txtGiaTien.getText(),txtSoLuong.getText(),txtdisCount.getText()};
			model.addRow(row);

		}else if(o.equals(btnXoa)) {

			int r = table.getSelectedRow();
			if(r != -1)
			{
				int tb = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa dòng này không?","Delete",JOptionPane.YES_NO_OPTION);
				if(tb == JOptionPane.YES_OPTION){
					ds.xoa(model.getValueAt(r,0).toString());
					model.removeRow(r);

				}
			}
		}else if(o.equals(btnSua)) {
			int r = table.getSelectedRow();
			if(r != -1) {
				try {
					String ma= model.getValueAt(r,0).toString();
					String matour  = JOptionPane.showInputDialog("Enter new Mã Tour:");
					String giatien = JOptionPane.showInputDialog("Enter new giá tiền:");
					String sluong = JOptionPane.showInputDialog("Enter new Số Lượng Người:");
					String discount = JOptionPane.showInputDialog("Enter new discount:");
					
					HoaDonCT hoaDonCT = new HoaDonCT(ma, matour, Double.parseDouble(giatien), Integer.parseInt(sluong),Double.parseDouble(discount));


					ds.sua(hoaDonCT);
					model.setValueAt(matour, r, 1);
					model.setValueAt(giatien, r, 2);
					model.setValueAt(sluong, r, 3);
					model.setValueAt(discount, r, 4);

					JOptionPane.showMessageDialog(null, "bạn đã chập nhật thành công");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}

		}
	}
	
}
