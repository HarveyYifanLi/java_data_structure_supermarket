package transaction;

public abstract class Employee extends Person {
	public abstract float getSalary(); // the exact usage of this abstract method are to be expected in the subclasses of the Employee class.
}

class Person{
	String name, address, telephone;
}
