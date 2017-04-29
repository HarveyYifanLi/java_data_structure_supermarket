package transaction;

class Manager extends Employee{	
	float annualSalary;
	
	Manager(){	
		annualSalary = 72000f; // default annual salary for the manager
	} // default constructor	

	Manager(String name, String address, String telephone){
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		annualSalary = 72000f; // default annual salary for the manager
	} //another constructor
	
	void setSalary(float salary){ // note that the access mode of the setSalary method for the Manager object is set to package
								// to protect the annualSalary field from being accessed outside of the package
		this.annualSalary = salary;
	}
	public float getSalary(){
		return annualSalary;
	}
	
	public String toString(){
		return ("The manager's name is "+name+";\n"+"address is "+address+";\n"+"telephone is "+telephone+";\n"
				+"salary is "+getSalary()+".\n");
	}
	
}

class SalesPerson extends Employee{
	int hours;
	float hourRate;
	int weeks;
	
	SalesPerson(){
		hours = 40;
		hourRate = 12.5f;
		weeks = 50; // assume there are working 50 weeks in a year
	}// set default salary in the constructor
	SalesPerson(String name, String address, String telephone){
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		hours = 40;
		hourRate = 12.5f;
		weeks = 50; // assume there are working 50 weeks in a year
	}// set default salary in the constructor
	
	void setSalary(int hours, float hourRate, int weeks){ // this setSalary method is set to package accessible mode
		this.hours = hours;
		this.hourRate = hourRate;
		this.weeks = weeks;
	}
	public float getSalary(){
		return hours*hourRate*weeks; 
	}
	
	public String toString(){
		return ("The sales person's name is "+name+";\n"+"address is "+address+";\n"+"telephone is "+telephone+";\n"
				+"salary is "+getSalary()+".\n");
	}
}
	
	
interface CustomerInterface{
	static final float BALANCE_LIMIT = 1000f;
	abstract float getBalance();
}

	
class EmployeeCustomer extends Employee implements CustomerInterface{
	private float balance;
	private float salary;
	
	EmployeeCustomer(){}
	EmployeeCustomer(String name, String address, String telephone, float salary){
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.salary = salary;
		// this.balance = balance;	let's try setting the balance using a setBalance() method
	}
	
	void setBalance(float balance){
		this.balance = balance;		
	}
	
	/**
	 * we need to implement the getBalance() method inherited from the interface CustomerInterface.
	 *
	 */
	public float getBalance(){
		return balance;
	}
	
	void setSalary(float salary){
		this.salary = salary;
	}
	
	public float getSalary(){
		return salary;
	}
	
	public String toString(){
		return ("The employee customer's name is "+name+";\n"+"address is "+address+";\n"+"telephone is "+telephone+";\n"
				+"salary is "+salary+";\n"+"balane is "+getBalance()+".\n");
	}
	
 }// end of class EmployeeCustomer
		