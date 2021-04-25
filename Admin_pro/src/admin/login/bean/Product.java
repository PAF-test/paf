package admin.login.bean;

public class Product {
	
	
	protected int pid;
	protected String pname;
	protected String discription;
	protected String price;
	
	
	public Product() {
	}
	
	public Product(String pname, String discription, String price) {
		super();
		this.pname = pname;
		this.discription = discription;
		this.price = price;
	}

	public Product(int pid, String pname, String discription, String price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.discription = discription;
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	
	

}

