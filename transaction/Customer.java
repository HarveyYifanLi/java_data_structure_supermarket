package transaction;
import java.util.*;

public class Customer{
	//instance fields
	String name, address, telephone;
	float balance;
	Order[] orders = new Order[20];
	//class field
	static Vector<Customer> allCustomers = new Vector<Customer>();
	
	//constructors
	Customer(){}
	
	Customer(String name, String address, String telephone){
		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}
	
	//class methods
	public static void addCustomer(Customer customer){
		allCustomers.addElement(customer);
	}
	public static Customer removeCustomer(String name){
		Customer customer;
		Enumeration<Customer> total = allCustomers.elements();
		
		while(total.hasMoreElements()){
			customer = (Customer) total.nextElement();// cast each enumeration object to a Customer object
			if (customer.name.equals(name)){
				allCustomers.removeElement(customer);
				return customer;
			}
		}
		
		return null;		
	}
	
	//instance methods
	public void setName(String name){
		this.name = name;	
	}
	public String getName(){
		return name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
	
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	public String getTelephone(){
		return telephone;
	}
	
	void setBalance(float balance){
		this.balance = balance;
	}
	public float getBalance(){
		return balance;
	}
	
	/**
	 * Add a new order to the Order array orders and
	 * if the adding is successful, return true; otherwise return false
	 * @param order
	 * @return boolean
	 */
	public boolean addOrder(Order order){
		if(getBalance() >= CustomerInterface.BALANCE_LIMIT){
			return false;
		}
		if (orders==null) orders = new Order[20];
		for (int i =0; i< orders.length; i++){
			if (orders[i]==null){
				orders[i]=order;
				return true;
			}
		}
		return false;
	}
	//we define three overloading methods for getOrder.
	public Order getOrder(){
		if (orders==null) return null;
		Order temp_order;
		
		for (int i =0; i<orders.length;i++){
			if(orders[i]!=null){
				temp_order = orders[i];
				orders[i]=null;
				return temp_order;
			}
		}
		return null;
	}
	public Order getOrder(String name){ // matching by a customer name
		if(orders == null) return null;
		Order temp_order;
		
		for (int i=0; i<orders.length;i++){
			if(orders[i]!=null && orders[i].receiver.name.equals(name)){
				temp_order = orders[i];
				orders[i]=null;
				return temp_order;
			}
		}
		return null;	
	}
	
	public Order getOrder(Customer receiver){// matching by a customer object
		if(orders == null) return null;
		Order temp_order;
		
		for (int i=0; i<orders.length;i++){
			if(orders[i]!=null && orders[i].receiver==receiver){
				temp_order = orders[i];
				orders[i]=null;
				return temp_order;
			}
		}
		return null;	
	}
	
	//we define overloading methods for getOrders
	public Order[] getOrders(String name){
		if(orders == null) return null;
		Order[] temp_orders = new Order[orders.length];
		int j = 0;
		
		for (int i=0; i<orders.length;i++){
			if(orders[i]!=null && orders[i].receiver.name.equals(name)){
				temp_orders[j]=orders[i];
				j++;
			}
		}
		
		Order[] orders = new Order[j];// redeclare orders of a new size of j
		
		for (int i=0; i < j;i++){
			orders[i] = temp_orders[i];
		}
		
		return orders;
	}
	
	public Order[] getOrders(Customer receiver){
		if(orders == null) return null;
		Order[] temp_orders = new Order[orders.length];
		int j = 0;
		
		for (int i=0; i<orders.length;i++){
			if(orders[i]!=null && orders[i].receiver==receiver){
				temp_orders[j]=orders[i];
				j++;
			}
		}
		
		Order[] orders = new Order[j];// redeclare orders of a new size of j
		
		for (int i=0; i < j;i++){
			orders[i] = temp_orders[i];
		}
		
		return orders;
	}
	
	public String toString(){
		return ("The customer's name is "+name+";\n"+"address is "+getAddress()+";\n"+"telephone is "+telephone+";\n"
				+"balance is "+getBalance()+".\n");
	}
    // define a method to be able to print out the elements of the orders object (which is an array)
	public void printOrders(Order[] orders){
		StringBuilder sb = new StringBuilder();
		
		for (int i =0; i < orders.length; i++){
			if (i>0) {
				sb.append(", ");
			}
			// print out the name of the receiver and the product name and quantity of that order element
			sb.append(orders[i].receiver.getName());
			System.out.println(orders[i].items.length);
			for (int j =0; j < orders[i].items.length; j++){
				//sb.append(orders[i].getItems()[j].getMerchandise().getName());
				//sb.append(orders[i].items[j].merchandise.name);
				//sb.append(orders[i].items[j].quantity);
				
			}
		}
		System.out.println(sb.toString()+"\n");
		//System.out.println(Arrays.toString(orders));
	}
	
}// end of class Customer
	
class Order{
	Customer receiver;
	Item[] items;
	
	Order(){}	
	Order(Customer receiver,Item[] items){
		this.receiver = receiver;
		this.items = items;
	}
	
	Item[] getItems(){
		return items;
	}
	Item findItem(Merchandise p){
		if (items == null) return null;
		for(int i =0; i<items.length; i++)
			if (items[i]!=null && items[i].merchandise == p)
				return items[i];
		return null;
	}
	void changeQuantity(Merchandise p, int newQuantity) throws NoSuchMerchandiseOrdered {
		Item item = findItem(p);
		
		if(item == null)
			throw new NoSuchMerchandiseOrdered(p,newQuantity);
		
		item.quantity = newQuantity;
	}

}

class Item{
	Merchandise merchandise;
	float quantity; //in POUNDS
	
	Item(){}
	Item(Merchandise merchandise, float quantity){
		this.merchandise = merchandise;
		this.quantity = quantity;
	}
	
	Merchandise getMerchandise(){
		return merchandise;
	}
	float getQuantity(){
		return quantity;
	}
}
class Merchandise{
	String name;
	float price; // dollar per pound
	
	Merchandise(){}
	Merchandise(String name, float price){
		this.name = name;
		this.price = price;
	}
	String getName(){
		return name;
	}
	float getPrice(){
		return price;
	}
}
class NoSuchMerchandiseOrdered extends Exception {
	public Merchandise p;
	public int newQuantity;
	
	NoSuchMerchandiseOrdered(Merchandise m, int q){
		super("No merchandise "+m.name + " is ordered");
		p = m;
		newQuantity = q;
	}
}
	
	
	
