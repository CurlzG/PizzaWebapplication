package orders;

public class DeliveryOrder {
	public int num;
	public String name;
	public String address;
public DeliveryOrder(int num, String name, String address) {
	this.num = num;
	this.name = name;
	this.address = address;
}
public String toString() {
	return num +" " +  name + " " + address;
}
}
