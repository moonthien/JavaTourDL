package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.channels.Selector;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;

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
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;

import dao.TourDL_Dao;

import entity.TourDL;

public class FormTourDL extends JFrame implements ActionListener ,MouseListener {
	private JTextField txtMaToour,txtTenTour,txtGiaTien,txtNgayDi,txtNgayDen;
	private JComboBox<String> combox1,combox2;
	private DefaultTableModel model;
	private JButton btnTroVe,btnLuu,btnSua,btnThem,btnXoa;
	private JTable table;
	private TourDL_Dao ds;
	private JDateChooser ngayDi;
	private JDateChooser ngayDen;
	public FormTourDL() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		setTitle("QUẢN LÝ TOUR");
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
		JLabel lblNewLabeltitle = new JLabel("QUẢN LÝ TOUR DU LỊCH");
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
		b.setBounds(56, 5, 354, 292);
		Component verticalStrut_1 = Box.createVerticalStrut(30);
		b.add(verticalStrut_1);
		paneleft.add(b);
		Box b1 = Box.createHorizontalBox();
		b1.add(Box.createVerticalStrut(20));
		b.add(b1);
		JLabel lbMaTour = new JLabel("Mã Tour:");
		lbMaTour.setBackground(new Color(255, 179, 102));
		lbMaTour.setForeground(new Color(255, 179, 102));
		lbMaTour.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		b1.add(lbMaTour);
		txtMaToour = new JTextField();
		b1.add(txtMaToour);

		b.add(Box.createVerticalStrut(10));
		//b3
		Box b3 = Box.createHorizontalBox();
		b.add(b3);
		JLabel lbTenTour = new JLabel("Tên Tour:");
		lbTenTour.setForeground(new Color(255, 179, 102));
		lbTenTour.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		b3.add(lbTenTour);
		txtTenTour = new JTextField();
		b3.add(txtTenTour);
		b.add(Box.createVerticalStrut(10));
		txtTenTour.setColumns(30);
		//b4
		Box b4 = Box.createHorizontalBox();
		b.add(b4);
		JLabel lblGiaTien = new JLabel("Giá Tiền : ");
		lblGiaTien.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblGiaTien.setForeground(new Color(255, 179, 102));
		b4.add(lblGiaTien);
		txtGiaTien = new JTextField();
		txtGiaTien.setText("");
		b4.add(txtGiaTien);
		b.add(Box.createVerticalStrut(10));
		//b5
		Box b5 = Box.createHorizontalBox();
		b.add(b5);
		JLabel lbNgayDi = new JLabel("Ngày Đi :");
		lbNgayDi.setForeground(new Color(255, 179, 102));
		lbNgayDi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		b5.add(lbNgayDi);
		b5.add(txtNgayDi = new JTextField());
		b.add(Box.createVerticalStrut(10));
		//b6
		Box b6 = Box.createHorizontalBox();
		b.add(b6);
		JLabel lbNgayDen = new JLabel("Ngày Đến :");
		lbNgayDen.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lbNgayDen.setForeground(new Color(255, 179, 102));
		b6.add(lbNgayDen);
		
		b6.add(txtNgayDen = new JTextField());
		b.add(Box.createVerticalStrut(10));
		//b7
		Box b7 = Box.createHorizontalBox();
		b.add(b7);
		JLabel lbdiemi = new JLabel("Điểm Đi :");
		lbdiemi.setForeground(new Color(255, 179, 102));
		lbdiemi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		b7.add(lbdiemi);
		combox2 = new JComboBox<String>();
		combox2.addItem("Hà Nội");
		b7.add(combox2);
		b.add(Box.createVerticalStrut(10));
		//b8
		Box b8 = Box.createHorizontalBox();
		b.add(b8);
		JLabel lbDiemDen = new JLabel("Điểm Đến :");
		lbDiemDen.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lbDiemDen.setForeground(new Color(255, 179, 102));
		b8.add(lbDiemDen);
		combox1 = new JComboBox<String>();
		combox1.addItem("Hà Nội");
		b8.add(combox1);
		b.add(Box.createVerticalStrut(10));

		//
		lbMaTour.setPreferredSize(lbDiemDen.getPreferredSize());
		lbTenTour.setPreferredSize(lbDiemDen.getPreferredSize());
		lblGiaTien.setPreferredSize(lbDiemDen.getPreferredSize());
		lbNgayDi.setPreferredSize(lbDiemDen.getPreferredSize());
		lbdiemi.setPreferredSize(lbDiemDen.getPreferredSize());
		lbNgayDen.setPreferredSize(lbDiemDen.getPreferredSize());
		//righ
		Box b11 = Box.createVerticalBox();
		model = new DefaultTableModel();
		model.addColumn("Mã Tour");
		model.addColumn("Tên Tour");
		model.addColumn("Giá Tiên");
		model.addColumn("Ngày Đi");
		model.addColumn("Ngày Đến");
		model.addColumn("Điểm đi");
		model.addColumn("Điểm đến ");
	
	
		
