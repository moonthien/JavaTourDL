package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;

import dao.NhanVien_Dao;
import entity.KhachHang;
import entity.NhanVien;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FormQLNV extends JFrame  implements ActionListener{
	private DefaultTableModel model;
	private JButton btnTroVe,btnLuu,btnSua,btnThem,btnXoa;
	private JTextField txtmaNV;
	private JTextField txtHo;
	private JTextField txtTennv;
	private JTextField txtDiaChi;
	private JTextField txtThanhPho;
	private JTextField textQuocGia;
	private JTextField txtSDT;
	private JTextField txtGioiTinh;
	private JTextField txtTuoi;
	private JTextField txtCMNN;
	private JTable table;
	private NhanVien_Dao dss;
	public FormQLNV() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		setTitle("QUẢN LÝ NHÂN VIÊN");
		setSize(1400,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		gui();
	}
	public void gui() {
		getContentPane().setLayout(null);
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(new Color(38, 154, 217));
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
		JLabel lblNewLabeltitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabeltitle.setBounds(608, 5, 290, 31);
		lblNewLabeltitle.setForeground(new Color(255, 255, 255));
		lblNewLabeltitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnNorth.add(lblNewLabeltitle);
		getContentPane().add(pnNorth);
		
		Box BE = Box.createHorizontalBox();
		BE.setBounds(0, 41, 1386, 708);
		
		JPanel paneleft = new JPanel();
		paneleft.setBackground(new Color(38, 154, 217));
		paneleft.setPreferredSize(new Dimension(700,800));
		paneleft.setLayout(null);
	
		Box b = Box.createVerticalBox();
		b.setBounds(56, 5, 354, 350);
		Component verticalStrut_1 = Box.createVerticalStrut(30);
		b.add(verticalStrut_1);
		paneleft.add(b);
		//b1
		Box b1 = Box.createHorizontalBox();
		
		b.add(b1);
		JLabel lbMaKH = new JLabel("Mã Nhân Viên:");
		lbMaKH.setForeground(new Color(245, 51, 10));
		lbMaKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		b1.add(lbMaKH);
		txtmaNV = new JTextField();
		b1.add(txtmaNV);
		b.add(Box.createVerticalStrut(10));
		//b2
		Box b2 = Box.createHorizontalBox();
		b.add(b2);
		JLabel lbHoNV = new JLabel("Họ Nhân Viên:");
		lbHoNV.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lbHoNV.setForeground(new Color(255, 0, 0));
		b2.add(lbHoNV);
		txtHo = new JTextField();
		b2.add(txtHo);
		txtHo.setColumns(30);
		b.add(Box.createVerticalStrut(10));
		//b3
		Box b3 = Box.createHorizontalBox();
		b.add(b3);
		JLabel lbTenKH = new JLabel("Tên Nhân Viên");
		lbTenKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lbTenKH.setForeground(new Color(245, 51, 10));
		b3.add(lbTenKH);
		txtTennv = new JTextField();
		b3.add(txtTennv);
		b.add(Box.createVerticalStrut(10));
		//b4
		Box b4 = Box.createHorizontalBox();
		b.add(b4);
		JLabel lblDiaChi = new JLabel("Địa Chỉ : ");
		lblDiaChi.setForeground(new Color(245, 51, 10));
		lblDiaChi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		b4.add(lblDiaChi);
		txtDiaChi = new JTextField();
		txtDiaChi.setText("");
		b4.add(txtDiaChi);
		b.add(Box.createVerticalStrut(10));
		//b5
		Box b5 = Box.createHorizontalBox();
		b.add(b5);
		JLabel lbThanhPho = new JLabel("Thành Phố :");
		lbThanhPho.setForeground(new Color(255, 0, 0));
		lbThanhPho.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		b5.add(lbThanhPho);
		txtThanhPho = new JTextField();
		txtThanhPho.setText("");
		b5.add(txtThanhPho);
		b.add(Box.createVerticalStrut(10));
		//b6
		Box b6 = Box.createHorizontalBox();
		b.add(b6);
		JLabel lbQuocGia = new JLabel("Quốc Gia :");
		lbQuocGia.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lbQuocGia.setForeground(new Color(255, 0, 0));
		b6.add(lbQuocGia);
		textQuocGia = new JTextField();
		b6.add(textQuocGia);
		b.add(Box.createVerticalStrut(10));
		//b7
		Box b7 = Box.createHorizontalBox();
		b.add(b7);
		JLabel lbSDT = new JLabel("SDT :");
		lbSDT.setForeground(new Color(255, 0, 0));
		lbSDT.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		b7.add(lbSDT);
		txtSDT = new JTextField();
		txtSDT.setText("");
		b7.add(txtSDT);
		b.add(Box.createVerticalStrut(10));
		//b8
		Box b8 = Box.createHorizontalBox();
		b.add(b8);
		JLabel lbGioiTinh = new JLabel("Giới Tính :");
		lbGioiTinh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lbGioiTinh.setForeground(new Color(255, 0, 0));
		b8.add(lbGioiTinh);
		txtGioiTinh = new JTextField();
		txtGioiTinh.setText("");
		b8.add(txtGioiTinh);
		b.add(Box.createVerticalStrut(10));
		//b9
		Box b9 = Box.createHorizontalBox();
		b.add(b9);
		JLabel lblTuoi = new JLabel("Tuổi :");
		lblTuoi.setForeground(new Color(255, 0, 0));
		lblTuoi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		b9.add(lblTuoi);
		txtTuoi = new JTextField();
		txtTuoi.setText("");
		b9.add(txtTuoi);
		b.add(Box.createVerticalStrut(10));
		//b10
		Box b10 = Box.createHorizontalBox();
		b.add(b10);
		JLabel lbCMND = new JLabel("CMND");
		lbCMND.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lbCMND.setForeground(new Color(255, 0, 0));
		b10.add(lbCMND);
		txtCMNN = new JTextField();
		txtCMNN.setText("");
		b10.add(txtCMNN);
		b.add(Box.createVerticalStrut(10));
		//
		lbMaKH.setPreferredSize(lbTenKH.getPreferredSize());
		lblDiaChi.setPreferredSize(lbTenKH.getPreferredSize());
		lbThanhPho.setPreferredSize(lbTenKH.getPreferredSize());
		lbQuocGia.setPreferredSize(lbTenKH.getPreferredSize());
		lbSDT.setPreferredSize(lbTenKH.getPreferredSize());
		lbGioiTinh.setPreferredSize(lbTenKH.getPreferredSize());
		lblTuoi.setPreferredSize(lbTenKH.getPreferredSize());
		lbCMND.setPreferredSize(lbTenKH.getPreferredSize());
		Box b11 = Box.createVerticalBox();
	
		
	
		model = new DefaultTableModel();
		model.addColumn("Mã Nhân Viên");
		model.addColumn("Họ Nhân Viên");
		model.addColumn("Tên Nhân Viên");
		model.addColumn("Địa Chỉ");
		model.addColumn("Thành Phố");
		model.addColumn("Quốc Gia");
		model.addColumn("SDT ");
		model.addColumn("Giới Tính ");
		model.addColumn("Tuổi");
		model.addColumn("CMND");
	
		BE.add(paneleft);
		
		 btnThem = new JButton("Thêm Nhân Viên");
		btnThem.setBackground(new Color(241, 176, 56));
		btnThem.setForeground(new Color(255, 0, 0));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnThem.setBounds(56, 567, 145, 41);
		paneleft.add(btnThem);
		
		 btnXoa = new JButton("Xa Thải Nhân Viên");
		btnXoa.setBackground(new Color(241, 176, 56));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnXoa.setForeground(new Color(255, 0, 0));
		btnXoa.setBounds(56, 642, 145, 43);
		paneleft.add(btnXoa);
		
		 btnSua = new JButton("Sửa thông tin");
		btnSua.setBackground(new Color(241, 176, 56));
		btnSua.setForeground(new Color(255, 0, 0));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnSua.setBounds(254, 642, 156, 43);
		paneleft.add(btnSua);
		
		 btnLuu = new JButton("Lưu vào danh sách");
		btnLuu.setBackground(new Color(241, 176, 56));
		btnLuu.setForeground(new Color(255, 0, 0));
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnLuu.setBounds(254, 566, 156, 43);
		paneleft.add(btnLuu);
		
		JLabel lbanh1 = new JLabel("");
		lbanh1.setIcon(new ImageIcon(FormQLNV.class.getResource("/img/f29d226640fd35b1d404b344e0fa7649.jpg")));
		lbanh1.setBounds(0, 0, 542, 510);
		paneleft.add(lbanh1);
		
		JLabel lblanh2 = new JLabel("New label");
		lblanh2.setBounds(0, 536, 542, 172);
		paneleft.add(lblanh2);
		lblanh2.setIcon(new ImageIcon(FormQLNV.class.getResource("/img/gr34.png")));
		
		JPanel paneright = new JPanel();
		BE.add(b11);
	
		getContentPane().add(BE);
		
		
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(-89, 5, 1000, 10);
		scrollPane.setBackground(new Color(241, 176, 56));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(1000, 10));
		scrollPane.setBorder(BorderFactory.createTitledBorder("Danh Sách Nhân Viên:"));
		b11.add(scrollPane);
		table.setRowHeight(25);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(38, 154, 217));
		b11.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 20, 800, 329);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(FormQLNV.class.getResource("/img/s.jpg")));
		
		dss = new NhanVien_Dao();
		table.setRowHeight(25);
		
		for (NhanVien nv: dss.getAllNhanVien()) {
			Object [] rowData= {nv.getMaNV(),nv.getHoNV(),nv.getTenNV(),nv.getDiaCHi(),nv.getThanhPho(),nv.getQuocGia(),nv.getsDT(),nv.getGioiTinh(),nv.getTuoi(),nv.getCMNN()};
			model.addRow(rowData);
		}
		btnTroVe.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
	}
	public static void main(String[] args) {
		new FormQLNV().setVisible(true);
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
			if(btnThem.getText().equalsIgnoreCase("thêm nhân viên")) {
				btnXoa.setEnabled(false);
				btnSua.setEnabled(false);
				btnLuu.setEnabled(true);
				btnThem.setEnabled(true);
				btnThem.setText("hủy");
			}else if(btnThem.getText().equalsIgnoreCase("hủy")) {
				btnXoa.setEnabled(true	);
				btnSua.setEnabled(true);
				btnLuu.setEnabled(false);
				btnThem.setText("thêm nhân viên");
			}
		}else if(o.equals(btnLuu)) {
			
			NhanVien nv = new NhanVien(txtmaNV.getText(),txtHo.getText(),txtTennv.getText(), txtDiaChi.getText(), txtThanhPho.getText(), textQuocGia.getText(), txtSDT.getText(), txtGioiTinh.getText(), Integer.parseInt(txtTuoi.getText()), txtCMNN.getText());
			dss.addNhanvien(nv);
			JOptionPane.showMessageDialog(null, "them thanh cong");
			String row[]= {txtmaNV.getText(),txtHo.getText(),txtTennv.getText(), txtDiaChi.getText(), txtThanhPho.getText(), textQuocGia.getText(), txtSDT.getText(), txtGioiTinh.getText(), txtTuoi.getText(), txtCMNN.getText()};
			model.addRow(row);
		}else if(o.equals(btnXoa)) {
			int r = table.getSelectedRow();
			if(r != -1)
			{
				int tb = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa dòng này không?","Delete",JOptionPane.YES_NO_OPTION);
				if(tb == JOptionPane.YES_OPTION){
					dss.xoa(model.getValueAt(r,0).toString());
					model.removeRow(r);

				}
			}
		}else if(o.equals(btnSua)) {
			int r = table.getSelectedRow();
			if(r != -1) {
				try {
					String ma= model.getValueAt(r,0).toString();
					String hoNV  = JOptionPane.showInputDialog("Nhập mới họ nhân Viên :");
					String tenNV  = JOptionPane.showInputDialog("Nhập mới Tên nhân viên :");
					String diaChi = JOptionPane.showInputDialog("Nhập mới địa chỉ:");
					String ThanhPho = JOptionPane.showInputDialog("nhập mới thành phố:");
					String QuocGia = JOptionPane.showInputDialog("Nhập mới quốc gia:");
					String sdt = JOptionPane.showInputDialog("Nhập mới SDT:");
					String gioiTinh = JOptionPane.showInputDialog("Nhấp mới giới tính:");
					String tuoi = JOptionPane.showInputDialog("Nhập mới tuổi:	");
					String CMND = JOptionPane.showInputDialog("Nhập mới CMND:");
					
					NhanVien nv = new NhanVien(ma,hoNV, tenNV, diaChi, ThanhPho, QuocGia, sdt, gioiTinh,Integer.parseInt(tuoi),CMND);
					

					dss.sua(nv);
					model.setValueAt(hoNV, r, 1);
					model.setValueAt(tenNV, r, 2);
					model.setValueAt(diaChi, r, 3);
					model.setValueAt(ThanhPho, r, 4);
					model.setValueAt(QuocGia, r, 5);
					model.setValueAt(sdt, r, 6);
					model.setValueAt(gioiTinh, r, 7);
					model.setValueAt(tuoi, r, 8);
					model.setValueAt(CMND, r, 9);
					JOptionPane.showMessageDialog(null, "bạn đã chập nhật thành công");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}

		}
	}
}
