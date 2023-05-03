package entity;

public class HoaDonCT {
	private String maHd,maTour;
	private double giaTien;
	private int soLuong;
	private double discount;
	public String getMaHd() {
		return maHd;
	}
	public void setMaHd(String maHd) {
		this.maHd = maHd;
	}
	public String getMaTour() {
		return maTour;
	}
	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public HoaDonCT() {
		super();
	}
	public HoaDonCT(String maHd, String maTour, double giaTien, int soLuong, double discount) {
		super();
		this.maHd = maHd;
		this.maTour = maTour;
		this.giaTien = giaTien;
		this.soLuong = soLuong;
		this.discount = discount;
	}
	public double tongTien() {
		double tong = 0;
		if(giaTien>0 && soLuong >0) {
			tong = giaTien*soLuong;
			return tong;
		}else {
			return 0;
		}
	}
	@Override
	public String toString() {
		return "HoaDonCT [maHd=" + maHd + ", maTour=" + maTour + ", giaTien=" + giaTien + ", soLuong=" + soLuong
				+ ", discount=" + discount + ",tổng Tiền =" + tongTien() +"]";
	}
	
}