		btnThem = new JButton("Thêm Khách Hàng");
		btnThem.setBackground(new Color(255, 179, 102));
		btnThem.setForeground(new Color(255, 0, 0));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnThem.setBounds(123, 567, 145, 41);
		paneleft.add(btnThem);
		
		 btnXoa = new JButton("Xóa Khách Hàng");
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
		
		JLabel lbanh1 = new JLabel("New label");
		lbanh1.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/note-ngay-50-anh-bau-troi-buon-dep-tam-trang-tinh-mich_3.jpg")));
		lbanh1.setBounds(26, 0, 542, 493);
		paneleft.add(lbanh1);
		
		JLabel lblanh2 = new JLabel("New label");
		lblanh2.setBounds(26, 514, 542, 184);
		paneleft.add(lblanh2);
		lblanh2.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/du-lịch-việt-nam.jpg")));
		
	
		BE.add(b11);
		BE.add(paneleft);
	
		getContentPane().add(BE);
	
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(-89, 5, 1000, 10);
		scrollPane.setBackground(new Color(241, 176, 56));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(1000, 10));
		scrollPane.setBorder(BorderFactory.createTitledBorder("Danh Sách Tour:"));
		b11.add(scrollPane);
		table.setRowHeight(25);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 174, 231));
		b11.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 798, 339);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(FormTourDL.class.getResource("/img/DL.jpg")));
		
		ds = new TourDL_Dao();
		table.setRowHeight(25);
		
		for (TourDL t: ds.getAllTour()) {
			Object [] rowData= {t.getMaTour(),t.getTenTour(),t.getGiaTien(),t.getNgayDi(),t.getNgayDen(),t.getDiemDi(),t.getDiemDen()};
			model.addRow(rowData);
		}
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				txtMaToour.setText(model.getValueAt(r, 0).toString());
				txtTenTour.setText(model.getValueAt(r, 1).toString());
				txtGiaTien.setText(model.getValueAt(r, 2).toString());
				txtNgayDi.setText(model.getValueAt(r, 3).toString());
				txtNgayDen.setText(model.getValueAt(r, 4).toString());
				 combox1.setSelectedItem(model.getValueAt(r, 5));
				 combox2.setSelectedItem(model.getValueAt(r, 6));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnTroVe.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
	}

	public static void main(String[] args) {
		new FormTourDL().setVisible(true);
		 Calendar calendar = Calendar.getInstance();
		 Date sqlDate = new Date(calendar.getTime().getTime());
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
			if(btnThem.getText().equalsIgnoreCase("thêm khách hàng")) {
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
			String ngayDi = txtNgayDi.getText();
			String ngayDen = txtNgayDen.getText();
			SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date s = null;
			try {
				s = dfm.parse(ngayDi);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			java.util.Date s1 = null;
			try {
				s1 = dfm.parse(ngayDen);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String diemDi = (String) combox1.getSelectedItem();
			String diemDen = (String) combox2.getSelectedItem();
			TourDL tour = new TourDL(txtMaToour.getText(), txtTenTour.getText(), Double.parseDouble(txtGiaTien.getText()), s , s1, diemDi,diemDen);
			ds.addTourDL(tour);
			JOptionPane.showMessageDialog(null, "them thanh cong");
			String row[]= {txtMaToour.getText(), txtTenTour.getText(), txtGiaTien.getText(), s.toString(),s1.toString(), diemDi,diemDen};
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
					String ten  = JOptionPane.showInputDialog("Enter new ten Tour:");
					String giaTien = JOptionPane.showInputDialog("Enter new gia Tien:");
					String ngayDii = JOptionPane.showInputDialog("Enter new ngày đi:");
					String ngayDenn = JOptionPane.showInputDialog("Enter new ngày Đén:");
					String diemDi = JOptionPane.showInputDialog("Enter new điểm đi:	",combox1.getSelectedItem());
					String diemDen = JOptionPane.showInputDialog("Enter new điểm đến:",combox2.getSelectedItem());
					SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date s = null;
					try {
						s = dfm.parse(ngayDii);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					java.util.Date s1 = null;
					try {
						s1 = dfm.parse(ngayDenn);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					TourDL tour = new TourDL(ma, ten, Double.parseDouble(giaTien), s, s1, diemDi, diemDen);

					ds.sua(tour);
					model.setValueAt(ten, r, 1);
					model.setValueAt(giaTien, r, 2);
					model.setValueAt(s, r, 3);
					model.setValueAt(s1, r, 4);
					model.setValueAt(diemDi, r, 5);
					model.setValueAt(diemDen, r, 6);
					JOptionPane.showMessageDialog(null, "bạn đã chập nhật thành công");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}

		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

