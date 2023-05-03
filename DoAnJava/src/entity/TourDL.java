package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TourDL {
	private String maTour,tenTour;
	private double giaTien;
	private Date ngayDi;
	private Date ngayDen;
	private String diemDi,diemDen;
	public String getMaTour() {
		return maTour;
	}
	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	public String getTenTour() {
		return tenTour;
	}
	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	public Date getNgayDi() {
		return ngayDi;
	}
	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}
	public Date getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}
	public String getDiemDi() {
		return diemDi;
	}
	public void setDiemDi(String diemDi) {
		this.diemDi = diemDi;
	}
	public String getDiemDen() {
		return diemDen;
	}
	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}
	public TourDL() {
		super();
	}
	public TourDL(String maTour, String tenTour, double giaTien, Date ngayDi, Date ngayDen, String diemDi,
			String diemDen) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.giaTien = giaTien;
		this.ngayDi = ngayDi;
		this.ngayDen = ngayDen;
		this.diemDi = diemDi;
		this.diemDen = diemDen;
	}
	@Override
	public String toString() {
		SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
		
		return "TourDL [maTour=" + maTour + ", tenTour=" + tenTour + ", giaTien=" + giaTien + ", ngayDi=" + dfm.format(ngayDi)
				+ ", ngayDen=" + dfm.format(ngayDen) + ", diemDi=" + diemDi + ", diemDen=" + diemDen + "]";
	}
	
}
