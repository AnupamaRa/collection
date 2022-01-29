package collection;

public class Categories {
	
	long pid;
    private String pname;
    private String category;
    private float price;
    private boolean available;
    public Categories(long pid,String pname,String category,float price,boolean available){
    		this.setPid(pid);
            this.setPname(pname);
            this.setCategory(category);
            this.setPrice(price);
            this.setAvailable(available);
    }
    public long getPid() {
        return pid;
    }
    public void setPid(long pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
   public boolean getavailable(boolean available) {
	   return this.setAvailable(available);
	   
   }
public boolean isAvailable() {
	return available;
}
public boolean setAvailable(boolean available) {
	this.available = available;
	return available;
}
public static void main(String[] args) {
	Categories c1 = new Categories(1, "sandeep","male",20,true);
	System.out.println(c1.pname);
	
	
}
	  
	
}
	
   