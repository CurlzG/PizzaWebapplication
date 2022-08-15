public class Orders {
	public String Name;
	public String Base;
	public String Size;
	public String top1;
	public String top2;
	public String top3;
	public String Address;
	
	//Orders Constructor
	public Orders(String name, String base, String size,String top1, String top2,String top3, String address) {
		this.Name = name;
		this.Base = base;
		this.Size = size;
		this.top1 = top1;
		this.top2 = top2;
		this.top3 = top3;
		this.Address = address;
	}
	public boolean checkValue() {
		System.out.println(toString());
		if(Base != "" && Size != "" && top1 != "" && top2 != "" && top3 != "") {
			return true;
		} else {
			return false;
		}
	}
	public String getName() {
		return Name;
	}
	public String getBase() {
		return Base;
	}
	public String getSize() {
		return Size;
	}

	public String getTop1() {
		return top1;
	}

	public String getTop2() {
		return top2;
	}

	public String getTop3() {
		return top3;
	}

	public String getAddress() {
		return Address;
	}
	
	public String toString() {
		return "Method --> " + Name + " " + Base + " " + Size + " " + top1 + " " + top2 + " " + top3 + " " + Address;
	}
	
}
