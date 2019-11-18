package com.nt.command;




public class CustomerCommand {
	private Integer cno;
	private String cname;
	private String  cadd;
	private Long   mobileNo;
	private  Float billAmt;
	public int getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Float getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(Float billAmt) {
		this.billAmt = billAmt;
	}
	

}
