package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.DonDatTour;
import entity.HoaDonCT;
import entity.MycombomaKH;
import entity.TourDL;

public class HoaDonCT_Dao {
	public List<HoaDonCT> getAllHoaDonCT(){
		List<HoaDonCT> dsHD = new ArrayList<HoaDonCT>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from Chi_Tiet_Hoa_Don_Tour";
			Statement stament = con.createStatement();
			ResultSet rs = stament.executeQuery(sql);
			while(rs.next()) {
				dsHD.add( new HoaDonCT(
						rs.getString("Ma_Hoa_Don"),
						rs.getString("Ma_Tour"),
						rs.getDouble("Gia_Tien"),
						rs.getInt("So_Luong_Nguoi_Trong_Tour"), 
						rs.getDouble("Discount")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
	}
	public void addDonTOur(HoaDonCT hoaDonCT) {
		Connection con  = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
		stmt = con.prepareStatement("insert into Chi_Tiet_Hoa_Don_Tour values(?,?,?,?,?)");
			stmt.setString(1, hoaDonCT.getMaHd());
			stmt.setString(2, hoaDonCT.getMaTour());
			stmt.setDouble(3, hoaDonCT.getGiaTien());
			stmt.setInt(4, hoaDonCT.getSoLuong());
			stmt.setDouble(5, hoaDonCT.getDiscount());
			stmt.executeUpdate();
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}finally {
			close(stmt);
		}
	}
	
	public void xoa(String maHD) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from Chi_Tiet_Hoa_Don_Tour where Ma_Hoa_Don = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			stmt.executeUpdate();
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}finally {
			close(stmt);
		}
	}


	public void sua(HoaDonCT hoaDonCT) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "update Chi_Tiet_Hoa_Don_Tour " 
				+ "set Ma_Tour =?, " 
				+ "Gia_Tien =?, " 
				+ "So_Luong_Nguoi_Trong_Tour =?, " 
				+ "Discount =? " 
				+ "where Ma_Hoa_Don =?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, hoaDonCT.getMaTour());
			stmt.setDouble(2, hoaDonCT.getGiaTien());
			stmt.setInt(3, hoaDonCT.getSoLuong());
			stmt.setDouble(4, hoaDonCT.getDiscount());
			stmt.setString(5, hoaDonCT.getMaHd());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}finally {
			close(stmt);
		}
	}
	
	public List<MycombomaKH> getmaHD(){
		List<MycombomaKH> dsma = new ArrayList<MycombomaKH>();
		Connection con = ConnectDB.getInstance().getConnection();
	
		String sql = "Select * from Hoa_Don_Tour";
		Statement stament;
		try {
			stament = con.createStatement();
			ResultSet rs = stament.executeQuery(sql);
			while (rs.next()) {
				dsma.add(new MycombomaKH(rs.getString("Ma_Hoa_Don")));
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();

		}
		return dsma;
	}
	public List<MycombomaKH> getmaTour(){
		List<MycombomaKH> dsma = new ArrayList<MycombomaKH>();
		Connection con = ConnectDB.getInstance().getConnection();
	
		String sql = "Select * from TourDuLich";
		Statement stament;
		try {
			stament = con.createStatement();
			ResultSet rs = stament.executeQuery(sql);
			while (rs.next()) {
				dsma.add(new MycombomaKH(rs.getString("Ma_Tour")));
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();

		}
		return dsma;
	}
	private void close(PreparedStatement stmt) {
		// TODO Auto-generated method stub
		if(stmt != null) {
			try {
				stmt.close();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
	}
}
