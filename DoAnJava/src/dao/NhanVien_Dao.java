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
import entity.NhanVien;

public class NhanVien_Dao {
	public List<NhanVien> getAllNhanVien(){
		List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from NhanVien";
			Statement stament = con.createStatement();
			ResultSet rs = stament.executeQuery(sql);
			while(rs.next()) {
				dsNhanVien.add( new NhanVien(
						rs.getString("Ma_Nhan_vien"),
						rs.getString("Ho_Nhan_Vien"),
						rs.getString("Ten_Nhan_Vien"),
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
		return dsNhanVien;
	}
	public void addNhanvien(NhanVien nv) {
		Connection con  = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
		 
			stmt = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getHoNV());
			stmt.setString(3, nv.getTenNV());
			stmt.setString(4, nv.getDiaCHi());
			stmt.setString(5, nv.getThanhPho());
			stmt.setString(6, nv.getQuocGia());
			stmt.setString(7, nv.getsDT());
			stmt.setString(8, nv.getGioiTinh());
			stmt.setInt(9, nv.getTuoi());
			stmt.setString(10, nv.getCMNN());
			stmt.executeUpdate();
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}finally {
			close(stmt);
		}
	}
	
	public void xoa(String maNV) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from NhanVien where Ma_Nhan_vien = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maNV);
			stmt.executeUpdate();
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}finally {
			close(stmt);
		}
	}


	public void sua(NhanVien nv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "update NhanVien " 
				+ "set Ho_Nhan_Vien =?, " 
				+ "Ten_Nhan_Vien =?, " 
				+ "DiaChi =?, " 
				+ "ThanhPho =?, " 
				+ "QuocGia =?, " 
				+ "SoDienThoai =?, " 
				+ "GioiTinh =?, " 
				+ "Tuoi =?, " 
				+ "SoCCCD =? " 
				+ "where Ma_Nhan_vien =?";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, nv.getHoNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getDiaCHi());
			stmt.setString(4, nv.getThanhPho());
			stmt.setString(5, nv.getQuocGia());
			stmt.setString(6, nv.getsDT());
			stmt.setString(7, nv.getGioiTinh());
			stmt.setInt(8, nv.getTuoi());
			stmt.setString(9, nv.getCMNN());
			stmt.setString(10, nv.getMaNV());
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
