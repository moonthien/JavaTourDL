package entity;

public class NhanVien {
	private String maNV,hoNV,tenNV,diaCHi,thanhPho,quocGia,sDT,gioiTinh,CMNN;
	private int tuoi;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoNV() {
		return hoNV;
	}
	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getDiaCHi() {
		return diaCHi;
	}
	public void setDiaCHi(String diaCHi) {
		this.diaCHi = diaCHi;
	}
	public String getThanhPho() {
		return thanhPho;
	}
	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getCMNN() {
		return CMNN;
	}
	public void setCMNN(String cMNN) {
		CMNN = cMNN;
	}
	
	public NhanVien() {
		super();
	}
	public NhanVien(String maNV, String hoNV, String tenNV, String diaCHi, String thanhPho, String quocGia, String sDT,
			String gioiTinh,int tuoi, String cMNN ) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.diaCHi = diaCHi;
		this.thanhPho = thanhPho;
		this.quocGia = quocGia;
		this.sDT = sDT;
		this.gioiTinh = gioiTinh;
		this.tuoi = tuoi;
		CMNN = cMNN;
	}
	
}
