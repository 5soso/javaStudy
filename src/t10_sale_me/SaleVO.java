package t10_sale_me;

public class SaleVO {
	private int idx;
	private String pName;
	private int ea;
	private String pDate; //날짜타입은 타입 관계없음
	
	private int salePrice; //새로 추가함.
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	
	@Override
	public String toString() {
		return "SaleVO [idx=" + idx + ", pName=" + pName + ", ea=" + ea + ", pDate=" + pDate + ", salePrice=" + salePrice
				+ "]";
	}
}
