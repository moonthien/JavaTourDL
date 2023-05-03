package entity;

import java.util.Date;

public class DonDatTour {
	private String maHD,maKH,maNV;
	private KhachHang kh;
	private NhanVien nv;
	private Date ngayDatTour;
	private int soLuong;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public Date getNgayDatTour() {
		return ngayDatTour;
	}
	public void setNgayDatTour(Date ngayDatTour) {
		this.ngayDatTour = ngayDatTour;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public DonDatTour() {
		super();
	}
	public DonDatTour(String maHD, String maKH, String maNV, Date ngayDatTour, int soLuong) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayDatTour = ngayDatTour;
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "DonTour [maHD=" + maHD + ", maKH=" + maKH + ", maNV=" + maNV + ", ngayDatTour=" + ngayDatTour
				+ ", soLuong=" + soLuong + "]";
	}
}
