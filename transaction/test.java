package transaction;

public class test{
	static public void main(String[] args){
		//testing the constructors for all the class objects
		Manager manager = new Manager("Michael Scott","Scranton, PA","6042103268");
		SalesPerson salesRep = new SalesPerson("Jim Halpert","Scranton, PA","6042103267");
		EmployeeCustomer empCus = new EmployeeCustomer("Andy, Benard","Scranton, PA","0000000000",48000);
		Customer customer = new Customer("Kelly Karpor","Scranton, PA","7787128699");
		Customer customer1 = new Customer();
		
		manager.setSalary(100000);
		salesRep.setSalary(20,12.5f,50);
		empCus.setBalance(999);
		empCus.setSalary(42000);
		customer.setBalance(100);
		//customer1.orders.length;
		
		//further testing the orders related fields of the Customer Object
		Merchandise m1 = new Merchandise("apple",1.0f);
		Merchandise m2 = new Merchandise("banana",1.8f);
		Merchandise m3 = new Merchandise("pineapple",2.8f);
		Merchandise m4 = new Merchandise("pear",1.5f);
		Merchandise m5 = new Merchandise("lettuce",2.0f);
		
		Item i1 = new Item(m1,4);
		Item i2 = new Item(m5,2.5f);
		
		Item[] items = new Item[3];
		items[0] = i1;
		items[1] = i2;
		
		Order order = new Order(customer,items);
		
		System.out.println(customer.addOrder(order)+"\n");
		System.out.println(customer.getOrders("Kelly Karpor").length+"\n");
		System.out.println(customer.getOrders("Kelly Karpor")+"\n");
		System.out.println(customer.orders+"\n");
		
		//customer.printOrders(customer.orders);
		customer.printOrders(customer.getOrders("Kelly Karpor"));

		
		System.out.println(manager);
		System.out.println(salesRep);
		System.out.println(empCus);
		System.out.println(customer);
		System.out.println(customer1);


	}
}