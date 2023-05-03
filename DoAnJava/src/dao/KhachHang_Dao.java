package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.TourDL;


public class KhachHang_Dao {
	public List<KhachHang> getAllKhachHang(){
		List<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from KhachHang";
			Statement stament = con.createStatement();
			ResultSet rs = stament.executeQuery(sql);
			while(rs.next()) {
				dsKhachHang.add( new KhachHang(
						rs.getString("Ma_Khach_Hang"),
						rs.getString("Ten_Khach_Hang"),
						rs.getString("DiaChi"), 
						rs.getString("ThanhPho"),
						rs.getString("QuocGia"), 
						rs.getString("SoDienThoai"),
						rs.getString("GioiTinh"),
						rs.getInt("Tuoi"), 
						rs.getString("SoCCCD")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	public void addKhachHang(KhachHang kh) {
		Connection con  = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
		 
			stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setString(3, kh.getDiaChi());
			stmt.setString(4, kh.getThanhPho());
			stmt.setString(5, kh.getQuocGia());
			stmt.setString(6, kh.getsDT());
			stmt.setString(7, kh.getGioiTinh());
			stmt.setInt(8, kh.getTuoi());
			stmt.setString(9, kh.getSoCMND());
			stmt.executeUpdate();
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}finally {
			close(stmt);
		}
	}
	
	public void xoa(String maKH) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from KhachHang where Ma_Khach_Hang = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maKH);
			stmt.executeUpdate();
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}finally {
			close(stmt);
		}
	}


	public void sua(KhachHang kh) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "update KhachHang " 
				+ "set Ten_Khach_Hang =?, " 
				+ "DiaChi =?, " 
				+ "ThanhPho =?, " 
				+ "QuocGia =?, " 
				+ "SoDienThoai =?, " 
				+ "GioiTinh =?, " 
				+ "Tuoi =?, " 
				+ "SoCCCD =? " 
				+ "where Ma_Khach_Hang =?";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, kh.getTenKH());
			stmt.setString(2, kh.getDiaChi());
			stmt.setString(3, kh.getThanhPho());
			stmt.setString(4, kh.getQuocGia());
			stmt.setString(5, kh.getsDT());
			stmt.setString(6, kh.getGioiTinh());
			stmt.setInt(7, kh.getTuoi());
			stmt.setString(8, kh.getSoCMND());
			stmt.setString(9, kh.getMaKH());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}finally {
			close(stmt);
		}
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
