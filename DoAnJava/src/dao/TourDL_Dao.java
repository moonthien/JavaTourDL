package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import connectDB.ConnectDB;
import entity.TourDL;

public class TourDL_Dao {
	public List<TourDL> getAllTour(){
		List<TourDL> dsTour = new ArrayList<TourDL>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from TourDuLich";
			Statement stament = con.createStatement();
			ResultSet rs = stament.executeQuery(sql);
			while(rs.next()) {
				dsTour.add( new TourDL(
						rs.getString("Ma_Tour"),
						rs.getString("TenTour"),
						rs.getDouble("GiaTien"),
						rs.getDate("Ngay_Di"), 
						rs.getDate("Ngay_Den"),
						rs.getString("Diem_Di"), 
						rs.getString("Diem_Den")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTour;
	}
	public void addTourDL(TourDL tour) {
		Connection con  = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
		
		        
			stmt = con.prepareStatement("insert into TourDuLich values(?,?,?,?,?,?,?)");
			stmt.setString(1, tour.getMaTour());
			stmt.setString(2, tour.getTenTour());
			stmt.setDouble(3, tour.getGiaTien());
			stmt.setDate(4, new java.sql.Date(tour.getNgayDi().getTime()));
			stmt.setDate(5, new java.sql.Date(tour.getNgayDen().getTime()));
			stmt.setString(6, tour.getDiemDi());
			stmt.setString(7, tour.getDiemDen());
			stmt.executeUpdate();
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}finally {
			close(stmt);
		}
	}
	
	public void xoa(String maTour) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from TourDuLich where Ma_Tour = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maTour);
			stmt.executeUpdate();
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}finally {
			close(stmt);
		}
	}


	public void sua(TourDL tour) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "update TourDuLich " 
				+ "set TenTour =?, " 
				+ "GiaTien =?, " 
				+ "Ngay_Di =?, " 
				+ "Ngay_Den =?, " 
				+ "Diem_Di =?, " 
				+ "Diem_Den =? " 
				+ "where Ma_Tour =?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tour.getTenTour());
			stmt.setDouble(2, tour.getGiaTien());
			stmt.setDate(3, new java.sql.Date(tour.getNgayDi().getTime()));
			stmt.setDate(4, new java.sql.Date(tour.getNgayDen().getTime()));
			stmt.setString(5, tour.getDiemDi());
			stmt.setString(6, tour.getDiemDen());
			stmt.setString(7, tour.getMaTour());
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
